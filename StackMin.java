//定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。

//使用迭代器，始终保存较小值，最后返回最小值，还能不破坏栈结构
import java.util.Stack;
import java.util.Iterator;
public class StackMin{

	Stack<Integer> stack = new Stack<Integer>();
	public void push(int node) {
        stack.push(node);
    }
    
    public void pop() {
        stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int min() {
        int min = top();

        Iterator<Integer> it = stack.iterator();
        while(it.hasNext()){
        	int tmp = it.next();
        	min = min > tmp ? tmp : min;
        }
        return min;
    }
}