package com.tokin.junitTest;

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
	private double pay;

	@Before
	public void setUp() throws Exception {
	}
	
	public CommissionTest(int lock, int stock, int barrel, double pay){
		this.lock = lock;
		this.stock = stock;
		this.barrel = barrel;
		this.pay = pay;
	}
	
	@Parameters
	public static Collection<Object[]>getData(){
		return Arrays.asList(
				new Object[][]{
					{0,0,0,"0"},
					{71,1,1,"641"}, 
					{ 10, 10, 10, "100" },
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
