//第一个只出现一次的字符位置。在一个字符串(1<=字符串长度<=10000，
//全部由字母组成)中找到第一个只出现一次的字符的位置。若为空串，返回-1。位置索引从0开始

//思路1：遍历比较法，每一个字符都和后面的所有字符进行比较，如果没有出现相同的则可以确认是所求答案，但时间复杂度会达到n^2，不推荐

//思路2：将每一个字符放入哈希表中，key，value分别记录字符和数量，接下来进行遍历字符串中每个字符，并在map中找到对应字符的出现次数，次数
//为1即为所求

import java.util.HashMap;
public class FirstNotRepeatingChar{
	//思路2实现：
	public int FirstNotRepeatingChar(String str){
		if(str == null || str.length() <= 0){
			return -1;
		}

		int length = str.length();
		if(length == 1){
			return 0;
		}

		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for(int i = 0; i < length; i++){
			char tmp = str.charAt(i);
			if(map.containsKey(tmp)){
				map.put(tmp, 1);
			}else{
				map.replace(tmp, map.get(tmp) + 1);
			}
		}

		for(int i = 0; i < length; i++){
			if(map.get(str.charAt(i)) == 1){
				return i;
			}
		}
		return -1;
	}
}