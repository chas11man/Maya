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
		Tzolkin c = new Tzolkin(13, "Chikchan");
		Tzolkin d = new Tzolkin(1, "Kimi");
		
		Tzolkin e = new Tzolkin(4, "Imix");
		Tzolkin f = new Tzolkin(3, "Ajaw");
		Tzolkin h = new Tzolkin(1, "Etznab");
		
		assertTrue(a.equals(b.subtractFromDate(6)));
		assertTrue(a.equals(c.subtractFromDate(4)));
		assertTrue(a.equals(d.subtractFromDate(5)));
		assertTrue(h.equals(f.subtractFromDate(2)));
		assertTrue(h.equals(e.subtractFromDate(3)));
		
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
		
		assertTrue(v.equals(w.subtractFromDate(2)));
		assertTrue(v.equals(x.subtractFromDate(3)));
		assertTrue(v.equals(y.subtractFromDate(4)));
		assertTrue(v.equals(z.subtractFromDate(5)));
		
		assertTrue(v.equals(o.subtractFromDate(12)));
		assertTrue(v.equals(p.subtractFromDate(13)));
		assertTrue(v.equals(q.subtractFromDate(14)));
		assertTrue(v.equals(r.subtractFromDate(19)));
		assertTrue(v.equals(s.subtractFromDate(20)));
		assertTrue(v.equals(t.subtractFromDate(21)));
		assertTrue(v.equals(u.subtractFromDate(40)));
	}
	
	@Test
	public void testSubtractDates() {
		Tzolkin a = new Tzolkin(9, "Imix");
		Tzolkin b = new Tzolkin(2, "Manik");
		
		Tzolkin c = new Tzolkin(10, "Kib");
		Tzolkin d = new Tzolkin(4, "Kib");
		Tzolkin e = new Tzolkin(11, "Kib");
		Tzolkin f = new Tzolkin(4, "Ik");
		Tzolkin g = new Tzolkin(10, "Lamat");
		
		assertEquals(6, a.subtractDates(b));
		assertEquals(20, c.subtractDates(d));
		assertEquals(40, c.subtractDates(e));
		assertEquals(46, c.subtractDates(f));
		assertEquals(52, c.subtractDates(g));
		
		assertEquals(6, b.subtractDates(a));
		assertEquals(20, d.subtractDates(c));
		assertEquals(40, e.subtractDates(c));
		assertEquals(46, f.subtractDates(c));
		assertEquals(52, g.subtractDates(c));
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
		Tzolkin h = new Tzolkin(3, "Lamat");
		Tzolkin i = new Tzolkin(4, "Muluk");
		Tzolkin j = new Tzolkin(5, "Ok");
		Tzolkin k = new Tzolkin(6, "Chuen");
		Tzolkin l = new Tzolkin(7, "Eb");
		Tzolkin m = new Tzolkin(8, "Ben");
		Tzolkin n = new Tzolkin(9, "Ix");
		Tzolkin o = new Tzolkin(10, "Men");
		Tzolkin p = new Tzolkin(11, "Kib");
		Tzolkin q = new Tzolkin(12, "Kaban");
		Tzolkin r = new Tzolkin(13, "Etznab");
		Tzolkin s = new Tzolkin(1, "Kawak");
		Tzolkin t = new Tzolkin(2, "Ajaw");
		Tzolkin u = new Tzolkin(3, "Imix");
		Tzolkin v = new Tzolkin(4, "Ik");
		
		assertEquals(1, daysToNextInstanceOf.invoke(a, b));
		assertEquals(2, daysToNextInstanceOf.invoke(a, c));
		assertEquals(3, daysToNextInstanceOf.invoke(a, d));
		assertEquals(4, daysToNextInstanceOf.invoke(a, e));
		assertEquals(5, daysToNextInstanceOf.invoke(a, f));
		assertEquals(6, daysToNextInstanceOf.invoke(a, g));
		assertEquals(7, daysToNextInstanceOf.invoke(a, h));
		assertEquals(8, daysToNextInstanceOf.invoke(a, i));
		assertEquals(9, daysToNextInstanceOf.invoke(a, j));
		assertEquals(10, daysToNextInstanceOf.invoke(a, k));
		assertEquals(11, daysToNextInstanceOf.invoke(a, l));
		assertEquals(12, daysToNextInstanceOf.invoke(a, m));
		assertEquals(13, daysToNextInstanceOf.invoke(a, n));
		assertEquals(14, daysToNextInstanceOf.invoke(a, o));
		assertEquals(15, daysToNextInstanceOf.invoke(a, p));
		assertEquals(16, daysToNextInstanceOf.invoke(a, q));
		assertEquals(17, daysToNextInstanceOf.invoke(a, r));
		assertEquals(18, daysToNextInstanceOf.invoke(a, s));
		assertEquals(19, daysToNextInstanceOf.invoke(a, t));
		assertEquals(20, daysToNextInstanceOf.invoke(a, u));
		assertEquals(21, daysToNextInstanceOf.invoke(a, v));
	}
	
	@Test
	public void testDaysSinceLastInstanceOf() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Method daysSinceLastInstanceOf = Tzolkin.class.getDeclaredMethod("daysSinceLastInstanceOf", Tzolkin.class);
		daysSinceLastInstanceOf.setAccessible(true);
		
		Tzolkin a = new Tzolkin(9, "Imix");
		Tzolkin b = new Tzolkin(10, "Ik");
		Tzolkin c = new Tzolkin(11, "Akbal");
		Tzolkin d = new Tzolkin(12, "Kan");
		Tzolkin e = new Tzolkin(13, "Chikchan");
		Tzolkin f = new Tzolkin(1, "Kimi");
		Tzolkin g = new Tzolkin(2, "Manik");
		Tzolkin h = new Tzolkin(3, "Lamat");
		Tzolkin i = new Tzolkin(4, "Muluk");
		Tzolkin j = new Tzolkin(5, "Ok");
		Tzolkin k = new Tzolkin(6, "Chuen");
		Tzolkin l = new Tzolkin(7, "Eb");
		Tzolkin m = new Tzolkin(8, "Ben");
		Tzolkin n = new Tzolkin(9, "Ix");
		Tzolkin o = new Tzolkin(10, "Men");
		Tzolkin p = new Tzolkin(11, "Kib");
		Tzolkin q = new Tzolkin(12, "Kaban");
		Tzolkin r = new Tzolkin(13, "Etznab");
		Tzolkin s = new Tzolkin(1, "Kawak");
		Tzolkin t = new Tzolkin(2, "Ajaw");
		Tzolkin u = new Tzolkin(3, "Imix");
		
		assertEquals(1, daysSinceLastInstanceOf.invoke(u, t));
		assertEquals(2, daysSinceLastInstanceOf.invoke(u, s));
		assertEquals(3, daysSinceLastInstanceOf.invoke(u, r));
		assertEquals(4, daysSinceLastInstanceOf.invoke(u, q));
		assertEquals(5, daysSinceLastInstanceOf.invoke(u, p));
		assertEquals(6, daysSinceLastInstanceOf.invoke(u, o));
		assertEquals(7, daysSinceLastInstanceOf.invoke(u, n));
		assertEquals(8, daysSinceLastInstanceOf.invoke(u, m));
		assertEquals(9, daysSinceLastInstanceOf.invoke(u, l));
		assertEquals(10, daysSinceLastInstanceOf.invoke(u, k));
		assertEquals(11, daysSinceLastInstanceOf.invoke(u, j));
		assertEquals(12, daysSinceLastInstanceOf.invoke(u, i));
		assertEquals(13, daysSinceLastInstanceOf.invoke(u, h));
		assertEquals(14, daysSinceLastInstanceOf.invoke(u, g));
		assertEquals(15, daysSinceLastInstanceOf.invoke(u, f));
		assertEquals(16, daysSinceLastInstanceOf.invoke(u, e));
		assertEquals(17, daysSinceLastInstanceOf.invoke(u, d));
		assertEquals(18, daysSinceLastInstanceOf.invoke(u, c));
		assertEquals(19, daysSinceLastInstanceOf.invoke(u, b));
		assertEquals(20, daysSinceLastInstanceOf.invoke(u, a));
	}
}
