/**
*重建二叉树，通过给出二叉树的前序和中序遍历结果来重建二叉树
*分析：前序遍历的第一个节点为根节点，而中序遍历值相同的节点索引找到后，左右分别为左右子树，
*而通过索引也可以推出前序遍历中左右子树位置，然后通过递归完成子树的重建，最后进行链接
*/

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class ReConstructBinaryTree {
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
		//判断输入是否合法
        if(pre == null || in == null || pre.length != in.length || in.length <1){
            return null;
        }
         
        return constructBinaryTree(pre, 0, pre.length-1, in, 0, in.length-1);
    }
    //辅助重建函数 
    public TreeNode constructBinaryTree(int[] pre, int ps, int pe, int[] in, int is, int ie){
		//递归结束条件
        if(ps > pe){
            return null;
        }
        //重建根节点 
        int value = pre[ps];
        TreeNode node = new TreeNode(value);
        //找到中序根节点的索引 
        int index = is;
        while(index <= ie && in[index] != value){
            index++;
        }
         
        if(index > ie){
            throw new RuntimeException("Invalid input");
        }
         
        node.left = constructBinaryTree(pre, ps+1, ps+index-is, in, is, index-1);
        node.right = constructBinaryTree(pre, ps+index-is+1, pe, in, index+1, ie);
         
        return node;
    }
}