package com.nines.demo.functionalinterface.function;

import java.util.function.Function;

/**
 * @author tanyujie
 * @classname demo
 * @description TODO
 * @date 2022/6/2 10:16
 * @since 1.0
 */
public class demo3 {

    public static Integer getAgeNum(String str, Function<String, String> fun1, Function<String, Integer> fun2, Function<Integer, Integer> fun3) {
        return fun1.andThen(fun2).andThen(fun3).apply(str);
    }

    public static void main(String[] args) {
        String str = "卡沙,320";
        Integer num = getAgeNum(str, (a) -> a.split(",")[1], Integer::parseInt, (c) -> c + 100);
        System.out.println(num);
    }

}
