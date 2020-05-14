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
		}
		input.close();
		payCommission(totalLock, totalStock, totalBarrel);
	}
	
	public static String payCommission(int totalLock, int totalStock, int totalBarrel){
		if(totalLock == 0 || totalStock == 0 || totalBarrel == 0){
			return ""+0;
		}
		else{
			if(totalLock > 70){
				totalLock = 70;
			}
			if(totalStock > 80){
				totalStock = 80;
			}
			if(totalBarrel > 90){
				totalBarrel = 90;
			}
			
			double totalSales = totalLock * 45 + totalStock * 30 + totalBarrel * 25;
			if(totalSales <= 1000){
				return ""+(totalSales*0.1);
			}
			if(totalSales > 1000 && totalSales < 1800){
				return ""+(totalSales*0.15);
			}
			if(totalSales >= 1800){
				return ""+(totalSales*0.2);
			}
		}
		return null;
	}
}
