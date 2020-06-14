package com.tokin.task03;
import java.util.DuplicateFormatFlagsException;
import java.util.Scanner;
/**
 * @Description TODO
 * @Author Tokin
 * @Date 2020/6/14 15:06
 * @Version 1.0
 */
public class PhoneBill {
    private static int[] startTime = new int[3];
    private static int[] endTime = new int[3];
    private static int[] poorTime = new int[3];
    private static int time;
    private static double money;
    private static int year;
    private static int month;
    private static int day;
    private static int T = 0;
    private static int W = 1;
    private static int M = 1;
    static String phoneBill(int y, int m, int d, int startTime1, int startTime2, int startTime3, int endTime1, int endTime2, int endTime3){
        year = y;
        month = m;
        day = d;
        startTime[0] = startTime1;
        startTime[1] = startTime2;
        startTime[2] = startTime3;
        endTime[0] = endTime1;
        endTime[1] = endTime2;
        endTime[2] = endTime3;
        Date();
        Time();
        if(M == 0){
                time = time + 60;
        }
        Money();
       return Double.toString(money);
    }


    //计算日期
    public static void Date(){
        if(month == 1 || month == 2)
        {
            year--;
            month += 12;
        }
        W = (day + 2 * month + 3 * (month + 1)/5 + year + year/4 - year/100 + year/400 + 1) % 7;//0是周日，其他对应
        if(month > 12)
        {
            year++;
            month -= 12;
        }
        if(W == 0){
            if(month == 3 && day >=25 && day <= 31){
                T = 1;
            }
            else if(month == 10 && day >=25 && day <= 31){
                T = 2;
            }
            else T = 0;
        }
        else T = 0;
    }
    //计算时间转换
    private static void Time(){
        if(startTime[0] > endTime[0]){
            endTime[0] += 24;
        }
        for(int i = 0;i < 3;i++){
            poorTime[i] = endTime[i] - startTime[i];
        }
        if(T == 0){
            if(W == 6 && endTime[0] >= 27){
                if(month == 3 && day >=24 && day <= 30){
                    poorTime[0]--;
                }
                else if(month == 10 && day >=25 && day <= 31){
                    poorTime[0]++;
                }
            }
            else if(W == 6 && endTime[0] >= 26  && month == 10 && day >=25 && day <= 31){
                M = 0;//判断时间是否经过变化了的
            }
        }
        else if(T == 1){
            if(startTime[0] <= 2 && endTime[0] >= 3){
                poorTime[0]--;
            }
        }
        else if(T == 2){
            if(startTime[0] < 2 && endTime[0] >= 3){
                poorTime[0]++;
            }
            else if(poorTime[1] < 0 && startTime[0] == 2 && endTime[0] == 2){
                poorTime[0]++;
            }
            else if(startTime[0] <= 2 && endTime[0] == 2){
                M = 0;//判断时间是否经过变化了的
            }
            else if(startTime[0] == 2  && endTime[0] > 2){
                M = 0;//判断时间是否经过变化了的
            }
        }
        time = poorTime[0] * 60 + poorTime[1];
        if(poorTime[2] > 0){//为负数或0时不像前进，为正确值
            time++;
        }
    }
    //计算话费
    private static void Money(){
        if(time <= 20){
            money = time * 0.05;
        }
        else{
            money =   (1 + (time - 20) * 0.10);
        }
    }
}
