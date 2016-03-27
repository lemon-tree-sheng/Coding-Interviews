/**题目描述：输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
*所有的偶数位于位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
*/

import java.util.Queue;
import java.util.LinkedList;

public class ReOrderArray{

	/**
	*这个题相对于原书上的题有一点不同，那就是需要奇偶数的相对位置分别保持不变，那么采用类似快排的做法就行不通了，快排本身就是不稳定
	*的，这里采用的是类似插入排序的思想，遍历过程中在遇到奇数时进行插入，同时奇数区需要一个边界索引作为标志，其他的就很简单了
	*/
	public void reOrderArray(int [] array) {
       if(array == null || array.length == 0){
            return ;
        }
 
        int tmp = 0;
        int oddEnd = -1;
        for(int i = 0; i < array.length; i++){
            if(array[i] % 2 != 0){
                tmp = array[i];
                for(int j = i; j > oddEnd+1; j--){
                    array[j] = array[j-1];
                }
                array[++oddEnd] = tmp;
            }
        }
    }

    //第二种做法，使用两个队列分别存储奇偶数，然后奇偶数分别出队列，这种做法耗时间耗内存，不推荐
	public static void reOrderArray(int[] array){
		if(array == null || array.length == 0){
			return ;
		}
		
		Queue<Integer> queue1 = new LinkedList<Integer>();
		Queue<Integer> queue2 = new LinkedList<Integer>();

		int index = 0;
		while(index < array.length){
			if(array[index] % 2 != 0){
				queue1.add(array[index++]);//奇数存在队列1中
			}else{
				queue2.add(array[index++]);
			}
		}

		index = 0;
		while(index < array.length){
			if(!queue1.isEmpty()){
				array[index++] = queue1.poll();
			}else{
				array[index++] = queue2.poll();
			}
		}
	}

}