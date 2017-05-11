package cn.gaotianye.type;
/**
 * 更好的类型推测机制
 * @author gaotianye
 */
public class TypeInference {
    public static void main(String[] args) {
        final Value< String > value = new Value<>();
        /*
         * Value.defaultValue()的参数类型可以被推测出，
         * 所以就不必明确给出Value.<String>defaultValue()
         */
        String s = value.getOrDefault( "22", Value.defaultValue() );
        System.out.println(s);
    }
}
