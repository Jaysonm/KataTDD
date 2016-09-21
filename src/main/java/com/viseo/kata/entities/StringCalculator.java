package com.viseo.kata.entities;

import java.util.ArrayList;

import static com.viseo.kata.entities.Utils.*;

public class StringCalculator {

    public static int add(String nombre) throws IllegalArgumentException {

        int nFinal;
        String characterBracket = "", escapeString = "", escapeStringFinal = "", nbString = "", characterBar;
        String[] splitOperation, splitFirstDelimiter, characterBars, stringWithSlash;
        ArrayList<Integer> list;
        ArrayList<Integer> negativeNb = new ArrayList<Integer>();

        if (nombre.contains("\n") || nombre.contains(",")){
            if(nombre.contains("//")){

                splitOperation = SplitRegex(nombre, "\n");
                splitFirstDelimiter = SplitRegex(splitOperation[0],"//");

                if(splitOperation[0].contains("[") && splitOperation[0].contains("]")){
                    characterBars = splitFirstDelimiter[1].split("\\]\\[");

                    for(String s : characterBars){
                        characterBracket += s + "|";
                    }

                    characterBar = characterBracket.substring(characterBracket.indexOf("[") + 1, characterBracket.indexOf("]|"));

                    if(characterBar.contains("|")){
                        stringWithSlash = SplitRegex(characterBar,"\\|");

                        for(String s : stringWithSlash){
                            escapeString = buildEscapeString(s, escapeString);
                            escapeString += "|";
                        }

                        escapeStringFinal = escapeString.substring(0, escapeString.length()-1);
                    }
                    else{
                        escapeStringFinal = buildEscapeString(characterBar, escapeStringFinal);
                    }
                }
                else{
                    escapeStringFinal = splitFirstDelimiter[1];
                }

                list = ReturnArrayStringToInt(SplitRegex(splitOperation[1], escapeStringFinal));
            }
            else{
                list = ReturnArrayStringToInt(SplitRegex(nombre, "\n|,"));
            }

            nFinal = sum(list, negativeNb);

            if(negativeNb.size() > 0) {
                for (Integer iNegative : negativeNb){
                    nbString += String.valueOf(iNegative) + " ";
                }
                throw new IllegalArgumentException("On ne peut pas additionner de nombre négatif" + nbString);
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
