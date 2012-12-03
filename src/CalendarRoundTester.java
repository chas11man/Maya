import static org.junit.Assert.*;

import org.junit.Test;


public class CalendarRoundTester {
	
	@Test
	public void testEquals() {
		Tzolkin t1 = new Tzolkin(1, "Imix");
		Tzolkin t2 = new Tzolkin(8, "Akbal");
		Haab h1 = new Haab(1, "Pohp");
		Haab h2 = new Haab(8, "Kumku");
		CalendarRound cr1a = new CalendarRound(t1, h1);
		CalendarRound cr2a = new CalendarRound(t1, h2);
		CalendarRound cr3a = new CalendarRound(t2, h1);
		CalendarRound cr4a = new CalendarRound(t2, h2);
		
		CalendarRound cr1b = new CalendarRound(t1, h1);
		CalendarRound cr2b = new CalendarRound(t1, h2);
		CalendarRound cr3b = new CalendarRound(t2, h1);
		CalendarRound cr4b = new CalendarRound(t2, h2);
		
		assertTrue(cr1a.equals(cr1b));
		assertTrue(cr2a.equals(cr2b));
		assertTrue(cr3a.equals(cr3b));
		assertTrue(cr4a.equals(cr4b));
		
		assertFalse(cr1a.equals(cr2b));
		assertFalse(cr1a.equals(cr3b));
		assertFalse(cr1a.equals(cr4b));
		
		assertFalse(cr2a.equals(cr1b));
		assertFalse(cr2a.equals(cr3b));
		assertFalse(cr2a.equals(cr4b));
		
		assertFalse(cr3a.equals(cr1b));
		assertFalse(cr3a.equals(cr2b));
		assertFalse(cr3a.equals(cr4b));
		
		assertFalse(cr4a.equals(cr1b));
		assertFalse(cr4a.equals(cr2b));
		assertFalse(cr4a.equals(cr3b));
	}
	
	@Test
	public void testConstructor() {
		Tzolkin t = new Tzolkin(3, "Kawak");
		Haab h = new Haab(6, "Chen");
		CalendarRound cr = new CalendarRound(t, h);
		
		assertEquals(3, cr.getTzolkin().getNumber());
		assertEquals("Kawak", cr.getTzolkin().getName());
		assertEquals(19, cr.getTzolkin().getNameNum());
		
		assertEquals(6, cr.getHaab().getNumber());
		assertEquals("Chen", cr.getHaab().getName());
		assertEquals(9, cr.getHaab().getNameNum());
	}
	
	@Test
	public void testAddToDate() {
		Tzolkin t1 = new Tzolkin(3, "Lamat");
		Tzolkin t2 = new Tzolkin(6, "Kan");
		
		Haab h1 = new Haab(6, "Pax");
		Haab h2 = new Haab(2, "Kayab");
		
		CalendarRound cr1 = new CalendarRound(t1, h1);
		CalendarRound cr2 = new CalendarRound(t2, h2);
		
		assertTrue(cr2.equals(cr1.addToDate(16)));
	}
	
	@Test
	public void testSubtractFromDate() {
		Tzolkin t1 = new Tzolkin(3, "Lamat");
		Tzolkin t2 = new Tzolkin(6, "Kan");
		
		Haab h1 = new Haab(6, "Pax");
		Haab h2 = new Haab(2, "Kayab");
		
		CalendarRound cr1 = new CalendarRound(t1, h1);
		CalendarRound cr2 = new CalendarRound(t2, h2);
		
		assertTrue(cr1.equals(cr2.subtractFromDate(16)));
	}
	
