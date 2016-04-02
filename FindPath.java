//输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
//路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。

/**
*由于路径是从根节点出发到叶节点，也就是说路径总是以根节点为起点，因此我们首先需要遍历根节点，在树的前序，中序，后序三种遍历方式
*中，只有前序遍历是首先访问根节点的。当用前序遍历的方式访问到某一结点时，我们把该节点添加到路径上，并累加该节点的值。如果该节点
*为叶节点并且路径中节点值的和刚好等于目标数，则当前的路径符合要求，我们把它加入到结果集合中。如果当前结点不是叶节点，则继续访问
*它的子节点。当前结点访问结束后，递归函数将自动回到它的父节点。因此我们在函数退出之前要在路径上删除当前节点并减去当前结点的值，以
*确保返回父节点时路径刚好是从根节点到父节点的路径
*不难看出保存路径的数据结构实际上是一个枝，因为路径要与递归调用的状态一致，而递归调用的本质是一个压栈出栈的过程。
*/

public class FindPath{
	public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(root == null){
        	return result;
        }
        ArrayList<Integer> list = new ArrayList<Integer>();
        FindPath(root, 0, target, list, result);
        return result;
    }
	
	public void FindPath(TreeNode root, int curNum, int target, ArrayList<Integer> list, ArrayList<ArrayList<Integer>> result){
		if(root != null){
			curNum += root.val;
			list.add(root.val);
			
			if(curNum == target){
				if(root.left == null && root.right == null){
					ArrayList<Integer> tmp = new ArrayList<Integer>(list);
					result.add(tmp);
				}
			}else if(curNum < target){
				FindPath(root.left, curNum, target, list, result);
				FindPath(root.right, curNum, target, list, result);
			}
			
			list.remove(list.size() - 1);
		}
	}

}