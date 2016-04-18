//正则表达式匹配

//题目描述：请实现一个函数用来匹配包括'.'和'*'的正则表达式。模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次
//（包含0次）。 在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"
//均不匹配

//思路：每次从字符串里拿出一个字符和模式中的字符去匹配。先来分析如何匹配一个字符。如果模式中的字符ch是‘.’，那么它可以匹配字符串中的任意
//字符。如果模式中的字符ch不是’.’而且字符串中的字符也是ch，那么他们相互匹配。当字符串中的字符和模式中的字符相匹配时，接着匹配后面的字符
//。相对而言当模式中的第二个字符不是‘*’时问题要简单很多。如果字符串中的第一个字符和模式中的第一个字符相匹配，那么在字符串和模式上都向后
//移动一个字符，然后匹配剩余的字符串和模式。如果字符串中的第一个字符和模式中的第一个字符不相匹配，则直接返回false。当模式中的第二个字符
//是‘*’时问题要复杂一些，因为可能有多种不同的匹配方式。一个选择是在模式上向后移动两个字符。这相当于‘*’和它面前的字符被忽略掉了，因为‘*’
//可以匹配字符串中0个字符。如果模式中的第一个字符和字符串中的第一个字符相匹配时，则在字符串向后移动一个字符，而在模式上有两个选择：我们
//可以在模式上向后移动两个字符，也可以保持模式不变。

public class match {
    public boolean match(char[] str, char[] pattern)
    {
        if(str == null || pattern == null){
        	return false;
        }

        return match(str, 0, pattern, 0);
    }

    public boolean match(char[] str, int strIndex, char[] pattern, int paIndex){
    	if(strIndex >= str.length && paIndex >= pattern.length){
    		return true;
    	}
    	
    	if(strIndex < str.length && paIndex >= pattern.length){
    		return false;
    	}
    	
    	if(paIndex + 1 < pattern.length && pattern[paIndex + 1] == '*'){
    		if(strIndex >= str.length){
    			return match(str, strIndex, pattern, paIndex + 2);
    		}else{
    			if(str[strIndex] == pattern[paIndex] || pattern[paIndex] == '.'){
    				return match(str, strIndex + 1, pattern, paIndex + 2) || match(str, strIndex + 1, pattern, paIndex)
    						 || match(str, strIndex, pattern, paIndex + 2);//或运算符连接的三个函数表达分别表示，匹配1个，多个，0个字符
    			}else{
    				return match(str, strIndex, pattern, paIndex + 2);
    			}
    		}
    	}
    	
    	if(strIndex >= str.length){
    		return false;
    	}else{
    		if(str[strIndex] == pattern[paIndex] || pattern[paIndex] == '.'){
				return match(str, strIndex + 1, pattern, paIndex + 1);
			}
    	}
    	
    	return false;
    }
}

