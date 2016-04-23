//滑动窗口的最大值。

//题目描述：给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么
//一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}； 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个： {[2,3,4],2,6,2,5,1}， {2,[3,
//4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。

//思路：使用首尾两个指针分别指向滑动窗口两边，在其中找到最大值保存，然后首尾两个指针分别后移，直到结束
public class Solution {
    public ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        ArrayList<Integer> list = new ArrayList<Integer>();
        int forward = size - 1;
        int pre = 0;
        if(num == null || size > num.length || pre > forward){
        	return list;
        }
        while(forward < num.length){
        	list.add(maxInt(num, pre++, forward++));
        }
        return list;
    }

    public int maxInt(int[] num, int begin, int end){
    	int max = num[begin];
    	for(int i = begin + 1; i <= end; i++){
    		if(num[i] > max){
    			max = num[i];
    		}
    	}
    	return max;
    }
}