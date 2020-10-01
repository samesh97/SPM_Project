package enums;

import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.Button;

public class Connection {

	private SimpleStringProperty subjectCode;
	private SimpleStringProperty tag;
	private SimpleStringProperty lecturer;
	private SimpleStringProperty groupId;
	private SimpleStringProperty location;
	private Button btnUpdate;
	private Button btnDelete;
	
	public Connection() {
		
	}
	
	public Connection(String subjectCode, String tag, String lecturer, String groupId, String location) {
		super();
		this.subjectCode = new SimpleStringProperty(subjectCode);
		this.tag = new SimpleStringProperty(tag);
		this.lecturer = new SimpleStringProperty(lecturer);
		this.groupId = new SimpleStringProperty(groupId);
		this.location = new SimpleStringProperty(location);
	}

	public SimpleStringProperty getSubjectCode() {
		return subjectCode;
	}

	public void setSubjectCode(String subjectCode) {
		this.subjectCode = new SimpleStringProperty(subjectCode);
	}

	public SimpleStringProperty getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = new SimpleStringProperty(tag);
	}

	public SimpleStringProperty getLecturer() {
		return lecturer;
	}

	public void setLecturer(String lecturer) {
		this.lecturer = new SimpleStringProperty(lecturer);
	}

	public SimpleStringProperty getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = new SimpleStringProperty(groupId);
	}

	public SimpleStringProperty getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = new SimpleStringProperty(location);
	}
	
	
}
