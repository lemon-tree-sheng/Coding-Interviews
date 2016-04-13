//和为S的两个数字。输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，
//输出两个数的乘积最小的。 

//定一个flag作为数组索引，初始值为1，即数组第二个数，先判断该数字加上紧邻的前一位和是否等于s，是而且乘积比当前保存乘积小进行更新结果；如
//果该数字加上紧邻的前一位和是否小于s，则说明前面的数字加上当前索引出的数字都小于s，那么直接flag++；如果该数字加上紧邻的前一位和大于s，
//则需要将加上的紧邻数字索引前移，然后再进行判断。不断更新乘积结果和保存的两个数字，最后进行输出
import java.util.ArrayList;
public class FindNumbersWithSum {
	public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(array == null || array.length <= 1){
        	return result;
        }

        int flag = 1;
        int mulResult = Integer.MAX_VALUE;
        
        while(flag < array.length){
        	if(array[flag] + array[flag - 1] <= sum){
        		if((array[flag] + array[flag - 1] == sum) && mulResult > array[flag] * array[flag - 1]){
        			result.add(0,array[flag - 1]);
            		result.add(1,array[flag]);
            		
            		mulResult = array[flag] * array[flag - 1];
        		}
        	}else{
        		int tmpIndex = flag - 2;
        		while(tmpIndex >= 0 && array[flag] + array[tmpIndex] != sum){
        			tmpIndex--;
        		}

        		if(tmpIndex >= 0 && mulResult > array[flag] * array[tmpIndex]){
        			result.add(0,array[tmpIndex]);
            		result.add(1,array[flag]);
            		mulResult = array[flag] * array[tmpIndex];
        		}
        	}
        	
        	flag++;
        }
        ArrayList<Integer> tmp = new ArrayList<Integer>();
        if(result.size() > 0){
        	tmp.add(result.get(0));
            tmp.add(result.get(1));
        }
        return tmp;
    }
}