	@Test
	public void testDaysToNextInstanceOf() {
		Tzolkin t1 = new Tzolkin(3, "Lamat");
		Tzolkin t2 = new Tzolkin(4, "Muluk");
		Tzolkin t3 = new Tzolkin(5, "Ok");
		Tzolkin t4 = new Tzolkin(6, "Chuen");
		Tzolkin t5 = new Tzolkin(7, "Eb");
		Tzolkin t6 = new Tzolkin(8, "Ben");
		Tzolkin t7 = new Tzolkin(9, "Ix");
		Tzolkin t8 = new Tzolkin(10, "Men");
		Tzolkin t9 = new Tzolkin(11, "Kib");
		Tzolkin t10 = new Tzolkin(12, "Kaban");
		Tzolkin t11 = new Tzolkin(13, "Etznab");
		Tzolkin t12 = new Tzolkin(1, "Kawak");
		Tzolkin t13 = new Tzolkin(2, "Ajaw");
		Tzolkin t14 = new Tzolkin(3, "Imix");
		Tzolkin t15 = new Tzolkin(4, "Ik");
		Tzolkin t16 = new Tzolkin(5, "Akbal");
		Tzolkin t17 = new Tzolkin(6, "Kan");
		
		Haab h1 = new Haab(6, "Pax");
		Haab h2 = new Haab(7, "Pax");
		Haab h3 = new Haab(8, "Pax");
		Haab h4 = new Haab(9, "Pax");
		Haab h5 = new Haab(10, "Pax");
		Haab h6 = new Haab(11, "Pax");
		Haab h7 = new Haab(12, "Pax");
		Haab h8 = new Haab(13, "Pax");
		Haab h9 = new Haab(14, "Pax");
		Haab h10 = new Haab(15, "Pax");
		Haab h11 = new Haab(16, "Pax");
		Haab h12 = new Haab(17, "Pax");
		Haab h13 = new Haab(18, "Pax");
		Haab h14 = new Haab(19, "Pax");
		Haab h15 = new Haab(20, "Pax");
		Haab h16 = new Haab(1, "Kayab");
		Haab h17 = new Haab(2, "Kayab");
		
		CalendarRound cr1 = new CalendarRound(t1, h1);
		CalendarRound cr2 = new CalendarRound(t2, h2);
		CalendarRound cr3 = new CalendarRound(t3, h3);
		CalendarRound cr4 = new CalendarRound(t4, h4);
		CalendarRound cr5 = new CalendarRound(t5, h5);
		CalendarRound cr6 = new CalendarRound(t6, h6);
		CalendarRound cr7 = new CalendarRound(t7, h7);
		CalendarRound cr8 = new CalendarRound(t8, h8);
		CalendarRound cr9 = new CalendarRound(t9, h9);
		CalendarRound cr10 = new CalendarRound(t10, h10);
		CalendarRound cr11 = new CalendarRound(t11, h11);
		CalendarRound cr12 = new CalendarRound(t12, h12);
		CalendarRound cr13 = new CalendarRound(t13, h13);
		CalendarRound cr14 = new CalendarRound(t14, h14);
		CalendarRound cr15 = new CalendarRound(t15, h15);
		CalendarRound cr16 = new CalendarRound(t16, h16);
		CalendarRound cr17 = new CalendarRound(t17, h17);
		
		assertEquals(0, cr1.daysToNextInstanceOf(cr1));
		assertEquals(1, cr1.daysToNextInstanceOf(cr2));
		assertEquals(2, cr1.daysToNextInstanceOf(cr3));
		assertEquals(3, cr1.daysToNextInstanceOf(cr4));
		assertEquals(4, cr1.daysToNextInstanceOf(cr5));
		assertEquals(5, cr1.daysToNextInstanceOf(cr6));
		assertEquals(6, cr1.daysToNextInstanceOf(cr7));
		assertEquals(7, cr1.daysToNextInstanceOf(cr8));
		assertEquals(8, cr1.daysToNextInstanceOf(cr9));
		assertEquals(9, cr1.daysToNextInstanceOf(cr10));
		assertEquals(10, cr1.daysToNextInstanceOf(cr11));
		assertEquals(11, cr1.daysToNextInstanceOf(cr12));
		assertEquals(12, cr1.daysToNextInstanceOf(cr13));
		assertEquals(13, cr1.daysToNextInstanceOf(cr14));
		assertEquals(14, cr1.daysToNextInstanceOf(cr15));
		assertEquals(15, cr1.daysToNextInstanceOf(cr16));
		assertEquals(16, cr1.daysToNextInstanceOf(cr17));
	}
	
