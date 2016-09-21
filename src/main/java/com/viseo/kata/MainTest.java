package com.viseo.kata;

import java.util.ArrayList;
import java.util.Arrays;

import static com.viseo.kata.entities.Utils.*;

public class MainTest {

    public static void main(String[] args) {

        final String nombre = "//[**][;;]\n1;;4**5**8**7";

        String[] splitOperation = SplitRegex(nombre, "//[(.*?)]\n");

        for(String s : splitOperation){
            System.out.println(s);
        }

        System.out.println("**************");

        ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(1,2,3,-1));
        ArrayList<Integer> list2 = new ArrayList<Integer>();

        for(Integer i : list){
            System.out.println(i);
        }

        sum(list, list2);

        System.out.println(list2);

    }
}
