/**
*利用给出数组旋转可知，在遍历索引前面元素大于后面元素即为找到相应位置，然后对数组元素为空和唯一以及最小元素就在第一个时的判断
*/
public class minNumberInRotateArray {
	public int minNumberInRotateArray(int [] array) {
	    if(array == null || array.length < 1){
			return 0;//基本数据类型不能返回null
		}
		
		if(array.length == 1){
			return array[0];
		}
		
		int index = 0;
		//这里需要把索引的判断放在前面以防止下标越界
		while(index < array.length-1 && array[index] < array[index+1]){
			index++;
		}
		
		if(index == array.length-1){
			return array[0];
		}else{
			return array[index+1];
		}
    }
}
