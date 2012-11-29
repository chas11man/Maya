import static org.junit.Assert.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Test;


public class TzolkinTester {
	
	@Test
	public void testEquals() {
		Tzolkin a1 = new Tzolkin(1, "Imix");
		Tzolkin a2 = new Tzolkin(1, "Imix");
		Tzolkin b1 = new Tzolkin(8, "Akbal");
		Tzolkin b2 = new Tzolkin(8, "Akbal");
		
		assertTrue(a1.equals(a2));
		assertTrue(b1.equals(b2));
		assertFalse(a1.equals(b1));
		assertFalse(b2.equals(a2));
	}
	
	@Test
	public void testFindNamesIndex() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Method findNamesIndex = Tzolkin.class.getDeclaredMethod("findNamesIndex", String.class);
		findNamesIndex.setAccessible(true);
		Tzolkin t = new Tzolkin(1, "Imix");
		
		assertEquals(1, findNamesIndex.invoke(t, "Imix"));
		assertEquals(2, findNamesIndex.invoke(t, "Ik"));
		assertEquals(3, findNamesIndex.invoke(t, "Akbal"));
		assertEquals(4, findNamesIndex.invoke(t, "Kan"));
		assertEquals(5, findNamesIndex.invoke(t, "Chikchan"));
		assertEquals(6, findNamesIndex.invoke(t, "Kimi"));
		assertEquals(7, findNamesIndex.invoke(t, "Manik"));
		assertEquals(8, findNamesIndex.invoke(t, "Lamat"));
		assertEquals(9, findNamesIndex.invoke(t, "Muluk"));
		assertEquals(10, findNamesIndex.invoke(t, "Ok"));
		assertEquals(11, findNamesIndex.invoke(t, "Chuen"));
		assertEquals(12, findNamesIndex.invoke(t, "Eb"));
		assertEquals(13, findNamesIndex.invoke(t, "Ben"));
		assertEquals(14, findNamesIndex.invoke(t, "Ix"));
		assertEquals(15, findNamesIndex.invoke(t, "Men"));
		assertEquals(16, findNamesIndex.invoke(t, "Kib"));
		assertEquals(17, findNamesIndex.invoke(t, "Kaban"));
		assertEquals(18, findNamesIndex.invoke(t, "Etznab"));
		assertEquals(19, findNamesIndex.invoke(t, "Kawak"));
		assertEquals(20, findNamesIndex.invoke(t, "Ajaw"));
		
		assertEquals(-1, findNamesIndex.invoke(t, "Bad"));
		assertEquals(-1, findNamesIndex.invoke(t, "imix"));
	}
	
	@Test
	public void testCompiler() {
		Tzolkin t = new Tzolkin(3, "Kawak");
		
		assertEquals(3, t.getNumber());
		assertEquals("Kawak", t.getName());
		assertEquals(19, t.getNameNum());
	}
	
	@Test
	public void testAddToDate() {
		Tzolkin a = new Tzolkin(9, "Imix");
		Tzolkin b = new Tzolkin(2, "Manik");
		Tzolkin c = new Tzolkin(13, "Chikchan");
		Tzolkin d = new Tzolkin(1, "Kimi");
		
		Tzolkin e = new Tzolkin(4, "Imix");
		Tzolkin f = new Tzolkin(3, "Ajaw");
		Tzolkin h = new Tzolkin(1, "Etznab");
		
		assertTrue(b.equals(a.addToDate(6)));
		assertTrue(c.equals(a.addToDate(4)));
		assertTrue(d.equals(a.addToDate(5)));
		assertTrue(f.equals(h.addToDate(2)));
		assertTrue(e.equals(h.addToDate(3)));
		
		Tzolkin v = new Tzolkin(9, "Etznab");
		Tzolkin w = new Tzolkin(11, "Ajaw");
		Tzolkin x = new Tzolkin(12, "Imix");
		Tzolkin y = new Tzolkin(13, "Ik");
		Tzolkin z = new Tzolkin(1, "Akbal");
		
		Tzolkin o = new Tzolkin(8, "Ok");
		Tzolkin p = new Tzolkin(9, "Chuen");
		Tzolkin q = new Tzolkin(10, "Eb");
		Tzolkin r = new Tzolkin(2, "Kaban");
		Tzolkin s = new Tzolkin(3, "Etznab");
		Tzolkin t = new Tzolkin(4, "Kawak");
		Tzolkin u = new Tzolkin(10, "Etznab");
		
		assertTrue(w.equals(v.addToDate(2)));
		assertTrue(x.equals(v.addToDate(3)));
		assertTrue(y.equals(v.addToDate(4)));
		assertTrue(z.equals(v.addToDate(5)));
		
		assertTrue(o.equals(v.addToDate(12)));
		assertTrue(p.equals(v.addToDate(13)));
		assertTrue(q.equals(v.addToDate(14)));
		assertTrue(r.equals(v.addToDate(19)));
		assertTrue(s.equals(v.addToDate(20)));
		assertTrue(t.equals(v.addToDate(21)));
		assertTrue(u.equals(v.addToDate(40)));
	}
	
	@Test
	public void testSubtractFromDate() {
		Tzolkin a = new Tzolkin(9, "Imix");
		Tzolkin b = new Tzolkin(2, "Manik");
		
		assertTrue(a.equals(b.subtractFromDate(6)));
	}
	
	//@Test
	public void testSubtractDates() {
		Tzolkin a = new Tzolkin(9, "Imix");
		Tzolkin b = new Tzolkin(2, "Manik");
		
		assertEquals(6, a.subtractDates(b));
		assertEquals(6, b.subtractDates(a));
	}
	
	@Test
	public void testDaysToNextInstanceOf() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		Method daysToNextInstanceOf = Tzolkin.class.getDeclaredMethod("daysToNextInstanceOf", Tzolkin.class);
		daysToNextInstanceOf.setAccessible(true);
		
		Tzolkin a = new Tzolkin(9, "Imix");
		Tzolkin b = new Tzolkin(10, "Ik");
		Tzolkin c = new Tzolkin(11, "Akbal");
		Tzolkin d = new Tzolkin(12, "Kan");
		Tzolkin e = new Tzolkin(13, "Chikchan");
		Tzolkin f = new Tzolkin(1, "Kimi");
		Tzolkin g = new Tzolkin(2, "Manik");
		
		assertEquals(1, daysToNextInstanceOf.invoke(a, b));
		assertEquals(2, daysToNextInstanceOf.invoke(a, c));
		assertEquals(3, daysToNextInstanceOf.invoke(a, d));
		assertEquals(4, daysToNextInstanceOf.invoke(a, e));
		assertEquals(5, daysToNextInstanceOf.invoke(a, f));
		assertEquals(6, daysToNextInstanceOf.invoke(a, g));
	}
	
	@Test
	public void testDaysSinceLastInstanceOf() {
		
	}
}
