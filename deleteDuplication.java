//删除链表中重复的结点。

//题目描述：在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。 
//例如，链表1->2->3->3->4->4->5 处理后为 1->2->5

//思路：本身题目很简单，用两个引用分别指向当前节点和之前节点，如果当前结点与下一节点重复则利用之前节点链接到后面节点。需要注意的是，这种
//做法是两两删除，如果节点数为奇数且与之前节点相同则会出错，因此我们做一个引用缓存，刚删除节点保存在这个缓存中，每一次新节点需先与缓存中
//引用相比较，相同则直接删除，然后继续遍历。
/*
 public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
*/
public class deleteDuplication {
    public ListNode deleteDuplication(ListNode pHead)
    {
    	if(pHead == null || pHead.next == null){
    		return pHead;
    	}

    	ListNode front = pHead;
    	ListNode tmpHead = new ListNode(0);
    	ListNode previous = tmpHead;
    	previous.next = front;
        ListNode cache = null;
    	while(front != null && front.next != null){
            if(cache != null && cache.val == front.val){
                front = front.next;
                previous.next = front;
                continue;
            }
    		if(front.val == front.next.val){
                cache = front;
    			previous.next = front.next.next;
    			front = previous.next;
    		}else{
    			previous = front;
    			front = front.next;
    		}
    	}
        
        if(front != null && cache != null && front.val == cache.val){
            previous.next = null;
        }
    	return tmpHead.next;
    }
}