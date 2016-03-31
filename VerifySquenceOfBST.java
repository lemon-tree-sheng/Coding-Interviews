//输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。

//思路：后序遍历结果最后一个是根节点，前面的节点分别为根节点的左子树和右子树，找出分界点并判断右子树是否有小于
//根节点的节点，如果有则直接返回false，没有则对分节点两边的左右子树进行递归
public class VerifySquenceOfBST{
	public boolean VerifySquenceOfBST(int[] sequence){
		if(sequence == null || sequence.length <= 0){
			return false;
		}

		return VerifySquenceOfBST(sequence, 0, sequence.length - 1);

	}

	public boolean VerifySquenceOfBST(int[] sequence, int front, int rear){
		if(front >= rear){
			return true;
		}

		int index = 0;
		while(index < rear && sequence[index] < sequence[rear]){
			index++;
		};
		if(index == rear ){
			return VerifySquenceOfBST(sequence, 0, rear - 1);
		}else{
			int tmp = index;
			while(tmp < rear){
				if(sequence[tmp++] < sequence[rear]){
					return false;
				}
			}
		}

		return VerifySquenceOfBST(sequence, 0, index - 1) && VerifySquenceOfBST(sequence, index, rear - 1);
	}
}