//最大公约数，辗转相除法迭代实现。最小公倍数用两数相乘然后除以最大公约数即可

public class Gcd{
	public static int gcd(int x, int y){
		if(x <= 0 || y <= 0){
			return -1;
		}

		if(x < y){
			x = x + y;
			y = x - y;
			x = x - y;
		}

		if(x % y != 0){
			return gcd(y, x % y);
		}else{
			return y;
		}
	}

	public static void main(String[] args){
		System.out.println(gcd(256,48));
	}
}