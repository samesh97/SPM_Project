package enums;

public class Lecturer {

	private String LecturerName;
	private String EmployeeID;
	private String Faculty;
	private String Department;
	private String Center;
	private String Building;
	private String Level;
	private String Rank;
	
	public Lecturer(){
		
	}

	public Lecturer(String lecturerName, String employeeID, String faculty, String department, String center,
			String building, String level, String rank) {
		super();
		LecturerName = lecturerName;
		EmployeeID = employeeID;
		Faculty = faculty;
		Department = department;
		Center = center;
		Building = building;
		Level = level;
		Rank = rank;
	}

	public String getLecturerName() {
		return LecturerName;
	}

	public void setLecturerName(String lecturerName) {
		this.LecturerName = lecturerName;
	}

	public String getEmployeeID() {
		return EmployeeID;
	}

	public void setEmployeeID(String employeeID) {
		this.EmployeeID = employeeID;
	}

	public String getFaculty() {
		return Faculty;
	}

	public void setFaculty(String faculty) {
		this.Faculty = faculty;
	}

	public String getDepartment() {
		return Department;
	}

	public void setDepartment(String department) {
		this.Department = department;
	}

	public String getCenter() {
		return Center;
	}

	public void setCenter(String center) {
		this.Center = center;
	}

	public String getBuilding() {
		return Building;
	}

	public void setBuilding(String building) {
		this.Building = building;
	}

	public String getLevel() {
		return Level;
	}

	public void setLevel(String level) {
		this.Level = level;
	}

	public String getRank() {
		return Rank;
	}

	public void setRank(String rank) {
		this.Rank = rank;
	}
	
	

}