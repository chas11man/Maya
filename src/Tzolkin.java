
public class Tzolkin {
	private String[] names = {"", "Imix", "Ik", "Akbal", "Kan", "Chikchan",
			"Kimi", "Manik", "Lamat", "Muluk", "Ok", "Chuen", "Eb", "Ben",
			"Ix", "Men", "Kib", "Kaban", "Etznab", "Kawak", "Ajaw"};
	
	private int number;
	private String name;
	private int nameNum;
	
	/**
	 * Tzolkin constructor
	 * 
	 * @param dayNumber Number of Tzolkin day, must be between 1-13 inclusive.
	 * @param dayName Name of Tzolkin day
	 */
	public Tzolkin(int dayNumber, String dayName)
	{
		if(dayNumber < 1 || dayNumber > 13)
		{
			throw new IllegalArgumentException(dayNumber + " is an invalid number, dayNumber must be an int 1-13");
		}
		if(findNamesIndex(dayName) == -1)
		{
			throw new IllegalArgumentException(dayName + " is an invalid Tzolkin name");
		}
		name = dayName;
		number = dayNumber;
		nameNum = findNamesIndex(dayName);
	}
	
	/**
	 * Difference in number of days between Tzolkin.this and Tzolkin.t
	 * 
	 * @param t Day to be compared to this
	 * @return number of days between the two closest occurrences of the two dates
	 */
	public int subtractDates(Tzolkin t)
	{
		if(this.equals(t))
		{
			return 0;
		}
		
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
	 * Adds the given number of days to this Tzolkin date and returns the
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
		int futureNameNum = (this.nameNum + days) % 20;
		//Check if numbers are 0 and assign them to the correct value
		if(futureNameNum == 0) {
			futureNameNum = 20;
		}
		if(futureNumber == 0) {
			futureNumber = 13;
		}
		//Get the name of the future day
		String futureName = names[futureNameNum];
		return new Tzolkin(futureNumber, futureName);
	}
	
	/**
	 * Subtracts the given number of days from this Tzolkin date and returns
	 * the Tzolkin day that many days in the past
	 * 
	 * @param days Number of days to go back
	 * @return a Tzolkin day "days" days behind this Tzolkin
	 */
	public Tzolkin subtractFromDate(int days)
	{
		//The number of the past day
		int pastNumber = (this.number - (days % 13));
		int pastNameNum = (this.nameNum - (days % 20));
		if(pastNumber <= 0)
		{
			pastNumber = 13 + pastNumber;
		}
		if(pastNameNum <= 0)
		{
			pastNameNum = 20 + pastNameNum;
		}
		String pastName = names[pastNameNum];
		return new Tzolkin(pastNumber, pastName);
	}
	
	/**
	 * Finds the index of the String in the array names and returns the
	 * index
	 * 
	 * @param value Tzolkin day name that should exist in names
	 * @return The index of value in names, -1 if it isn't present
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
	 * @param t Day to be compared to this
	 * @return Number of days to the next instance of t since this
	 */
	private int daysToNextInstanceOf(Tzolkin t)
	{
		Tzolkin temp = this;
		int numberDiff = 0;
		//Increase temp to the first day with the same day number
		if(temp.number > t.number)
		{
			numberDiff = (13-temp.number) + t.number;
		} 
		else if(temp.number < t.number)
		{
			numberDiff = (t.number - temp.number);
		}
		int daysToNextInstance = numberDiff;	//Count to return
		temp = temp.addToDate(numberDiff);		//temp.number and t.number are now equal
		//Check if temp matches t, if not, increase 13 more days and add 13 to overall count
		while(!temp.equals(t))
		{
			temp = temp.addToDate(13);
			daysToNextInstance += 13;
		}
		return daysToNextInstance;
	}
	
	/**
	 * Find the number of days since the last instance of t from this
	 * 
	 * @param t Day to be compared to this
	 * @return Number of days to the next instance of t since this
	 */
	private int daysSinceLastInstanceOf(Tzolkin t)
	{
		Tzolkin temp = this;
		int numberDiff = 0;
		
		if(temp.number > t.number)
		{
			numberDiff = (temp.number - t.number);
		}
		else if(temp.number < t.number)
		{
			numberDiff = (13 + temp.number) - t.number;
		}
		
		int daysSinceLastInstance = numberDiff;
		temp = temp.subtractFromDate(numberDiff);
		
		while(!temp.equals(t))
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
	public boolean equals(Tzolkin t)
	{
		return (this.name == t.name
				&& this.number == t.number
				&& this.nameNum == t.nameNum);
	}
	
	/**
	 * Getter method for Tzolkin.number
	 * 
	 * @return Tzolkin.number
	 */
	public int getNumber() {
		return number;
	}
	
	/**
	 * Getter method for Tzolkin.nameNum
	 * 
	 * @return Tzolkin.nameNum
	 */
	public int getNameNum() {
		return nameNum;
	}
	
	/**
	 * Getter method for Tzolkin.name
	 * 
	 * @return Tzolkin.name
	 */
	public String getName() {
		return name;
	}
}
