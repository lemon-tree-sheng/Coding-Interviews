//把数组排成最小的数,输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
//例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。

//思路1：全排列思路，将数组里的数以递归方式进行全排列，然后拿出字典序的第一个数字即可

//思路2：排序思路，自定义比较器，该比较器可实现两字符串的大小比较，比较结果应实现哪一个字符串数字应该放在前面，然后利用该比较器对
//整个整数数组以新定义字符串比较器比较规则进行快排，最后返回快排的字符串结果即可

import java.util.ArrayList;
import java.util.Collections;

public class PrintMinNumber {
	//思路1实现
    public String PrintMinNumber(int [] numbers) {
		if(numbers == null || numbers.length == 0){
    		return "";
    	}
    	
    	if(numbers.length == 1){
    		return String.valueOf(numbers[0]);
    	}
    	
    	String[] target = new String[numbers.length];
    	for(int i = 0; i < numbers.length; i++){
    		target[i] = String.valueOf(numbers[i]);
    	}
    	
    	ArrayList<String> list = new ArrayList<String>();
    	permutation(target, 0, list);
    	Collections.sort(list);
		return list.get(0);
    }
    
    public void permutation(String[] target, int index, ArrayList<String> list){
    	if(index == target.length - 1){
    		StringBuilder sb = new StringBuilder();
    		for(int i = 0; i < index + 1; i++){
    			sb.append(target[i]);
    		}
    		list.add(sb.toString());
    	}
    	
    	String tmp;
    	for(int i = index; i < target.length; i++){
    		tmp = target[index];
    		target[index] = target[i];
    		target[i] = tmp;
    		permutation(target, index + 1, list);
    		tmp = target[index];
    		target[index] = target[i];
    		target[i] = tmp;
    	}
    }

    //思路2实现：
    private static class MinNumComparator implements Comparator<String>{
		@Override
		public int compare(String o1, String o2) {
			return new String(o1 + o2).compareTo(new String(o2 + o1));
		}
    	
    }
    
    public String PrintMinNumber(int [] numbers) {
		if(numbers == null || numbers.length == 0){
    		return "";
    	}
    	
    	if(numbers.length == 1){
    		return String.valueOf(numbers[0]);
    	}
    	
    	String[] target = new String[numbers.length];
    	for(int i = 0; i < numbers.length; i++){
    		target[i] = String.valueOf(numbers[i]);
    	}
    	
    	MinNumComparator mc = new MinNumComparator();
    	quickSort(target, 0, numbers.length - 1, mc);
    	
    	StringBuilder sb = new StringBuilder();
    	for(int i = 0; i < numbers.length; i++){
    		sb.append(target[i]);
    	}
    	return sb.toString();
    }
    
    public void quickSort(String[] numbers, int begin, int end, MinNumComparator mc){
    	if(begin >= end){
    		return ;
    	}
    	String tmp = numbers[begin];
		int tmpBegin = begin;
		int tmpEnd = end;
    	while(tmpBegin < tmpEnd){
    		while(tmpBegin < tmpEnd && mc.compare(numbers[tmpEnd], tmp) > 0){
    			tmpEnd--;
    		}
    		numbers[tmpBegin] = numbers[tmpEnd];
    		while(tmpBegin < tmpEnd && mc.compare(numbers[tmpBegin], tmp) < 0){
    			tmpBegin++;
    		}
    		numbers[tmpEnd] = numbers[tmpBegin];
    	}
    	numbers[tmpBegin] = tmp;
    	quickSort(numbers, begin, tmpBegin - 1, mc);
    	quickSort(numbers, tmpEnd + 1, end, mc);
    }
}