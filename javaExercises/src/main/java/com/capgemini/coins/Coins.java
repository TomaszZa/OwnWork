package com.capgemini.coins;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by ldrygala on 2015-02-06.
 * <p/>
 * Consider N coins aligned in a row. Each coin is showing either heads or
 * tails. The adjacency of these coins is the number of adjacent pairs of coins
 * with the same side facing up.
 * <p/>
 * It must return the maximum possible adjacency that can be obtained by
 * reversing exactly one coin (that is, one of the coins must be reversed).
 * Consecutive elements of array A represent consecutive coins in the row. Array
 * A contains only 0s and/or 1s: 0 represents a coin with heads facing up; 1
 * represents a coin with tails facing up. For example, given array A consisting
 * of six numbers, such that:
 * <p/>
 * A[0] = 1 A[1] = 1 A[2] = 0 A[3] = 1 A[4] = 0 A[5] = 0
 * <p/>
 * the function should return 4. The initial adjacency is 2, as there are two
 * pairs of adjacent coins with the same side facing up, namely (0, 1) and (4,
 * 5). After reversing the coin represented by A[2], the adjacency equals 4, as
 * there are four pairs of adjacent coins with the same side facing up, namely:
 * (0, 1), (1, 2), (2, 3) and (4, 5), and it is not possible to obtain a higher
 * adjacency. The same adjacency can be obtained by reversing the coin
 * represented by A[3].
 */
public class Coins {
	public static int solution(List<Integer> coins) {
		int points = 0, revPoints = 0;
		Integer toChange;
		List<Integer> newList;

		for (int i = 0; i < coins.size(); i++) {

			newList = newListForCalculation(coins);
			toChange = newList.get(i);
			newList.remove(i); // dodac zamiane elementu!!
			newList.add(i, changeOneCoin(toChange));

			for (int j = 1; j < newList.size(); j++) {
				if (newList.get(j) == newList.get(j - 1))
					revPoints++;
			}

			if (revPoints > points)
				points = revPoints;
			revPoints = 0;

		}

		return points;
	}

	public static List<Integer> CreateList(int n) {
		Random x = new Random();
		List<Integer> coinsList = new ArrayList<Integer>();

		for (int i = 0; i < n; i++) {
			coinsList.add(x.nextInt(2));
		}

		return coinsList;
	}

	private static List<Integer> newListForCalculation(List<Integer> coins) { // utworzenie
																				// nowej
																				// listy
		List<Integer> newList = new ArrayList<Integer>(); // z wartosciami z
															// oryginalnej

		for (int i = 0; i < coins.size(); i++) {
			newList.add(coins.get(i));
		}

		return newList;
	}

	private static int changeOneCoin(Integer x) {
		int change = 0;

		if (x.intValue() == 1)
			change = 0;
		if (x.intValue() == 0)
			change = 1;

		return change;
	}
}