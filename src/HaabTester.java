import static org.junit.Assert.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Test;


public class HaabTester {
	
	@Test
	public void testEquals() {
		Haab a1 = new Haab(1, "Pohp");
		Haab a2 = new Haab(1, "Pohp");
		Haab b1 = new Haab(8, "Kumku");
		Haab b2 = new Haab(8, "Kumku");
		
		assertTrue(a1.equals(a2));
		assertTrue(b1.equals(b2));
		assertFalse(a1.equals(b1));
		assertFalse(b2.equals(a2));
	}
	
	@Test
	public void testFindNamesIndex() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Method findNamesIndex = Haab.class.getDeclaredMethod("findNamesIndex", String.class);
		findNamesIndex.setAccessible(true);
		Haab h = new Haab(1, "Pohp");
		
		assertEquals(1, findNamesIndex.invoke(h, "Pohp"));
		assertEquals(2, findNamesIndex.invoke(h, "Wo"));
		assertEquals(3, findNamesIndex.invoke(h, "Sip"));
		assertEquals(4, findNamesIndex.invoke(h, "Zotz"));
		assertEquals(5, findNamesIndex.invoke(h, "Sek"));
		assertEquals(6, findNamesIndex.invoke(h, "Xul"));
		assertEquals(7, findNamesIndex.invoke(h, "Yaxkin"));
		assertEquals(8, findNamesIndex.invoke(h, "Mol"));
		assertEquals(9, findNamesIndex.invoke(h, "Chen"));
		assertEquals(10, findNamesIndex.invoke(h, "Yax"));
		assertEquals(11, findNamesIndex.invoke(h, "Sak"));
		assertEquals(12, findNamesIndex.invoke(h, "Keh"));
		assertEquals(13, findNamesIndex.invoke(h, "Mak"));
		assertEquals(14, findNamesIndex.invoke(h, "Kankin"));
		assertEquals(15, findNamesIndex.invoke(h, "Muan"));
		assertEquals(16, findNamesIndex.invoke(h, "Pax"));
		assertEquals(17, findNamesIndex.invoke(h, "Kayab"));
		assertEquals(18, findNamesIndex.invoke(h, "Kumku"));
		assertEquals(19, findNamesIndex.invoke(h, "Wayeb"));
		
