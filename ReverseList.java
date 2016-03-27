//题目：反转链表

/**在这只讨论节点大于等于三个的情况，使用三个指针，pre，in，post，分别指向相邻的三个节点，首节点在进行迭代操作之前首先指空，
​*然后进入迭代操作，in改指pre进行指向反转，然后pre指向in所指节点，in指向post所指节点，post向下滑动，为下一轮做准备，如此反
​*复，最后返回最后一个节点作为头指针即可。
​*/

public class ReverseList {
    public ListNode ReverseList(ListNode head) {
    	if(head == null){
    		return null;
    	}

    	if(head.next == null){
    		return head;
    	}

    	if(head.next.next == null){
    		ListNode root = head.next;
    		head.next.next = head;
    		head.next = null;
    		return root;
    	}

    	ListNode pre,in,post;
    	pre = head;
    	in = pre.next;
    	post = in.next;
    	pre.next = null;
    	while(post != null){
    		in.next = pre;
    		pre = in;
    		in = post;
    		post = post.next;
    	}
    	in.next = pre;
    	return in;
    }
}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}