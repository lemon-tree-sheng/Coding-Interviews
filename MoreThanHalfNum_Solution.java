//数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
//由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。

//分析可知，要想某个数字出现的次数超过数组长度一半，那么它出现的次数会超过所有其他数字出现次数的总和。当某个数字出现时给出count
//为1，下一个数字相同则count++，不相同则count--，如果count为0说明该数字在已经遍历的数字当中已经和不同的数字出现次数总和相同，
//舍弃不予考虑，将当前数字置为待选数字，count置为1，可知，最后一个置count为1的数字即为所求数字

public class MoreThanHalfNum_Solution {
    public int MoreThanHalfNum_Solution(int [] array) {
        if(array == null || array.length <= 0){
        	return 0;
        }

        if(array.length == 1){
        	return array[0];
        }

        int result = 0;
        int count = 1;

        for(int i = 1; i < array.length; i++){
        	if(array[i] == array[result]){
        		count++;
        	}else{
        		count--;
        	}

        	if(count == 0){
        		result = i;
        		count = 1;
        	}
        }
        
        int index = 0;
        int num = 0;
        while(index < array.length){
        	if(array[index++] == array[result]){
        		num ++;
        	}
        }
        if(num > array.length/2){
        	return array[result];
        }
        return 0;
    }
}