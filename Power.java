//题目描述:给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。

/**
*解体思路：本题采用递归解决，指数进行右移，用得到的右移结果乘以右移结果，进行递归。需要注意的是当指数为奇数时，需要单独把漏掉
*的一次乘以底数乘回来
*/

public class Power {
    public double power(double base, int exponent) {
        if(exponent == 0 && base == 0){
			return 1;
		}
		
		int exp = exponent;
		exp = exponent > 0 ? exponent : -exponent;
		
		double result = powerHalf(base, exp);
				
		if(exponent < 0){
			result = 1/result;
		}
	
		return result;
  }
    
    public double powerHalf(double base, int exp){
		if(exp == 0){
			return 1;
		}
		
		if(exp == 1){
			return base;
		}
		
		double result = powerHalf(base, exp >> 1);
		result *= result;
		
		if(exp % 2 != 0){
			result *= base;
		}
		
		return result;
	}
}