//矩阵中的路径。

//题目描述：请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一个格子开始，每一步可以
//在矩阵中向左，向右，向上，向下移动一个格子。如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。 例如 a b c e s f c s a 
//d e e 矩阵中包含一条字符串"bcced"的路径，但是矩阵中不包含"abcb"路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径
//不能再次进入该格子。

//思路：这是一个可以用回朔法解决的典型题。首先，在矩阵中任选一个格子作为路径的起点。假设矩阵中某个格子的字符为ch，那么这个格子不可能处
//在路径上的第i个位置。如果路径上的第i个字符不是ch，那么这个格子不可能处在路径上的第i个位置。如果路径上的第i个字符正好是ch，那么往相邻
//的格子寻找路径上的第i+1个字符。除在矩阵边界上的格子之外，其他格子都有4个相邻的格子。重复这个过程知道路径上的所有字符都在矩阵中找到相
//应的位置。 
//由于回朔法的递归特性，路径可以被开成一个栈。当在矩阵中定位了路径中前n个字符的位置之后，在与第n个字符对应的格子的周围都没有找到第n+1个
//字符，这个时候只要在路径上回到第n-1个字符，重新定位第n个字符。 由于路径不能重复进入矩阵的格子，还需要定义和字符矩阵大小一样的布尔值矩
//阵，用来标识路径是否已经进入每个格子。 当矩阵中坐标为（row,col）的格子和路径字符串中下标为pathLength的字符一样时，从4个相邻的格子(row,
//col-1),(row-1,col),(row,col+1)以及(row+1,col)中去定位路径字符串中下标为pathLength+1的字符。 如果4个相邻的格子都没有匹配字符串中下标为p
//athLength+1的字符，表明当前路径字符串中下标为pathLength的字符在矩阵中的定位不正确，我们需要回到前一个字符(pathLength-1)，然后重新定位。 
//一直重复这个过程，直到路径字符串上所有字符都在矩阵中找到合适的位置
public class hasPath {
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str)
    {
    	if (matrix == null || matrix.length != rows * cols || str == null || str.length < 1) {
            return false;
        }

        boolean[] visited = new boolean[rows * cols];
        for (int i = 0; i < visited.length; i++) {
            visited[i] = false;
        }

        int[] pathLength = {0};
        // 以每一个点为起始进行搜索
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (hasPathCore(matrix, rows, cols, str, visited, i, j, pathLength)) {
                    return true;
                }
            }
        }
        return false;
    }
	
    private boolean hasPathCore(char[] matrix, int rows, int cols, char[] str, boolean[] visited,
                                       int row, int col, int[] pathLength) {
        if (pathLength[0] == str.length) {
            return true;
        }
        boolean hasPath = false;

        if (row >= 0 && row < rows
                && col >= 0 && col < cols
                && matrix[row * cols + col] == str[pathLength[0]]
                && !visited[row * cols + col]) {

            visited[row * cols + col] = true;
            pathLength[0]++;

            hasPath = hasPathCore(matrix, rows, cols, str, visited, row, col - 1, pathLength)
                    || hasPathCore(matrix, rows, cols, str, visited, row - 1, col, pathLength)
                    || hasPathCore(matrix, rows, cols, str, visited, row, col + 1, pathLength)
                    || hasPathCore(matrix, rows, cols, str, visited, row + 1, col, pathLength);

            if (!hasPath) {
                pathLength[0]--;
                visited[row * cols + col] = false;
            }
        }
        return hasPath;
    }
}