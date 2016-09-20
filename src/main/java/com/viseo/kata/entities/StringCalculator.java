package com.viseo.kata.entities;

import java.util.ArrayList;

public class StringCalculator {

    public static int add(String nombre) throws IllegalArgumentException {

        int nFinal = 0;

        if (nombre.contains("\n") || nombre.contains(",")){
            if(nombre.contains("//")){
                String[] split = SplitRegex(nombre, "\n");
                String[] delimiter = SplitRegex(split[0], "//");

                ArrayList<Integer> list = ReturnArrayStringToInt(SplitRegex(split[1], delimiter[1]));
                for(Integer i : list){
                    nFinal += i;
                }
            }
            else{
                ArrayList<Integer> list = ReturnArrayStringToInt(SplitRegex(nombre, "\n|,"));
                for(Integer i : list){
                    if(i < 0){

                        throw new IllegalArgumentException("On ne peut pas additionner de nombre négatif" + i);
                    }
                    else{
                        nFinal += i;
                    }
                }
            }

        }
        else if(nombre.equals("")){
            nFinal = 0;
        }
        else{
            nFinal = Integer.parseInt(nombre);
        }

        return nFinal;
    }

    private static ArrayList<Integer> ReturnArrayStringToInt(String[] listString){
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i = 0; i < listString.length; i++){
            list.add(Integer.parseInt(listString[i]));
        }
        return list;
    }

    private static String[] SplitRegex(String list, String regex){
        return list.split(regex);
    }

}
