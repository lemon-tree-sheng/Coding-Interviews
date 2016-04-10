//丑数，把只包含因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但14不是，
//因为它包含因子7。 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。

//思路1：从1开始逐一判断每个数，符合丑数条件则计数加1，直到到达指定索引处，这种方法性能低，耗时间，不推荐

//思路2：我们开辟一个index长度数组作为储存空间，逐一放入达到目标前的每个丑数，以空间换时间。我们可以确定，每个丑数必然是
//之前存入的某个丑数的2，3或5倍，于是我们用t2，t3，t5来标记已储存丑数中分别乘以2，3，以及5可以大于目前最大丑数的索引，每次
//确定下一个最大丑数时，即判断t2，t3，t5索引处哪个数乘以相应倍数得到的结果更小，然后填充新丑数，之后按照确定t2，t3，t5规则
//更新这些索引即可
public class GetUglyNumber_Solution{
	//解决方案1：
	public int GetUglyNumber_Solution(int index) {
        if(index <= 0){
    		return 0;
    	}
    	
       	int count = 0;
        int tmpIndex = 0;
        while(tmpIndex < index){
        	count++;
            if(isUglyNumber(count)){
                tmpIndex++;
            }
        }
        return count;
    }
    
    public boolean isUglyNumber(int number){
        while(number % 2 == 0){
        	number /= 2;
        }
        
        while(number % 3 == 0){
        	number /= 3;
        }
        
        while(number % 5 == 0){
        	number /= 5;
        }
        return number == 1;
    }

    //解决方案2：
    public int GetUglyNumber_Solution(int index) {
        if(index <= 0){
    		return 0;
    	}
    	
       	int[] array = new int[index];
       	array[0] = 1;
       	int t2 = 0, t3 = 0, t5 = 0;
       	int next = 1;
       	while(next < index){
       		array[next] = min(array[t2] * 2, array[t3] * 3, array[t5] * 5);
       		while(array[t2]*2 <= array[next]){
       			t2++;
       		}
       		while(array[t3]*3 <= array[next]){
       			t3++;
       		}
       		while(array[t5]*5 <= array[next]){
       			t5++;
       		}
       		next++;
       	}
       	return array[index - 1];
    }
    
    public int min(int a, int b, int c){
    	int tmp = (a > b ? b : a);
    	return c > tmp ? tmp : c; 
    }
}