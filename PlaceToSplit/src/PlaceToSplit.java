
import java.io.BufferedReader;
import java.io.DataInputStream;
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
	public static void main(String args[]){
		PrintWriter wyjscie_konsoli = new PrintWriter(System.out, true);
		int array[];
		int znak,wielk;
		boolean splitrez;
		String tymcz;
		
		
			try(BufferedReader odczyt_konsoli = new BufferedReader(new InputStreamReader(System.in));
					Scanner odczyt_liczb = new Scanner(System.in)){ //automatyczna obsluga wyjatkow
				wyjscie_konsoli.println("Wprowadz wielkosc tablicy: ");
			    tymcz = odczyt_konsoli.readLine();   //odczytuje lancuch z wejscia konsoli
			    wielk = Integer.parseInt(tymcz);     //zamienia lancuch na int za pomoca obiektu opakowujacego Integer
			    System.out.println(wielk); //DEBUG wprowadza znaki ktore na int maja inne wartosci
			    array = new int[wielk];         //tworzy obiekt tablicy z dana wielkoscia
			    
				wyjscie_konsoli.println("Wprowadz dane do tablicy: ");
				
				int j = 0;
				do{
					wyjscie_konsoli.println("Podaj "+j+" liczbe do tabeli:");
					znak = odczyt_liczb.nextInt(); //zapisuje odczytywany znak do zmiennej znak  
					System.out.println(znak);  //debug!! dodac odczytywanie int normalnie
					array[j++] = znak;
				}while(j < wielk);      //po wyjsciu pojawia sie blad
			splitrez = canBalance(array);
			wyjscie_konsoli.print("Analizowanie tabeli: ");
			wyjscie_konsoli.println();
			wyjscie_konsoli.print("{");
			for(int i=0; i< array.length; i++){
				wyjscie_konsoli.print(array[i]);
				if(i<array.length-1) wyjscie_konsoli.print(",");
			}
			wyjscie_konsoli.println("}");
			wyjscie_konsoli.println();
			wyjscie_konsoli.println("Warunek mozliwosci podzialu tablicy na rowne czesci: "+splitrez);
		
		}catch(IOException exc){                                          
			System.out.println("Blad odczytu konsoli: "+exc);
		}
	
	
}
	
    private PlaceToSplit() {
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