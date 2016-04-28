package dto;

public class UserDTO {

	private int challan;
	private String name;
	private String fname;
	private int noHoliday;
	private String course;
	private int messAmount;
	private String email;
	private String doe;

	public String getDoe() {
		return doe;
	}

	public void setDoe(String doe) {
		this.doe = doe;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getChallan() {
		return challan;
	}

	public void setChallan(int challan) {
		this.challan = challan;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public int getNoHoliday() {
		return noHoliday;
	}

	public void setNoHoliday(int noHoliday) {
		this.noHoliday = noHoliday;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public int getMessAmount() {
		return messAmount;
	}

	public void setMessAmount(int messAmount) {
		this.messAmount = messAmount;
	}
}
