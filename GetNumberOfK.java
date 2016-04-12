//数字在排序数组中出现的次数

//利用二分查找分别找到目标值的第一个索引和最后一个索引，作差加1即可

public class GetNumberOfK{
	public int GetNumberOfK(int [] array , int k) {
       	if(array == null || array.length <= 0){
       		return 0;
       	}
       	int begin = searchTheFirst(array, 0, array.length - 1, k);
       	int end = searchTheLast(array, 0, array.length - 1, k);
       	if(begin == -1 && end == -1){
       		return 0;
       	}
       	return end - begin + 1;
    }

    public int searchTheFirst(int[] array, int begin, int end, int k){
    	int index = binarySearch(array, begin, end, k);
    	if(index != -1){
    		if(index == 0 || array[index - 1] != k){
    			return index;
    		}else{
    			return searchTheFirst(array, begin, index - 1, k);
    		}
    	}
    	return -1;
    }

    public int searchTheLast(int[] array, int begin, int end, int k){
    	int index = binarySearch(array, begin, end, k);
    	if(index != -1){
    		if(index == array.length - 1 || array[index + 1] != k){
    			return index;
    		}else{
    			return searchTheLast(array, index + 1, end, k);
    		}
    	}
    	return -1;
    }

	public int binarySearch(int[] array, int begin, int end, int key){
		if(begin > end){
			return -1;
		}
		int mid = (begin + end) / 2;
		if(array[mid] == key){
			return mid;
		}else if(array[mid] < key){
			return binarySearch(array, mid + 1, end, key);
		}else{
			return binarySearch(array, begin, mid - 1, key);
		}
	}
}	