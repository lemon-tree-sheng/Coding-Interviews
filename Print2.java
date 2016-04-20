//把二叉树打印成多行。从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。

//思路：这个跟按层次顺序打印二叉树差不多，只不过这个题需要将每一层都分开，而不是一行打出来，那么我们只需要每次确定该层个数，然后每次从
//头部取出已确定个数个节点，然后每次更新每层的个数即可。顺带说一句，如果之字形能够完成，这个题就很easy了。

import java.util.ArrayList;
/*
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
*/
public class Solution {
    ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
    	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    	if(pRoot == null){
    		return result;
    	}
    	
    	ArrayList<TreeNode> cache = new ArrayList<TreeNode>();
    	cache.add(pRoot);
    	int count = cache.size();
    	TreeNode tmp = null;
    	while(cache.size() > 0){
    		ArrayList<Integer> list = new ArrayList<Integer>();
    		while(count > 0){
    			tmp = cache.remove(0);
    			list.add(tmp.val);
    			if(tmp.left != null){
    				cache.add(tmp.left);
    			}
    			if(tmp.right != null){
    				cache.add(tmp.right);
    			}
    			count--;
    		}
    		result.add(list);
    		count = cache.size();
    	}
    	return result;
    }
    
}