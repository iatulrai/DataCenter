package pac;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Transaction;

import com.opensymphony.xwork2.ActionSupport;

/**
 *
 * @author Atul Rai
 */
public class StuAction extends ActionSupport {

	private int roll, ctr;
	private int marks;
	private String name, msg;
	private List<Integer> rollList = new ArrayList<Integer>();

	@Override
	public String execute() throws Exception {

		org.hibernate.SessionFactory factory = pac.HU.getSessionFactory();
		org.hibernate.Session ses = factory.openSession();
		Transaction tr = ses.beginTransaction();
		Criteria cr = ses.createCriteria(pac.Stu.class);
		List<Stu> st = cr.list();
		for (Stu n : st) {
			rollList.add(n.gerRoll());
		}

		if (ctr == 0) {
			return "DESIGN";
		} else if (ctr == 1) {
			Stu s = new Stu(name, marks);
			ses.save(s);
			tr.commit();
			setMsg("Student record successfully inserted");
			return "SUCCESS";

		} else if (ctr == 3) {

			Stu s = (Stu) ses.get(Stu.class, roll);
			setName(s.getName());
			setMarks(s.getMarks());
			return "UPDATE";

		} else if (ctr == 4) {

			Stu s = (Stu) ses.get(Stu.class, getRoll());
			s.setName(name);
			s.setMarks(marks);
			tr.commit();
			setMsg("Student record successfully updated");
			return "UPDATE";

		} else if (ctr == 5) {

			try {
				Stu s = (Stu) ses.get(Stu.class, getRoll());
				ses.delete(s);
				tr.commit();
				setMsg("Student record successfully deleted");
			} catch (Exception e) {
				setMsg("Sorry no record found");
			}
			return "UPDATE";
		} else {
			return "REPORT";
		}
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

	/**
	 * @return the ctr
	 */
	public int getCtr() {
		return ctr;
	}

	/**
	 * @param ctr
	 *            the ctr to set
	 */
	public void setCtr(int ctr) {
		this.ctr = ctr;
	}

	/**
	 * @return the msg
	 */
	public String getMsg() {
		return msg;
	}

	/**
	 * @param msg
	 *            the msg to set
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}

	/**
	 * @return the rollList
	 */
	public List<Integer> getRollList() {
		return rollList;
	}

	/**
	 * @param rollList
	 *            the rollList to set
	 */
	public void setRollList(List<Integer> rollList) {
		this.rollList = rollList;
	}

}
