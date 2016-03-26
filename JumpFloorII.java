//题目：一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法

//这实际上是一个数学题，通过数学归纳法很容易得出本题结果为：2^(n-1)
public class JumpFloorII{
	public int JumpFloorII(int target) {
        if(target < 1){
			return 0;
		}
		
		return 1<<(target-1);
    }
}