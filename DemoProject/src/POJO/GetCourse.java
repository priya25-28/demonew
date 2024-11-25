package POJO;

public class GetCourse {
	
	private String url;
	private String services;
	private String expertise;
	private Courses courses;// return type will be a class because we have made another pojo class for courses 
	// as it have three more jsons inside it. If there is a simple key value pair then we can directly assign the
	//values like above object if it has nested jsons , we need to make another pojo class for that and call it
	//in the main class
	private String linkedIn;
	
	private String instructor;
	
	
	public String getInstructor() {
		return instructor;
	}
	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getServices() {
		return services;
	}
	public void setServices(String services) {
		this.services = services;
	}
	public String getExpertise() {
		return expertise;
	}
	public void setExpertise(String expertise) {
		this.expertise = expertise;
	}
	public Courses getCourses() {
		return courses;
	}
	public void setCourses(Courses courses) {
		this.courses = courses;
	}
	public String getLinkedIn() {
		return linkedIn;
	}
	public void setLinkedIn(String linkedIn) {
		this.linkedIn = linkedIn;
	}

}
