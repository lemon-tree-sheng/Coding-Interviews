//最小的K个数

//简单排序后然后取出最靠前的k个数

import java.util.ArrayList;
public class Solution {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if(input == null || k <= 0 || k > input.length){
            return list;
        }
        
        for(int i = 0; i < input.length - 1; i++){
            int tmp = i;
            for(int j = i + 1; j < input.length; j++){
                if(input[j] < input[tmp]){
                    tmp = j;
                }
            }
            int tmpInt = input[tmp];
            for(int z = tmp; z > i; z--){
            	input[z] = input[z-1];
            }
            input[i] = tmpInt;
    	}
        
        for(int i = 0; i < k; i++){
            list.add(input[i]);
        }
        return list;
    }
}