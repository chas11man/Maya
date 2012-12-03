import static org.junit.Assert.*;

import org.junit.Test;


public class LongCountTester {
	
	@Test
	public void testConstructor() {
		LongCount lc = new LongCount(1, 2, 3, 4, 5);
		
		assertEquals(1, lc.getBaktuns());
		assertEquals(2, lc.getKatuns());
		assertEquals(3, lc.getTuns());
		assertEquals(4, lc.getWinals());
		assertEquals(5, lc.getKin());
	}
	
	@Test
	public void testEquals() {
		LongCount lc1 = new LongCount(1, 2, 3, 4, 5);
		LongCount lc2 = new LongCount(1, 2, 3, 4, 5);
		LongCount lc3 = new LongCount(1, 2, 3, 4, 6);
		
		assertTrue(lc1.equals(lc2));
		assertFalse(lc1.equals(lc3));
	}
	
	@Test
	public void testConvertLongCountToDays() {
		LongCount lc1 = new LongCount(0, 0, 0, 0, 0);
		LongCount lc2 = new LongCount(0, 0, 0, 0, 1);
		LongCount lc3 = new LongCount(0, 0, 0, 1, 0);
		LongCount lc4 = new LongCount(0, 0, 1, 0, 0);
		LongCount lc5 = new LongCount(0, 1, 0, 0, 0);
		LongCount lc6 = new LongCount(1, 0, 0, 0, 0);
		LongCount lc7 = new LongCount(1, 1, 1, 1, 1);
		LongCount lc8 = new LongCount(9, 2, 3, 4, 5);
		LongCount lc9 = new LongCount(0, 19, 19, 17, 19);
		
		assertEquals(0, lc1.convertLongCountToDays());
		assertEquals(1, lc2.convertLongCountToDays());
		assertEquals(20, lc3.convertLongCountToDays());
		assertEquals(360, lc4.convertLongCountToDays());
		assertEquals(7200, lc5.convertLongCountToDays());
		assertEquals(144000, lc6.convertLongCountToDays());
		assertEquals(151581, lc7.convertLongCountToDays());
		assertEquals(1311565, lc8.convertLongCountToDays());
		assertEquals(143999, lc9.convertLongCountToDays());
	}
	
	@Test
	public void testConvertDaysToLongCount() {
		LongCount lc1 = new LongCount(0, 0, 0, 0, 0);
		LongCount lc2 = new LongCount(0, 0, 0, 0, 1);
		LongCount lc3 = new LongCount(0, 0, 0, 1, 0);
		LongCount lc4 = new LongCount(0, 0, 1, 0, 0);
		LongCount lc5 = new LongCount(0, 1, 0, 0, 0);
		LongCount lc6 = new LongCount(1, 0, 0, 0, 0);
		LongCount lc7 = new LongCount(1, 1, 1, 1, 1);
		LongCount lc8 = new LongCount(9, 2, 3, 4, 5);
		LongCount lc9 = new LongCount(0, 19, 19, 17, 19);
		
		assertTrue(lc1.equals(lc1.convertDaysToLongCount(0)));
		assertTrue(lc2.equals(lc1.convertDaysToLongCount(1)));
		assertTrue(lc3.equals(lc1.convertDaysToLongCount(20)));
		assertTrue(lc4.equals(lc1.convertDaysToLongCount(360)));
		assertTrue(lc5.equals(lc1.convertDaysToLongCount(7200)));
		assertTrue(lc6.equals(lc1.convertDaysToLongCount(144000)));
		assertTrue(lc7.equals(lc1.convertDaysToLongCount(151581)));
		assertTrue(lc8.equals(lc1.convertDaysToLongCount(1311565)));
		assertTrue(lc9.equals(lc1.convertDaysToLongCount(143999)));
	}
	
	@Test
	public void testAddToDate() {
		LongCount lc0 = new LongCount(0,0,0,0,0);
		LongCount lc1 = new LongCount(1,1,1,1,1);
		LongCount lc2 = new LongCount(0,0,0,0,1);
		LongCount lc3 = new LongCount(0,0,0,1,0);
		LongCount lc4 = new LongCount(0,0,1,0,0);
		LongCount lc5 = new LongCount(0,1,0,0,0);
		LongCount lc6 = new LongCount(1,0,0,0,0);
		
		assertTrue(lc0.equals(lc0.addToDate(0)));
		assertTrue(lc1.equals(lc0.addToDate(151581)));
		assertTrue(lc2.equals(lc0.addToDate(1)));
		assertTrue(lc3.equals(lc0.addToDate(20)));
		assertTrue(lc4.equals(lc0.addToDate(360)));
		assertTrue(lc5.equals(lc0.addToDate(7200)));
		assertTrue(lc6.equals(lc0.addToDate(144000)));
	}
	
	@Test
	public void testSubtractFromDate() {
		LongCount lc0 = new LongCount(0,0,0,0,0);
		LongCount lc1 = new LongCount(1,1,1,1,1);
		LongCount lc2 = new LongCount(0,0,0,0,1);
		LongCount lc3 = new LongCount(0,0,0,1,0);
		LongCount lc4 = new LongCount(0,0,1,0,0);
		LongCount lc5 = new LongCount(0,1,0,0,0);
		LongCount lc6 = new LongCount(1,0,0,0,0);
		
		assertTrue(lc0.equals(lc0.subtractFromDate(0)));
		assertTrue(lc0.equals(lc1.subtractFromDate(151581)));
		assertTrue(lc0.equals(lc2.subtractFromDate(1)));
		assertTrue(lc0.equals(lc3.subtractFromDate(20)));
		assertTrue(lc0.equals(lc4.subtractFromDate(360)));
		assertTrue(lc0.equals(lc5.subtractFromDate(7200)));
		assertTrue(lc0.equals(lc6.subtractFromDate(144000)));
	}
	
	@Test
	public void testSubtractDates() {
		LongCount lc1 = new LongCount(9,2,3,4,5);
		LongCount lc2 = new LongCount(9,2,3,3,0);
		
		assertEquals(25, lc1.subtractDates(lc2));
		assertEquals(25, lc2.subtractDates(lc1));
	}
}
