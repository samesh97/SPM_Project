package enums;


public class Building
{
	public static final int MAIN_BUILDING = 0;
	public static final int NEW_BUILDING = 1;
	public static final int ENGINEERING_BUILDING = 2;
	public static final int BUSINESS_BUILDING = 3;
	
	public static int getType(String text)
	{
		if(text != null)
		{
			if(text.equals("Main Building"))
			{
				return MAIN_BUILDING;
			}
			else if(text.equals("New Building"))
			{
				return NEW_BUILDING;
			}
			else if(text.equals("Engineering Building"))
			{
				return ENGINEERING_BUILDING;
			}
			else if(text.equals("Business School"))
			{
				return BUSINESS_BUILDING;
			}
			else
			{
				return -99;
			}
		}
		else
		{
			return -99;
		}
	}
	
}

