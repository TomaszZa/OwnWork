package com.capgemini.pokerHands;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

public class Player {
	private BufferedReader file;
	private List<Kart> hand = new ArrayList<Kart>();
	private int result;
	private int drawCardSequence, drawCardSame1, drawCardSame2, drawCardHighest;

	Player(BufferedReader f) {
		result = 0;
		file = f;
		drawCardSequence = 0;
		drawCardSame1 = 0;
		drawCardSame2 = 0;
		drawCardHighest = 15;
		try{
			readFileCards();
		}catch(IOException exc){
				System.out.println("File read failure!");
		}
	}

	private void readFileCards() throws IOException { 
		char kindRead, suitRead;
		
		for (int i = 0; i < 5; i++) {
			kindRead = (char) file.read();
			if(kindRead == '\n') kindRead = (char) file.read(); //new read
			suitRead = (char) file.read();
			file.read();  //deliting space
			hand.add(new Kart(kindRead, suitRead));
		}
	}

	private String sequenceCards() {    
		int count = 0;
		int smallest = 15;
		boolean royal = false;
		boolean cardFound = false;

		for (int i = 0; i < hand.size(); i++) {
			if (hand.get(i).getValue() < smallest)
				smallest = hand.get(i).getValue();
		}
		
		if (smallest == 10)
			royal = true;
		drawCardSequence = smallest;
		
		for (int j = 0; j < 5; smallest++,j++) {
			for (int i = 0; i < hand.size(); i++) {
				if (hand.get(i).getValue() == smallest)
					cardFound = true;
			}
			if(cardFound){
				count++;
				cardFound = false;
			}
		}
		
		if (count == 5 && royal)
			return "CardsInOrderWithRoyal";
		if (count == 5)
			return "CardsInOrder";
		return "CardsNoInOrder";
	}

	private boolean colorCards() {
		int count = 0;
		boolean cardsAtTheSameColour = false;
		char[] cardsuit = { 'H', 'S', 'D', 'C' };
		
		for (int i = 0; i < cardsuit.length; i++) {
			for (int j = 0; j < hand.size(); j++) {
				if (cardsuit[i] == hand.get(j).getSuit())
					count++;
			}
			
			if (count == 5){
				cardsAtTheSameColour = true;
				break;
			}
			count = 0;
		}
		return cardsAtTheSameColour;
	}

	private void highestCards() {
		int highest = 0;

		
		for (int i = 0; i < hand.size(); i++) {
			
			if (hand.get(i).getValue() < drawCardHighest && hand.get(i).getValue() > highest)
				highest = hand.get(i).getValue();
		}
		
		drawCardHighest = highest;
	}

	public void HighestRoll() {
		
		result += drawCardHighest;
		highestCards();
		
	}

	private String sameCards() {
		int count = 0, numberOfCards = 0, secondNumberOfCards = 0;
		int card;
		String sameResult = "NoTheSameCards";

		for (int j = 0; j < hand.size(); j++) {
			card = hand.get(j).getValue();
			for (int i = 0; i < hand.size(); i++) {
				if (card == hand.get(i).getValue())
					count++;
			}

			if (count >= numberOfCards && drawCardSame1 != card) { //DrawCardSame1 != card - protect 
				                                                    //from counting the same card twice
				secondNumberOfCards = numberOfCards;   
				numberOfCards = count;
				drawCardSame2 = drawCardSame1;
				drawCardSame1 = card;
			}
			count = 0;
		}
		switch (numberOfCards) {
		case 4:
			sameResult = "FourSameCards";
			break;
		case 3:
			switch (secondNumberOfCards) {
			case 0:
			case 1:
				sameResult = "ThreeSameCards";
				break;
			case 2:
				sameResult = "ThreeAndTwoSameCards";
			}
			break;
		case 2:
			switch (secondNumberOfCards) {
			case 0:
			case 1:
				sameResult = "OnePairCards";
				break;
			case 2:
				sameResult = "TwoPairsCards";
				break;
			case 3:
				sameResult = "ThreeAndTwoSameCards";
				
			}
			break;
		}
		return sameResult;
	}

	public void sequenceCalculating() {    //pomysl Krzyska Granatowskiego z enumami
	    Figura figura;
	    
		highestCards();

		figura = Figura.parseByValues(colorCards(), sequenceCards(), sameCards());
		
		switch (figura) {   //for second line from file figura is equal null !
		case ROYALFLUSH:
			result = 450 + drawCardSequence;
			break;
		case SFLUSH:
			result = 400 + drawCardSequence;
			break;
		case FOUR:
			result = 350 + drawCardSame1;
			break;
		case FULL:
			result = 300 + drawCardSame1 + drawCardSame2;
			break;
		case FLUSH:
		case FLUSH1:
		case FLUSH2:
		case FLUSH3:
		case FLUSH4:
		case FLUSH5:
		case FLUSH6:
			result = 250 + drawCardHighest;
			break;
		case STRAIGHTN:
		case STRAIGHTR:
			result = 200 + drawCardSequence;
			break;
		case THREE:
			result = 150 + drawCardSame1;
			break;
		case TWOPAIR:
			result = 100 + drawCardSame1 + drawCardSame2;
			break;
		case PAIR:
			result = 50 + drawCardSame1;
			break;
		case HIGHEST:
			result = drawCardHighest;
			break;
		}
	}

	public int compareResult() {
		return result;
	}

	public int getDrawCardSequence() {
		return drawCardSequence;
	}

	public int getDrawCardSame1() {
		return drawCardSame1;
	}

	public int getDrawCardSame2() {
		return drawCardSame2;
	}

	public int getDrawCardHighest() {
		return drawCardHighest;
	}

}
