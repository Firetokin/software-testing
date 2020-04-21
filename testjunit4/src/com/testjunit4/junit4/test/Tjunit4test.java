package com.testjunit4.junit4.test;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Test;

import com.testjunit4.junit4.*;

public class Tjunit4test {
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAdvise() {
		String z = new Tjunit4().Advise("c1");
		assertEquals("a1", z);
	}

}
