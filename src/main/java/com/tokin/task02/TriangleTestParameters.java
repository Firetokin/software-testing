package com.tokin.task02;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
/**
 * @Description TODO
 * @Author Tokin
 * @Date 2020/6/13 10:30
 * @Version 1.0
 */
public class TriangleTestParameters {
    private final static String dir = "src/test/resources/";  //路径写法！熟记！

    public static void main(String[] args) throws Exception {
        boundaryValueTestCase();    //边界值分析测试用例
        robustnessTestCase();       //健壮性测试用例
        worst_caseTestCase();       //最坏情况测试用例
        robust_worstTestCase();     //健壮最坏情况 测试用例
    }
    //边界值分析测试用例  4n+1:  4*3+1 = 13
    private static void boundaryValueTestCase() throws Exception {
        int[] side_abc = {1, 2, 50, 99, 100};
        FileOutputStream fileOutputStream = new FileOutputStream(dir+"三角形边界值分析测试用例.csv");
        //字节 -->字符
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream,"UTF-8");
        CSVFormat csvFormat = CSVFormat.DEFAULT.withHeader("Serial number","Side length a","Side length b","Side length c","Expected value");
        CSVPrinter csvPrinter = new CSVPrinter(outputStreamWriter,csvFormat);
        int count = 0;
        int a1 = 50;
        int b1 = 50;
        for(int c1 : side_abc){
            csvPrinter.printRecord(++count,a1,b1,c1,Triangle02.classTriangle02(a1,b1,c1));
        }
        int a2 = 50;
        int c2 = 50;
        for(int b2 : side_abc){
            if(b2 != 50) {   //去掉冗余
                csvPrinter.printRecord(++count, a2, b2, c2, Triangle02.classTriangle02(a2, b2, c2));
            }
        }
        int b3 = 50;
        int c3 = 50;
        for(int a3 : side_abc){
            if(a3 != 50) {  //去掉冗余
                csvPrinter.printRecord(++count, a3, b3, c3, Triangle02.classTriangle02(a3, b3, c3));
            }
        }
        csvPrinter.flush();
        csvPrinter.close();
    }

    //健壮性测试用例 6n + 1 = 19
    private static void robustnessTestCase()throws Exception{
        int [] side_abc = {0, 1, 2, 50, 99, 100, 101};
        FileOutputStream fileOutputStream = new FileOutputStream(dir+"三角形健壮性测试用例.csv");
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream,"UTF-8");
        CSVFormat csvFormat = CSVFormat.DEFAULT.withHeader("Serial number","Side length a","Side length b","Side length c","Expected value");
        CSVPrinter csvPrinter = new CSVPrinter(outputStreamWriter,csvFormat);
        //if ( conditionA && conditionB ) 和 if ( conditionA || conditionB )
        //如果conditionA是false的话，那么if ( conditionA && conditionB )就不用判断conditionB了，直接为false
        //如果conditionA是true的话，那么if ( conditionA || conditionB )就不用判断conditionB了，直接是true
        int count = 0;
        for (int a : side_abc) {
            for (int b : side_abc) {
                for (int c : side_abc) {
                    if (a == b && a == 50 || a == c & a == 50 || b == c && b == 50) {
                        //区别于边界值分析的算法，代码简单，但这种情况时间空间复杂度较上一种高
                        csvPrinter.printRecord(++count, a, b, c, Triangle02.classTriangle02(a, b, c));
                    }
                }
            }
        }
        csvPrinter.flush();
        csvPrinter.close();
    }
    //最坏情况 测试用例,计算集合笛卡尔积：5^n = 125
    private static void worst_caseTestCase()throws Exception{
        int [] side_abc = {1, 2, 50, 99, 100};
        FileOutputStream fileOutputStream = new FileOutputStream(dir+"三角形最坏情况测试用例.csv");
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream,"UTF-8");
        CSVFormat csvFormat = CSVFormat.DEFAULT.withHeader("Serial number","Side length a","Side length b","Side length c","Expected value");
        CSVPrinter csvPrinter = new CSVPrinter(outputStreamWriter,csvFormat);
        int count = 0;
        for (int a : side_abc) {
            for (int b : side_abc) {
                for (int c : side_abc) {
                    csvPrinter.printRecord(++count, a, b, c, Triangle02.classTriangle02(a, b, c));
                }
            }
        }
        csvPrinter.flush();
        csvPrinter.close();
    }

    //健壮最坏情况
    private static void robust_worstTestCase()throws Exception{
        int [] side_abc = {0, 1, 2, 50, 99, 100, 101};
        FileOutputStream fileOutputStream = new FileOutputStream(dir+"三角形健壮最坏情况测试用例.csv");
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream,"UTF-8");
        CSVFormat csvFormat = CSVFormat.DEFAULT.withHeader("Serial number","Side length a","Side length b","Side length c","Expected value");
        CSVPrinter csvPrinter = new CSVPrinter(outputStreamWriter,csvFormat);
        int count = 0;
        for (int a : side_abc) {
            for (int b : side_abc) {
                for (int c : side_abc) {
                    csvPrinter.printRecord(++count, a, b, c, Triangle02.classTriangle02(a, b, c));
                }
            }
        }
        csvPrinter.flush();
        csvPrinter.close();
    }
}
