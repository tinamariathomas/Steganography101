package com.company;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class Converter {
    static public String textToBinaryString(String text) {
        Charset charSet = StandardCharsets.US_ASCII;
        byte[] bytes = text.getBytes(charSet);
        StringBuffer binary = new StringBuffer();
        for (byte b : bytes) {
            String s = String.format("%8s", Integer.toBinaryString((int) b)).replace(' ', '0');
            binary.append(s);
        }
        System.out.println(binary);
        System.out.println("bytes= " + Arrays.toString(bytes));
        return binary.toString();
    }

    static public String binaryStringToText(String binaryString) {

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < binaryString.length()/8; i++) {
            String s = binaryString.substring(i*8,(i+1)*8);
            int charCode = Integer.parseInt(s,2);
            result.append((char)charCode);

        }
        return result.toString();
    }
}
