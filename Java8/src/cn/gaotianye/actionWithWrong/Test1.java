package cn.gaotianye.actionWithWrong;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Java程序员们最常犯的10个错误
 * 1、将数组转化为列表
 * 	  不要只使用，Arrays.asList(arr)
 * 	  而是用new ArrayList<String>(Arrays.asList(arr));
 * @author gaotianye
 */
public class Test1 {
	public static void main(String[] args) {
		String[] arr = {"1","2","3"};
		List<String> list = Arrays.asList(arr);
		for (String str : list) {
			System.out.println(str);
		}
		System.out.println("=========");
/*		list.add("4");
		for (String str : list) {
			System.out.println(str);
		}*/
		//没有增加元素的方法，所以它的大小是固定的
		//解决问题：
		ArrayList<String> arrList = new ArrayList<String>(Arrays.asList(arr));
		arrList.add("4");
		for (String str : arrList) {
			System.out.println(str);
		}
	}
}
