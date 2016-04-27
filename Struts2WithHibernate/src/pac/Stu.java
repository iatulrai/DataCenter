package pac;

/**
 *
 * @author Atul Rai
 */
public class Stu {

	private int roll;
	private int marks;
	private String name;

	public Stu() {

	}

	public Stu(String name, int marks) {
		this.name = name;
		this.marks = marks;
	}

	public String getReport() {
		return "<tr><td>" + roll + "</td><td>" + name + "</td><td>" + marks + "</td></tr>";
	}

	public Integer gerRoll() {
		return roll;
	}

	/**
	 * @return the roll
	 */
	public int getRoll() {
		return roll;
	}

	/**
	 * @param roll
	 *            the roll to set
	 */
	public void setRoll(int roll) {
		this.roll = roll;
	}

	/**
	 * @return the marks
	 */
	public int getMarks() {
		return marks;
	}

	/**
	 * @param marks
	 *            the marks to set
	 */
	public void setMarks(int marks) {
		this.marks = marks;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

}
