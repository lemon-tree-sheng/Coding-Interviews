//序列化二叉树。请实现两个函数，分别用来序列化和反序列化二叉树

//思路：我们知道，通过一棵二叉树的前序遍历序列和中序遍历序列可以还原一棵树，所以此题如果使用这种方式则明显可解。只是问题在于，在反序列化
//的时候需要全部读出序列化串后才能还原。

//于是我们可以采用层次遍历的方式序列化一棵树，在节点为null的时候使用#作为占位，因为反序列化的时候需要使用串的索引来确定父节点的子节点，
//也就是说我们需要将一棵树序列化成一棵完全二叉树，空节点使用#作为占位。

public class Serialize {
	String Serialize(TreeNode root) {
        if(root == null){
        	return null;
        }
        StringBuffer sb = new StringBuffer();
        ArrayList<TreeNode> list = new ArrayList<TreeNode>();
        int count = (1 << treeDepth(root)) - 1;//计数，拿到此树的深度后计算对应完全二叉树节点数
        list.add(root);
        count--;
        TreeNode tmpNode = null;
        
        //层次遍历二叉树，开始序列化
        while(list.size() > 0 && count >= 0){
        	tmpNode = list.remove(0);
        	if(tmpNode != null){
        		sb.append(tmpNode.val+",");
        		list.add(tmpNode.left);
        		list.add(tmpNode.right);
        	}else{
        		sb.append("#,");//#作为空节点占位符
        		list.add(null);
        		list.add(null);
        	}
        	count --;
        }
        return sb.toString();
    }

    TreeNode Deserialize(String str) {
    	if(str == null || str.length() == 0){
    		return null;
    	}
    	return Deserialize(str.split(","), 0);
    }

    TreeNode Deserialize(String[] strings, int index){
        
    	TreeNode newNode = null;
    	if(index < strings.length){
    		if(!strings[index].equals("#")){
    			newNode = new TreeNode(Integer.parseInt(strings[index]));
    			newNode.left = Deserialize(strings, 2 * index + 1);
    			newNode.right = Deserialize(strings, 2 * index + 2);
    		}
    	}
    	return newNode;
    }
    
    int treeDepth(TreeNode root){
    	int depth = 0;
    	if(root == null){
    		return depth;
    	}else{
    		int lDepth = treeDepth(root.left) + 1;
    		int rDepth = treeDepth(root.right) + 1;
    		return lDepth > rDepth ? lDepth : rDepth;
    	}
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