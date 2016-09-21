package com.viseo.kata;

public class MainTest {

    public static void main(String[] args) {

        final String nombre = "//[++]\n1++4++5++8++7";

        String[] split = nombre.split("\n");
        String[] crochetSplit = split[0].split("]");
        String[] delimiter = crochetSplit[0].split("//\\[");
        System.out.println(delimiter[1]);

        String nb = "";
        String nb2 = delimiter[1].substring(delimiter[1].length()-1);

        for(int i = 0; i < delimiter[1].length(); i++){
            nb += "\\" + nb2;
        }

        System.out.println(nb.length());
        String test2 = "\\*\\*";

        System.out.println(nb.equals(test2));

        String[] test = split[1].split(nb);
        System.out.println(split[1]);
        for(String s : test){
            System.out.println(s);
        }
        System.out.println(nb);
    }
}
