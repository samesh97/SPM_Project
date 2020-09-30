package enums;

public class Session {

	private String Lecturer;
	private String Subject;
	private String Tag;
	private String Group;
	private int Count;
	private int Duration;
	
	public Session(){}
	public Session(String lecturer, String subject, String tag, String group, int count, int duration) {
		super();
		Lecturer = lecturer;
		Subject = subject;
		Tag = tag;
		Group = group;
		Count = count;
		Duration = duration;
	}

	public String getLecturer() {
		return Lecturer;
	}

	public void setLecturer(String lecturer) {
		Lecturer = lecturer;
	}

	public String getSubject() {
		return Subject;
	}

	public void setSubject(String subject) {
		Subject = subject;
	}

	public String getTag() {
		return Tag;
	}

	public void setTag(String tag) {
		Tag = tag;
	}

	public String getGroup() {
		return Group;
	}

	public void setGroup(String group) {
		Group = group;
	}

	public int getCount() {
		return Count;
	}

	public void setCount(int count) {
		Count = count;
	}

	public int getDuration() {
		return Duration;
	}

	public void setDuration(int duration) {
		Duration = duration;
	}
	
	
	
}
