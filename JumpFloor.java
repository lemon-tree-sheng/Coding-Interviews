//本题用递归思想很好理解，第一步可以跨一个台阶，剩下JumpFloor(target - 1)中走法，跨两个台阶则剩下 JumpFloor(target - 2)
 //种走法，加起来就好。只是递归效率太低，不推荐使用，仔细观察会发现递归式归纳起来和斐波拉契很像，使用迭代的方式替代递归调用
 
public class JumpFloor{
	public static int JumpFloor(int target) {
		if(target < 1){
			return 0;
		}
		
		if(target <= 2){
			return target;
		}
		
		int pre = 2, prePre =1;
		for(int i = 3; i <= target; i++){
			pre = pre + prePre;
			prePre = pre - prePre;
		}
		
		return pre;
	}
}