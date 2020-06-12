package com.tokin.task01;
/**
 * Triangle test
 */

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class CommissionTest {
    private int lock, stock,barrel;
    private String pay;

    @Before
    public void setUp() throws Exception {
    }

    public CommissionTest(int lock, int stock, int barrel, String pay){
        this.lock = lock;
        this.stock = stock;
        this.barrel = barrel;
        this.pay = pay;
    }

    @Parameters
    public static Collection<Object[]>getData(){
        return Arrays.asList(
                new Object[][]{
                        {0,0,0,"0.0"},
                        {1,1,1,"10.0"},
                        { 2,  1,  1,  "14.5" },
                        { 10, 10, 10, "100.0" },
                        {10,20,30,"220.0"},
                        {20,30,40,"420.0"},
                });
    }
    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testPayCommission() {
        assertEquals(this.pay, Commission.payCommission(lock, stock, barrel));
    }

}
