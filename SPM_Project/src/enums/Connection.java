package enums;

import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.Button;

public class Connection {

	private String subjectCode;
	private String tag;
	private String lecturer;
	private String groupId;
	private String location;
	private Button btnUpdate;
	private Button btnDelete;
	
	public Connection() {
		
	}
	
	public Connection(String subjectCode, String tag, String lecturer, String groupId, String location) {
		super();
		this.subjectCode = subjectCode;
		this.tag = tag;
		this.lecturer = lecturer;
		this.groupId = groupId;
		this.location = location;
	}

	public String getSubjectCode() {
		return subjectCode;
	}

	public void setSubjectCode(String subjectCode) {
		this.subjectCode = subjectCode;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getLecturer() {
		return lecturer;
	}

	public void setLecturer(String lecturer) {
		this.lecturer = lecturer;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
	
}
