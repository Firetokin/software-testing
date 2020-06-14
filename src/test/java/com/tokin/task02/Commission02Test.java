package com.tokin.task02;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;

class Commission02Test {
    @ParameterizedTest
    @CsvFileSource(resources = "/Commission边界值分析测试用例.csv",numLinesToSkip = 1)
    void commission02BoundaryValue(int count,int l, int s, int b ,String except) {
        assertEquals(except,Commission02.payCommission(l,s,b));
    }
    @ParameterizedTest
    @CsvFileSource(resources = "/Commission健壮性测试用例.csv",numLinesToSkip = 1)
    void commission02Robustness(int count,int l, int s, int b ,String except) {
        assertEquals(except,Commission02.payCommission(l,s,b));
    }
    @ParameterizedTest
    @CsvFileSource(resources = "/Commission最坏情况测试用例.csv",numLinesToSkip = 1)
    void commission02WorstCase(int count,int l, int s, int b ,String except) {
        assertEquals(except,Commission02.payCommission(l,s,b));
    }
    @ParameterizedTest
    @CsvFileSource(resources = "/Commission健壮最坏情况测试用例.csv",numLinesToSkip = 1)
    void commission02RobustWorst(int count,int l, int s, int b ,String except) {
        assertEquals(except,Commission02.payCommission(l,s,b));
    }
}