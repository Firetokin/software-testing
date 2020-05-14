package com.tokin.test01;
/**
 * 
 * @Author Tokin
 * @Description NextDate函数问题(输出日期是输入日期的后一天)
 * @Date 2020年5月14日
 * @Verson
 */
public class NextDate {
	/*判断是否闰年*/
	private static boolean leapYear(int y){
		if(((y%4 == 0) && (y%100 != 0)) || (y%400 == 0) ){
			return true;
		}
		else{
			return false;
		}
	}

	public static String classnextdate(int month, int day, int year){
		int flag= 1;
		if(year<1900 ||year>2050){
			flag = 0;
			return "年份输入错误";
		}else{
			if(month <1 || month >12){
				flag = 0;
				return "月份输入错误";
			}else{
				if(month==4 ||month==6 || month==9 || month==11){
					if(day>30 || day <1){
						flag = 0;
						return "日期输入错误";
					}
				}
				if(month==1 || month==3 || month==5 || month==7 || month==8 || month==10 ||month==12){
					if(day>31 || day < 1){
						flag = 0;
						return "日期输入错误";
					}
				}
				if(month == 2){
					if(leapYear(year)){
						if(day > 29){
							flag = 0;
							return "日期输入错误";
						}
					}else{
						if(day > 28){
							flag = 0;
							return "日期输入错误";
						}
					}
				}
			}
			
		}
		if(flag==1){
			switch(month){
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:	
				if(day == 31){
					int nextMonth = month + 1;
					return year+"年"+nextMonth+"月"+1+"日";
				}
				else{
					return year+"年"+month+"月"+(day+1)+"日";
				}
			case 4:
			case 6:
			case 9:
			case 11:
				if(day == 30){
					int nextMonth = month + 1;
					return year+"年"+nextMonth+"月"+1+"日";
				}
				else{
					return year+"年"+month+"月"+(day+1)+"日";
				}
			case 2:
				if(leapYear(year)){
					if(day == 29){
						int nextMonth = month + 1;
						return year+"年"+nextMonth+"月"+1+"日";
					}
					else{
						return year+"年"+month+"月"+(day+1)+"日";
					}
				}
			case 12:
				if(day == 30){
					int nextYear = year+1;
					return nextYear+"年"+1+"月"+1+"日";
				}else{
					return year+"年"+month+"月"+(day+1)+"日";
				}
				
			}
				
		}
		return null;
	}

}
