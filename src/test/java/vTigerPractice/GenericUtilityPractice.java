package vTigerPractice;

import java.util.Random;

public class GenericUtilityPractice {
       public static void main(String[] args) {
    	  
    	   //by using non static method and calling by object as reference
    	   Random ran= new Random();
   		   int random= ran.nextInt(500);
   		   System.out.println(random);
   		   
   		   int random1=ran.nextInt(200);
   		   System.out.println(random1);
    	   
    	   //by using static method and calling by class name as reference
		     int value1=GenericUtilityPractice.add(random,random1);
	         System.out.println(value1);
      }
      public static int add (int a, int b) {
	         int c=a+b;
	         return c;
     }
}