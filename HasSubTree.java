//题目：输入两颗二叉树A，B，判断B是不是A的子结构。

//二叉树相关算法，递归思想是惯用思考方式，本题就是首先找到相同节点，然后继续往下比较，root2可以首先结束

public class HasSubTree{
	public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if(null == root1 || null == root2){
            return false;
        }
 
        if(root1.val == root2.val){
            if(isSubTree(root1, root2)){
                return true;
            }
        }
         
        return HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);
    }
 
    public boolean isSubTree(TreeNode root1, TreeNode root2){
        if(root2 == null){
            return true;
        }
 
        if(root1 == null){
            return false;
        }
 
        if(root1.val == root2.val){
            return isSubTree(root1.left, root2.left) && isSubTree(root1.right, root2.right);
        }
 
        return false;
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