package com.nines.demo.functionalinterface.consumer;

import java.util.function.Consumer;

/**
 * @author tanyujie
 * @classname demo
 * @description TODO
 * @date 2022/6/1 16:13
 * @since 1.0
 */
public class demo2 {

    public static void doThing(String name, Consumer<String> con1, Consumer<String> con2) {
        con1.andThen(con2).accept(name);
    }

    public static void main(String[] args) {
        String name = "a bb ccc";
        doThing(name,
                (a) -> System.out.println(a + " dddd"),
                (a) -> System.out.println(a.toUpperCase()));
    }

}
