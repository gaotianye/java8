package cn.gaotianye.test1;

import java.util.Arrays;
import java.util.List;

public class LambdaTest {
	public static void main(String[] args) {
		//1、Java7
		/*List<String> asList = Arrays.asList("1","2","3");
		for (String str : asList) {
			System.out.println(str);
		}*/
		//2、Java8     
		//(1)参数e的类型是由编译器推测出来的
//		Arrays.asList("a","b","c").forEach(e -> System.out.println(e));
		//(2)同时，也可以通过把参数类型与参数包括在括号中的形式直接给出参数的类型(错误类型会编译报错)
//		Arrays.asList("a","b","c").forEach((String e) -> System.out.println(e));
		/**
		 * (3)在某些情况下lambda的函数体会更加复杂，
		 * 这时可以把函数体放到在一对花括号中，就像在Java中定义普通函数一样
		 */
		/*Arrays.asList("a","b","c").forEach(e ->{
			System.out.println(e);
			System.out.println(e);
		});*/
		/**
		 * (4)Lambda可以引用类的成员变量与局部变量
		 * （如果这些变量不是final的话，它们会被隐含的转为final，这样效率更高）。
		 * 例如，下面两个代码片段是等价的：
		 */
		/*String seperator = "//";
		Arrays.asList("a","b","c").forEach(e -> System.out.println(e+seperator));
		
		final String s = "\\";
		Arrays.asList("a","b","c").forEach(e -> System.out.println(e+s));*/
		//编译失败，因为lambda内部不能使用非final类型的变量
		/*for(int i=0;i<5;i++){
			Arrays.asList("a","b","c").forEach(e -> System.out.println(e+i));
		}*/
		/**
		 * (5)Lambda可能会返回一个值。返回值的类型也是由编译器推测出来的。
		 * 如果lambda的函数体只有一行的话，那么没有必要显式使用return语句。
		 * 下面两个代码片段是等价的：
		 */
		/*List<String> list = Arrays.asList("b","a","x","cd","ek","d","ai","ee");
		list.sort((e1,e2) -> e1.compareTo(e2));
		
		list.sort((e1,e2) -> {
			int ct = e1.compareTo(e2);
			return ct;
		});
		for (String str : list) {
			System.out.println(str);
		}*/
	}
}