		assertEquals(-1, findNamesIndex.invoke(h, "Bad"));
		assertEquals(-1, findNamesIndex.invoke(h, "imix"));
	}
	
	@Test
	public void testConstructor() {
		Haab t = new Haab(3, "Chen");
		
		assertEquals(3, t.getNumber());
		assertEquals("Chen", t.getName());
		assertEquals(9, t.getNameNum());
	}
	
	@Test
	public void testAddToDate() {
		Haab a = new Haab(1, "Pohp");
		Haab b = new Haab(5, "Pohp");
		Haab c = new Haab(1, "Wo");
		Haab d = new Haab(5, "Wayeb");
		
		assertTrue(a.equals(a.addToDate(365)));
		assertTrue(b.equals(a.addToDate(4)));
		assertTrue(c.equals(a.addToDate(20)));
		assertTrue(d.equals(a.addToDate(364)));
		
		Haab e = new Haab(1, "Wayeb");
		Haab f = new Haab(3, "Sip");
		
		assertTrue(a.equals(e.addToDate(5)));
		assertTrue(d.equals(e.addToDate(4)));
		assertTrue(e.equals(e.addToDate(365)));
		assertTrue(f.equals(e.addToDate(47)));
	}
	
	@Test
	public void testSubtractFromDate() {
		Haab a = new Haab(1, "Pohp");
		Haab b = new Haab(5, "Pohp");
		Haab c = new Haab(1, "Wo");
		Haab d = new Haab(5, "Wayeb");
		Haab g = new Haab(20, "Pohp");
		
		assertTrue(a.equals(a.subtractFromDate(0)));
		assertTrue(a.equals(a.subtractFromDate(365)));
		assertTrue(a.equals(b.subtractFromDate(4)));
		assertTrue(a.equals(c.subtractFromDate(20)));
		assertTrue(a.equals(d.subtractFromDate(364)));
		assertTrue(g.equals(c.subtractFromDate(1)));
		assertTrue(d.equals(a.subtractFromDate(1)));
		
		Haab e = new Haab(1, "Wayeb");
		Haab f = new Haab(3, "Sip");
		
		assertTrue(e.equals(a.subtractFromDate(5)));
		assertTrue(e.equals(d.subtractFromDate(4)));
		assertTrue(e.equals(e.subtractFromDate(365)));
		assertTrue(e.equals(f.subtractFromDate(47)));
	}
	
	@Test
	public void testDaysToNextInstanceOf() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		Method daysToNextInstanceOf = Haab.class.getDeclaredMethod("daysToNextInstanceOf", Haab.class);
		daysToNextInstanceOf.setAccessible(true);
		
		Haab a = new Haab(1, "Pohp");
		Haab b = new Haab(2, "Pohp");
		Haab c = new Haab(6, "Pohp");
		Haab d = new Haab(20, "Pohp");
		Haab e = new Haab(1, "Wo");
		Haab f = new Haab(2, "Wo");
		Haab g = new Haab(1, "Xul");
		Haab h = new Haab(20, "Kumku");
		Haab i = new Haab(1, "Wayeb");
		Haab j = new Haab(5, "Wayeb");
		
		assertEquals(0, daysToNextInstanceOf.invoke(a, a));
		assertEquals(1, daysToNextInstanceOf.invoke(a, b));
		assertEquals(5, daysToNextInstanceOf.invoke(a, c));
		assertEquals(19, daysToNextInstanceOf.invoke(a, d));
		assertEquals(20, daysToNextInstanceOf.invoke(a, e));
		assertEquals(21, daysToNextInstanceOf.invoke(a, f));
		assertEquals(100, daysToNextInstanceOf.invoke(a, g));
		assertEquals(359, daysToNextInstanceOf.invoke(a, h));
		assertEquals(360, daysToNextInstanceOf.invoke(a, i));
		assertEquals(364, daysToNextInstanceOf.invoke(a, j));
		
		Haab k = new Haab(1, "Wayeb");
		Haab l = new Haab(5, "Wayeb");
		Haab m = new Haab(1, "Pohp");
		Haab n = new Haab(20, "Pohp");
		Haab o = new Haab(1, "Wo");
		Haab p = new Haab(16, "Sek");
		Haab q = new Haab(20, "Kumku");
		
		assertEquals(0, daysToNextInstanceOf.invoke(k, k));
		assertEquals(4, daysToNextInstanceOf.invoke(k, l));
		assertEquals(5, daysToNextInstanceOf.invoke(k, m));
		assertEquals(24, daysToNextInstanceOf.invoke(k, n));
		assertEquals(25, daysToNextInstanceOf.invoke(k, o));
		assertEquals(100, daysToNextInstanceOf.invoke(k, p));
		assertEquals(364, daysToNextInstanceOf.invoke(k, q));
	}
	
	@Test
	public void testDaysSinceLastInstanceOf() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Method daysSinceLastInstanceOf = Haab.class.getDeclaredMethod("daysSinceLastInstanceOf", Haab.class);
		daysSinceLastInstanceOf.setAccessible(true);
		
		Haab a = new Haab(1, "Pohp");
		Haab b = new Haab(2, "Pohp");
		Haab c = new Haab(6, "Pohp");
		Haab d = new Haab(20, "Pohp");
		Haab e = new Haab(1, "Wo");
		Haab f = new Haab(2, "Wo");
		Haab g = new Haab(1, "Xul");
		Haab h = new Haab(20, "Kumku");
		Haab i = new Haab(1, "Wayeb");
		Haab j = new Haab(5, "Wayeb");
		
		assertEquals(0, daysSinceLastInstanceOf.invoke(a, a));
		assertEquals(1, daysSinceLastInstanceOf.invoke(b, a));
		assertEquals(5, daysSinceLastInstanceOf.invoke(c, a));
		assertEquals(19, daysSinceLastInstanceOf.invoke(d, a));
		assertEquals(20, daysSinceLastInstanceOf.invoke(e, a));
		assertEquals(21, daysSinceLastInstanceOf.invoke(f, a));
		assertEquals(100, daysSinceLastInstanceOf.invoke(g, a));
		assertEquals(359, daysSinceLastInstanceOf.invoke(h, a));
		assertEquals(360, daysSinceLastInstanceOf.invoke(i, a));
		assertEquals(364, daysSinceLastInstanceOf.invoke(j, a));
		
		Haab k = new Haab(1, "Wayeb");
		Haab l = new Haab(5, "Wayeb");
		Haab m = new Haab(1, "Pohp");
		Haab n = new Haab(20, "Pohp");
		Haab o = new Haab(1, "Wo");
		Haab p = new Haab(16, "Sek");
		Haab q = new Haab(20, "Kumku");
		
		assertEquals(0, daysSinceLastInstanceOf.invoke(k, k));
		assertEquals(4, daysSinceLastInstanceOf.invoke(l, k));
		assertEquals(1, daysSinceLastInstanceOf.invoke(m, l));
		assertEquals(5, daysSinceLastInstanceOf.invoke(m, k));
		assertEquals(24, daysSinceLastInstanceOf.invoke(n, k));
		assertEquals(25, daysSinceLastInstanceOf.invoke(o, k));
		assertEquals(100, daysSinceLastInstanceOf.invoke(p, k));
		assertEquals(364, daysSinceLastInstanceOf.invoke(q, k));
	}
	
	@Test
	public void testSubtractDates() {
		Haab a = new Haab(1, "Pohp");
		Haab b = new Haab(11, "Pohp");
		Haab c = new Haab(1, "Wo");
		Haab d = new Haab(6, "Kayab");
		Haab e = new Haab(1, "Wayeb");
		Haab f = new Haab(5, "Wayeb");
		
		assertEquals(0, a.subtractDates(a));
		assertEquals(10, a.subtractDates(b));
		assertEquals(20, a.subtractDates(c));
		assertEquals(40, a.subtractDates(d));
		assertEquals(5, a.subtractDates(e));
		assertEquals(1, a.subtractDates(f));
		
		assertEquals(0, a.subtractDates(a));
		assertEquals(10, b.subtractDates(a));
		assertEquals(20, c.subtractDates(a));
		assertEquals(40, d.subtractDates(a));
		assertEquals(5, e.subtractDates(a));
		assertEquals(1, f.subtractDates(a));
	}
}
