package cn.gaotianye.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * lambda语法表达式
 * @author gaotianye
 */
public class Lambda2 {
	public static void main(String[] args) {
		/**
		 * (1)最全的：
			(Type1 param1, Type2 param2, ..., TypeN paramN) -> {
				statment1;
				statment2;
		  		//.............
				return statmentM;
			}
		 */
		List<String> names = new ArrayList<String>();
		names.add("TaoBao");
		names.add("ZhiFuBao");
		//这里map方法就是接受了一个lambda表达式
		List<String> lowerCaseName = names.stream().map((String name)->{
			return name.toUpperCase();
		}).collect(Collectors.toList());
		/**
		 * (2)参数类型省略:绝大多数情况，编译器都可以从上下文环境中推断出lambda表达式的参数类型
			(param1, param2, ..., paramN) -> {
				statment1;
				statment2;
		  		//.............
				return statmentM;
			}
		 */
		List<String> lowerCaseName2 = names.stream().map((name)->{
			return name.toUpperCase();
		}).collect(Collectors.toList());
		/**
		 * (3)当lambda表达式的参数个数只有一个，可以省略小括号
			param1 -> {
				statment1;
				statment2;
		  		//.............
				return statmentM;
			}
		 */
		List<String> lowerCaseName3 = names.stream().map(name ->{
			return name.toUpperCase();
		}).collect(Collectors.toList());
		/**
		 * (4)当lambda表达式只包含一条语句时，可以省略大括号、return和语句结尾的分号。
		 */
		List<String> lowerCaseName4 = names.stream().map(name -> name.toUpperCase())
				.collect(Collectors.toList());
		/**
		 * (5)使用Method Reference
		 */
		List<String> lowerCaseName5 = names.stream().map(String::toLowerCase).collect(Collectors.toList());
	}
}
