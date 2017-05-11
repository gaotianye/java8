package cn.gaotianye.actionWithWrong;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/**
 * Java程序员们最常犯的10个错误
 * 3.在一个循环中删除一个列表中的元素
 * @author gaotianye
 *
 */
public class Test3 {
	public static void main(String[] args) {
		/*ArrayList<String> list = new ArrayList<String>(Arrays.asList("a","b","c","d"));
		for(int i=0;i<list.size();i++){
		    list.remove(i);
		}*/
		/**
		 * 输出结果：[b, d]
		 * 在这个方法中有一个严重的错误。
		 * 当一个元素被删除时，列表的大小缩小并且下标变化，
		 * 所以当你想要在一个循环中用下标删除多个元素的时候，它并不会正常的生效。
		 */
//		System.out.println(list);
		/**
		 * 你要知道在循环中正确的删除多个元素的方法是使用迭代，
		 * 并且你也要知道java中的foreach循环看起来像一个迭代器，但实际上并不是。
		 */
		ArrayList<String> list = new ArrayList<String>(Arrays.asList("a","b","c","d"));
		/*
		 * 在一个foreach循环中，编译器会使.next()在删除元素之后被调用，
		 * 因此就会抛出ConcurrentModificationException异常
		 */
/*		for(String s:list){
		    if(s.equals("a")){
		        list.remove(s);
		    }
		}*/
		Iterator<String> iter = list.iterator();
		while(iter.hasNext()){
			//.next()必须在.remove()之前调用。
		    String s = iter.next();
		    if(s.equals("a")){
		    	iter.remove();
		    }
		}
	}
}
