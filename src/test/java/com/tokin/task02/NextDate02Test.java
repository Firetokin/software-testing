package com.tokin.task02;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;

class NextDate02Test {
    @ParameterizedTest
    @CsvFileSource(resources = "/NextDate边界值分析测试用例.csv",numLinesToSkip = 1)
    void nextDate02BoundaryValue(int count,int y, int m, int d ,String except) {
        assertEquals(except,NextDate02.classnextdate(y,m,d));
    }
    @ParameterizedTest
    @CsvFileSource(resources = "/NextDate最坏情况测试用例.csv",numLinesToSkip = 1)
    void nextDate02WorstCase(int count,int y, int m, int d ,String except) {
        assertEquals(except,NextDate02.classnextdate(y,m,d));
    }
    @ParameterizedTest
    @CsvFileSource(resources = "/NextDate健壮性测试用例.csv",numLinesToSkip = 1)
    void nextDate02Robustness(int count,int y, int m, int d ,String except) {
        assertEquals(except,NextDate02.classnextdate(y,m,d));
    }
    @ParameterizedTest
    @CsvFileSource(resources = "/NextDate健壮性最坏情况测试用例.csv",numLinesToSkip = 1)
    void nextDate02RobustWorst(int count,int y, int m, int d ,String except) {
        assertEquals(except,NextDate02.classnextdate(y,m,d));
    }

}