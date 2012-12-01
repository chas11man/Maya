
public class Haab {
	private String[] names = {"", "Pohp", "Wo", "Sip", "Zotz", "Sek", "Xul",
			"Yaxkin", "Mol", "Chen", "Yax", "Sak", "Keh", "Mak", "Kankin",
			"Muan", "Pax", "Kayab", "Kumku", "Wayeb"};
	
	private int number;
	private String name;
	private int nameNum;
	
	/**
	 * Haab constructor
	 * 
	 * @param dayNumber Number of Haab day, must be between 1-20 inclusive.
	 * @param dayName Name of Haab day
	 */
	public Haab(int dayNumber, String dayName)
	{
		if(dayNumber < 1 || dayNumber > 20)
		{
			throw new IllegalArgumentException(dayNumber + " is an invalid number, dayNumner must be an int 1-13");
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
	 * Finds the index of the String in the array names and returns the
	 * index
	 * 
	 * @param value Haab day name that should exist in names
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
	 * Difference in number of days between Haab.this and Haab.t
	 * 
	 * @param h Day to be compared to this
	 * @return number of days between the two closest occurrences of the two dates
	 */
	public int subtractDates(Haab h)
	{
		if(this.equals(h))
		{
			return 0;
		}
		
		int daysToNext = daysToNextInstanceOf(h);
		int daysSinceLast = daysSinceLastInstanceOf(h);
		
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
	 * Finds the number of days to the next instance of h from this
	 * 
	 * @param h Day to be compared to this
	 * @return Number of days to the next instance of h since this
	 */
	private int daysToNextInstanceOf(Haab h)
	{
		Haab temp = this;
		int numberDiff = 0;
		
		while(!temp.equals(h))
		{
			//If h is in the same month and in the future from this
			if(temp.nameNum == h.nameNum && temp.number < h.number)
			{
				//Increase temp to the same day as h
				//This should exit the while loop
				numberDiff += (h.number - temp.number);
				temp = temp.addToDate(h.number - temp.number);
			}
			//If going from this to h passes through Wayeb to Pohp
			else if(h.nameNum <= temp.nameNum)
			{
				//Increase temp to the 1st of the next month
				numberDiff += (21 - temp.number);
				temp = temp.addToDate(21 - temp.number);
				//Increase temp to 1.Pohp
				numberDiff += (20 * (19 - temp.nameNum) + 5);
				temp = temp.addToDate(20 * (19 - temp.nameNum) + 5);
				//Increase temp to 1st of h.name
				numberDiff += (20 * (h.nameNum - 1));
				temp = temp.addToDate(20 * (h.nameNum - 1));
			}
			//If going from this to h doesn't pass through Wayeb to Pohp
			else
			{
				//Increase temp to the 1st of the next month
				//then to the 1st of the month of h
				numberDiff += ((21 - temp.number) + 20 * (h.nameNum - temp.nameNum - 1));
				temp = temp.addToDate((21 - temp.number) + 20 * (h.nameNum - temp.nameNum - 1));
			}
		}
		
		return numberDiff;
	}
	
	/**
	 * Find the number of days since the last instance of h from this
	 * 
	 * @param h Day to be compared to this
	 * @return Number of days to the next instance of h since this
	 */
	private int daysSinceLastInstanceOf(Haab h)
	{
		Haab temp = this;
		int numberDiff = 0;
		
		while(!temp.equals(h))
		{
			//If h is in the same month and in the past from this
			if(temp.nameNum == h.nameNum && h.number < temp.number)
			{
				//Decrease temp to the same day as h
				//This should exit the while loop
				numberDiff += (temp.number - h.number);
				temp = temp.subtractFromDate(temp.number - h.number);
			}
			//If going from this to h passes through Pohp to Wayeb
			//Ends with temp = 5.Wayeb
			else if(temp.nameNum <= h.nameNum)
			{
				//Decrease temp to the first day of the current month
				numberDiff += (temp.number - 1);
				temp = temp.subtractFromDate(temp.number - 1);
				//Decrease temp to 1.Pohp
				//Then decrease temp to 5.Wayeb
				numberDiff += (20 * (temp.nameNum - 1) + 1);
				temp = temp.subtractFromDate(20 * (temp.nameNum - 1) + 1);
			}
			//If going from this to h doesn't pass through Pohp to Wayeb
			else
			{
				//Decrease temp to the last of the previous month
				//Then decrease temp to the last of the month of h
				numberDiff += (temp.number + 20 * (temp.nameNum - h.nameNum));
				temp = temp.subtractFromDate(temp.number + 20 * (h.nameNum - temp.nameNum - 1));
			}
		}
		
		return numberDiff;
	}
	
	/**
	 * Adds the given number of days to this Haab date and returns the Haab day
	 * that many days in the future
	 * 
	 * @param days Number of days to advance
	 * @return A Haab day "days" days ahead of this Haab
	 */
	public Haab addToDate(int days)
	{
		//Dynamic count of days left
		int daysLeft = days;
		//Temporary parameters for the incrementing temporary day
		int futureNumber = this.number;
		int futureNameNum = this.nameNum;
		//Until there are no days left, keep moving forward to the proper day
		//or the 1st of the next month
		while(daysLeft > 0)
		{
			//If the month is Wayeb (#19) it must be dealt with differently
			if(futureNameNum == 19)
			{
				//If the month does not increase any more
				if(daysLeft <= (5 - futureNumber))
				{
					futureNumber += daysLeft;
					daysLeft = 0;
				}
				//If the month is in the future
				else
				{
					futureNameNum = 1;
					daysLeft -= 6 - futureNumber;
					futureNumber = 1;
				}
			}
			//All other months 1-18 work the same
			else
			{
				//If the month does not increase any more
				if(daysLeft <= (20 - futureNumber))
				{
					futureNumber += daysLeft;
					daysLeft = 0;
				}
				//If the month is in the future
				else
				{
					futureNameNum++;
					daysLeft -= (21 - futureNumber);
					futureNumber = 1;
				}
			}
		}
		
		String futureName = names[futureNameNum];
		return new Haab(futureNumber, futureName);
	}
	
	/**
	 * Subtracts the given number of days from this Haab date and returns
	 * the Haab day that many days in the past
	 * 
	 * @param days Number of days to go back
	 * @return a Haab day "days" days behind this Haab
	 */
	public Haab subtractFromDate(int days)
	{
		//Dynamic count of days left
		int daysLeft = days;
		//Temporary parameters for the incrementing temporary day
		int pastNumber = this.number;
		int pastNameNum = this.nameNum;
		//Until there are no days left, keep moving forward to the proper day
		//or the 1st of the next month
		while(daysLeft > 0)
		{
			//If the month is XXXX it must be dealt with differently
			if(pastNameNum == 1)
			{
				//If the month does not increase any more
				if(daysLeft <= pastNumber)
				{
					pastNumber -= daysLeft;
					daysLeft = 0;
				}
				//If the month is in the past
				else
				{
					pastNameNum = 19;
					daysLeft -= pastNumber;
					pastNumber = 5;
				}
			}
			//All other months 2-19 work the same
			else
			{
				//If the month does not increase any more
				if(daysLeft <= pastNumber)
				{
					pastNumber -= daysLeft;
					daysLeft = 0;
				}
				//If the month is in the past
				else
				{
					pastNameNum--;
					daysLeft -= pastNumber;
					pastNumber = 20;
				}
			}
		}
		
		String pastName = names[pastNameNum];
		return new Haab(pastNumber, pastName);
	}
	
	/**
	 * If this and h are equal, returns true, else returns false.
	 * 
	 * @param h Haab to be compared to this
	 * @return True if equal, else false
	 */
	public boolean equals(Haab h)
	{
		return (this.name == h.name
				&& this.number == h.number
				&& this.nameNum == h.nameNum);
	}
	
	/**
	 * Getter method for Haab.number
	 * 
	 * @return Haab.number
	 */
	public int getNumber() {
		return number;
	}
	
	/**
	 * Getter method for Haab.nameNum
	 * 
	 * @return Haab.nameNum
	 */
	public int getNameNum() {
		return nameNum;
	}
	
	/**
	 * Getter method for Haab.name
	 * 
	 * @return Haab.name
	 */
	public String getName() {
		return name;
	}
	
	
}
