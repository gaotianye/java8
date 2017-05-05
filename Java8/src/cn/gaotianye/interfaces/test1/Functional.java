package cn.gaotianye.interfaces.test1;
/**
 * (1)语言设计者投入了大量精力来思考如何使现有的函数友好地支持lambda。
 * 最终采取的方法是：增加函数式接口的概念。
 * 
 * 函数式接口就是一个具有一个方法的普通接口。像这样的接口，可以被隐式转换为lambda表达式。
 * java.lang.Runnable与java.util.concurrent.Callable是函数式接口最典型的两个例子。
 * 
 * 在实际使用过程中，函数式接口是容易出错的：
 * 如有某个人在接口定义中增加了另一个方法，这时，这个接口就不再是函数式的了，并且编译过程也会失败。
 * 
 * 为了克服函数式接口的这种脆弱性并且能够明确声明接口作为函数式接口的意图，
 * Java 8增加了一种特殊的注解@FunctionalInterface
 * （Java 8中所有类库的已有接口都添加了@FunctionalInterface注解）。
 * 让我们看一下这种函数式接口的定义：
 */
@FunctionalInterface
public interface Functional {
	void method();
	/**
	 * (2)如果在提示是@FunctionalInterface情况下，
	 * 有多个方法的话，会编译失败，如下所示
	 */
//	void method2();
	/**
	 * (3)默认方法与静态方法并不影响函数式接口的契约，可以任意使用
	 */
	static void method3() {
		System.out.println("static ..... method3 ");
	}
	default void defaultMehtod4(){
		System.out.println("default ..... method4 ");
	}
	/**
	 * TODO (4)默认方法使接口有点像Traits
	 * （Scala中特征(trait)类似于Java中的Interface，但它可以包含实现代码，也就是目前Java8新增的功能），
	 * 但与传统的接口又有些不一样，它允许在已有的接口中添加新方法(????)，而同时又保持了与旧版本代码的兼容性。
	 */
}
