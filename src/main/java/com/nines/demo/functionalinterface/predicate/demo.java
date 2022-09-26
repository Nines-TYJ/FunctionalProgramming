package com.nines.demo.functionalinterface.predicate;

import java.util.function.Predicate;

/**
 * @author tanyujie
 * @classname demo
 * @description TODO
 * @date 2022/6/1 17:30
 * @since 1.0
 */
public class demo {

    public static boolean checkLength(String str, Predicate<String> pre){
        return pre.test(str);
    }

    public static void main(String[] args) {
        String str = "abcdef";
        boolean f = checkLength(str, s -> s.length() > 5);
        System.out.println(f);
    }

}
