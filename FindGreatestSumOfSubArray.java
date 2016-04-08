//连续子数组的最大和.例如输入的数组为{1, -2, 3, 10, -4, 7, 2, -5}，和最大的子数组为｛3, 10, -4, 7, 2}。因此输出为该子数组的和18 。

//思路：当加上第i个数的时候，如果前面的保存的值为负，则保存当前索引指向的值，抛弃前面保存的值，如果为正，则加上当前索引
//指向值，然后将新的当前值与之前保存的最大值进行比较和更新
public class FindGreatestSumOfSubArray{
	public int FindGreatestSumOfSubArray(int[] array) {
        if(array == null || array.length <= 0){
        	return 0;
        }

        if(array.length == 1){
        	return array[0];
        }

        int sum = 0;
        int curSum = 0;

        for(int i : array){
        	if(curSum <= 0){
        		curSum = i;
        	}else{
        		curSum += i;
        	}

        	if(sum < curSum){
        		sum = curSum;
        	}
        }

        return sum;
    }
}