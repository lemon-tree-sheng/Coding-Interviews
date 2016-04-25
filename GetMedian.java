//数据流中的中位数。

//题目描述：如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。如果从数据流中
//读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。

//简单将数字加入到数组当中，然后对数组进行排序，最后取出中位数。偷懒了，以后再改进程序。
import java.util.ArrayList;
import java.util.Arrays;
public class GetMedian {
	ArrayList<Integer> list = new ArrayList<Integer>();
    public void Insert(Integer num) {
    	if(num != null){
    		list.add(num);
    	}
    }

    public Double GetMedian() {
    	int len = list.size();
    	int[] array = new int[len];
    	for(int i = 0; i < len; i++){
    		array[i] = list.get(i);
    	}
    	Arrays.sort(array);
        return len % 2 == 0 ? (double)((array[len / 2] + array[len / 2 - 1])/ 2) : array[len / 2];
    }
}