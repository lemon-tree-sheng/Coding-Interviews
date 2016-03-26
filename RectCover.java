//题目：我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？

/**
*目测出题人是想把这个题往斐波拉契公式上凑，才默认target = 0时返回值为1，经过分析前几项可以轻松推测这是一个斐波那契序列，
*编码解决并不困难，跟斐波那契差不多，一如既往不使用递归解决。
*/
public class RectCover {
    public int rectCover(int target) {
        if(target <= 1){
            return 1;
        }
         
        int pre = 1,prePre = 1;
        for(int i = 2; i <= target; i++){
            pre = pre + prePre;
            prePre = pre - prePre;
        }
         
        return pre;
    }
}