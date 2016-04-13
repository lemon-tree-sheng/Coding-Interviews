//和为S的连续正数序列。
//小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。但是他并不满足于此,他在想究竟有多少种连续的正数
//序列的和为100(至少包括两个数)。没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。现在把问题交给你,你能不能也很快的找出所有和
//为S的连续正数序列? Good Luck! 

//思路：定首尾两个标志数字，small和big分别为连续数字的最小和最大数字。small和big初始为1和2，当连续数字和大于目标时，small前进一位，
//，当连续数字和小于目标时，big前进一位，直到small到 sum/2 + 1 为止


import java.util.ArrayList;
public class FindContinuousSequence {
    public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
       	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
       	if(sum <= 1){
       		return result;
       	}

       	int small = 1;
       	int big = 2;
       	int tmpSum = 3;
       	while(small < sum/2 + 1){
       		if(tmpSum <= sum){
       			if(tmpSum == sum){
       				ArrayList<Integer> list = new ArrayList<Integer>();
           			for(int i = small; i <= big; i++){
           				list.add(i);
           			}
           			result.add(list);
       			}
       			big += 1;
       			tmpSum += big;
       		}else{
       			tmpSum -= small;
       			small += 1;
       		}
       	}
       	return result;
    }
}