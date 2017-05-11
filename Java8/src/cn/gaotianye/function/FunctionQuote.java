package cn.gaotianye.function;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

/**
 * 方法引用：
 * 方法引用提供了非常有用的语法，可以直接引用已有Java类或对象（实例）的方法或构造器。
 * 与lambda联合使用，方法引用可以使语言的构造更紧凑简洁，减少冗余代码。
 * @author gaotianye
 *
 */
public class FunctionQuote {
	public static void main(String[] args) {
		/**
		 * 第一种方法引用是构造器引用，它的语法是Class::new，
		 * 或者更一般的Class< T >::new。请注意构造器没有参数。
		 */
//		Car c = Car.create(Car::new);
		//Supplier可以看成一个对象的工厂，每次调用返回一个给定类型的对象
		//等价于：
		Car c = Car.create(new Supplier<Car>() {
			@Override
			public Car get() {
				return new Car("baoma",1000000.00,2000.0);
			}
		});
		List<Car> cars = Arrays.asList(c);
		
		/**
		 * 第二种方法引用是静态方法引用，它的语法是Class::static_method。
		 * 请注意这个方法接受一个Car类型的参数
		 */
		cars.forEach(Car::collide);
		/**
		 * 第三种方法引用是特定类的任意对象的方法引用，它的语法是Class::method。
		 * 请注意，这个方法没有参数。
		 */
		cars.forEach(Car::repair);
		/**
		 * 第四种方法引用是特定对象的方法引用，它的语法是instance::method。
		 * 请注意，这个方法接受一个Car类型的参数
		 */
		Car police = Car.create(Car::new);
		cars.forEach(police::follow);
	}
}
