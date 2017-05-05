package cn.gaotianye.test3;

import java.util.function.Supplier;

import cn.gaotianye.interfaces.test2.Defaulable;

public interface DefaulableFactory {
	static Defaulable create( Supplier< Defaulable > supplier ) {
        return supplier.get();
    }
}
