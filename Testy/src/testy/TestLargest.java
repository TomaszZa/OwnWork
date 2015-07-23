package testy;

import junit.framework.*;

public class TestLargest extends TestCase {
	public TestLargest(String name){
		super(name);
	}
	
	public void testOrder(){
		assertEquals(9, Largest.largest(new int[]  {8,9,7}));
		assertEquals(9, Largest.largest(new int[] {9,8,7}));
		assertEquals(9, Largest.largest(new int[] {8,7,9}));
	}
	
	public void testDouble(){
		assertEquals(9, Largest.largest(new int[] {8,9,6,9}));
	}
	
	public void testOne(){
	assertEquals(1, Largest.largest(new int[] {1}));
	}
	
	public void testMin(){
		int tab[] = {-1, -3,-4,-6};
		assertEquals(-1, Largest.largest(tab));
	}
	
	public void testEmpty(){
		try{
			Largest.largest(new int[] {});
			fail("Metoda powinna wygenerowac wyjatek");
		}catch(RuntimeException e){
			assertTrue(true);
		}
	}
}
