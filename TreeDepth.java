//二叉树的深度

//递归思路，当前结点不为空时深度加1，然后递归左子树和右子树
public class TreeDepth{
	public int TreeDepth(TreeNode pRoot)
    {
    	if(pRoot == null){
            return 0;
        }
        int depthL = TreeDepth(pRoot.left) + 1;
        int depthR = TreeDepth(pRoot.right) + 1;
        return depthL > depthR ? depthL : depthR;
    }
}