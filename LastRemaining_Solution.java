//孩子们的游戏(圆圈中最后剩下的数)。

//题目描述：每年六一儿童节,NowCoder都会准备一些小礼物去看望孤儿院的小朋友,今年亦是如此。HF作为NowCoder的资深元老,自然也准备了一些小游戏。
//其中,有个游戏是这样的:首先,让小朋友们围成一个大圈。然后,他随机指定一个数m,让编号为0的小朋友开始报数。每次喊到m的那个小朋友要出列唱首歌,
//然后可以在礼品箱中任意的挑选礼物,并且不再回到圈中,从他的下一个小朋友开始,继续0...m-1报数....这样下去....直到剩下最后一个小朋友,可以不用
//表演,并且拿到NowCoder名贵的“名侦探柯南”典藏版(名额有限哦!!^_^)。请你试着想下,哪个小朋友会得到这份礼品呢？

//约瑟夫出环问题，本题采用数组索引的变化解决
public class LastRemaining_Solution {
    public int LastRemaining_Solution(int n, int m) {
        if(n < 1 || m < 1){
        	return -1;
        }

        int[] children = new int[n];
        int remain = n;
        int i = -1;
        int speak = 0;
        while(remain > 0){
        	i++;
        	if(i >= n){
        		i = 0;
        	}
        	if(children[i] == -1)
        		continue;
        	speak++;
        	if(speak == m){
        		children[i] = -1;
        		remain--;
        		speak = 0;
        	}
        }
        return i;
    }
}