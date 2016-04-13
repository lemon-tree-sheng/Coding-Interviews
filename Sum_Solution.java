//求1+2+3+...+n。求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。

//短路特性

public class Sum_Solution {
    public int Sum_Solution(int n) {
        int res = n;
        boolean tmp = (res != 0) && ((res += Sum_Solution(n - 1)) != 0);
        return res;
    }
}