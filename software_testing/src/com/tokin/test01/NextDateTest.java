package com.tokin.test01;

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
public class NextDateTest {
	private int year, month, day;
	private String outDay;
	

	@Before
	public void setUp() throws Exception {
	}
	
	public NextDateTest(int month, int day, int year,String outDay){
		this.year = year;
		this.month = month;
		this.day = day;
		this.outDay = outDay;
	}
	
	@Parameters
	public static Collection<Object[]>getData(){
		return Arrays.asList(
				new Object[][]{
					{1,3,1899,"年份输入错误"},
					{2,29,2007,"日期输入错误"},
					{2,28,2008,"2008年2月29日"},
					{2,29,2008,"2008年3月1日"},
					{0,3,1999,"月份输入错误"},
					{ 3, 31, 2010, "2010年4月1日" }, 
					{ 4, 30, 2010, "2010年5月1日" }, 
					{ 12, 30, 2010, "2011年1月1日" }, 
					{ 5, 30, 2019, "2019年5月31日" }, 
					{ 10, 29, 2019, "2019年10月30日" },
				});
		
	}
	@After
	public void tearDown() throws Exception {
	}


	@Test
	public void testClassnextdate() {
		assertEquals(this.outDay,NextDate.classnextdate(month, day, year));
	}

}
