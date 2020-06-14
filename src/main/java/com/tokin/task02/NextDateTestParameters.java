package com.tokin.task02;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

/**
 * @Description TODO
 * @Author Tokin
 * @Date 2020/6/14 8:40
 * @Version 1.0
 */
public class NextDateTestParameters {
    private final static String dir = "src/test/resources/";
    public static void main(String[] args) throws Exception {
        boundaryValueTestCase();    //边界值分析测试用例
        robustnessTestCase();       //健壮性测试用例
        worst_caseTestCase();       //最坏情况测试用例
        robust_worstTestCase();     //健壮最坏情况 测试用例
    }
    //边界值分析测试用例  4n+1:  4*3+1 = 13
    private static void boundaryValueTestCase() throws Exception{
        int[] year = {1900,1911,1975,2049,2050};
        int[] month = {1,2,6,11,12};
        int[] day ={1,2,15,30,31};
        FileOutputStream fileOutputStream = new FileOutputStream(dir+"NextDate边界值分析测试用例.csv");
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream,"UTF-8");
        CSVFormat csvFormat = CSVFormat.DEFAULT.withHeader("Serial number","Year","Month","Day","Expected value");
        CSVPrinter csvPrinter = new CSVPrinter(outputStreamWriter,csvFormat);

        int count = 0;
        for(int y : year){
            for(int m : month){
                for(int d : day){
                    if((y == 1975 && m == 6)  || (y == 1975 && d == 15) || (m == 6 && d == 15)){
                        csvPrinter.printRecord(++count,y,m,d,NextDate02.classnextdate(y,m,d));
                    }
                }
            }
        }
        csvPrinter.flush();
        csvPrinter.close();
    }
    //健壮性测试用例 6n + 1 = 19
    private static void robustnessTestCase() throws Exception{
        int[] year = {1899,1900,1911,1975,2049,2050,2051};
        int[] month = {0,1,2,6,11,12,13};
        int[] day ={0,1,2,15,30,31,32};
        FileOutputStream fileOutputStream = new FileOutputStream(dir+"NextDate健壮性测试用例.csv");
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream,"UTF-8");
        CSVFormat csvFormat = CSVFormat.DEFAULT.withHeader("Serial number","Year","Month","Day","Expected value");
        CSVPrinter csvPrinter = new CSVPrinter(outputStreamWriter,csvFormat);

        int count = 0;
        for(int y : year){
            for(int m : month){
                for(int d : day){
                    if((y == 1975 && m == 6)  || (y == 1975 && d == 15) || (m == 6 && d == 15)){
                        csvPrinter.printRecord(++count,y,m,d,NextDate02.classnextdate(y,m,d));
                    }
                }
            }
        }
        csvPrinter.flush();
        csvPrinter.close();
    }
    //最坏情况 测试用例,计算集合笛卡尔积：5^n = 125
    private static void worst_caseTestCase() throws Exception{
        int[] year = {1900,1911,1975,2049,2050};
        int[] month = {1,2,6,11,12};
        int[] day ={1,2,15,30,31};
        FileOutputStream fileOutputStream = new FileOutputStream(dir+"NextDate最坏情况测试用例.csv");
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream,"UTF-8");
        CSVFormat csvFormat = CSVFormat.DEFAULT.withHeader("Serial number","Year","Month","Day","Expected value");
        CSVPrinter csvPrinter = new CSVPrinter(outputStreamWriter,csvFormat);

        int count = 0;
        for(int y : year){
            for(int m : month){
                for(int d : day){
                        csvPrinter.printRecord(++count,y,m,d,NextDate02.classnextdate(y,m,d));
                }
            }
        }
        csvPrinter.flush();
        csvPrinter.close();
    }
    //健壮最坏情况
    private static void robust_worstTestCase() throws Exception{
        int[] year = {1899,1900,1911,1975,2049,2050,2051};
        int[] month = {0,1,2,6,11,12,13};
        int[] day ={0,1,2,15,30,31,32};
        FileOutputStream fileOutputStream = new FileOutputStream(dir+"NextDate健壮性最坏情况测试用例.csv");
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream,"UTF-8");
        CSVFormat csvFormat = CSVFormat.DEFAULT.withHeader("Serial number","Year","Month","Day","Expected value");
        CSVPrinter csvPrinter = new CSVPrinter(outputStreamWriter,csvFormat);

        int count = 0;
        for(int y : year){
            for(int m : month){
                for(int d : day){
                        csvPrinter.printRecord(++count,y,m,d,NextDate02.classnextdate(y,m,d));
                }
            }
        }
        csvPrinter.flush();
        csvPrinter.close();
    }
}
