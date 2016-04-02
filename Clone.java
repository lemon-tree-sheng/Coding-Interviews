//输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点）。
//进行复杂链表的复制

//思路：new一个新节点，值和指针都相同，然后采用递归链接后面节点

public class Clone {
    public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree == null || (pRootOfTree.left == null && pRootOfTree.right == null)){
            return pRootOfTree;
        }
        
        pRootOfTree tmpNode = Convert(pRootOfTree.left);
        if(tmpNode.left == null){
            tmpNode.left = null;
        }
        tmpNode.right = pRootOfTree;
    }
}

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}