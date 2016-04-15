//扑克牌顺子。

//题目描述：LL今天心情特别好,因为他去买了一副扑克牌,发现里面居然有2个大王,2个小王(一副牌原本是54张^_^)...他随机从中抽出了5张牌,想测测自己
//的手气,看看能不能抽到顺子,如果抽到的话,他决定去买体育彩票,嘿嘿！！“红心A,黑桃3,小王,大王,方片5”,“Oh My God!”不是顺子.....LL不高兴了,他
//想了想,决定大\小 王可以看成任何数字,并且A看作1,J为11,Q为12,K为13。上面的5张牌就可以变成“1,2,3,4,5”(大小王分别看作2和4),“So Lucky!”。
//LL决定去买体育彩票啦。 现在,要求你使用这幅牌模拟上面的过程,然后告诉我们LL的运气如何。为了方便起见,你可以认为大小王是0。

//思路：现对数组进行排序，然后统计0的个数zeroCount，再然后统计非零数字之间的距离，如果zeroCount足以填充，则返回true
public class isContinuous {
    public boolean isContinuous(int [] numbers) {
    	if(numbers == null || numbers.length != 5){
    		return false;
    	}
    	//对数组进行排序
    	quickSort(numbers, 0, numbers.length - 1);

    	int index = 0;
    	int zeroCount = 0;
    	int gapCount = 0;
    	while(index < numbers.length - 1){
    		if(numbers[index] == 0){
    			zeroCount++;
    			//零的个数不能超过4
    			if(zeroCount == 5){
    				return false;
    			}
    		}else{
    			//不能有两张牌一样大
    			if(numbers[index + 1] - numbers[index] == 0){
    				return false;
    			}
    			gapCount += numbers[index + 1] - numbers[index] - 1;
    		}
    		index++;
    	}

    	return zeroCount < gapCount ? false : true;
    }

    public void quickSort(int[] numbers, int start, int end){
    	if(start < end){
    		int tmpS = start;
    		int tmpE = end;
    		int tmpKey = numbers[start];
    		while(tmpS < tmpE){
    			while(tmpS < tmpE && numbers[tmpE] >= tmpKey){
    				tmpE--;
    			}
    			numbers[tmpS] = numbers[tmpE];
    			while(tmpS < tmpE && numbers[tmpS] < tmpKey){
    				tmpS++;
    			}
    			numbers[tmpE] = numbers[tmpS];
    		}
    		numbers[tmpS] = tmpKey;
    		quickSort(numbers, start, tmpS - 1);
    		quickSort(numbers, tmpS + 1, end);
    	}
    }
}