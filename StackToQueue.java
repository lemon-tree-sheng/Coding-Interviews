/**
 
*思路：需要两个栈的配合来实现队列的先进先出，从尾部添加的特点。利用stack1实现队列的添加，
 
*每次出队列时检查stack2是否有值，没有则从stack1依次出栈添加，此时stack2中元素的顺序正好是
 
*先进来的元素靠近栈顶，出队列的话直接从stack2出栈即可；有的话直接从stack2出栈即可。
 
*/
 
import java.util.Stack;
 
  
 
public class StackToQueue {
 
    Stack<Integer> stack1 = newStack<Integer>();
 
    Stack<Integer> stack2 = newStack<Integer>();
 
      
 
    publicvoidpush(intnode) {
 
        stack1.push(node);
 
    }
 
      
 
    publicintpop() {
 
        if(!stack2.isEmpty()){
 
            return(int)stack2.pop();
 
        }else{
 
            while(!stack1.isEmpty()){
 
                stack2.push(stack1.pop());
 
            }
 
            returnstack2.pop();
 
        }
 
    }
 
}