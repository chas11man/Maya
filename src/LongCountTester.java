import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

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
		
		LongCount lc7 = new LongCount(8,0,17,17,8);
		LongCount lc8 = new LongCount(8,3,10,12,8);
		
		assertTrue(lc8.equals(lc7.addToDate(18980)));
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
		LongCount lc3 = new LongCount(8,0,17,17,8);
		LongCount lc4 = new LongCount(8,3,10,12,8);
		
		assertEquals(25, lc1.subtractDates(lc2));
		assertEquals(25, lc2.subtractDates(lc1));
		
		assertEquals(18980, lc3.subtractDates(lc4));
	}
	
	@Test
	public void testFirstLongCountAfterEightBaktuns() {
		LongCount lc1 = new LongCount(0,0,0,0,0);
		LongCount lc2 = new LongCount(8,0,17,17,8);
		Tzolkin t = new Tzolkin(3, "Lamat");
		Haab h = new Haab(6, "Pax");
		CalendarRound cr = new CalendarRound(t, h);
		assertTrue(lc2.equals(lc1.firstLongCountAfterEightBaktuns(cr)));
	}
	
	@Test
	public void testCalendarRoundDatesInBacktunsEightAndNine() {
		LongCount lc = new LongCount(0,0,0,0,0);
		LongCount lc1 = new LongCount(8,0,17,17,8);
		LongCount lc2 = new LongCount(8,3,10,12,8);
		LongCount lc3 = new LongCount(8,6,3,7,8);
		LongCount lc4 = new LongCount(8,8,16,2,8);
		LongCount lc5 = new LongCount(8,11,8,15,8);
		LongCount lc6 = new LongCount(8,14,1,10,8);
		LongCount lc7 = new LongCount(8,16,14,5,8);
		LongCount lc8 = new LongCount(8,19,7,0,8);
		LongCount lc9 = new LongCount(9,1,19,13,8);
		LongCount lc10 = new LongCount(9,4,12,8,8);
		LongCount lc11 = new LongCount(9,7,5,3,8);
		LongCount lc12 = new LongCount(9,9,17,16,8);
		LongCount lc13 = new LongCount(9,12,10,11,8);
		LongCount lc14 = new LongCount(9,15,3,6,8);
		LongCount lc15 = new LongCount(9,17,16,1,8);
		
		List<LongCount> list = new ArrayList<LongCount>();
		list.add(lc1);
		list.add(lc2);
		list.add(lc3);
		list.add(lc4);
		list.add(lc5);
		list.add(lc6);
		list.add(lc7);
		list.add(lc8);
		list.add(lc9);
		list.add(lc10);
		list.add(lc11);
		list.add(lc12);
		list.add(lc13);
		list.add(lc14);
		list.add(lc15);
		
		Tzolkin t = new Tzolkin(3, "Lamat");
		Haab h = new Haab(6, "Pax");
		CalendarRound cr = new CalendarRound(t, h);
		List<LongCount> answer = lc.calendarRoundDatesInBacktunsEightAndNine(cr);
		
		assertTrue(list.get(0).equals(answer.get(0)));
		assertTrue(list.get(1).equals(answer.get(1)));
		assertTrue(list.get(2).equals(answer.get(2)));
		assertTrue(list.get(3).equals(answer.get(3)));
		assertTrue(list.get(4).equals(answer.get(4)));
		assertTrue(list.get(5).equals(answer.get(5)));
		assertTrue(list.get(6).equals(answer.get(6)));
		assertTrue(list.get(7).equals(answer.get(7)));
		assertTrue(list.get(8).equals(answer.get(8)));
		assertTrue(list.get(9).equals(answer.get(9)));
		assertTrue(list.get(10).equals(answer.get(10)));
		assertTrue(list.get(11).equals(answer.get(11)));
		assertTrue(list.get(12).equals(answer.get(12)));
		assertTrue(list.get(13).equals(answer.get(13)));
		assertTrue(list.get(14).equals(answer.get(14)));
	}
}