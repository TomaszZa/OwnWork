package com.capgemini.pokerHands;

public class Kart {
	private int value; 
	private char kind; 
	private char suit; 
	
	public Kart(char kindTemp, char suitTemp){
		kind = kindTemp;
		suit = suitTemp;
		
		switch(kind){
		case 'J':
			value = 11;
			break;
		case 'Q':
			value = 12;
			break;
		case 'K':
			value = 13;
			break;
		case 'A':
			value = 14;
			break;
		case 'T':
			value = 10;
			break;
		default:
			value = kind-48;  // to make from '1' => 1 ats.
		}
	}
	
	public int getValue(){
		return value;
	}
	public char getSuit(){
		return suit;
	}
}
