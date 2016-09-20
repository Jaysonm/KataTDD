package com.viseo.kata.entities;

public class StringCalculator {

    public static int add(String nombre) {

        int nFinal = 0;

        if (nombre.contains(",")) {
            String[] nombreSplit = nombre.split(",");
            for(int i = 0; i < nombreSplit.length; i++){
                if(i+1 != nombreSplit.length){
                    nFinal = Integer.parseInt(nombreSplit[i]) + Integer.parseInt(nombreSplit[i+1]);
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
