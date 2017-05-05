package cn.gaotianye.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LambdaWithStream {
	public static void main(String[] args) {
		List<String> names = new ArrayList<String>();
		names.add("TaoBao");
		names.add("ZhiFuBao");
		//这里map方法就是接受了一个lambda表达式
		List<String> lowerCaseName = names.stream().map((String name)->{
			return name.toUpperCase();
		}).collect(Collectors.toList());
		for (String str : lowerCaseName) {
			System.out.println(str);
		}
	}
}
