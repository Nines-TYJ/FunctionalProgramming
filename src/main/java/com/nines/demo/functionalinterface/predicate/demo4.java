package com.nines.demo.functionalinterface.predicate;

import java.util.function.Predicate;

/**
 * @author tanyujie
 * @classname demo2
 * @description TODO
 * @date 2022/6/2 9:46
 * @since 1.0
 */
public class demo4 {

    public static boolean check(String str, Predicate<String> pre) {
        return pre.negate().test(str);
    }

    public static void main(String[] args) {
        String str = "abc";
        boolean f = check(str, (a) -> a.length() > 5);
        System.out.println(f);
    }

}
