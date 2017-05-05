package cn.gaotianye.stream;

import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * 创建Stream
 * @author gaotianye
 *
 */
public class Test2 {
	public static void main(String[] args) {
		/**
		 * 	方式一：通过Stream接口的静态工厂方法（注意：Java8里接口可以带静态方法）；
		 */
		//NO1:of方法：有两个overload方法，一个接受变长参数
		Stream<Integer> integerStream = Stream.of(1, 2, 3, 5);
		long c1 = integerStream.filter(e -> e>1).count();
		System.out.println("大于3得值有"+c1+"个");
		//of方法：接受单一值
		Stream<String> stringStream = Stream.of("taobao");
		//TODO 怎么求长度？？？？
//		Stream<String> c2 = stringStream.filter(e -> e.length());
		/*
		 * NO2:generator方法：生成一个无限长度的Stream，
		 * 其元素的生成是通过给定的Supplier
		 * （这个接口可以看成一个对象的工厂，每次调用返回一个给定类型的对象）
		 * 
		 * 三条语句的作用都是一样的，只是使用了lambda表达式和方法引用的语法来简化代码。
		 * 每条语句其实都是生成一个无限长度的Stream，其中值是随机的。
		 * 这个无限长度Stream是懒加载，
		 * 一般这种无限长度的Stream都会配合Stream的limit()方法来用。
		 */
		Stream.generate(new Supplier<Double>() {
			@Override
			public Double get() {
				return Math.random();
			}
		});
		Stream.generate(() -> Math.random());
		Stream.generate(Math::random);
		/*
		 * NO3:iterate方法：也是生成无限长度的Stream，和generator不同的是，
		 * 其元素的生成是重复对给定的种子值(seed)调用用户指定函数来生成的。
		 * 其中包含的元素可以认为是：seed，f(seed),f(f(seed))无限循环
		 */
		/**
		 * 方式二：通过Collection接口的默认方法
				（默认方法：Default method，也是Java8中的一个新特性，
				就是接口中的一个带有实现的方法，后续文章会有介绍）
				–stream()，把一个Collection对象转换成Stream
		 */
	}
}
