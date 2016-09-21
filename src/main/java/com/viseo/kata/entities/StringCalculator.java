package com.viseo.kata.entities;

import java.util.ArrayList;

public class StringCalculator {

    public static int add(String nombre) throws IllegalArgumentException {

        int nFinal = 0;
        String escapeString = "";

        if (nombre.contains("\n") || nombre.contains(",")){
            if(nombre.contains("//")){

                String[] split = SplitRegex(nombre, "\n");
                String[] delimiter;
                if(split[0].contains("[") && split[0].contains("]")){
                    String[] crochetSplit = SplitRegex(split[0], "]");
                    delimiter = SplitRegex(crochetSplit[0], "//\\[");
                }
                else{
                    delimiter = SplitRegex(split[0], "//");
                }

                if(delimiter[1].length() >= 1){
                    String getCharacter = delimiter[1].substring(delimiter[1].length()-1);

                    for(int i = 0; i < delimiter[1].length(); i++){
                        escapeString += "\\" + getCharacter;
                    }

                    String[] test = SplitRegex(split[1], escapeString);

                }

                ArrayList<Integer> list = ReturnArrayStringToInt(SplitRegex(split[1], escapeString));
                for(Integer i : list){
                    if(i < 1000){
                        nFinal += i;
                    }
                }
            }
            else{
                ArrayList<Integer> list = ReturnArrayStringToInt(SplitRegex(nombre, "\n|,"));
                ArrayList<Integer> negativeNb = new ArrayList<Integer>();
                for(Integer i : list){
                    if(i < 0){
                        negativeNb.add(i);
                    }
                    else{
                        if(i < 1000){
                            nFinal += i;
                        }
                    }
                }

                if(negativeNb.size() > 0) {
                    String nbString = " ";
                    for (Integer iNegative : negativeNb){
                        nbString += String.valueOf(iNegative) + " ";
                    }
                    throw new IllegalArgumentException("On ne peut pas additionner de nombre négatif" + nbString);

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
