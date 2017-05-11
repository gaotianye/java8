package cn.gaotianye.actionWithWrong;

import java.util.ArrayList;
import java.util.List;

/**
 * Java程序员们最常犯的10个错误
 * 5、在集合中使用原始类型
 * 		在Java中原始类型与无界通配符类型很容易混合在一起，
 * 		拿Set来说，Set是一个原始类型，而Set<?>是无界的通配符类型。
 * @author gaotianye
 *
 */
public class Test5 {
	//下面使用原始类型List作为参数的代码
	public static void add(List list,Object o){
	    list.add(o);
	}
	public static void main(String[] args){
	    List<String> list = new ArrayList<String>();
	    add(list,10);
	    /*
	     * 报错：java.lang.Integer cannot be cast to java.lang.String
	     * 使用原生类型集合是危险的，这是因为原生类型集合跳过了泛型类型检查，
	     * 并且不是安全的，在Set、Set<?>和Set<Object>中有很大的不同
	     */
	    String s = list.get(0);
	    //解决参考Test6.java
	}
}
