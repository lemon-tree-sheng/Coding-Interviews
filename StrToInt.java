//把字符串转换成整数。将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。

//题目描述：这看起来是很简单的题目，实现基本功能 ，大部分人都能用10行之内的代码解决。可是，当我们要把很多特殊情况即测试用例都考虑进去，
//却不是件容易的事。解决数值转换问题本身并不难，但我希望在写转换数值的代码之前，应聘者至少能把空指针，空字符串”“，正负号，溢出等方方面
//面的测试用例都考虑到，并且在写代码的时候对这些特殊的输入都定义好合理的输出。当然，这些输出并不一定要和atoi完全保持一致，但必须要有显
//式的说明，和面试官沟通好。这个应聘者最大的问题就是还没有养成在写代码之前考虑所有可能的测试用例的习惯，逻辑不够严谨，因此一开始的代码
//只处理了最基本的数值转换。后来我每次提醒他一处特殊的测试用例之后，他改一处代码。尽管他已经做了两次修改，但仍然有不少很明显的漏洞，特
//殊输入空字符串”“，边界条件比如最大的正整数与最小的负整数等。由于这道题思路本身不难，因此我希望他把问题考虑得极可能周到，代码尽量写完
//整。

//题目很简单，只不过用例中会有前面出现符号+/-，以及中间出现字母，多了些判断而已。另外，0到9的ASCII码值为48~57
public class StrToInt {
    public int StrToInt(String str) {
        if(str.equals("") || str.length() == 0){
            return 0;
        }
        char[] charArray = str.toCharArray();
        int weight = 1;
        int result = 0;
        int sign = 1;
        for(int i = charArray.length - 1; i >= 0; i--){
            if(charArray[i] == '-'){
                sign = -1;
                continue;
            }else if(charArray[i] == '+'){
                continue;
            }
             
            if(charArray[i] < 48 || charArray[i] > 57){
                return 0;
            }
             
            result += (charArray[i] - 48) * weight;
            weight *= 10;
        }
        return result * sign;
    }
}