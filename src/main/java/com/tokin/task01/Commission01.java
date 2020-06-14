package com.tokin.task01;

/**
 * @Description TODO
 * @Author Tokin
 * @Date 20T20/6/13 8:30
 * @Version 1.0
 */
public class Commission01 {
    static String payCommission(int totalLock, int totalStock, int totalBarrel){
        double totalsales = totalLock*45.0 + totalStock*30.0 + totalBarrel*25.0;
        double totalpay = 0;
        if(totalsales <= 1000 && totalsales >=0){
            totalpay = totalsales *0.1;
        }
        else if(totalsales > 1000 && totalsales < 1800){
            totalpay = 1000*0.1 + (totalsales-1000)*0.15;
        }else{
            totalpay = 1000*0.1 + 800*0.15 + (totalsales - 1800)*0.2;
        }
        return ""+totalpay;
    }
}
