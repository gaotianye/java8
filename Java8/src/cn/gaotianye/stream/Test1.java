package cn.gaotianye.stream;

import java.util.Arrays;
import java.util.List;

/**
 * 	1、Stream是元素的集合，这点让Stream看起来用些类似Iterator；
	2、可以支持顺序和并行的对原Stream进行汇聚的操作；
	
	大家可以把Stream当成一个高级版本的Iterator。
	原始版本的Iterator，用户只能一个一个的遍历元素并对其执行某些操作；
	高级版本的Stream，用户只要给出 需要对其包含的元素执行什么操作，
	比如“过滤掉长度大于10的字符串”、“获取每个字符串的首字母”等，
	具体这些操作如何应用到每个元素上，就给Stream就好了！
 * @author gaotianye
 */
public class Test1 {
	public static void main(String[] args) {
		/**
		 * 	1、创建Stream；
			2、转换Stream，每次转换原有Stream对象不改变，返回一个新的Stream对象
			（**可以有多次转换**）；
			3、对Stream进行聚合（Reduce）操作，获取想要的结果；
		 */
		List<Integer> nums = Arrays.asList(1,null,3,4,null);
		long count = nums.stream().filter(num -> num !=null).count();
		System.out.println(count);
	}
}
