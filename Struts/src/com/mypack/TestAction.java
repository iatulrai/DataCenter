package com.mypack;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class TestAction extends Action {
	@Override
	public ActionForward execute(ActionMapping map, ActionForm form, ServletRequest req, ServletResponse res)
			throws Exception {

		String success = req.getParameter("success");

		if (success != null) {
			return map.findForward("success");
		} else {
			return map.findForward("failure");
		}

	}

}
