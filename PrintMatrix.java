/*输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，例如，如果输入如下矩阵：
* 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
*/

import java.util.ArrayList;
public class PrintMatrix{
	/**
	*第一种实现方式：给出四个标志变量规范住一个矩阵，然后迭代加入list，每一圈打完之后将标志变量分别改变一个坐标
	*，缩小矩阵，继续迭代加入list。需要注意的是单行单列的情况，由于一次行方向或列方向打印就可完成，故后面的打印
	*需要加入判断是否单行单列，如果单行或者单列，则不再打印
	*/
	public ArrayList<Integer> printMatrix(int[][] matrix){
		if(matrix == null){
			return null;
		}

		ArrayList<Integer> list = new ArrayList<Integer>();
	    int row = matrix.length - 1;
	    int col = matrix[0].length - 1;
		int left = 0, top = 0, right = col, bottom = row;

		while(left <= right && top <= bottom){
			for(int i = left; i <= right; i++){
				list.add(matrix[top][i]);
			}
			for(int i = top + 1; i <= bottom; i++){
				list.add(matrix[i][right]);
			}
			if(top != bottom)
				for(int i = right - 1; i >= left; i--){
					list.add(matrix[bottom][i]);
				}
			if(left != right)
				for(int i = bottom - 1; i > top; i--){
					list.add(matrix[i][left]);
				}
			left++; right--; top++; bottom--;
		}
		return list;
	}

	/**
	*第二种实现方式：通过索引的变化分别打印每条边，flag记录圈数以确定后续打印范围，每当打完一圈后列需要加1以跳入新的打印循环
	*，此种方式用元素个数size来防止单行单列的情况	
	*/
	public ArrayList<Integer> printMatrix(int [][] matrix) {
       if(matrix == null){
       		return null;
       }

       ArrayList<Integer> list = new ArrayList<Integer>();
       int i = 0, j = 0;
       int row = matrix.length - 1;
       int col = matrix[0].length - 1;
       int size = (row+1)*(col+1);
       int flag = 0;

       while(size > 0){
       		if(flag != 0){
       			j++;
       		}

       		while(j <= col - flag && size > 0){
       			list.add(matrix[i][j++]);
       			size--;
       		}
       		j--;

	       	while(++i <= row - flag && size > 0){
	       		list.add(matrix[i][j]);
	       		size--;
	       	}
	       	i--;

	       	while(--j >= 0 + flag && size > 0){
	       		list.add(matrix[i][j]);
	       		size--;
	       	}
	       	j++;

       		while(--i > 0 + flag && size > 0){
       			list.add(matrix[i][j]);
       			size--;
       		}
       		i++
       		flag++;
       }
       return list; 
    }


}