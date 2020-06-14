package com.tokin.task02;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

/**
 * @Description TODO
 * @Author Tokin
 * @Date 2020/6/14 9:37
 * @Version 1.0
 */
public class CommissionTestParameters {
    private final static String dir = "src/test/resources/";
    public static void main(String[] args) throws Exception {
        boundaryValueTestCase();    //边界值分析测试用例
        robustnessTestCase();       //健壮性测试用例
        worst_caseTestCase();       //最坏情况测试用例
        robust_worstTestCase();     //健壮最坏情况 测试用例
    }
    //边界值分析测试用例  4n+1:  4*3+1 = 13
    private static void boundaryValueTestCase() throws Exception{
        int[] lock = {1,2,35,69,70};
        int[] stock = {1,2,40,79,80};
        int[] barrel = {1,2,45,89,90};
        FileOutputStream fileOutputStream = new FileOutputStream(dir+"Commission边界值分析测试用例.csv");
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream,"UTF-8");
        CSVFormat csvFormat = CSVFormat.DEFAULT.withHeader("Serial number","Lock","Stock","Barrel","Expected value");
        CSVPrinter csvPrinter = new CSVPrinter(outputStreamWriter,csvFormat);
        int count = 0;
        for(int l : lock){
            for(int s : stock){
                for(int b : barrel){
                    if((l == 35 && s == 40) || (l == 35 && b == 45) ||(s == 40 && b == 45)){
                        csvPrinter.printRecord(++count,l,s,b,Commission02.payCommission(l,s,b));
                    }
                }
            }
        }
        csvPrinter.flush();
        csvPrinter.close();
    }
    //健壮性测试用例 6n + 1 = 19
    private static void robustnessTestCase() throws Exception{
        int[] lock = {0,1,2,35,69,70,71};
        int[] stock = {0,1,2,40,79,80,81};
        int[] barrel = {0,1,2,45,89,90,91};
        FileOutputStream fileOutputStream = new FileOutputStream(dir+"Commission健壮性测试用例.csv");
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream,"UTF-8");
        CSVFormat csvFormat = CSVFormat.DEFAULT.withHeader("Serial number","Lock","Stock","Barrel","Expected value");
        CSVPrinter csvPrinter = new CSVPrinter(outputStreamWriter,csvFormat);
        int count = 0;
        for(int l : lock){
            for(int s : stock){
                for(int b : barrel){
                    if((l == 35 && s == 40) || (l == 35 && b == 45) ||(s == 40 && b == 45)){
                        csvPrinter.printRecord(++count,l,s,b,Commission02.payCommission(l,s,b));
                    }
                }
            }
        }
        csvPrinter.flush();
        csvPrinter.close();
    }
    //最坏情况 测试用例,计算集合笛卡尔积：5^n = 125
    private static void worst_caseTestCase() throws Exception{
        int[] lock = {1,2,35,69,70};
        int[] stock = {1,2,40,79,80};
        int[] barrel = {1,2,45,89,90};
        FileOutputStream fileOutputStream = new FileOutputStream(dir+"Commission最坏情况测试用例.csv");
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream,"UTF-8");
        CSVFormat csvFormat = CSVFormat.DEFAULT.withHeader("Serial number","Lock","Stock","Barrel","Expected value");
        CSVPrinter csvPrinter = new CSVPrinter(outputStreamWriter,csvFormat);
        int count = 0;
        for(int l : lock){
            for(int s : stock){
                for(int b : barrel){
                        csvPrinter.printRecord(++count,l,s,b,Commission02.payCommission(l,s,b));
                }
            }
        }
        csvPrinter.flush();
        csvPrinter.close();
    }
    //健壮最坏情况
    private static void robust_worstTestCase() throws Exception{
        int[] lock = {0,1,2,35,69,70,71};
        int[] stock = {0,1,2,40,79,80,81};
        int[] barrel = {0,1,2,45,89,90,91};
        FileOutputStream fileOutputStream = new FileOutputStream(dir+"Commission健壮最坏情况测试用例.csv");
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream,"UTF-8");
        CSVFormat csvFormat = CSVFormat.DEFAULT.withHeader("Serial number","Lock","Stock","Barrel","Expected value");
        CSVPrinter csvPrinter = new CSVPrinter(outputStreamWriter,csvFormat);
        int count = 0;
        for(int l : lock){
            for(int s : stock){
                for(int b : barrel){
                        csvPrinter.printRecord(++count,l,s,b,Commission02.payCommission(l,s,b));
                }
            }
        }
        csvPrinter.flush();
        csvPrinter.close();
    }
}
