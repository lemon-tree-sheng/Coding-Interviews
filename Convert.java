
//输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。

//递归思想：使用一个容量为1的缓冲区，保存左子树的最后一个节点，修改当前结点和缓冲区节点的指针，然后将当前结点放入缓冲区，递归处理
//右子树

public class Convert {
    public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree != null){
            TreeNode[] tmpLastNode = new TreeNode[1];
            Convert(pRootOfTree, tmpLastNode);
            TreeNode head = tmpLastNode[0];
            while(head != null && head.left != null){
                head = head.left;
            }
            return head;
        }
        return null;
    }

    public void Convert(TreeNode pRootOfTree, TreeNode[] tmpLastNode){
        if(pRootOfTree != null){
            Convert(pRootOfTree.left, tmpLastNode);
            pRootOfTree.left = tmpLastNode[0];
            if(tmpLastNode[0] != null){
                tmpLastNode[0].right = pRootOfTree;
            }
            tmpLastNode[0] = pRootOfTree;
            if(tmpLastNode[0].right != null){
                Convert(tmpLastNode[0].right, tmpLastNode);
            }
        }
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