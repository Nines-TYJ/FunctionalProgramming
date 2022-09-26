package com.nines.demo.functionalinterface;

/**
 * @author tanyujie
 * @classname MyFunctionalInterface
 * @description 函数式接口 有且只有一个抽象方法的接口，称之为函数式接口，接口中可以保函其他的方法(默认，静态，私有)
 * @date 2022/5/31 15:17
 * @since 1.0
 */
@FunctionalInterface
public interface MyFunctionalInterface {

    abstract void show();

}
