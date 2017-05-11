package cn.gaotianye.actionWithWrong;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Java程序员们最常犯的10个错误
 * 2.判断一个数组是否包含一个值
 * 	No1代码起作用，但是没有必要把一个数组转化成列表，转化为列表需要额外的时间
 *  可以考虑使用No2、No3的代码
 * @author gaotianye
 */
public class Test2 {
	public static void main(String[] args) {
		String[] arr = {"1","2","3","4","5"};
		boolean b = isContains3("2",arr);
		System.out.println(b);
	}
	//No1
	private static boolean isContains(String str,String[] arr) {
		HashSet<String> set = new HashSet<String>(Arrays.asList(arr));
		boolean contains = set.contains(str);
		return contains;
	}
	//No2
	private static boolean isContains2(String str,String[] arr) {
		boolean contains = Arrays.asList(arr).contains(str);
		return contains;
	}
	//No3
	private static boolean isContains3(String str,String[] arr) {
		for (String s : arr) {
			if(s.equals(str)){
				return true;
			}
		}
		return false;
	}
}
