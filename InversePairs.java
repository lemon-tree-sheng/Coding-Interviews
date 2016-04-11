//数组中的逆序对。在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，
//求出这个数组中的逆序对的总数。

//直接解法，每一个数字和后面剩余字符进行比较

public class InversePairs{
	public int InversePairs(int[] array){
		if(array == null || array.length <= 1){
            return 0;
        }
        
        int len = array.length;
        int count = 0;
        for(int i = 0; i < len - 1; i++){
            for(int j = i + 1; j < len; j++){
                if(array[i] > array[j]){
                    count++;
                }
            }
        }
        return count;
	}
}