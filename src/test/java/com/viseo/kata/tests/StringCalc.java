package com.viseo.kata.tests;

import com.viseo.kata.entities.StringCalculator;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StringCalc {

    @Test
    public void calculateStringEqualTo3(){
        final String nombre = "1,2";
        int operations = StringCalculator.add(nombre);
        assertEquals(3, operations);
    }

    @Test
    public void calculateStringEqualTo1(){
        final String nombre = "1";
        int operations = StringCalculator.add(nombre);
        assertEquals(1, operations);
    }

    @Test
    public void calculateStringEqualTo0(){
        final String nombre = "";
        int operations = StringCalculator.add(nombre);
        assertEquals(0, operations);
    }

    @Test
    public void calculateStringEqualTo6(){
        final String nombre = "1,2,3";
        int operations = StringCalculator.add(nombre);
        assertEquals(6, operations);
    }

    @Test
    public void calculateStringEqualTo10(){
        final String nombre = "1,2,3,4";
        int operations = StringCalculator.add(nombre);
        assertEquals(10, operations);
    }

    @Test
    public void calculateStringEqualTo15(){
        final String nombre = "1,2\n3,4,5";
        int operations = StringCalculator.add(nombre);
        assertEquals(15, operations);
    }

}
