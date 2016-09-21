package com.viseo.kata;

public class MainTest {

    public static void main(String[] args) {

        final String nombre = "//[**][;;]\n1;;4**5**8**7";
        String stringWithCrochet = "", nb = "", character, crochet, escapeString = "";
        String[] split, split2, crochets;

        /* Split notre chaine pour seulement avoir les crochets */
        split = nombre.split("\n");
        split2 = split[0].split("//");
        crochets = split2[1].split("\\]\\[");

        /* Séparé nos charactère par une barre oblique */
        for(String s : crochets){
            stringWithCrochet += s + "|";
        }

        crochet = stringWithCrochet.substring(stringWithCrochet.indexOf("[") + 1, stringWithCrochet.indexOf("]|"));

        if(crochet.contains("|")){
            String[] stringWithSlash = crochet.split("\\|");

            for(String s : stringWithSlash){
                character = s.substring(s.length()-1);

                for(int i = 0; i < s.length(); i++){
                    nb += "\\" + character;
                }
                nb += "|";
            }

            escapeString = nb.substring(0, nb.length()-1);
        }
        else{
            character = crochet.substring(crochet.length()-1);

            for(int i = 0; i < crochet.length(); i++){
                nb += "\\" + character;
            }
        }

        String[] test = split[1].split(escapeString);

        for(String t : test){
            System.out.println(t);
        }
    }
}
