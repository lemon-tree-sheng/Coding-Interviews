//题目：从上往下打印出二叉树的每个节点，同层节点从左至右打印。

//思路：使用一个队列进行辅助，首先加入root节点，队列不为空时出队列一个节点，拿到对应值后立即将该节点的子节点加入队列
//，不断迭代出最后结果

public class PrintFromTopToBottom{
	public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
    	ArrayList<Integer> list = new ArrayList<Integer>();
    	
        if(root == null){
            return list;
        }
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode tmpNode = queue.poll();
            list.add(tmpNode.val);
            addChildToQueue(tmpNode, queue);
        }
        return list;
    }
    
    public void addChildToQueue(TreeNode root, Queue<TreeNode> queue){
        if(root.left != null){
            queue.add(root.left);
        }
        
        if(root.right != null){
            queue.add(root.right);
        }
    }
}