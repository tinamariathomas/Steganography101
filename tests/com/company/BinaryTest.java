package com.company;

import org.junit.Test;

import static org.junit.Assert.*;

public class BinaryTest {
    @Test
    public void shouldSetLSBToOne(){
        assertEquals(Binary.setLSBValue(100,'1'),101);
    }

    @Test
    public void shouldSetLSBToZero(){
        assertEquals(Binary.setLSBValue(100,'0'),100);
    }

    @Test
    public void shouldCheckIfLSBisZero(){
        assertEquals(Binary.getLSBValue(100),'0');
    }

    @Test
    public void shouldCheckIfLSBisOne(){
        assertEquals(Binary.getLSBValue(101),'1');

    }
}