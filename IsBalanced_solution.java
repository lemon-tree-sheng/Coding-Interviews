//输入一棵二叉树，判断该二叉树是否是平衡二叉树。

//思路1：判断根节点的左右子树高度差是否小于等于1，是则继续递归判断左右子树是否都满足该条件。这种方法需要遍历节点多次

//思路2：后序遍历思考，每次先比较左右子树高度，然后更新节点高度到父节点，这样不断进行比较只需要遍历节点1次

public class IsBalanced_solution{
	//思路1：
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
    //思路2：
    public boolean IsBalanced_Solution(TreeNode root) {
        return IsBalanced_Solution(root, new int[1]);
    }

    public boolean IsBalanced_Solution(TreeNode root, int[] depth) {
        if(root == null){
        	depth[0] = 0;
        	return true;
        }

        int[] left = new int[1];
        int[] right = new int[1];
        if(IsBalanced_Solution(root.left, left) && IsBalanced_Solution(root.right, right)){
        	int diff = left[0] - right[0];
        	if(diff >= -1 && diff <= 1){
        		depth[0] = 1 + (left[0] > right[0] ? left[0] : right[0]);
        		return true;
        	}
        }
        return false;
    }
}