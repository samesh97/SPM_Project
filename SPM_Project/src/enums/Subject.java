package enums;

import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.Button;

public class Subject
{
	private String subjectCode;
	private String name;
	private int offeredYear;
	private int offeredSemester;
	private int lectureHours;
	private int tutorialHours;
	private int labHours;
	private int evaluationHours;
	//private Button buttonUpdate;
	//private Button buttonDelete;
	
	public Subject() {}
	
	public Subject(String subjectCode, String name, int offeredYear, int offeredSemester, int lectureHours,
			int tutorialHours, int labHours, int evaluationHours
			//,Button buttonUpdate,Button buttonDelete
			) {
		super();
		this.subjectCode = subjectCode;
		this.name = name;
		this.offeredYear = offeredYear;
		this.offeredSemester = offeredSemester;
		this.lectureHours = lectureHours;
		this.tutorialHours = tutorialHours;
		this.labHours = labHours;
		this.evaluationHours = evaluationHours;
		//this.buttonUpdate= new Button("UPDATE");
		//this.buttonDelete= new Button("DELETE");
	}

	public String getSubjectCode() {
		return subjectCode;
	}

	public void setSubjectCode(String subjectCode) {
		this.subjectCode = subjectCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getOfferedYear() {
		return offeredYear;
	}

	public void setOfferedYear(int offeredYear) {
		this.offeredYear = offeredYear;
	}

	public int getOfferedSemester() {
		return offeredSemester;
	}

	public void setOfferedSemester(int offeredSemester) {
		this.offeredSemester = offeredSemester;
	}

	public int getLectureHours() {
		return lectureHours;
	}

	public void setLectureHours(int lectureHours) {
		this.lectureHours = lectureHours;
	}

	public int getTutorialHours() {
		return tutorialHours;
	}

	public void setTutorialHours(int tutorialHours) {
		this.tutorialHours = tutorialHours;
	}

	public int getLabHours() {
		return labHours;
	}

	public void setLabHours(int labHours) {
		this.labHours = labHours;
	}

	public int getEvaluationHours() {
		return evaluationHours;
	}

	public void setEvaluationHours(int evaluationHours) {
		this.evaluationHours = evaluationHours;
	}

	/*
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
	
	*/

	
	
}
