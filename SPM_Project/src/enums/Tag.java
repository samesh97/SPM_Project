package enums;

public class Tag {
	
	private String id;
	private String tag;
	private String name;
	private String yearSem;
	private String discription;

	public Tag() {
		
	}
	

	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public Tag(String tag, String name, String yearSem, String discription) {
		super();
		this.tag = tag;
		this.name = name;
		this.yearSem = yearSem;
		this.discription = discription;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getYearSem() {
		return yearSem;
	}

	public void setYearSem(String yearSem) {
		this.yearSem = yearSem;
	}

	public String getDiscription() {
		return discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}
	
	

}
