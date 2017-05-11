package cn.gaotianye.stream;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 转换Stream其实就是把一个Stream通过某些行为转换成一个新的Stream。
 * Stream接口中定义了几个常用的转换方法，下面我们挑选几个常用的转换方法来解释。
 * 
 * Stream里有个操作函数的集合，每次转换操作（lazy操作）就是把转换函数放入这个集合中，
 * 在汇聚操作（action）的时候循环Stream对应的集合，然后对每个元素执行所有的函数。
 * @author gaotianye
 *
 */
public class TransformStream {
	public static void main(String[] args) {
		/**
		 * 1. distinct: 
		 * 	对于Stream中包含的元素进行去重操作（去重逻辑依赖元素的equals方法），
		 *	新生成的Stream中没有重复的元素；
		 */
		/**
		 * 2. filter: 
		 * 	对于Stream中包含的元素使用给定的过滤函数进行过滤操作，新生成的Stream只包含符合条件的元素；
		 */
		/**
		 * 3. map: 
		 * 	对于Stream中包含的元素使用给定的转换函数进行转换操作，新生成的Stream只包含转换生成的元素。
		 * 	这个方法有三个对于原始类型的变种方法，分别是：mapToInt，mapToLong和mapToDouble。
		 *	 这三个方法也比较好理解，比如mapToInt就是把原始Stream转换成一个新的Stream，
		 * 	这个新生成的Stream中的元素都是int类型。之所以会有这样三个变种方法，可以免除自动装箱/拆箱的额外消耗；
		 */
		/**
		 * 4. flatMap：
		 * 	和map类似，不同的是其每个元素转换得到的是Stream对象，会把子Stream中的元素压缩到父集合中；
		 */
		/**
		 * 5. peek:
		 *  生成一个包含原Stream的所有元素的新Stream，同时会提供一个消费函数（Consumer实例），
		 *  新Stream每个元素被消费的时候都会执行给定的消费函数；
		 */
		/**
		 * 6. limit: 
		 * 	对一个Stream进行截断操作，获取其前N个元素，如果原Stream中包含的元素个数小于N，那就获取其所有的元素；
		 */
		/**
		 * 7. skip: 
		 * 	返回一个丢弃原Stream的前N个元素后剩下元素组成的新Stream，
		 * 	如果原Stream中包含的元素个数小于N，那么返回空Stream；
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
	    /**
	     * 流程：
	     * 给定一个Integer类型的List，
	     * 获取其对应的Stream对象，
	     * 然后进行过滤掉null，
	     * 再去重，
	     * 再每个元素乘以2，
	     * 再每个元素被消费的时候打印自身，
	     * 在跳过前两个元素，
	     * 最后取前四个元素进行加和运算
	     */
	    /**
	     * 结果分析：
	     * peek：形成一个消费函数，新Stream每个元素被消费的时候都会执行给定的消费函数。
	     * skip(2) 执行2次消费函数
	     * limit(4) 执行4次消费函数
	     * 
	     * sum() 计算 执行到limit(4)的时候的数值（6、8、10、12）
	     */
		System.out.println("sum is:"+nums.stream().filter(num -> num != null).
	    			distinct().mapToInt(num -> num * 2).
	    			peek(System.out::println).skip(2).limit(4).sum());
	    System.out.println("================");
	    /**
	     * 结果分析：
	     * skip(2) 
	     * limit(4)
	     * 然后执行peek  消费函数执行6 8 10 12
	     * 
	     * sum() 计算 执行到limit(4)的时候的数值（6、8、10、12）
	     */
		System.out.println("sum is:"+nums.stream().filter(num -> num != null).
    			distinct().mapToInt(num -> num * 2).
    			skip(2).limit(4).peek(System.out::println).sum());
	}
}
