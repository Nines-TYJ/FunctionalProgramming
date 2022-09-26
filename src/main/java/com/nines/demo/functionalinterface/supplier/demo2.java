package com.nines.demo.functionalinterface.supplier;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.function.Supplier;

/**
 * @author tanyujie
 * @classname demo2
 * @description TODO
 * @date 2022/6/1 11:51
 * @since 1.0
 */
public class demo2 {

    public static int getMax(Supplier<Integer> sup) {
        return sup.get() - 100;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{-10, 5, 9, 55, 100, -50, 1111};
        int maxValue = getMax(Arrays.stream(arr).max()::getAsInt);
        System.out.println(maxValue);
    }

}
