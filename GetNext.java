//二叉树的下一个结点。给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。注意，树中的结点不仅包含左右子结点，
//同时包含指向父结点的指针。

//思路：如果该节点有右子树，则右子树的最左节点即为所求；没有右子树，则如果该节点为父节点的左节点，则父节点即为所求；若没有右子树且
//不为父节点的左子节点则一直往上走，直到找到节点有左节点即为所求

/*
public class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}
*/
public class Solution {
    public TreeLinkNode GetNext(TreeLinkNode pNode)
    {
        if(pNode == null){
        	return null;
        }

        TreeLinkNode target = null;
        if(pNode.right != null){
        	target = pNode.right;
        	while(target.left != null){
        		target = target.left;
        	}
        	return target;
        }else if(pNode.next != null){
        	target = pNode.next;
        	TreeLinkNode tmppNode = pNode;
        	while(target != null && target.left != tmppNode){
        		tmppNode = target;
        		target = target.next;
        	}

        	return target;
        }
        return null;
    }
}