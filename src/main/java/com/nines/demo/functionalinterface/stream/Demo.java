package com.nines.demo.functionalinterface.stream;

import java.util.stream.Stream;

/**
 * @author tanyujie
 * @classname Demo
 * @description TODO
 * @date 2022/6/6 9:36
 * @since 1.0
 */
public class Demo {

    public static void main(String[] args) {
        String str = "her name is susu";

        Stream.of(str.split(" ")).flatMapToInt(CharSequence::chars).forEach(s -> System.out.print((char) s));
        System.out.println();
        Stream.of(str.split(" ")).flatMap(s -> s.chars().boxed()).forEach(s -> System.out.print((char) s.intValue()));
    }

}
