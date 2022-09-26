package com.nines.demo.functionalinterface.function;

import java.util.function.Function;

/**
 * @author tanyujie
 * @classname demo
 * @description TODO
 * @date 2022/6/2 10:16
 * @since 1.0
 */
public class demo {

    public static Integer string2Integer(String str, Function<String, Integer> function) {
        return function.apply(str);
    }

    public static void main(String[] args) {
        String str = "123";
        Integer num = string2Integer(str, Integer::parseInt);
        System.out.println(num + 100);
    }

}
