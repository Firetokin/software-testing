package com.tokin.task02;

/**
 * @Description TODO
 * @Author Tokin
 * @Date 2020/6/14 9:36
 * @Version 1.0
 */
public class Commission02 {
    //本题按测试要求题意，在此处：假设一条数据是一个月的销售情况，不考虑一个月发多次并累加判断是否符号销售规定等
    static String payCommission(int totalLock, int totalStock, int totalBarrel){
        double totalsales = totalLock * 45.0 + totalStock * 30.0 + totalBarrel * 25.0;
        double totalpay = 0;
        if(totalsales <= 1000 && totalsales >=0){
            totalpay = totalsales * 0.1;
        }
        else if(totalsales > 1000 && totalsales < 1800){
            totalpay = 1000 * 0.1 + (totalsales-1000) * 0.15;
        }else{
            totalpay = 1000 * 0.1 + 800 * 0.15 + (totalsales - 1800) * 0.2;
        }
        return Double.toString(totalpay);
    }
}
