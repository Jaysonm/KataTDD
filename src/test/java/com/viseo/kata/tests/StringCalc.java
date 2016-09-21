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
        System.out.println("calculateStringEqualTo3 = " + operations);
    }

    @Test
    public void calculateStringEqualTo1(){
        final String nombre = "1";
        int operations = StringCalculator.add(nombre);
        assertEquals(1, operations);
        System.out.println("calculateStringEqualTo1 = " + operations);
    }

    @Test
    public void calculateStringEmpty(){
        final String nombre = "";
        int operations = StringCalculator.add(nombre);
        assertEquals(0, operations);
        System.out.println("calculateStringEmpty = " + operations);
    }

    @Test
    public void calculateStringEqualTo6(){
        final String nombre = "1,2,3";
        int operations = StringCalculator.add(nombre);
        assertEquals(6, operations);
        System.out.println("calculateStringEqualTo6 = " + operations);
    }

    @Test
    public void calculateStringEqualTo10(){
        final String nombre = "1,2,3,4";
        int operations = StringCalculator.add(nombre);
        assertEquals(10, operations);
        System.out.println("calculateStringEqualTo10 = " + operations);
    }

    @Test
    public void calculateStringEqualTo15(){
        final String nombre = "1,2\n3,4,5";
        int operations = StringCalculator.add(nombre);
        assertEquals(15, operations);
        System.out.println("calculateStringEqualTo15 = " + operations);
    }

    @Test
    public void TestingDelimitersSupporting(){
        final String nombre = "//:\n1:2";
        int operations = StringCalculator.add(nombre);
        assertEquals(3, operations);
        System.out.println("TestingDelimitersSupporting ':' = " + operations);
    }

    @Test
    public void TestingOneNegativeNumbers() throws IllegalArgumentException{
        try{
            final String nombre = "1,2,-2";
            StringCalculator.add(nombre);
        }
        catch(IllegalArgumentException e){
            System.out.println(e);
        }
    }

    @Test
    public void TestingThreeNegativeNumbers() throws IllegalArgumentException{
        try{
            final String nombre = "1,2,-2,-1,-5";
            StringCalculator.add(nombre);
        }
        catch(IllegalArgumentException e){
            System.out.println(e);
        }
    }

    @Test
    public void IgnoredNumberBiggerThan1000(){
        final String nombre = "1,2,1001";
        int operations = StringCalculator.add(nombre);
        assertEquals(3, operations);
        System.out.println("IgnoredNumberBiggerThan1000 = " + operations);
    }

    @Test
    public void DelimitersCanHaveAnyLength(){
        final String nombre = "//[***]\n1***2***1001";
        int operations = StringCalculator.add(nombre);
        assertEquals(3, operations);
        System.out.println("DelimitersCanHaveAnyLength = " + operations);
    }

}
