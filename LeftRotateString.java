//左旋转字符串。汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，就是用字符串模拟这个指令的运算结果。对于一个给定的
//字符序列S，请你把其循环左移K位后的序列输出。例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。

//思路1：缓冲区暂存法：将左边n位字符先放入缓冲区中，然后左移n位剩余字符，然后将缓冲区中字符从右边开始填充

//思路2：多次翻转法：先将0到n为字符进行翻转，然后将n到最后字符进行翻转，最后整个字符区间进行翻转，结果即为所求。这种方法复杂度更低
public class LeftRotateString {
	//思路1：
    public String LeftRotateString(String str,int n) {
        if(n == 0 || str.length() <= 0){
        	return str;
        }

        char[] cache = new char[n];
        char[] charArray = str.toCharArray();
        for(int i = 0; i < n; i++){
        	cache[i] = charArray[i];
        }

        for(int i = n; i < str.length(); i++){
        	charArray[i - n] = charArray[i];
        }

        for(int i = 0; i < n; i++){
        	charArray[i + str.length() - n] = cache[i];
        }
        
        return new String(charArray);
    }

    //思路2：
    public String LeftRotateString(String str,int n) {
        if(n == 0 || str.length() <= 0){
        	return str;
        }

        char[] charArray = str.toCharArray();
        reverse(charArray, 0, n - 1);
        reverse(charArray, n, str.length() - 1);
        reverse(charArray, 0, str.length() - 1);
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
}