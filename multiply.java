//构建乘积数组。给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。
//不能使用除法。

//思路：普通遍历相乘，对于i位置直接跳过，那样做的时间复杂度在O(n^2)，不推荐。现在我们先用迭代方式乘到当前元素的前一个，然后放入B[i]中，
//一次遍历做完后，然后把后面未乘进来的元素乘回来，同样使用迭代的方式，逐步累积因数。具体做法：先设B[0] = 1；则B[1] = B[0] * A[0] = A[0]；
//；B[2] = B[1] * A[1] = A[0] * A[1]，遍历完第一组。然后乘回来未乘上的元素，设tmp = A[len - 1], B[len - 2] *= tmp, tmp *= A[len -2], 遍
//历到第一个即可
public class multiply {
    public int[] multiply(int[] A) {
    	if(A == null || A.length <= 0){
    		return new int[0];
    	}

    	int len = A.length;
    	int[] B = new int[len];
    	B[0] = 1;
    	for(int i = 1; i < len; i++){
    		B[i] = B[i - 1] * A[i - 1];
    	}

    	int tmp = A[len - 1];
    	for(int i = len - 2; i >= 0; i--){
    		B[i] *= tmp;
    		tmp *= A[i];
    	}

    	return B;
    }
}