//按之字形顺序打印二叉树。

//题目描述：请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，第三行按照从左到右的顺序
//打印，其他行以此类推。

//思路：设一个缓冲区，定义一个flag标志变量（1表示将访问节点的子节点按先左后右顺序加入缓冲区，-1则放过来），缓存每个节点，首先缓存入头节
//点，从缓存区的最右（也就是最后）开始弹出节点，往左逼近，以下每层都是如此从右往左弹出节点，弹出节点后将节点值存入list中，然后按照之前
//的flag标志按顺序加入子节点进入缓存区，直到弹出节点到最左边为止，即为一层遍历完毕。

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
public class Print {
    public ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
    	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    	if(pRoot == null){
    		return result;
    	}
    	
    	ArrayList<TreeNode> cache = new ArrayList<TreeNode>(); 
    	cache.add(pRoot);
    	int flag = -1;
    	int index = 0;
    	while(cache.size() > 0){
    		ArrayList<Integer> list = new ArrayList<Integer>();
    		index = cache.size() - 1;
    		TreeNode tmp = null;
    		flag = -flag;
    		while(index >= 0){
    			tmp = cache.remove(index--);
    			list.add(tmp.val);
    			if(flag == 1){
    				if(tmp.left != null){
    					cache.add(tmp.left);
    				}
    				if(tmp.right != null){
    					cache.add(tmp.right);
    				}
    			}else{
    				if(tmp.right != null){
    					cache.add(tmp.right);
    				}
    				if(tmp.left != null){
    					cache.add(tmp.left);
    				}
    			}
    		}
    		result.add(list);
    	}
    	return result;
    }
}