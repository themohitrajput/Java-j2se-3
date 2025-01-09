package com.Lession2;
import java.util.Scanner;

public class Email {
	public static void main(String[] args) {
		// User-input code
		        Scanner scan = new Scanner(System.in);
		System.out.println("Enter your email address");
		        String email = scan.next();

		// Code to check if email ends with '.' (period sign) 
		boolean checkEndDot  = false;
		checkEndDot = email.endsWith(".");

		// Code to find out last index of '@' sign
		int indexOfAt = email.indexOf('@');
		int lastIndexOfAt = email.lastIndexOf('.');

		//Code to check occurrence of @ in the email address  
		int countOfAt = 0;
		for (int i = 0; i<email.length(); i++) {
		if(email.charAt(i)=='@')
		countOfAt++; }

		// Code to check occurrence of [period sign i..e, "."] after @ 
		        String buffering = email.substring(email.indexOf('@')+1, email.length());
		int len = buffering.length();
		int countOfDotAfterAt = 0;
		for (int i=0; i<len; i++) {
		if(buffering.charAt(i)=='.')
		countOfDotAfterAt++; }

		// Code to print userName&domainName
		String userName = email.substring(0, email.indexOf('@'));           
		String domainName = email.substring(email.indexOf('@')+1, email.length());
		System.out.println("\n");   
		if ((countOfAt==1) && (userName.endsWith(".")==false)  && (countOfDotAfterAt ==1) &&
		                  ((indexOfAt+3) <= (lastIndexOfAt) && !checkEndDot)) {

		System.out.println("\"Valid email address\"");}
		else {       
		System.out.println("\n\"Invalid email address\""); 
		}
	  }
	}



















