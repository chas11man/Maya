
public class Tzolkin {
	private String[] names = {"Imix", "Ik", "Akbal", "Kan", "Chikchan",
			"Kimi", "Manik", "Lamat", "Muluk", "Ok", "Chuen", "Eb", "Ben",
			"Ix", "Men", "Kib", "Kaban", "Etznab", "Kawak", "Ajaw"};
	
	private int number;
	private String name;
	private int nameNum;
	
	/**
	 * 
	 * @param dayNumber
	 * @param dayName
	 */
	public Tzolkin(int dayNumber, String dayName)
	{
		name = dayName;
		number = dayNumber;
		nameNum = findNamesIndex(dayName);
	}
	
	/**
	 * Difference between this Tzolkin and Tzolkin t
	 * 
	 * @param t
	 * @return number of days between the two consecutive occurrences of the two dates
	 */
	public int subtractDates(Tzolkin t)
	{
		if(this.equals(t))
		{
			return 0;
		}
		
		//int numDiff = Math.abs(this.number - t.number);
		int daysToNext = daysToNextInstanceOf(t);
		int daysSinceLast = daysSinceLastInstanceOf(t);
		
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
	 * Adds the given number of days to this Tzolkin day and returns the
	 * Tzolkin day that many days in the future
	 * 
	 * @param days Number of days to advance
	 * @return A Tzolkin day "days" days ahead of this Tzolkin
	 */
	public Tzolkin addToDate(int days)
	{
		//The number of the future day
		int futureNumber = ((this.number + days) % 13);
		//The index in names of the name of the future day
		int futureNameNum = ((this.nameNum + 1 + days) % 20) - 1;
		String futureName = names[futureNameNum];
		
		return new Tzolkin(futureNumber, futureName);
	}
	
	/**
	 * 
	 * @param days
	 * @return
	 */
	public Tzolkin subtractFromDate(int days)
	{
		int pastNumber = (this.number + (13 - days))%13;
		int pastNameNum = ((this.nameNum + 1 + (20 - days))%20) - 1;
		String pastName = names[pastNameNum];
		
		return new Tzolkin(pastNumber, pastName);
	}
	
	/**
	 * Finds the index of the String in the array names and returns the
	 * index
	 * 
	 * @param value Tzolkin day name that should exist in names
	 * @return The index of value in names 
	 */
	private int findNamesIndex(String value)
	{
		for(int i = 0; i < names.length; i++)
		{
			if(names[i] == value)
			{
				return i;
			}
		}
		return -1;
	}
	
	/**
	 * Finds the number of days to the next instance of t from this
	 * 
	 * @param t
	 * @return
	 */
	private int daysToNextInstanceOf(Tzolkin t)
	{
		//this == 2.Manik && t == 9.Imix
		Tzolkin temp = t;
		int daysToNextInstance = 0;
		int numberDiff = Math.abs(this.number - t.number);	//numberDiff = 7
		daysToNextInstance += numberDiff;	//daysToNext = 7
		temp = temp.addToDate(numberDiff);	//temp = 9.Ix
		while(!this.equals(temp))
		{
			temp = temp.addToDate(13);
			daysToNextInstance += 13;
		}
		return daysToNextInstance;
	}
	
	/**
	 * 
	 * @param t
	 * @return
	 */
	private int daysSinceLastInstanceOf(Tzolkin t)
	{
		//this == 2.Manik && t == 9.Imix
		Tzolkin temp = t;
		int daysSinceLastInstance = 0;
		int numberDiff = 13 - Math.abs(this.number - t.number);
		daysSinceLastInstance += numberDiff;
		temp = temp.subtractFromDate(numberDiff);
		while(!this.equals(temp))
		{
			temp = temp.subtractFromDate(13);
			daysSinceLastInstance += 13;
		}
		return daysSinceLastInstance;
	}
	
	/**
	 * If this and t are equal, returns true, else returns false.
	 * 
	 * @param t Tzolkin to be compared to this
	 * @return True if equal, else false
	 */
	private boolean equals(Tzolkin t)
	{
		return (this.name == t.name
				&& this.number == t.number
				&& this.nameNum == t.nameNum);
	}
	
	
}
