public class CalendarRound {
	private Tzolkin tzolkin;
	private Haab haab;
	
	public CalendarRound(Tzolkin t, Haab h)
	{
		tzolkin = t;
		haab = h;
	}
	
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
	
	public CalendarRound addToDate(int days)
	{
		return new CalendarRound(tzolkin.addToDate(days), haab.addToDate(days));
	}
	
	public CalendarRound subtractFromDate(int days)
	{
		return new CalendarRound(tzolkin.subtractFromDate(days), haab.subtractFromDate(days));
	}
	
	public boolean equals(CalendarRound cr)
	{
		return (this.tzolkin.equals(cr.tzolkin)
				&& this.haab.equals(cr.haab));
	}
	
	public Tzolkin getTzolkin() {
		return tzolkin;
	}
	
	public Haab getHaab() {
		return haab;
	}
}
