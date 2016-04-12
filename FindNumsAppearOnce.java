//数组中只出现一次的数字。一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。

//不推荐蛮力比较，复杂度较高。利用异或我们可以知道两个数相同则异或为0，若数组中只有一个不同的数字则迭代每个数字进行异或运算，
//得到的结果就是该只出现一次的数字。我们同样进行迭代异或运算，最后结果肯定为两个不同数的异或结果，我们找到该结果从右到左第一
//1出现的位置，然后按该位置是否为1将数组分为两部分，那么两个只出现一次的数字自然被分开，而且各个部分剩余数字皆成对出现，我们
//从每一个部分里面找只出现一次的数字就很简单了

public class FindNumsAppearOnce{
	public void FindNumsAppearOnce(int[] array, int num1[], int num2[]){
		num1[0] = 0;
		num2[0] = 0;
		if(array == null || array.length < 2){
			return ;
		}

		int xor = 0;
		for(int i : array){
			xor ^= i;
		}

		int indexOf1 = findFirst1(xor);

		for(int i : array){
			if(nIs1(i, indexOf1)){
				num1[0] ^= i;
			}else{
				num2[0] ^= i;
			}
		}
	}

	public int findFirst1(int num){
		int i = 0;
		while((num & 1) == 0){
			num >>>= 1;
			i++;
		}
		return i;
	}

	public boolean nIs1(int num, int n){
		return ((num >>>= n) & 1) == 1;
	}
}