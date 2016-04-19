//链表中环的入口结点。一个链表中包含环，请找出该链表的环的入口结点。


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