package enums;

public class Day
{
	public static final int MONDAY = 1;
	public static final int TUESDAY = 2;
	public static final int WEDNESDAY = 3;
	public static final int THURSDAY = 4;
	public static final int FRIDAY = 5;
	public static final int SATURDAY = 6;
	public static final int SUNDAY = 7;
	
	public static String getString(int day)
	{
		if(day == MONDAY)
		{
			return "Monday";
		}
		else if(day == TUESDAY)
		{
			return "Tuesday";
		}
		else if(day == WEDNESDAY)
		{
			return "Wednesday";
		}
		else if(day == THURSDAY)
		{
			return "Thursday";
		}
		else if(day == FRIDAY)
		{
			return "Friday";
		}
		else if(day == SATURDAY)
		{
			return "Saturday";
		}
		else if(day == SUNDAY)
		{
			return "Sunday";
		}
		else
		{
			return "";
		}
		
	}
	
}
