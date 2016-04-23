//机器人的运动范围。

//题目描述：地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，但是不能进入行坐标
//和列坐标的数位之和大于k的格子。 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。但是，它不能进入方格（35,38），因为3+
//5+3+8 = 19。请问该机器人能够达到多少个格子？

//思路：简单回溯即可解决。机器人从坐标(0,0)开始移动。当它准备进入坐标为(i,j)的格子时，通过检查坐标的数位和来判断机器人是否能够进入。如果
//机器人能够进入坐标为(i,j)的格子，我们接着再判断它能否进入四个相邻的格子(i,j-1)、(i-1,j),(i,j+1)和(i+1,j)。
public class movingCount {
    public int movingCount(int threshold, int rows, int cols) {
        if (threshold < 0 || rows < 1 || cols < 1) {
            return 0;
        }

        boolean[] visited = new boolean[rows * cols];
        for (int i = 0; i < visited.length; i++) {
            visited[i] = false;
        }

        return movingCountCore(threshold, rows, cols, 0, 0, visited);
    }
	
	private int movingCountCore(int threshold, int rows, int cols,
            int row, int col, boolean[] visited) {

		int count = 0;
		
		if (check(threshold, rows, cols, row, col, visited)) {
		visited[row * cols + col] = true;
		count = 1
		+ movingCountCore(threshold, rows, cols, row - 1, col, visited)
		+ movingCountCore(threshold, rows, cols, row, col - 1, visited)
		+ movingCountCore(threshold, rows, cols, row + 1, col, visited)
		+ movingCountCore(threshold, rows, cols, row, col + 1, visited);
		}
		
		return count;
	}
	
	private boolean check(int threshold, int rows, int cols,
            int row, int col, boolean[] visited) {
		return col >= 0 && col < cols
		&& row >= 0 && row < rows
		&& !visited[row * cols + col]
		&& (getDigitSum(col) + getDigitSum(row) <= threshold);
	}
	
	private int getDigitSum(int number) {
        int result = 0;
        while (number > 0) {
            result += (number % 10);
            number /= 10;
        }

        return result;
    }
}