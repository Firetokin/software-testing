package com.testjunit4.junit4;

public class Tjunit4 {
	public String Advise(String s){
		if(s == "c1"){
			return "a1";
		}
		if(s == "c2"){
			return "a2";
		}
		if(s == "c3"){
			return "a3";
		}
		else{
			return "a4";
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String z = new Tjunit4().Advise("c1");
		System.out.println(z);
	}

}
