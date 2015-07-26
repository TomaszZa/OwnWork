package com.capgemini.coins;

import java.util.List; //test
import java.util.Scanner;

public class MainClass {
	public static void main(String args[]) {
		Scanner consol_in = new Scanner(System.in);
		String Quit;

		do {

			panelMethod(consol_in);

			System.out.println("\n");
			System.out.println("s- start program, q- quit program: ");
			Quit = consol_in.nextLine();

			System.out.println(Quit);
		} while (Quit.compareTo("q") != 0);

		consol_in.close();
		System.out.println("End of program");
	}

	private static void panelMethod(Scanner consol_in) {

		int Result = 0, NumberofCoins = 0;
		List<Integer> ShowList;

		System.out.println("Add number of Coins");
		NumberofCoins = consol_in.nextInt();
		consol_in.nextLine(); // delete enter
		System.out.print("Sequence from Coins:");

		ShowList = Coins.CreateList(NumberofCoins);
		Result = Coins.solution(ShowList);

		for (int i = 0; i < ShowList.size(); i++) {
			System.out.print(ShowList.get(i));
		}

		System.out.println();
		System.out.println("Points from coins: " + Result);

	}

}
