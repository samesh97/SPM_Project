package enums;

public class Faculty
{
	public static final int COMPUTING = 0;
	public static final int ENGINEERING = 1;
	public static final int BUSINESS = 2;
	public static final int HUMANITIES_AND_SCIENCE = 3;
	public static final int SCHOOL_OF_ARCHITECTURE = 4;
	public static final int GRADUATE_STUDIES_AND_RESEARCH = 5;

	public static int getType(String text)
	{
		if(text != null)
		{
			if(text.equals("Computing"))
			{
				return COMPUTING;
			}
			else if(text.equals("Engineering"))
			{
				return ENGINEERING;
			}
			else if(text.equals("Business"))
			{
				return BUSINESS;
			}
			else if(text.equals("Humanities & Sciences"))
			{
				return HUMANITIES_AND_SCIENCE;
			}
			else if(text.equals("School of Architecture"))
			{
				return SCHOOL_OF_ARCHITECTURE;
			}
			else if(text.equals("Graduate Studies & Research"))
			{
				return GRADUATE_STUDIES_AND_RESEARCH;
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
