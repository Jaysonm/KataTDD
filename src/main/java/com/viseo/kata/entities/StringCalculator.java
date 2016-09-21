package com.viseo.kata.entities;

import java.util.ArrayList;

import static com.viseo.kata.entities.Utils.*;

public class StringCalculator {

    public static int add(String nombre) throws IllegalArgumentException {

        int nFinal = 0;
        String characterBracket = "", escapeString = "", escapeStringFinal = "", character, characterBar;
        String[] splitOperation, splitFirstDelimiter, characterBars, stringWithSlash;

        if (nombre.contains("\n") || nombre.contains(",")){
            if(nombre.contains("//")){

                splitOperation = SplitRegex(nombre, "\n");
                splitFirstDelimiter = SplitRegex(splitOperation[0],"//");

                if(splitOperation[0].contains("[") && splitOperation[0].contains("]")){
                    characterBars = splitFirstDelimiter[1].split("\\]\\[");

                    /* Séparé nos charactère par une barre oblique */
                    for(String s : characterBars){
                        characterBracket += s + "|";
                    }

                    characterBar = characterBracket.substring(characterBracket.indexOf("[") + 1, characterBracket.indexOf("]|"));

                    if(characterBar.contains("|")){
                        stringWithSlash = SplitRegex(characterBar,"\\|");

                        for(String s : stringWithSlash){
                            character = s.substring(s.length()-1);

                            for(int i = 0; i < s.length(); i++){
                                escapeString += "\\" + character;
                            }

                            escapeString += "|";
                        }

                        escapeStringFinal = escapeString.substring(0, escapeString.length()-1);
                    }
                    else{
                        character = characterBar.substring(characterBar.length()-1);

                        for(int i = 0; i < characterBar.length(); i++){
                            escapeStringFinal += "\\" + character;
                        }
                    }

                }
                else{
                    escapeStringFinal = splitFirstDelimiter[1];
                }

                ArrayList<Integer> list = ReturnArrayStringToInt(SplitRegex(splitOperation[1], escapeStringFinal));
                for(Integer i : list){
                    if(i < 1000){
                        nFinal += i;
                    }
                }
            }
            else{
                ArrayList<Integer> list = Utils.ReturnArrayStringToInt(SplitRegex(nombre, "\n|,"));
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



}
