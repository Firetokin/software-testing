package com.tokin.task01;
import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.Collection;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

//参数化运行器,修饰类，指定需要的Runner
@RunWith(Parameterized.class)
public class Triangle01Test {
    private int a, b , c;
    private String type;


    @Before
    public void setUp() {
    }

    public Triangle01Test(int a, int b, int c, String type) {
        // TODO Auto-generated constructor stub
        this.a = a;
        this.b = b;
        this.c = c;
        this.type = type;
    }
    //测试数据的集合
    @Parameters
    public static Collection<Object[]>getData(){
        return Arrays.asList(
                new Object[][]{
                        {10,20,30,"非三角形"},
                        {2,2,2,"等边三角形"},
                        {0,0,0,"输入错误"},
                        {4,3,5,"一般三角形"},
                        { 3, 3, 4, "等腰三角形" },
                        { 4, 4, 5, "等腰三角形" },
                        { 1, 0, 0, "输入错误" },
                        { 1, 1, 1, "等边三角形" },
                });

    }
    @Test
    public void classify() {
        assertEquals(this.type, Triangle01.classify(a, b, c));
    }

}

