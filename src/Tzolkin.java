
public class Tzolkin {
	private String[] names = {"Imix", "Ik", "Akbal", "Kan", "Chikchan",
			"Kimi", "Manik", "Lamat", "Muluk", "Ok", "Chuen", "Eb", "Ben",
			"Ix", "Men", "Kib", "Kaban", "Etznab", "Kawak", "Ajaw"};
	
	private int number;
	private String name;
	private int nameNum;
	
	public Tzolkin(int dayNumber, String dayName)
	{
		name = dayName;
		number = dayNumber;
		nameNum = findNamesIndex(dayName);
	}
	
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
		int futureNumber = ((this.number + 1 + days) % 13) - 1;
		int futureNameNum = (this.nameNum + 1 + days) % 20) -1;
		String futureName = names[futureNameNum];
		Tzolkin futureDate = new Tzolkin(futureNumber, futureName);
		return futureDate;
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
