package application;

import java.util.ArrayList;
import java.util.List;

public class GameOfLifeTest {

	@Test
	public void testGenarateArea() { // genarated list size check
		GameOfLife game = new GameOfLife(10, 10);

		game.generateArea(10, 10);

		assertEquals(100, game.getArea().size());

	}

	@Test
	public void testNumberOfNeighboursZero() {
		GameOfLife game = new GameOfLife(10, 10);
		List<Boolean> tempList = new ArrayList<Boolean>();

		for (int i = 0; i < 100; i++) {
			tempList.add(false);
		}
		tempList.remove(5);
		tempList.add(5, true);

		game.putArea(tempList);

		try {
			game.goThroughtListOfFields();

		} catch (EndOfGameException exc) {
		}

		assertFalse(game.getArea().get(5));
	}

	@Test
	public void testNumberOfNeighboursOne() {
		GameOfLife game = new GameOfLife(10, 10);
		List<Boolean> tempList = new ArrayList<Boolean>();

		for (int i = 0; i < 100; i++) {
			tempList.add(false);
		}
		tempList.remove(5);
		tempList.add(5, true);

		tempList.remove(15);
		tempList.add(15, true);

		game.putArea(tempList);

		try {
			game.goThroughtListOfFields();

		} catch (EndOfGameException exc) {
		}

		assertFalse(game.getArea().get(5));
	}

	@Test
	public void testNumberOfNeighboursTwo() {
		GameOfLife game = new GameOfLife(10, 10);
		List<Boolean> tempList = new ArrayList<Boolean>();

		for (int i = 0; i < 100; i++) {
			tempList.add(false);
		}
		tempList.remove(5);
		tempList.add(5, true);

		tempList.remove(15);
		tempList.add(15, true);

		tempList.remove(6);
		tempList.add(6, true);

		game.putArea(tempList);

		try {
			game.goThroughtListOfFields();

		} catch (EndOfGameException exc) {
		}

		assertTrue(game.getArea().get(5));
	}

	@Test
	public void testNumberOfNeighboursThree() {
		GameOfLife game = new GameOfLife(10, 10);
		List<Boolean> tempList = new ArrayList<Boolean>();

		for (int i = 0; i < 100; i++) {
			tempList.add(false);
		}

		tempList.remove(5);
		tempList.add(5, true);

		tempList.remove(15);
		tempList.add(15, true);

		tempList.remove(6);
		tempList.add(6, true);

		tempList.remove(4);
		tempList.add(4, true);

		game.putArea(tempList);

		try {
			game.goThroughtListOfFields();

		} catch (EndOfGameException exc) {
		}

		assertTrue(game.getArea().get(5));
	}

	@Test
	public void testNumberOfNeighboursEight() {
		GameOfLife game = new GameOfLife(10, 10);
		List<Boolean> tempList = new ArrayList<Boolean>();

		for (int i = 0; i < 100; i++) {
			tempList.add(false);
		}

		tempList.remove(15);
		tempList.add(15, true);

		tempList.remove(5);
		tempList.add(5, true);

		tempList.remove(25);
		tempList.add(25, true);

		tempList.remove(16);
		tempList.add(16, true);

		tempList.remove(14);
		tempList.add(14, true);

		tempList.remove(6);
		tempList.add(6, true);

		tempList.remove(4);
		tempList.add(4, true);

		tempList.remove(26);
		tempList.add(26, true);

		tempList.remove(24);
		tempList.add(24, true);

		game.putArea(tempList);

		try {
			game.goThroughtListOfFields();

		} catch (EndOfGameException exc) {
		}

		assertFalse(game.getArea().get(15));
	}

	@Test
	public void testReinkarnationNumberOfNeighboursThree() {
		GameOfLife game = new GameOfLife(10, 10);
		List<Boolean> tempList = new ArrayList<Boolean>();

		for (int i = 0; i < 100; i++) {
			tempList.add(false);
		}
		tempList.remove(5);
		tempList.add(5, false);

		tempList.remove(15);
		tempList.add(15, true);

		tempList.remove(6);
		tempList.add(6, true);

		tempList.remove(4);
		tempList.add(4, true);

		game.putArea(tempList);

		try {
			game.goThroughtListOfFields();

		} catch (EndOfGameException exc) {
		}

		assertTrue(game.getArea().get(5));
	}

	@Test
	public void testReinkarnationNumberOfNeighboursLessThenTree() {
		GameOfLife game = new GameOfLife(10, 10);
		List<Boolean> tempList = new ArrayList<Boolean>();

		for (int i = 0; i < 100; i++) {
			tempList.add(false);
		}
		tempList.remove(5);
		tempList.add(5, false);

		tempList.remove(6);
		tempList.add(6, true);

		tempList.remove(4);
		tempList.add(4, true);

		game.putArea(tempList);

		try {
			game.goThroughtListOfFields();

		} catch (EndOfGameException exc) {
		}

		assertFalse(game.getArea().get(5));
	}

	@Test
	public void testEndOfGameAllDead() {
		GameOfLife game = new GameOfLife(10, 10);

		List<Boolean> tempList = new ArrayList<Boolean>();

		for (int i = 0; i < 100; i++) {
			tempList.add(false);
		}

		game.putArea(tempList);
		try {
			game.goThroughtListOfFields();
		} catch (EndOfGameException exc) {
			return;
		}

		fail("EndOfFile should accure");
	}

	@Test
	public void testEndOfGameNoChange() {
		GameOfLife game = new GameOfLife(3, 3);

		List<Boolean> tempList = new ArrayList<Boolean>();

		for (int i = 0; i < 9; i++) {
			tempList.add(false);
		}

		game.putArea(tempList);
		try {
			game.goThroughtListOfFields();
		} catch (EndOfGameException exc) {
			return;
		}

		fail("EndOfFile should accure");
	}

	@Test
	public void testCheckNumberOfNeighboursForNoneNeigbours() {
		GameOfLife game = new GameOfLife(10, 10);

		List<Boolean> tempList = new ArrayList<Boolean>();

		for (int i = 0; i < 100; i++) {
			tempList.add(false);
		}

		tempList.remove(15);
		tempList.add(15, true);

		game.putArea(tempList);

		assertEquals(0, game.checkNumberOfNeighbours(1, 5));

	}

	@Test
	public void testCheckNumberOfNeigboursForEightNeighbours() {
		GameOfLife game = new GameOfLife(10, 10);
		List<Boolean> tempList = new ArrayList<Boolean>();

		for (int i = 0; i < 100; i++) {
			tempList.add(false);
		}

		tempList.remove(15);
		tempList.add(15, true);

		tempList.remove(16);
		tempList.add(16, true);

		tempList.remove(14);
		tempList.add(14, true);

		tempList.remove(5);
		tempList.add(5, true);

		tempList.remove(4);
		tempList.add(4, true);

		tempList.remove(6);
		tempList.add(6, true);

		tempList.remove(25);
		tempList.add(25, true);

		tempList.remove(26);
		tempList.add(26, true);

		tempList.remove(24);
		tempList.add(24, true);

		game.putArea(tempList);
		assertEquals(8, game.checkNumberOfNeighbours(1, 5));
	}

}
