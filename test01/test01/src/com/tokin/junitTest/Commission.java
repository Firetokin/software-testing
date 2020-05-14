package com.tokin.junitTest;

import java.util.Scanner;

public class Commission {
	
	public static int totalLock = 0;
	public static int totalStock = 0;
	public static int totalBarrel = 0;
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int lock = input.nextInt();
		while(lock != -1){
			int stock = input.nextInt();
			int barrel = input.nextInt();
			totalLock += lock;
			totalStock += stock;
			totalBarrel += barrel;
			lock = input.nextInt(); //别忘记！！！
		}
		input.close();
		payCommission(totalLock, totalStock, totalBarrel);
	}
	
	public static String payCommission(int totalLock, int totalStock, int totalBarrel){
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
