//翻转单词顺序列。例如，“student. a am I”。后来才意识到，这家伙原来把句子单词的顺序翻转了，正确的句子应该是“I am a student.”。

//思路1：将所有字符进行翻转，然后将每个单词进行翻转

//思路2：将每个单词作为一个单位直接进行翻转
public class ReverseSentence {
	//思路1：
	public String ReverseSentence(String str) {
        if(str == null || str.trim().equals("")){
        	return str;
        }

        char[] charArray = str.toCharArray();
        reverse(charArray, 0, str.length() - 1);
        int start = 0, end = 0;
        while(start < str.length()){
        	while(charArray[end] != ' ' && end != str.length() - 1){
        		end++;
        	}

        	if(start < end){
        		reverse(charArray, start, end - 1);
        	}
        	start = end + 1;
        	end = start;
        }
        return new String(charArray);
    }

    public void reverse(char[] charArray, int start, int end){
    	if(charArray == null || start < 0 || end > charArray.length - 1){
    		return ;
    	}
    	while(start < end){
    		char tmp = charArray[start];
    		charArray[start] = charArray[end];
    		charArray[end] = tmp;

    		start++;
    		end--;
    	}
    }
    //思路2：
    public String ReverseSentence(String str) {
        if(str == null || str.trim().equals("")){
        	return str;
        }

        char[] charArray = str.toCharArray();
        reverse(charArray, 0, str.length() - 1);
        int start = 0, end = 0;
        while(start < str.length()){
        	while(charArray[end] != " " || end != str.length()){
        		end++;
        	}

        	if(start < end){
        		reverse(charArray, start, end - 1);
        	}
        	start = end + 1;
        	end = start;
        }
    }

    public void reverse(char[] charArray, int start, int end){
    	if(charArray == null || start < 0 || end > charArray.length - 1){
    		return ;
    	}
    	while(start < end){
    		char tmp = charArray[start];
    		charArray[start] = charArray[end];
    		charArray[end] = tmp;

    		start++;
    		end--;
    	}
    }
}