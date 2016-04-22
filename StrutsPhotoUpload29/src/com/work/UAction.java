package com.work;

public class UAction {

	String ename, photo, msg;

	public String execute() throws Exception {
		msg = com.db.Admin.addemp(ename, photo);
		setEname("");
		return "SUCCESS";
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
