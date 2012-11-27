
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
		int futureNumber = ((this.number + 1 + days) % 13) - 1;
		//The index in names of the name of the future day
		int futureNameNum = ((this.nameNum + 1 + days) % 20) - 1;
		String futureName = names[futureNameNum];
		
		return new Tzolkin(futureNumber, futureName);
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
}
