package com.company;

public class Binary {
    static public char getLSBValue(int number){
        StringBuilder s = new StringBuilder(String.format("%8s", Integer.toBinaryString(number)).replace(' ', '0'));
        return s.toString().charAt(7);
    }


    public static int setLSBValue(int number, char lsb) {
        StringBuilder s = new StringBuilder(String.format("%8s", Integer.toBinaryString(number)).replace(' ', '0'));
        s.setCharAt(7,lsb);
        return Integer.parseInt(s.toString(),2);
    }
}
