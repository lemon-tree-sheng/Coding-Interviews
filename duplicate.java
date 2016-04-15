//数组中重复的数字。

//题目描述：在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，但不知道有几个数字是重复的。也不知道每个数字重复
//几次。请找出数组中任意一个重复的数字。 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是重复的数字2或者3。

//思路1：对数组进行排序(时间复杂度O(nlgn))，然后遍历找出O(n);

//思路2：使用hash表，遍历过程中如果发现没有重复出现则放入hashmap中，如重复出现则结束。这种方法需要额外的hash表，空间复杂度为O(n)

//思路3：分析可知，如果没有重复则数组每一个元素值就等于其下标值，有重复则会有例外。那么我们遍历每个元素时，对比元素值和下标，如果相同则
//继续遍历，如果不同则对比数组中下标为元素值的的元素，相同则结束遍历，不同则进行交换。持续此过程直到出现重复值

public class duplicate {
    // Parameters:
    //    numbers:     an array of integers
    //    length:      the length of array numbers
    //    duplication: (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
    //                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
    //    这里要特别注意~返回任意重复的一个，赋值duplication[0]
    // Return value:       true if the input is valid, and there are some duplications in the array number
    //                     otherwise false
    public boolean duplicate(int numbers[],int length,int [] duplication) {
    	if(numbers == null || numbers.length != length || length <= 0){
    		return false;
    	}

    	for(int i = 0; i < length; i++){
    		if(numbers[i] < 0 || numbers[i] >= length){
    			return false;
    		}
    		
    		while(numbers[i] != i){
    			if(numbers[numbers[i]] == numbers[i]){
    				duplication[0] = numbers[i];
    				return true;
    			}else{
    				swap(numbers, i, numbers[i]);
    			}
    		}
    	}
    	return false;
    }
    
    public void swap(int[] numbers, int x, int y){
    	int tmp = numbers[x];
    	numbers[x] = numbers[y];
    	numbers[y] = tmp;
    }
}