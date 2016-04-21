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

public class ForgetAction extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4062338257636263939L;

	
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userid = req.getParameter("uid");
		String msg = com.db.Admin.forget(userid);
		req.setAttribute("msg", msg);
		if (msg.startsWith("Sorry"))
			req.getRequestDispatcher("Forget.jsp").forward(req, resp);
		else {
			String ar[] = msg.split(":"); // ar[0] - pass , ar[1] = mailid
			try {
				String[] EMAILADDR = { ar[1] };
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
						return new PasswordAuthentication("atul.optimist", "1993@ANAI");// Please
																						// Provide
																						// The
																						// Sender
																						// Address
					}
				});
				ses.setDebug(true);
				Message msgg = new MimeMessage(ses); // Multipurpose Internet
														// Mail Extension
				InternetAddress addressFrom = new InternetAddress("atul.optimist");
				msgg.setFrom(addressFrom);
				InternetAddress[] ADDRESS_TO = new InternetAddress[EMAILADDR.length];
				for (int i = 0; i < EMAILADDR.length; i++) {
					ADDRESS_TO[i] = new InternetAddress(EMAILADDR[i]);
				}
				msgg.setRecipients(Message.RecipientType.BCC, ADDRESS_TO);
				// Setting the Subject and Content Type
				msgg.setSubject("Hello " + userid + ", ur Password is - " + ar[0]);
				msgg.setContent("Hello " + userid
						+ ", this mail send on request for password recovery & ur password is - " + ar[0], "text/html");
				Transport.send(msgg);
			} catch (Exception e) {
			}
			req.setAttribute("msg", "ur password successfully send on ur mail id. ");
			req.getRequestDispatcher("Forget.jsp").forward(req, resp);
		}
	}
}