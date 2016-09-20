package com.viseo.kata;

public class MainTest {

    public static void main(String[] args) {

        String caractere = "//;\n1;2;3;4";

        String[] test = caractere.split("\n");
        String[] test2 = test[0].split("//");

        for(String t : test2){
           System.out.println(t);
        }
    }
}
