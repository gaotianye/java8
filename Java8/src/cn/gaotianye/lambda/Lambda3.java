package cn.gaotianye.lambda;
/**
 * 了解即可
 * @author gaotianye
 *
 */
public class Lambda3 {
	public static void main(String[] args) {
		/**
		 * 方法引用语法格式有3种：
			(1)objectName::instanceMethod
			(2)ClassName::staticMethod
				1和2等同于把lambda表达式的参数直接当成instanceMethod|staticMethod的参数来调用。
				比如System.out::println等同于x->System.out.println(x);
					Math::max等同于(x, y)->Math.max(x,y)
			(3)ClassName::instanceMethod
				等同于把lambda表达式的第一个参数当成instanceMethod的目标对象，
				其他剩余参数当成该方法的参数。
				比如String::toLowerCase等同于x->x.toLowerCase()。
		 */
		/**
		 * 构造器引用语法如下：
			ClassName::new，把lambda表达式的参数当成ClassName构造器的参数 。
			例如BigDecimal::new等同于x->new BigDecimal(x)。
		 */
	}
}
