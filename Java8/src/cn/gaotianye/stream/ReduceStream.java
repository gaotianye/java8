package cn.gaotianye.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 汇聚操作（也称为折叠--reduce）接收一个元素序列为输入，
 * 反复使用某个合并操作，把序列中的元素合并成一个汇总的结果。
 * 
 * 比如查找一个数字列表的总和或者最大值，或者把这些数字累积成一个List对象。
 * Stream接口有一些通用的汇聚操作，比如reduce()和collect()；
 * 也有一些特定用途的汇聚操作，比如sum(),max()和count()。
 * 
 * 注意：sum方法不是所有的Stream对象都有的，只有IntStream、LongStream和DoubleStream是实例才有。
 * @author gaotianye
 *
 */
public class ReduceStream {
	public static void main(String[] args) {
		/**
		 * 1.1、可变汇聚：把输入的元素们累积到一个可变的容器中，比如Collection或者StringBuilder；
		 * 
		 * 可变汇聚对应的只有一个方法：collect，
		 * 正如其名字显示的，它可以把Stream中的要有元素收集到一个结果容器中（比如Collection）。
		 * 先看一下最通用的collect方法的定义（还有其他override方法）：
		 * <R> R collect(Supplier<R> supplier,
                  BiConsumer<R, ? super T> accumulator,
                  BiConsumer<R, R> combiner);
           Supplier supplier是一个工厂函数，用来生成一个新的容器；
           BiConsumer accumulator也是一个函数，用来把Stream中的元素添加到结果容器中；
           BiConsumer combiner还是一个函数，用来把中间状态的多个结果容器合并成为一个（并发的时候会用到）
		 */
	    ArrayList<Integer> nums = new ArrayList<Integer>();
	    nums.add(1);
	    nums.add(1);
	    nums.add(null);
	    nums.add(2);
	    nums.add(3);
	    nums.add(4);
	    nums.add(null);
	    nums.add(5);
	    nums.add(6);
	    nums.add(7);
	    nums.add(8);
	    nums.add(9);
	    nums.add(10);
	    List<Integer> numsWithoutNull = nums.stream().filter(num -> num != null).distinct().
	    		collect(() -> new ArrayList<Integer>(),
	    				(list, item) -> list.add(item),
	    				(list1, list2) -> list1.addAll(list2)
	    		);
	    /**
	     * 上面这段代码就是对一个元素是Integer类型的List，先过滤掉全部的null，去重，
	     * 然后把剩下的元素收集到一个新的List中
	     * 。
	     * 进一步看一下collect方法的三个参数，都是lambda形式的函数：
	     * 第一个函数生成一个新的ArrayList实例；
	     * 第二个函数接受两个参数，第一个是前面生成的ArrayList对象，二个是stream中包含的元素，
	     * 		函数体就是把stream中的元素加入ArrayList对象中。
	     * 		第二个函数被反复调用直到原stream的元素被消费完毕；
	     * 第三个函数也是接受两个参数，这两个都是ArrayList类型的，
	     * 		函数体就是把第二个ArrayList全部加入到第一个中；
	     */
//	    for (Integer integer : numsWithoutNull) {
//			System.out.println(integer);
//		}
	    /**
	     * 1.2、上面的collect方法调用也有点太复杂了，没关系！我们来看一下collect方法另外一个override的版本
	     * 
	     * Java8给我们提供了Collector的工具类–[Collectors].
	     * 其中已经定义了一些静态工厂方法，比如：Collectors.toCollection()收集到Collection中, 
	     * Collectors.toList()收集到List中和Collectors.toSet()收集到Set中。
	     * 
	     * JavaDoc:http://docs.oracle.com/javase/8/docs/api/java/util/stream/Collectors.html
	     */
	    List<Integer> numsWithoutNull2 = nums.stream().filter(num -> num != null).distinct().
	    		collect(Collectors.toList());
	    for (Integer integer : numsWithoutNull2) {
	    	System.out.println(integer);
	    }

		/**
		 * 2、其他汇聚：除去可变汇聚剩下的，一般都不是通过反复修改某个可变对象，
		 * 而是通过把前一次的汇聚结果当成下一次的入参，反复如此。比如reduce，count，allMatch；
		 */
	    /**
	     * 2.1：reduce方法很通用，count，sum等都可以使用其实现。reduce方法有三个override的方法，只介绍前2种
	     * 		Optional<T> reduce(BinaryOperator<T> accumulator);
				接受一个BinaryOperator类型的参数，在使用的时候我们可以用lambda表达式来。
	     */
	    ArrayList<Integer> ints = new ArrayList<Integer>();
	    ints.add(1);
	    ints.add(2);
	    ints.add(3);
	    ints.add(4);
	    ints.add(5);
	    ints.add(6);
	    ints.add(7);
	    ints.add(8);
	    ints.add(91);
	    ints.add(10);
	    System.out.println("ints sum is:" + ints.stream().reduce((sum, item) -> sum + item).get());
	    System.out.println("ints sum is:" + ints.stream().reduce(0, (sum, item) -> sum + item));
	    System.out.println("ints sum is:" + ints.stream().count());
	    /**
	     * 其他方法：
	     * 	– allMatch：是不是Stream中的所有元素都满足给定的匹配条件
			– anyMatch：Stream中是否存在任何一个元素满足匹配条件
			– findFirst: 返回Stream中的第一个元素，如果Stream为空，返回空Optional
			– noneMatch：是不是Stream中的所有元素都不满足给定的匹配条件
			– max和min：使用给定的比较器（Operator），返回Stream中的最大|最小值
	     */
	    System.out.println(ints.stream().anyMatch(item -> item < 10));
	    ints.stream().max((o1, o2) -> o1.compareTo(o2)).ifPresent(System.out::println);
	}
}
