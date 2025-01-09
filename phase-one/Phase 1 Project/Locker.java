package com.simplilearn;

import java.awt.List;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Locker
{
	 public static void main(String[] args) 
	 {
		 String a,d,sr;
		 ArrayList <String>list = new ArrayList <String>();
		 Scanner sc =new Scanner(System.in);
	
		 char ch ;
		 do {
			 System.out.println("\nLockers Operations");
	         System.out.println("1. Add File ");
	         System.out.println("2. Delete File ");
	         System.out.println("3. Search File ");
	         System.out.println("4. Close ");
	         int choice = sc.nextInt();
	         
		 switch(choice)
		 {		 
		 case 1 : 
			 //create file
			 try
             {	
				 System.out.println("File Name : ");
				  a = sc.next();
				  File file = new File(a+".txt");
				  
				 if (file.createNewFile()) 
		            {  
		                System.out.println(" New File is created!");  
		                break;
		            }
		            else
		            { 
		                if(file.exists())
		                {	 
		                    System.out.println("File already exists."); 	                           
		                }
		                else
		                {
		                	System.out.println("File doesnot exists.");
		                }
		            }
				 
             }
           
			 catch (IOException e)
			 {  
		            e.printStackTrace(); 
             } 
		  
		 case 2 : //delete the file
			 try
			 {
			 System.out.println("which file do you want to Delete : ");
			  d = sc.next();

			  File file = new File(d+".txt");
			 
			  if(file.exists())
			  {
				  boolean s = Boolean.parseBoolean(d);
				  s = file.delete();
				  System.out.println("File deleted !!\n"); 
			  }
			  else
			  {
				  System.out.println("File not deleted");
			  } 
		 }
			 catch (Exception e) {  
				 System.out.println(e);
             } 
			 break;
			  
		 case 3 ://search the file
			 try {
			 System.out.println("which file do you want to Search : ");
			  sr = sc.next();

			  File file1 = new File(sr+".txt");
			 if(file1.exists())
			  {
				 System.out.println("Search file name : "+file1);
				 }
			 else {
				 System.out.println("File Not Found");
			 }
		 }
		 
		 catch (Exception e)
			 {  
			 System.out.println(e); 
         } 
			 break;
			 
		 case 4 : 
			 System.exit(5);
		default :
			
			 System.out.println("Invalid Choice");
			 break;
		 } 
		
		 System.out.println("\nDo you want to continue (Type y or n) \n");
         ch = sc.next().charAt(0);
		 }
		 while (ch == 'Y'|| ch == 'y'); 
		 }

	private static String list(String string)
	{
		return null;
	}
 }
