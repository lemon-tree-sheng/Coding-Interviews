//递归虽然代码漂亮，但是造成的空间和时间的浪费却是难以承受的，数字一大则性能极低而且极容易造成栈溢出
public class Fibonacci {
    public int Fibonacci(int n) {
		if(n<=1){
			return n;
		}else {
			if(n == 2){
				return 1;
			}
			
			int pre = 1,prePre = 1,result = 0;
			for(int i = 3; i <= n; i++){
				result = pre + prePre;
				prePre = pre;
				pre = result;
			}
			
			return result;
		}
    }
}