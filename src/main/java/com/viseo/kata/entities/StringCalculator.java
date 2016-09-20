package com.viseo.kata.entities;

import java.util.ArrayList;

public class StringCalculator {

    public static int add(String nombre) {

        int nFinal = 0;

        if (nombre.contains(",")) {
            ArrayList<Integer> list = returnArrayStringToInt(nombre.split(","));
            for(Integer i : list){
                nFinal += i;
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

    private static ArrayList<Integer> returnArrayStringToInt(String[] listString){
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i = 0; i < listString.length; i++){
            list.add(Integer.parseInt(listString[i]));
        }
        return list;
    }


}
