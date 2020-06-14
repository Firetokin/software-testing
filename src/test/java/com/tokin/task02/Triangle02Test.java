package com.tokin.task02;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;

class Triangle02Test {
    @ParameterizedTest
    @CsvFileSource(resources = "/三角形边界值分析测试用例.csv",numLinesToSkip = 1)
        //numLinesToSkip = 1是略过文件第1行
    void triangle02BoundaryValue(int count,int a, int b, int c ,String except) {
        assertEquals(except,Triangle02.classTriangle02(a,b,c));
    }
    @ParameterizedTest
    @CsvFileSource(resources = "/三角形健壮性测试用例.csv",numLinesToSkip = 1)
        //numLinesToSkip = 1是略过文件第1行
    void triangle02Robustness(int count,int a, int b, int c ,String except) {
        assertEquals(except,Triangle02.classTriangle02(a,b,c));
    }
    @ParameterizedTest
    @CsvFileSource(resources = "/三角形最坏情况测试用例.csv",numLinesToSkip = 1)
        //numLinesToSkip = 1是略过文件第1行
    void triangle02WorstCase(int count,int a, int b, int c ,String except) {
        assertEquals(except,Triangle02.classTriangle02(a,b,c));
    }
    @ParameterizedTest
    @CsvFileSource(resources = "/三角形健壮最坏情况测试用例.csv",numLinesToSkip = 1)
        //numLinesToSkip = 1是略过文件第1行
    void triangle02RobustWorst(int count,int a, int b, int c ,String except) {
        assertEquals(except,Triangle02.classTriangle02(a,b,c));
    }
}