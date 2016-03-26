//题目：输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。

//java本身int占4个字节，32位，判断每一个末位并进行结果计数后，将目标数右移一位
public class NumberOf1{
	public static int numberOf1(int n) {
		int sum = 0;
		for(int i = 0; i < 32; i++){
			sum += n & 1;
			n >>>= 1;
		}
		return sum;
	}
}
