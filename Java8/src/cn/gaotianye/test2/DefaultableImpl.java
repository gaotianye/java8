package cn.gaotianye.test2;

public class DefaultableImpl implements Defaulable {
	//抽象方法必须实现
	@Override
	public void test() {
		System.out.println("test.....");
	}
	//默认方法无需实现
}
