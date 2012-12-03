import java.util.ArrayList;
import java.util.List;


public class LongCount {
	private int baktuns;	//20 - 144000
	private int katuns;		//20 - 7200
	private int tuns;		//18 - 360
	private int winals;		//20 - 20
	private int kin;		//1  - 1
	
	/**
	 * Constructor for LongCount
	 * @param bak Baktuns
	 * @param kat Katuns
	 * @param tun Tuns
	 * @param win Winals
	 * @param ki Kin
	 */
	public LongCount(int bak, int kat, int tun, int win, int ki)
	{
		baktuns = bak;
		katuns = kat;
		tuns = tun;
		winals = win;
		kin = ki;
	}
	
	/**
	 * Finds the first LongCount day after 8.0.0.0.0 equal to a given CalendarRound
	 * @param cr CalendarRound day
	 * @return LongCount day after 8.0.0.0.0 equal to cr
	 */
	public LongCount firstLongCountAfterEightBaktuns(CalendarRound cr)
	{
		//8.0.0.0.0 == 9.Ajaw 3.Sip
		LongCount lc = new LongCount(8,0,0,0,0);
		Tzolkin t = new Tzolkin(9, "Ajaw");
		Haab h = new Haab(3, "Sip");
		CalendarRound eightBaktuns = new CalendarRound(t, h);
		
		int daysSinceEightBaktuns = cr.daysSinceLastInstanceOf(eightBaktuns);
		return lc.addToDate(daysSinceEightBaktuns);
	}
	
	/**
	 * Finds a list of all LongCount dates equal to a given CalendarRound date in Baktuns 8 and 9
	 * @param cr CalendarRound day to find LongCount equivalents of
	 * @return List of all LongCount dates equal to a given CalendarRound date in Baktuns 8 and 9
	 */
	public List<LongCount> calendarRoundDatesInBacktunsEightAndNine(CalendarRound cr)
	{
		List<LongCount> retList = new ArrayList<LongCount>();
		LongCount next = firstLongCountAfterEightBaktuns(cr);
		while(next.baktuns == 8 || next.baktuns == 9)
		{
			retList.add(next);
			next = next.addToDate(18980);
		}
		return retList;
	}
	
	/**
	 * Finds the difference between two LongCount dates
	 * @param lc LongCount day to be compared to this
	 * @return Days difference between this and lc
	 */
	public int subtractDates(LongCount lc)
	{
		return Math.abs(this.convertLongCountToDays() - lc.convertLongCountToDays());
	}
	
	/**
	 * Calculates the LongCount day a specified number days in the future from this
	 * @param days LongCount days to move to the future
	 * @return LongCount day "days" days ahead of this
	 */
	public LongCount addToDate(int days)
	{
		return convertDaysToLongCount(days + this.convertLongCountToDays());
	}
	
	/**
	 * Calculates the LongCount day a specified number days in the past from this
	 * @param days LongCount days to move in the past
	 * @return LongCount day "days" days behind this
	 */
	public LongCount subtractFromDate(int days)
	{
		return convertDaysToLongCount(this.convertLongCountToDays() - days);
	}
	
	/**
	 * Determines if two LongCounts are equal
	 * @param lc LongCount to be compared to this
	 * @return True if lc and this are equal, else false
	 */
	public boolean equals(LongCount lc)
	{
		return (this.baktuns == lc.baktuns
				&& this.katuns == lc.katuns
				&& this.tuns == lc.tuns
				&& this.winals == lc.winals
				&& this.kin == lc.kin);
	}
	
	/**
	 * Takes this LongCount and returns a numerical representation of the date
	 * starting with 0.0.0.0.0 equal to 0
	 * @return Number of days after the zero date
	 */
	public int convertLongCountToDays()
	{
		return (baktuns * 144000 + katuns * 7200 + tuns * 360 + winals * 20 + kin);
	}
	
	/**
	 * Given a number of days since the zero date, finds the corresponding LongCount day
	 * @param days Days since zero date to convert to LongCount
	 * @return LongCount that corresponds to the given days since zero date
	 */
	public LongCount convertDaysToLongCount(int days)
	{
		int nextKin = days % 20;
		days -= days % 20;
		
		int nextWinals = (days % 360) / 20;
		days -= days % 360;
		
		int nextTuns = (days % 7200) / 360;
		days -= days % 7200;
		
		int nextKatuns = (days % 144000) / 7200;
		days -= days % 144000;
		
		int nextBaktuns = days / 144000;
		
		return new LongCount(nextBaktuns, nextKatuns, nextTuns, nextWinals, nextKin);
	}
	
	/**
	 * Getter method for class variable baktuns
	 * @return this.baktuns
	 */
	public int getBaktuns() {
		return baktuns;
	}
	
	/**
	 * Getter method for class variable katuns
	 * @return this.katuns
	 */
	public int getKatuns() {
		return katuns;
	}
	
	/**
	 * Getter method for class variable tuns
	 * @return this.tuns
	 */
	public int getTuns() {
		return tuns;
	}
	
	/**
	 * Getter method for class variable winals
	 * @return this.winals
	 */
	public int getWinals() {
		return winals;
	}
	
	/**
	 * Getter method for class variable kin
	 * @return this.kin
	 */
	public int getKin() {
		return kin;
	}
}