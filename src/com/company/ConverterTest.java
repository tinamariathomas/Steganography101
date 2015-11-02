package com.company;

import org.junit.Test;

import static org.junit.Assert.*;

public class ConverterTest {

    @Test
    public void testConvertUTFStringToBinary() throws Exception {
        assertEquals("01100001",Converter.convertUTFStringToBinary("a"));
    }
    @Test
    public void testConvertUTFStringToBinaryForMultipleCharacter() throws Exception {
        assertEquals("0110000101100001", Converter.convertUTFStringToBinary("aa"));
    }

    @Test
    public void testConvertBinarytoString() throws Exception {
        assertEquals("a", Converter.convertBinarytoString("01100001"));
    }
    @Test
    public void testConvertBinarytoStringForMultipleCharacter() throws Exception {
        assertEquals("aa",Converter.convertBinarytoString("0110000101100001"));
    }
}