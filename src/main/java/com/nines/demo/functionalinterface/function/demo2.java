package com.nines.demo.functionalinterface.function;

import java.util.function.Function;

/**
 * @author tanyujie
 * @classname demo
 * @description TODO
 * @date 2022/6/2 10:16
 * @since 1.0
 */
public class demo2 {

    public static Integer string2IntegerAdd100(String str, Function<String, Integer> fun1, Function<Integer, Integer> fun2) {
        return fun1.andThen(fun2).apply(str);
    }

    public static void main(String[] args) {
        String str = "123";
        Integer num = string2IntegerAdd100(str, Integer::parseInt, (a) -> a + 100);
        System.out.println(num);
    }

}
