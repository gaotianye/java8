package cn.gaotianye.actionWithWrong;

import java.util.ArrayList;
import java.util.List;

/**
 * 解决Test5.java问题
 * @author gaotianye
 *
 */
public class Test6 {
	//下面使用原始类型List作为参数的代码
	public static void add(ArrayList list,Object o){
	    list.add(o);
	}
	public static void main(String[] args){
		ArrayList<Integer> list = new ArrayList<Integer>();
	    add(list,10);
	    /*
	     * 报错：java.lang.Integer cannot be cast to java.lang.String
	     * 使用原生类型集合是危险的，这是因为原生类型集合跳过了泛型类型检查，
	     * 并且不是安全的，在Set、Set<?>和Set<Object>中有很大的不同
	     */
	    int s = list.get(0);
	    System.out.println(s);
	    //解决参考Test6.java
	}
}
