package com.viseo.kata;

public class MainTest {

    public static void main(String[] args) {

        String caractere = "1,2,3\n4";

        String[] test = caractere.split("\n|,");

        for(String t : test){
           System.out.println(t);
        }
    }
}
