package cn.gaotianye.interfaces.test2;
/**
 * 默认方法与抽象方法不同之处在于抽象方法必须要求实现，但是默认方法则没有这个要求。
 * 相反，每个接口都必须提供一个所谓的默认实现，
 * 这样所有的接口实现者将会默认继承它（如果有必要的话，可以覆盖这个默认实现）。
 * @author gaotianye
 */
public interface Defaulable {
	//默认方法
	default String notRequired() { 
        return "Default implementation"; 
    }
	//抽象方法
	void test();
}
