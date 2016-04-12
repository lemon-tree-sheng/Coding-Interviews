//输入一棵二叉树，判断该二叉树是否是平衡二叉树。

//判断根节点的左右子树高度差是否小于等于1，是则继续递归判断左右子树是否都满足该条件

public class IsBalanced_solution{
	public boolean IsBalanced_Solution(TreeNode root) {
        if(root == null){
        	return true;
        }

        if(Math.abs(TreeDepth(root.left) - TreeDepth(root.right)) <= 1){
        	return IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);
        }
        return false;
    }
    
    public int TreeDepth(TreeNode pRoot){
    	if(pRoot == null){
            return 0;
        }
        int depthL = TreeDepth(pRoot.left) + 1;
        int depthR = TreeDepth(pRoot.right) + 1;
        return depthL > depthR ? depthL : depthR;
    }
}