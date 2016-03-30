/*题目：输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。
*假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，序列4，5,3,2,1是该压栈序列
*对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。
*/

//利用辅助栈来做，按照给出入栈序列依次入栈，直到栈顶元素等于出栈序列首元素值，则
//出栈，出栈序列首元素后移一位，此过程不断迭代，直到出栈序列结束则返回真，否则返回假

import java.util.Stack;
public class IsPopOrder{
	public boolean IsPopOrder(int [] pushA,int [] popA) {
		if(pushA == null || popA == null || pushA.length == 0 || popA.length == 0 || pushA.length != popA.length){
			return false;
		}

		Stack<Integer> stack = new Stack<Integer>();
		int pushIndex = 0, popIndex = 0;

		while(popIndex < popA.length){
			while(pushIndex < pushA.length && (stack.isEmpty() || stack.peek() != popA[popIndex])){
				stack.push(pushA[pushIndex]);
				pushIndex++;
			}

			if(stack.peek() == popA[popIndex]){
				stack.pop();
				popIndex++;
			}else{
				return false;
			}
		}
		return true;
    }
}