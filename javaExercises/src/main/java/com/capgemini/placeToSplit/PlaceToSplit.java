package com.capgemini.placeToSplit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Given a non-empty array, return true if there is a place to split the array so that the sum of the numbers on one side is equal to the sum of the numbers on the other side.
 * Example:
 * {{{
 * canBalance({1, 1, 1, 2, 1}) → true
 * canBalance({2, 1, 1, 2, 1}) → false
 * canBalance({10, 10}) → true
 * }}}
 */
public final class PlaceToSplit {
	static int array[];
	static int charakter,size;
	static boolean splitrez;
	static String temp;
	
	
    private PlaceToSplit() {
    	charakter = 0;
    	size = 0;
    	splitrez = false;
    }
    
    public static void interfejs(){
    	PrintWriter consol_output = new PrintWriter(System.out, true);
    	
    	try(BufferedReader console_input = new BufferedReader(new InputStreamReader(System.in));
				Scanner numbers_input = new Scanner(System.in)){ //automatyczna obsluga wyjatkow
    		
			consol_output.println("Add array size: ");
			
		    temp = console_input.readLine();   //odczytuje lancuch z wejscia konsoli
		    size = Integer.parseInt(temp);     //zamienia lancuch na int za pomoca obiektu opakowujacego Integer
		    
		    
		    array = new int[size];         //tworzy obiekt tablicy z dana wielkoscia
		    
			consol_output.println("Add data to the array: ");
			
			int j = 0;
			do{
				consol_output.println("Add "+j+" number to array:");
				charakter = numbers_input.nextInt(); //zapisuje odczytywany znak do zmiennej znak  
				array[j++] = charakter;
			}while(j < size);      
			
		splitrez = canBalance(array);
		consol_output.print("Array analizing: ");
		consol_output.println();
		consol_output.print("{");
		
		for(int i=0; i< array.length; i++){
			consol_output.print(array[i]);
			if(i<array.length-1) consol_output.print(",");
		}
		consol_output.println("}");
		consol_output.println();
		consol_output.println("If it's possible to divide array on two values: "+splitrez);
	
	}catch(IOException exc){                                          
		System.out.println("Console read failure: "+exc);
	}
    }

    public static boolean canBalance(int[] nums) {  //sprawdza warunek
    	int left,right;
    	for(int i = 0 ; i< nums.length; i++){
    		left = 0;
    		right = 0; 
    		for(int j = 0; j<=i; j++){
    			left += nums[j];
    		}
    		for(int j = nums.length-1; j>i; j--){
    			right += nums[j];
    		}
    		if(left == right) return true;
    	}
        return false;
    }
}
