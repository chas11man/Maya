public class CalendarRound {
	private Tzolkin tzolkin;
	private Haab haab;
	
	/**
	 * CalendarRound constructor
	 * 
	 * @param t Tzolkin day
	 * @param h Haab day
	 */
	public CalendarRound(Tzolkin t, Haab h)
	{
		tzolkin = t;
		haab = h;
	}
	
	/**
	 * Finds the difference between two CalendarRound days
	 * @param cr CalendarRound day to be compared to this
	 * @return The difference between two CalendarRound days
	 */
	public int subtractDates(CalendarRound cr)
	{
		if(this.equals(cr))
		{
			return 0;
		}
		
		int daysToNext = daysToNextInstanceOf(cr);
		int daysSinceLast = daysSinceLastInstanceOf(cr);
		
		if(daysToNext < daysSinceLast)
		{
			return daysToNext;
		}
		else if(daysSinceLast < daysToNext)
		{
			return daysSinceLast;
		}
		return -1;
	}
	
	/**
	 * Finds how many CalendarRound days until the next occurrence of cr from this
	 * @param cr Future day from this to be compared
	 * @return Number of days from this to cr
	 */
	public int daysToNextInstanceOf(CalendarRound cr)
	{
		CalendarRound temp = this;
		int numberDiff = 0;
		
		if(cr.equals(this))
		{
			return 0;
		}
		//Check if the next occurrence of cr.tzolkin from this is equal to cr
		int daysToNextTzolkin = temp.tzolkin.daysToNextInstanceOf(cr.tzolkin);
		if(cr.equals(temp.addToDate(daysToNextTzolkin)))
		{
			return daysToNextTzolkin;
		}
		//Set temp to the next occurrence of cr.haab
		int daysToNextHaab = temp.haab.daysToNextInstanceOf(cr.haab);
		temp = temp.addToDate(daysToNextHaab);
		
		numberDiff += daysToNextHaab;
		//Keep adding 365 days to temp until temp == cr
		while(!cr.equals(temp))
		{
			temp = temp.addToDate(365);
			numberDiff += 365;
		}
		return numberDiff;
	}
	
	/**
	 * Finds how many CalendarRound days since the last occurrence of cr from this
	 * @param cr Past day to be compared to this
	 * @return Number of days since cr last occurred
	 */
	public int daysSinceLastInstanceOf(CalendarRound cr)
	{
		CalendarRound temp = this;
		int numberDiff = 0;
		
		if(cr.equals(this))
		{
			return 0;
		}
		//Check if the last occurrence of cr.tzolkin since this is equal to cr
		int daysSinceLastTzolkin = temp.tzolkin.daysSinceLastInstanceOf(cr.tzolkin);
		if(cr.equals(temp.subtractFromDate(daysSinceLastTzolkin)))
		{
			return daysSinceLastTzolkin;
		}
		//Set temp to the last occurrence of cr.haab
		int daysSinceLastHaab = temp.haab.daysSinceLastInstanceOf(cr.haab);
		temp = temp.subtractFromDate(daysSinceLastHaab);
		
		numberDiff += daysSinceLastHaab;
		//Keep subtracting 365 days from temp until temp == cr
		while(!cr.equals(temp))
		{
			temp = temp.subtractFromDate(365);
			numberDiff += 365;
		}
		return numberDiff;
	}
	
	/**
	 * Calculates the CalendarRound day a specified number days in the future from this
	 * @param days Number of days to add to this
	 * @return CalendarRound day "days" days in the future
	 */
	public CalendarRound addToDate(int days)
	{
		return new CalendarRound(tzolkin.addToDate(days), haab.addToDate(days));
	}
	
	/**
	 * Calculates the CalendarRound day a specified number days in the past from this
	 * @param days Number of days to subtract from this
	 * @return CalendarRound day "days" days in the past
	 */
	public CalendarRound subtractFromDate(int days)
	{
		return new CalendarRound(tzolkin.subtractFromDate(days), haab.subtractFromDate(days));
	}
	
	/**
	 * Determines if two CalendarRound dates are the same day
	 * @param cr Day to be compared to this
	 * @return True if cr and this are equal, else false
	 */
	public boolean equals(CalendarRound cr)
	{
		return (this.tzolkin.equals(cr.tzolkin)
				&& this.haab.equals(cr.haab));
	}
	
	/**
	 * Getter method for class variable "tzolkin"
	 * @return this.tzolkin
	 */
	public Tzolkin getTzolkin() {
		return tzolkin;
	}
	
	/**
	 * Getter method for class variable "haab"
	 * @return this.haab
	 */
	public Haab getHaab() {
		return haab;
	}
}
