//对称的二叉树。请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。

//我们可以重定义先序遍历访问根节后先访问右节点再访问左节点，然后与先访问左节点再访问右节点的原树进行比较，问题就很容易解决了
public class isSymmetrical {
    boolean isSymmetrical(TreeNode pRoot)
    {
        return isSymmetrical(pRoot, pRoot);
    }
    
    boolean isSymmetrical(TreeNode left, TreeNode right){
    	if(left == null && right == null){
    		return true;
    	}

    	if(left == null || right == null){
    		return false;
    	}

    	if(left.val != right.val){
    		return false;
    	}

    	return isSymmetrical(left.left, right.right) && isSymmetrical(left.right, right.left);
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

