package com.nines.demo.functionalinterface.predicate;

import java.util.function.Predicate;

/**
 * @author tanyujie
 * @classname demo2
 * @description TODO
 * @date 2022/6/2 9:46
 * @since 1.0
 */
public class demo3 {

    public static boolean check(String str, Predicate<String> pre1, Predicate<String> pre2) {
        return pre1.or(pre2).test(str);
    }

    public static void main(String[] args) {
        String str = "abcdfeg";
        boolean f = check(str, (a) -> a.length() > 5, (b) -> b.contains("n"));
        System.out.println(f);
    }

}
