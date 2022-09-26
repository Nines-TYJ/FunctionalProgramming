package com.nines.demo.functionalinterface;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author tanyujie
 * @classname demo
 * @description TODO
 * @date 2022/5/31 16:37
 * @since 1.0
 */
public class demo {

    public static void show(MyFunctionalInterface myFunctionalInterface) {
        myFunctionalInterface.show();
    }

    public static Comparator<String> myComparator() {
        return (o1, o2) -> o2.length() - o1.length();
    }

    public static void main(String[] args) {
//        show(() -> System.out.println("函数时编程接口 lambda表达方式"));
        List<String> list = Arrays.asList("1", "10", "2", "444","20", "55555");
//        String[] array = list.toArray(new String[0]);
//        System.out.println(Arrays.toString(array));
//        Arrays.sort(array, (o1, o2) -> o2.length() - o1.length());
//        System.out.println(Arrays.toString(array));

        List<String> a = list.stream().sorted(Comparator.comparing(Integer::parseInt)).collect(Collectors.toList());
        System.out.println(a);

        Thread b = new Thread(() -> System.out.println("123"));
        b.start();
        System.out.println(b.getName());

        Runnable z = () -> System.out.println("1230");
        z.run();
    }

}
