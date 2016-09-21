package com.viseo.kata.entities;

import java.util.ArrayList;

public class Utils {

    public static ArrayList<Integer> ReturnArrayStringToInt(String[] listString){
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i = 0; i < listString.length; i++){
            list.add(Integer.parseInt(listString[i]));
        }
        return list;
    }

    public static String[] SplitRegex(String list, String regex){
        return list.split(regex);
    }

    public static String buildEscapeString(String s, String escapeFinal){
        String character = s.substring(s.length()-1);

        for(int i = 0; i < s.length(); i++){
            escapeFinal += "\\" + character;
        }

        return escapeFinal;
    }

    public static int sum(ArrayList<Integer> list, ArrayList<Integer> list2){
        int nFinal = 0;
        for(Integer i : list){
            if(i < 0){
                list2.add(i);
            }
            else if(i < 1000){
                nFinal += i;
            }
        }

        return nFinal;
    }

}
