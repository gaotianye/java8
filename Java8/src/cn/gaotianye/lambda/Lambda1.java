package cn.gaotianye.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 一个不用被绑定到一个标识符上，并且可能被调用的函数。
 * 这个解释还不够通俗，lambda表达式可以这样定义：
 * 一段带有输入参数的可执行语句块。
 * @author gaotianye
 */
public class Lambda1 {
	public static void main(String[] args) {
		List<String> list = Arrays.asList("dc","asa","ab","aa");
		/*Collections.sort(list);
		for (String str : list) {
			System.out.println(str);
		}*/
		/*list.sort((o1,o2)->o1.compareTo(o2));
		for (String str : list) {
			System.out.println(str);
		}*/
		/*Collections.sort(list, (o1,o2)->o1.compareTo(o2));
		for (String str : list) {
			System.out.println(str);
		}*/
	}
}
