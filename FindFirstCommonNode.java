//两个链表的第一个公共结点。输入两个链表，找出它们的第一个公共结点。

//思路1：暴力遍历，对链表的1的每一个节点都遍历链表2，寻找第一个相同节点，不推荐

//思路2：利用两个辅助栈，分别压入两个链表的每个节点，然后顺序出栈，当第一个不相同节点出现时，则表示上一个节点为第一个相同节点

//思路3：先行法，先遍历两个链表，得到长度后，作差，然后利用差让长的链表先走相差步，然后一起向下走，遇到相同节点即为所求


import java.util.Stack;
public class FindFirstCommonNode{
	//思路2：
	public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2){
		if(pHead1 == null || pHead2 == null){
			return null;
		}
		Stack<ListNode> stack1 = new Stack<ListNode>();
		Stack<ListNode> stack2 = new Stack<ListNode>();

		while(pHead1 != null){
			stack1.push(pHead1);
			pHead1 = pHead1.next;
		}

		while(pHead2 != null){
			stack2.push(pHead2);
			pHead2 = pHead2.next;
		}

		ListNode tmp = null;
		while(!stack1.isEmpty() && !stack2.isEmpty() && stack1.peek() == stack2.peek()){
			tmp = stack1.pop();
			stack2.pop();
		}
		return tmp;
	}
}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}