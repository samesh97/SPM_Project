package enums;

public class Department
{
	public static final int NONE = 0;
	public static final int COMPUTER_SCIENCE_AND_SOFTWARE_ENGINEERING = 1;
	public static final int CYBER_SECURITY = 2;
	public static final int INFORMATION_TECHNOLOGY = 3;
	public static final int INFORMATION_SYSTEMS_ENGINEERING = 4;
	public static final int INTERACTIVE_MEDIA = 5;
	public static final int DATA_SCIENCE = 6;
	public static final int COMPUTER_SYSTEMS_AND_NETWORK_ENGINEERING = 7;
	public static final int CIVIL_ENGINEERING = 8;
	public static final int ELECTRICAL_AND_ELECTRONIC_ENGINEERING = 9;
	public static final int MATERIALS_ENGINEERING = 10;
	public static final int MECHANICAL_ENGINEERING = 11;
	public static final int MECHATRONICS_ENGINEERING = 12;
	public static final int QUANTITY_SERVEYING = 13;
	public static final int BUSINESS_ANALYTICS = 14;
	public static final int ACCOUNTING_AND_FINANCE = 15;
	public static final int HUMAN_CAPITAL_MANAGEMENT = 16;
	public static final int QUALITY_MANAGEMENT = 17;
	public static final int LOGISTICS_AND_SUPPLY_CHAIN_MANAGEMENT = 18;
	public static final int MANAGEMENT_INFORMATION_SYSTEMS = 19;
	public static final int ARCHITECTURE = 20;
	
	

	
	
	public static int getType(String text)
	{
		if(text != null)
		{
			if(text.equals("none"))
			{
				return NONE;
			}
			else if(text.equals("Computer Science & Software Engineering"))
			{
				return COMPUTER_SCIENCE_AND_SOFTWARE_ENGINEERING;
			}
			else if(text.equals("Cyber Security"))
			{
				return CYBER_SECURITY;
			}
			else if(text.equals("Information Technology"))
			{
				return INFORMATION_TECHNOLOGY;
			}
			else if(text.equals("Information Systems Engineering"))
			{
				return INFORMATION_SYSTEMS_ENGINEERING;
			}
			else if(text.equals("Interactive Media"))
			{
				return INTERACTIVE_MEDIA;
			}
			else if(text.equals("Data Science"))
			{
				return DATA_SCIENCE;
			}
			else if(text.equals("Computer Systems & Network Engineering"))
			{
				return COMPUTER_SYSTEMS_AND_NETWORK_ENGINEERING;
			}
			else if(text.equals("Civil Engineering"))
			{
				return CIVIL_ENGINEERING;
			}
			else if(text.equals("Electrical & Electronic Engineering"))
			{
				return ELECTRICAL_AND_ELECTRONIC_ENGINEERING;
			}
			else if(text.equals("Materials Engineering"))
			{
				return MATERIALS_ENGINEERING;
			}
			else if(text.equals("Mechanical Engineering"))
			{
				return MECHANICAL_ENGINEERING;
			}
			else if(text.equals("Mechatronics Engineering"))
			{
				return MECHATRONICS_ENGINEERING;
			}
			else if(text.equals("Quantity Serveying"))
			{
				return QUANTITY_SERVEYING;
			}
			else if(text.equals("Business Analytics"))
			{
				return BUSINESS_ANALYTICS;
			}
			else if(text.equals("Accounting & Finance"))
			{
				return ACCOUNTING_AND_FINANCE;
			}
			else if(text.equals("Human Capital Mangement"))
			{
				return HUMAN_CAPITAL_MANAGEMENT;
			}
			else if(text.equals("Quality Management"))
			{
				return QUALITY_MANAGEMENT;
			}
			else if(text.equals("Logistics & Supply Chain Management"))
			{
				return LOGISTICS_AND_SUPPLY_CHAIN_MANAGEMENT;
			}
			else if(text.equals("Management Information Systems"))
			{
				return MANAGEMENT_INFORMATION_SYSTEMS;
			}
			else if(text.equals("Architecture"))
			{
				return ARCHITECTURE;
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
