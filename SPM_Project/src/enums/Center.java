package enums;

public class Center
{
	public static final int MALABE = 0;
	public static final int KOLLUPITIYA = 1;
	public static final int KANDY = 2;
	public static final int MATARA = 3;
	public static final int KURUNEGALA = 4;
	public static final int JAFFNA = 5;
	

	public static int getType(String text)
	{
		if(text != null)
		{
			if(text.equals("Malabe"))
			{
				return MALABE;
			}
			else if(text.equals("Kollupitiya"))
			{
				return KOLLUPITIYA;
			}
			else if(text.equals("Kandy"))
			{
				return KANDY;
			}
			else if(text.equals("Matara"))
			{
				return MATARA;
			}
			else if(text.equals("Kurunegala"))
			{
				return KURUNEGALA;
			}
			else if(text.equals("Jaffna"))
			{
				return JAFFNA;
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
