package cn.gaotianye.interfaces.test2;

public class OverridableImpl implements Defaulable {
	@Override
	public String notRequired() {
		return "Overridden implementation";
	}
	//抽象方法必须实现
	@Override
	public void test() {
		System.out.println("test.....");
	}
}
