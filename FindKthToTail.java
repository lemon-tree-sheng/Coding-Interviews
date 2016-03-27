//题目：输入一个链表，输出该链表中倒数第k个结点。

//定义两个指针，一个先驱，一个后继，中间相距k-1距离即可

public class FindKthToTail{
	public static ListNode findKthToTail(ListNode head,int k) {
    	if(head == null){
    		return null;
    	}
    	
    	ListNode pre = head, prePre = head;
    	int index = 1;
    	
    	while(pre != null && index != k ){
    		pre = pre.next;
    		index++;
    	}
    	
    	if(pre == null){
    		return null;
    	}
    	
    	while(pre.next != null){
    		pre = pre.next;
    		prePre = prePre.next;
    	}
    	
    	return prePre;
    }
}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}