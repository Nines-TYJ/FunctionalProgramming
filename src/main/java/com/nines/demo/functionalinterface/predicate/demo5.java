package com.nines.demo.functionalinterface.predicate;

import java.util.Objects;
import java.util.function.Predicate;

/**
 * @author tanyujie
 * @classname demo2
 * @description TODO
 * @date 2022/6/2 9:46
 * @since 1.0
 */
public class demo5 {

    public static boolean check(String str, Predicate<String> pre1, Predicate<String> pre2) {
        Objects.requireNonNull(pre1, "pre1为空");
        return pre1.and(pre2).test(str);
    }

    public static void main(String[] args) {
        // 筛选出名字为4个字的女的
        String[] array = {"迪丽热巴,女", "古力娜扎,女", "马儿扎哈,男", "卡沙,女"};
        for (String str : array) {
            if (check(str, (a) -> a.split(",")[0].length() == 4, (b) -> Objects.equals(b.split(",")[1], "女"))) {
                System.out.println(str);
            }
        }
    }

}
