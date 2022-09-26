package com.nines.demo.functionalinterface.stream;

import java.util.stream.Stream;

/**
 * @author tanyujie
 * @classname Demo
 * @description TODO
 * @date 2022/6/6 9:36
 * @since 1.0
 */
public class Demo2 {

    public static void main(String[] args) {
        String str = "her name is susu";

        str.chars().parallel().forEach(i -> System.out.print((char) i));
        System.out.println();
        str.chars().parallel().forEachOrdered(i -> System.out.print((char) i));
    }

}
