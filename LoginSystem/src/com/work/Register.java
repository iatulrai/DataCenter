package com.work;

import java.io.IOException;
import java.security.Security;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Register extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 603051980973854686L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userid = req.getParameter("uid");
		String pass = req.getParameter("pass");
		String mailid = req.getParameter("mailid");
		int scode = (int) (Math.random() * 100000);
		String msg = com.db.Admin.addUser(userid, pass, scode, mailid);
		req.setAttribute("msg", msg);
		req.setAttribute("id", userid);
		if (msg.startsWith("Sorry"))
			req.getRequestDispatcher("SignUp.jsp").forward(req, resp);
		else {
			try {
				String[] EMAILADDR = { mailid};
				Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
				Properties props = new Properties();
				props.put("mail.smtp.host", "smtp.gmail.com");
				props.put("mail.smtp.auth", "true");
				props.put("mail.debug", "true");
				props.put("mail.smtp.port", "465");
				props.put("mail.smtp.socketFactory.port", "465");
				props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
				props.put("mail.smtp.socketFactory.fallback", "false");
				Session ses = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication("atul.optimist", "1993@ANAI");// Please Provide The Sender Address
					}
				});
				ses.setDebug(true);
				Message msgg = new MimeMessage(ses); // Multipurpose Internet Mail Extension
				InternetAddress addressFrom = new InternetAddress("atul.optimist");
				msgg.setFrom(addressFrom);
				InternetAddress[] ADDRESS_TO = new InternetAddress[EMAILADDR.length];
				for (int i = 0; i < EMAILADDR.length; i++) {
					ADDRESS_TO[i] = new InternetAddress(EMAILADDR[i]);
				}
				msgg.setRecipients(Message.RecipientType.BCC, ADDRESS_TO);
				// Setting the Subject and Content Type
				msgg.setSubject("ur Security code - " + scode);
				msgg.setContent("Hello " + userid + ", ur security code for Registration is - " + scode, "text/html");
				Transport.send(msgg);
			} catch (Exception e) {
			}
			req.getRequestDispatcher("Verify.jsp").forward(req, resp);
		}
	}
}