	@Test
	public void daysSinceLastInstanceOf() {
		Tzolkin t1 = new Tzolkin(3, "Lamat");
		Tzolkin t2 = new Tzolkin(4, "Muluk");
		Tzolkin t3 = new Tzolkin(5, "Ok");
		Tzolkin t4 = new Tzolkin(6, "Chuen");
		Tzolkin t5 = new Tzolkin(7, "Eb");
		Tzolkin t6 = new Tzolkin(8, "Ben");
		Tzolkin t7 = new Tzolkin(9, "Ix");
		Tzolkin t8 = new Tzolkin(10, "Men");
		Tzolkin t9 = new Tzolkin(11, "Kib");
		Tzolkin t10 = new Tzolkin(12, "Kaban");
		Tzolkin t11 = new Tzolkin(13, "Etznab");
		Tzolkin t12 = new Tzolkin(1, "Kawak");
		Tzolkin t13 = new Tzolkin(2, "Ajaw");
		Tzolkin t14 = new Tzolkin(3, "Imix");
		Tzolkin t15 = new Tzolkin(4, "Ik");
		Tzolkin t16 = new Tzolkin(5, "Akbal");
		Tzolkin t17 = new Tzolkin(6, "Kan");
		
		Haab h1 = new Haab(6, "Pax");
		Haab h2 = new Haab(7, "Pax");
		Haab h3 = new Haab(8, "Pax");
		Haab h4 = new Haab(9, "Pax");
		Haab h5 = new Haab(10, "Pax");
		Haab h6 = new Haab(11, "Pax");
		Haab h7 = new Haab(12, "Pax");
		Haab h8 = new Haab(13, "Pax");
		Haab h9 = new Haab(14, "Pax");
		Haab h10 = new Haab(15, "Pax");
		Haab h11 = new Haab(16, "Pax");
		Haab h12 = new Haab(17, "Pax");
		Haab h13 = new Haab(18, "Pax");
		Haab h14 = new Haab(19, "Pax");
		Haab h15 = new Haab(20, "Pax");
		Haab h16 = new Haab(1, "Kayab");
		Haab h17 = new Haab(2, "Kayab");
		
		CalendarRound cr1 = new CalendarRound(t1, h1);
		CalendarRound cr2 = new CalendarRound(t2, h2);
		CalendarRound cr3 = new CalendarRound(t3, h3);
		CalendarRound cr4 = new CalendarRound(t4, h4);
		CalendarRound cr5 = new CalendarRound(t5, h5);
		CalendarRound cr6 = new CalendarRound(t6, h6);
		CalendarRound cr7 = new CalendarRound(t7, h7);
		CalendarRound cr8 = new CalendarRound(t8, h8);
		CalendarRound cr9 = new CalendarRound(t9, h9);
		CalendarRound cr10 = new CalendarRound(t10, h10);
		CalendarRound cr11 = new CalendarRound(t11, h11);
		CalendarRound cr12 = new CalendarRound(t12, h12);
		CalendarRound cr13 = new CalendarRound(t13, h13);
		CalendarRound cr14 = new CalendarRound(t14, h14);
		CalendarRound cr15 = new CalendarRound(t15, h15);
		CalendarRound cr16 = new CalendarRound(t16, h16);
		CalendarRound cr17 = new CalendarRound(t17, h17);
		
		assertEquals(0, cr17.daysSinceLastInstanceOf(cr17));
		assertEquals(1, cr17.daysSinceLastInstanceOf(cr16));
		assertEquals(2, cr17.daysSinceLastInstanceOf(cr15));
		assertEquals(3, cr17.daysSinceLastInstanceOf(cr14));
		assertEquals(4, cr17.daysSinceLastInstanceOf(cr13));
		assertEquals(5, cr17.daysSinceLastInstanceOf(cr12));
		assertEquals(6, cr17.daysSinceLastInstanceOf(cr11));
		assertEquals(7, cr17.daysSinceLastInstanceOf(cr10));
		assertEquals(8, cr17.daysSinceLastInstanceOf(cr9));
		assertEquals(9, cr17.daysSinceLastInstanceOf(cr8));
		assertEquals(10, cr17.daysSinceLastInstanceOf(cr7));
		assertEquals(11, cr17.daysSinceLastInstanceOf(cr6));
		assertEquals(12, cr17.daysSinceLastInstanceOf(cr5));
		assertEquals(13, cr17.daysSinceLastInstanceOf(cr4));
		assertEquals(14, cr17.daysSinceLastInstanceOf(cr3));
		assertEquals(15, cr17.daysSinceLastInstanceOf(cr2));
		assertEquals(16, cr17.daysSinceLastInstanceOf(cr1));
	}
	
	@Test
	public void testSubtractDates() {
		Tzolkin t1 = new Tzolkin(6, "Kan");
		Tzolkin t2 = new Tzolkin(3, "Lamat");
		
		Haab h1 = new Haab(2, "Kayab");
		Haab h2 = new Haab(6, "Pax");
		
		CalendarRound cr1 = new CalendarRound(t1, h1);
		CalendarRound cr2 = new CalendarRound(t2, h2);
		
		assertEquals(16, cr1.subtractDates(cr2));
	}
}
