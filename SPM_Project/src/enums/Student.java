package enums;

import javafx.scene.control.Button;

public class Student {
	private String id;
	private String yearSem;
	private String program;
	private String groupNo;
	private String subGroupNo;
	private String groupId;
	private String subGroupId;
	private Button buttonUpdate;
	private Button buttonDelete;
	public Student() {
		
	}

	public Student(String yearSem, String program, String groupNo, String subGroupNo, String groupId,
			String subGroupId) {
		super();
		this.yearSem = yearSem;
		this.program = program;
		this.groupNo = groupNo;
		this.subGroupNo = subGroupNo;
		this.groupId = groupId;
		this.subGroupId = subGroupId;
		this.buttonUpdate= new Button("UPDATE");
		this.buttonDelete= new Button("DELETE");
	}

	public String getYearSem() {
		return yearSem;
	}

	public void setYearSem(String yearSem) {
		this.yearSem = yearSem;
	}

	public String getProgram() {
		return program;
	}

	public void setProgram(String program) {
		this.program = program;
	}

	public String getGroupNo() {
		return groupNo;
	}

	public void setGroupNo(String groupNo) {
		this.groupNo = groupNo;
	}

	public String getSubGroupNo() {
		return subGroupNo;
	}

	public void setSubGroupNo(String subGroupNo) {
		this.subGroupNo = subGroupNo;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getSubGroupId() {
		return subGroupId;
	}

	public void setSubGroupId(String subGroupId) {
		this.subGroupId = subGroupId;
	}

	public Button getButtonUpdate() {
		return buttonUpdate;
	}

	public void setButtonUpdate(Button buttonUpdate) {
		this.buttonUpdate = buttonUpdate;
	}

	public Button getButtonDelete() {
		return buttonDelete;
	}

	public void setButtonDelete(Button buttonDelete) {
		this.buttonDelete = buttonDelete;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	
	

}
