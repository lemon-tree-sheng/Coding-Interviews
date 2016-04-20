//链表中环的入口结点。一个链表中包含环，请找出该链表的环的入口结点。

//思路：1：两个指针一前一后，从pHead出发，front指针向下链，然后previous将next指向null，然后previous跟上front，如此循环，当front.next = 
//null的时候，即为所求。

//思路：2：首先求环中节点数目，设两指针一快一慢，快指针一次两个节点，慢指针一次一个节点，最后相遇肯定在环中，然后再走一圈即可知道环中节
//数目；然后利用所求数目n，设两指针一前一后，前者先走n个节点，然后一起向下走，相遇的时候即为所求
/*
 public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
*/
public class EntryNodeOfLoop {
	//思路1实现
    public ListNode EntryNodeOfLoop(ListNode pHead)
    {
        if(pHead == null || pHead.next == null){
        	return null;
        }

        ListNode front = pHead, previous = front;
        while(front.next != null){
        	front = front.next;
        	previous.next = null;
        	previous = front;
        }

        return front;
    }
}