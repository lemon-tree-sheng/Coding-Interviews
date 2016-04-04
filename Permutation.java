//输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,则打印出由字符a,b,c
//所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。 结果请按字母顺序输出。 

//递归考虑，每一次我们把字符看成头和尾两部分，头部分字符遍历选出，然后尾部分自动成为下一个头尾部分，递归解决

import java.util.ArrayList;
import java.util.Collections;
public class Permutation {
    public ArrayList<String> Permutation(String str) {
       ArrayList<String> list = new ArrayList<String>();
       if(str == null || str.length() == 0){
           return list;
       }
       
       permutation(str.toCharArray(), 0, list);
       Collections.sort(list);
       return list;
    }
    
    public void permutation(char[] charArray, int index, ArrayList<String> list){
    	if(index == charArray.length - 1){
    		String tmp = new String(charArray);
    		if(!list.contains(tmp)){
    			list.add(tmp);
    		}
    		return ;
    	}
    	
    	char tmp;
    	for(int i = index; i < charArray.length; i++){
    		tmp = charArray[index];
    		charArray[index] = charArray[i];
    		charArray[i] = tmp; 
    		permutation(charArray, index + 1, list);
    		tmp = charArray[i];
    		charArray[i] = charArray[index];
    		charArray[index] = tmp;
    	}
    }
}