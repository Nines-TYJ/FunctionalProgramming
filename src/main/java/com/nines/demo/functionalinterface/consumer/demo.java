package com.nines.demo.functionalinterface.consumer;

import java.util.function.Consumer;

/**
 * @author tanyujie
 * @classname demo
 * @description TODO
 * @date 2022/6/1 16:13
 * @since 1.0
 */
public class demo {

    public static void doThing(String name, Consumer<String> con) {
        con.accept(name);
    }

    public static void main(String[] args) {
        String name = "张三 李四 王麻子";
        doThing(name, (a) -> System.out.println(new StringBuffer(a).reverse().toString()));
    }

}
