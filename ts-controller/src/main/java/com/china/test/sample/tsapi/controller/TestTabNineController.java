package com.china.test.sample.tsapi.controller;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yandongjun
 */
public class TestTabNineController {
    public static void main(String[] args) {
        List<Object[]> list = new ArrayList<>();
        Object[] objects1 = new Object[] { 1, 2, 3};
        Object[] objects2 = new Object[] { 1, 2, 3};
        Object[] objects3 = new Object[] { 1, 2, 3};
        list.add(objects1);
        list.add(objects2);
        list.add(objects3);

        System.out.println(list.toString());

    }
}