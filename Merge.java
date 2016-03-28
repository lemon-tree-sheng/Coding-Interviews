//题目:输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。

/*第一种方式：重新定义一个节点root和flag，root作为新链表头，flag随着添加元素的增加向下滑动，用给出的两个链表不断比较，较小的链上新链，
*然后向下滑动，直到某个链表比较完，然后将剩余另一链表链上新表即可
*/
public class Solution {
    public ListNode merge(ListNode list1,ListNode list2) {
        if(list1 == null){
        	return list2;
        }

        if(list2 == null){
        	return list1;
        }

        ListNode root = new ListNode();
        ListNode flag = root;
        while(list1 != null && list2 != null){
        	if(list1.val < list2.val){
        		flag.next = list1;
        		list1 = list1.next;
        	}else{
        		flag.next = list2;
        		list2 = list2.next;
        	}
        	flag = flag.next;
        }

        if(list1 != null){
        	flag.next = list1;
        }

        if(list2 != null){
        	flag.next = list2;
        }

        return root.next;
    }

/**
*第二种方式：使用递归方式，比较两链表的首节点，得到较小节点后，递归合并剩下节点链表
*/
    public ListNode merge(ListNode list1,ListNode list2) {
        if(list1 == null){
        	return list2;
        }

        if(list2 == null){
        	return list1;
        }

        ListNode tmp = list1;
        if(tmp.val < list2.val){
        	tmp.next = merge(tmp.next,list2);
        }else{
        	tmp = list2;
        	tmp.next = merge(list1,tmp.next);
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