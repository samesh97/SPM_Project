package enums;

public class Level
{
	public static final int PROFESSOR = 1;
	public static final int ASSISTANT_PROFESSOR = 2;
	public static final int SENIOR_LECTURER_HG = 3;
	public static final int SENIOR_LECTURER = 4;
	public static final int LECTURER = 5;
	public static final int ASSISTANT_LECTURER = 6;
	public static final int INSTRUCTOR = 7;

	
	public static int getType(String text)
	{
		if(text != null)
		{
			if(text.equals("Professor"))
			{
				return PROFESSOR;
			}
			else if(text.equals("Assistant Professor"))
			{
				return ASSISTANT_PROFESSOR;
			}
			else if(text.equals("Senior Lecturer(HG)"))
			{
				return SENIOR_LECTURER_HG;
			}
			else if(text.equals("Senior Lecturer"))
			{
				return SENIOR_LECTURER;
			}
			else if(text.equals("Lecturer"))
			{
				return LECTURER;
			}
			else if(text.equals("Assistant Lecturer"))
			{
				return ASSISTANT_LECTURER;
			}
			else if(text.equals("Instructors"))
			{
				return INSTRUCTOR;
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

