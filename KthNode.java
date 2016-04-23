//二叉搜索树的第k个结点。给定一颗二叉搜索树，请找出其中的第k大的结点。例如， 5 / \ 3 7 /\ /\ 2 4 6 8 中，按结点数值大小顺序第三个
//结点的值为4。

//思路：中序遍历，cache[0] = k作为一个计数器

public class KthNode {
	TreeNode KthNode(TreeNode pRoot, int k)
    {
        if(pRoot == null && k < 1){
        	return null;
        }
        int[] cache = {k};
        return KthNode(pRoot, cache);
    }
    
    TreeNode KthNode(TreeNode pRoot, int[] cache)
    {
    	TreeNode result = null;
    	if(pRoot.left != null){
    		result = KthNode(pRoot.left, cache);
    	}  	
    	if(result == null){
    		if(cache[0] == 1){
    			return pRoot;
    		}else{
    			cache[0] -= 1;
    		}
    	}
    	if(result == null && pRoot.right != null){
    		result = KthNode(pRoot.right, cache);
    	}
    	return result;
    }
}