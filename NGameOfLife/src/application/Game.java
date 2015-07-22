package application;

import console.Console;

public class Game {
	Console console;
	Board board; // z konsoli

	public Game(Console c) {
		console = c;
		board = console.getBoard();
	}

	public void goThroughtFields() throws EndOfGameException {
		int nNeighbours = 0;

		for (int i = 0; i < board.getBoardList().size(); i++) {
			nNeighbours = checkField(i);
			board.getBoardList().get(i).putNeighbours(nNeighbours);
		}
		int countFalse = 0;
		for (int i = 0; i < board.getBoardList().size(); i++) {
			board.getBoardList().get(i).checkNeighbours();
			if (!(board.getBoardList().get(i).getLifeStatus()))
				countFalse++;
		}
		console.writeOnConsole();

		if (countFalse == board.getBoardList().size() - 1)
			throw new EndOfGameException();
	}

	private int checkField(int i) { // tu jest blad !!
		int x;
		int y;
		int xtemp;
		int ytemp;
		int nNeighbours = 0;

		x = board.getBoardList().get(i).getCoordinates().x;
		y = board.getBoardList().get(i).getCoordinates().y;
		xtemp = x;
		ytemp = y;

		for (int j = -1; j < 2; j++) {
			for (int l = -1; l < 2; l++) {
				xtemp += l;
				ytemp += j;

				if (xtemp == -1)
					xtemp = board.getRows() - 1;
				if (xtemp == board.getRows())
					xtemp = 0;
				if (ytemp == -1)
					ytemp = board.getColumns() - 1;
				if (ytemp == board.getColumns())
					ytemp = 0;

				if (!(l == 0 && j == 0))
					if (board.getBoardList().get(xtemp + ytemp * board.getRows()).getLifeStatus())
						nNeighbours++;
				xtemp = x;
				ytemp = y;
			}
		}

		return nNeighbours;
	}

}
