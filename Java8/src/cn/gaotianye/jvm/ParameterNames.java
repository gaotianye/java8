package cn.gaotianye.jvm;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * java编译器
 * 如果不使用–parameters参数来编译这个类，然后运行这个类，
 * 会得到下面的输出：  Parameter: arg0
 * 
 * 如果使用–parameters参数来编译这个类，参数的真实名字将会显示出来：
 * 参考：http://www.importnew.com/11908.html#intro
 * @author gaotianye
 *
 */
public class ParameterNames {
	public static void main(String[] args) throws Exception {
        Method method = ParameterNames.class.getMethod("main", String[].class);
        for( final Parameter parameter: method.getParameters() ) {
            System.out.println( "Parameter: " + parameter.getName() );
        }
	}
}
