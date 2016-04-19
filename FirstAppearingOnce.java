//字符流中第一个不重复的字符。请实现一个函数用来找出字符流中第一个只出现一次的字符。例如，当从字符流中只读出前两个字符"go"时，第一个只
//出现一次的字符是"g"。当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。

//思路：利用数组做一个简易的hash表，数组下标对应字符的ASCII码值，而数组中真正存插入字符的索引，首先将数组全部初始化为-1，当插入字符时，
//如果字符ASCII码值对应数组下标处元素值仍为-1，则说明这个字符第一次出现，将数组该处元素更新为插入索引；如果字符ASCII码值对应数组下标处
//元素值不为-1，则说明已经出现过，将值更新为-2。最后对数组进行遍历，找出元素值不为负且最小的值则为所求
public class FirstAppearingOnce {
	int[] chars = new int[256];
	int index = 0;
    //Insert one char from stringstream
    public void Insert(char ch)
    {
        if(index == 0){
    		for(int i = 0; i < chars.length; i++){
    			chars[i] = -1;
    		}
    	}
    	
        if(chars[ch] == -1){
        	chars[ch] = index;
        }else{
        	chars[ch] = -2;
        }

        index++;
    }
  //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
    	int minIndex = Integer.MAX_VALUE;
    	char value = '#';
    	for(int i = 0; i < chars.length; i++){
    		if(chars[i] >= 0 && chars[i] < minIndex){
    			minIndex = chars[i];
    			value = (char)i;
    		}
    	}

    	return value;
    }
}