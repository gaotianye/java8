package cn.gaotianye.actionWithWrong;
/**
 * Java程序员们最常犯的10个错误
 * 7、创建字符串
 * @author gaotianye
 *
 */
public class Test7 {
	public static void main(String[] args) {
		//No1:x和y有什么区别吗？
		//1.使用字符串
		String x = "abc";
		//2.使用构造器
		String y = new String("abc");
		//No2:回答前面的问题
		String a = "abc";
		String b = "abc";
		System.out.println(a==b);//true
		System.out.println(a.equals(b));//true
		//c和d是对象
		String c = new String("abc");
		String d = new String("abc");
		System.out.println(c==d);//false
		System.out.println(c.equals(d));//true
	}
}
