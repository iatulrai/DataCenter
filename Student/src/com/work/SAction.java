package com.work;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class SAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String roll, name, college, state, city, msg;
	int ctr;

	List<String> collList = new ArrayList<>();
	List<String> stList = new ArrayList<>();
	List<String> ctList = new ArrayList<>();
	List<String> rollList = new ArrayList<>();

	@Override
	public String execute() throws Exception {

		collList = com.db.Admin.getCollege();
		stList = com.db.Admin.getState();
		ctList = com.db.Admin.getCity(state);
		rollList = com.db.Admin.getRoll();

		if (ctr == 1) {
			setMsg(com.db.Admin.addStudent(name, college, state, city));

			return "DESIGN";
		} else if (ctr == 2) {

			List<String> r = com.db.Admin.getRecord(roll);
			if (r.size() != 1) {
				setName(r.get(0));
				setCollege(r.get(1));
				setState(r.get(2));
				ctList = com.db.Admin.getCity(state);
				setCity(r.get(3));
			} else {
				setName("");
				setCollege("");
				setState("");
				setCity("");
			}
			return "UPDATE";

		} else if (ctr == 3) {

			setMsg(com.db.Admin.updStudent(roll, name, college, state, city));
			return "UPDATE";
		} else if (ctr == 4) {

			setMsg(com.db.Admin.delStu(roll));
			rollList = com.db.Admin.getRoll();
			return "UPDATE";
		} else if (ctr == 5) {
			ResultSet rs = com.db.Admin.getReport();
			HttpServletRequest request = ServletActionContext.getRequest();
			request.setAttribute("rs", rs);
			return "LIST";
		}
		return "DESIGN";

	}

	public List<String> getCollList() {
		return collList;
	}

	public void setCollList(List<String> collList) {
		this.collList = collList;
	}

	public List<String> getStList() {
		return stList;
	}

	public void setStList(List<String> stList) {
		this.stList = stList;
	}

	public List<String> getCtList() {
		return ctList;
	}

	public void setCtList(List<String> ctList) {
		this.ctList = ctList;
	}

	public List<String> getRollList() {
		return rollList;
	}

	public void setRollList(List<String> rollList) {
		this.rollList = rollList;
	}

	public String getRoll() {
		return roll;
	}

	public void setRoll(String roll) {
		this.roll = roll;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCollege() {
		return college;
	}

	public void setCollege(String college) {
		this.college = college;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public int getCtr() {
		return ctr;
	}

	public void setCtr(int ctr) {
		this.ctr = ctr;
	}

}
