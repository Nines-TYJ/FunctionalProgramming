package com.nines.demo.functionalinterface.supplier;

import java.util.function.Supplier;

/**
 * @author tanyujie
 * @classname demo
 * @description Supplier<T>接口被称之为生产型接口，指定接口的泛型是什么类型，那么接口中的get就会生产什么类型的数据
 * @date 2022/6/1 11:13
 * @since 1.0
 */
public class demo {

    public static String addNullToEnd(Supplier<String> sup) {
        return sup.get() + "Null";
    }

    public static void main(String[] args) {
        String str = addNullToEnd(() -> "aaaa" + "bbb");
        System.out.println(str);
    }

}
