//不用加减乘除做加法。写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。

//思路：使用位运算，第一步，两数相加，但是有进位则舍弃，做法是两个数进行异或；第二步，得到两个数相加时产生的进位个数，做法是两数相与
//然后左移一位；第三部，将前两步的结果进行相加

public class Add {
    public int Add(int num1,int num2) {
        int sum, carry;
        do{
            sum = num1 ^ num2;
            carry = (num1 & num2) << 1;
            
            num1 = sum;
            num2 = carry;
        }while(num2 != 0);
        return num1;
    }
}