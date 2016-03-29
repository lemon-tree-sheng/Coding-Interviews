//操作给定的二叉树，将其变换为源二叉树的镜像。

//二叉树的镜像，使用递归比较容易可以搞定，直接上代码
public class Mirror{
	public void mirror(TreeNode root) {
        if(root == null || (root.left == null && root.right == null)){
        	return ;
        }

        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        mirror(root.left);
        mirror(root.right);
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