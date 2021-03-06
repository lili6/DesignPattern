package lili.stringarray;

/**
 * Design an algorithm and write code to remove the duplicate characters in a string
 * without using any additional bufer.NOTE: One or two additional variables are fne.
 * An extra copy of the array is not.
 * FOLLOW UP
 * Write the test cases for this method.
 * 设计一个算法，移除一个字符串中重复的字符，且不适用buffer，1-2个变量最好
 * Created by lili on 2015/3/10.
 */
public class RemoveDuplicate {

	public static void main(String[] args)
	{

//		System.out.println (
	  /* tail:9
		len:11
		after remove:abcdefgzy y
		Process finished with exit code 0*/
//		removeDuplicates("abcdefgcfzy".toCharArray());
		removeDuplicates("aaabbb".toCharArray());
	}

	/**
	 * 去除第一个重复字符
	 * Time complexity is O(N2). N*N
	 * @param str
	 */
	public static void removeDuplicates(char[] str) {
		if (str == null) return;
		int len = str.length;
		if (len <2) return;

		int tail = 1;
		for (int i =1; i <len ; ++i) {
			int j;
			for (j = 0; j <tail; ++j) {
				if (str[i] == str[j]) break;
			}
			if (j == tail) {
				str[tail] = str[i];
				++tail;
			}
		}

		System.out.println("tail:" + tail) ;
		System.out.println("len:" + str.length) ;
		str[tail] = 0;

		//-------------print the result
		System.out.print("after remove:") ;
		for (int r=0; r <str.length; r++) {
			System.out.print(str[r]);
		}
	}

	/**
	 * With Additional Memory of Constant Size
	 * 格外的常量的内存使用
	 * @param str
	 */
	public static void removeDuplicatesEff(char[] str) {
		    if (str == null) return;
		    int len = str.length;
		    if (len < 2) return;
		   boolean[] hit = new boolean[256];
		    for (int i = 0; i < 256; ++i) {
			    hit[i] = false;
		    }
		    hit[str[0]] = true;
		   int tail = 1;
		   for (int i = 1; i < len; ++i) {
			   if (!hit[str[i]]) {
				   str[tail] = str[i];
				   ++tail;
				   hit[str[i]] = true;
				  }
			   }
		  str[tail] = 0;
		 }
}
