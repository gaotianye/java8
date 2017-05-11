package cn.gaotianye.actionWithWrong;
public class Test4 {
	/**
	 * 1、 HashMap和HashTable区别？
			HashTable是同步的，HashMap是异步的，所以HashMap比较常用
	 */
	/**
	 * 2、访问级别
	 * 		程序员们经常使用public作为类字段的修饰符，可以很简单的通过引用得到值，
	 * 		但这是一个坏的设计，按照经验，分配给成员变量的访问级别应该尽可能的低。
	 */
	/**
	 * 3、ArrayList与LinkedList的对比
	 * 		当程序员们不知道ArrayList与LinkedList的区别时，他们经常使用ArrayList，
	 * 		因为它看起来比较熟悉。然而，它们之前有巨大的性能差别。
	 * 		简而言之，如果有大量的增加删除操作并且没有很多的随机访问元素的操作，
	 * 		应该首先LinkedList。
	 * 		如果你刚接触它们，请查看 ArrayList vs. LinkedList来获得更多关于它们性能的信息。
	 */
	/**
	 * 4、可变与不可变
	 * 		不可变对象有许多的优点，比如简单，安全等等。
	 * 		但是对于每一个不同的值都需要一个独立的对象，太多的对象可能会造成大量的垃圾回收。
	 * 
	 * 		当选择可变与不可变时应该有一个平衡。
			一般的，可变对象用来避免产生大量的中间对象。
			一个典型的例子是连接大量的字符串。
			如果你用一个不可变的字符串，你会产生很多需要进行垃圾回收的对象。
			String result="";
			for(String s: arr){
			    result = result + s;
			}
			这很浪费CPU的时间，使用可变对象是正确的解决方案(比如StringBuilder)。
			
			有时在某些情况下也是需要可变对象的。
			比如将可变对象作为参数传入方法，你不用使用很多语句便可以得到多个结果。
			另外一个例子是排序和过滤：
				当然，你可以写一个方法来接收原始的集合，并且返回一个排好序的集合，
				但是那样对于大的集合就太浪费了
	 */
	/**
	 * 5、父类与子类的构造函数
	 * 这个编译期错误的出现是父类默认的构造方法未定义，
	 * 在java中，如果一个类没有定义构造方法，
	 * 编译器会默认的为这个类添加一个无参的构造方法。
	 * 
	 * 如果在父类中定义了构造方法，在这个例子中是Super(String s),
	 * 编译器就不会添加默认的无参构造方法，这就是上面这个父类的情形。
		
		子类的构造器，不管是无参还有有参，都会调用父类的无参构造器。
		因为编译器试图在子类的两个构造方法中添加super()方法。
		但是父类默认的构造方法未定义，编译器就会报出这个错误信息。
		想要修复这个问题，可以简单的通过
		1)在父类中添加一个Super()构造方法，像下面这样：
		public Super(){
    		System.out.println("Super");
		}
		2)移除父类自定义的构造方法
		3)在子类的构造方法中调用父类的super(value)方法。
	 */
}
