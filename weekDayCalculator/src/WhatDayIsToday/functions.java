/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WhatDayIsToday;

//import java.util.Scanner;

/**
 *
 * @author theparrot
 */
public class functions{
	//Scanner in = new Scanner(System.in);
	int year,month,day;
	public String[] daysOfWeek = {"Saturday","Sunday","Monday","Tuesday","Wednesday","Thursday","Friday"};
	int[][] daysInMonth = {{0,31,28,31,30,31,30,31,31,30,31,30,31},
						{0,31,29,31,30,31,30,31,31,30,31,30,31}};
	
	public int dayCheck(int year,int month,int day){
		if(year<1)return 0;
		if(month<1||month>12)return 0;
		if(day<1||day>daysInMonth[aFuckingLeap(year)][month])return 0;
		else return 1;
	};
	
	public int aFuckingLeap (int year){
		int isLeap = 0;
		if(year>=1582){//the Gregorian reform was introduced in October 1582
			if(year%400==0)isLeap=1;		
			else if(year%100==0)isLeap = 0;
			else if (year%4==0)isLeap = 1;
		}
		else if (year%4==0)isLeap = 1;
		if (isLeap == 1) return 1;
		else return 0;
	}
	

	
	public int calculateDayOfWeek(int year,int month,int day){
		//the first day of year 1 is a Saturday.
		//it is hence coded with the number 0
		//Sunday is 1, Monday is 2, etc.
		int i = -1,j;
		if(year==1)i+=0;
		else for(j=1;j<year;j++){
			if(aFuckingLeap(j)==0)i+=1;
			else i+=2;
		}
		
		if(month==1)i+=0;
		else for(j=1;j<month;j++){
			i+=daysInMonth[aFuckingLeap(year)][j];
		}
		
		i+=day;
		if(year>1582)i-=10;//Gregorian conversion drop 10 days from the year
		//the actual conversion is that the day after Thursday, October 4, 1582 became Friday, October 15, 1582
		return i%7;
	}
}
