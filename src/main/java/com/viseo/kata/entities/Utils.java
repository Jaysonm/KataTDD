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

}
