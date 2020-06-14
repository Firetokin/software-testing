package com.tokin.task03;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;

class PhoneBillTest {
    @ParameterizedTest
    @CsvFileSource(resources = "/电话账单测试用例.csv",numLinesToSkip = 1)
    void billTest(int y,int m, int d,int s1,int s2,int s3,int e1,int e2,int e3,String except){
        assertEquals(except,PhoneBill.phoneBill(y,m,d,s1,s2,s3,e1,e2,e3));
    }
}