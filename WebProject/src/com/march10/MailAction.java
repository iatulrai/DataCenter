package com.march10;

import java.io.IOException;
import java.io.PrintWriter;
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

public class MailAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String to = request.getParameter("to");
		String sub = request.getParameter("sub");
		String msg = request.getParameter("msg");

		PrintWriter out = response.getWriter();
		out.println("<body bgcolor=lightgreen><h2><tt>");

		try {

			String SMTP_HOST_NAME = "smtp.gmail.com";
			String SMTP_PORT = "465";

			final String EMAIL_FROM = "zaliraj0786";
			final String EMAIL_PASSWORD = "forget@ali";

			String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
			String[] EMAIL_TO = { to, "iatulrai@gmail.com" };

			Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());

			boolean debug = true;

			Properties props = new Properties();
			props.put("mail.smtp.host", SMTP_HOST_NAME);
			props.put("mail.smtp.auth", "true");
			props.put("mail.debug", "true");
			props.put("mail.smtp.port", SMTP_PORT);
			props.put("mail.smtp.socketFactory.port", SMTP_PORT);
			props.put("mail.smtp.socketFactory.class", SSL_FACTORY);
			props.put("mail.smtp.socketFactory.fallback", "false");
			Session ses = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(EMAIL_FROM, EMAIL_PASSWORD);// Please
																					// Provide
																					// The
																					// Sender
																					// Address
				}
			});
			ses.setDebug(debug);
			Message msgg = new MimeMessage(ses); // Multipurpose Internet Mail
													// Extension
			InternetAddress addressFrom = new InternetAddress(EMAIL_FROM);
			msgg.setFrom(addressFrom);
			InternetAddress[] ADDRESS_TO = new InternetAddress[EMAIL_TO.length];
			for (int i = 0; i < EMAIL_TO.length; i++) {
				ADDRESS_TO[i] = new InternetAddress(EMAIL_TO[i]);
			}
			msgg.setRecipients(Message.RecipientType.TO, ADDRESS_TO);
			// Setting the Subject and Content Type
			msgg.setSubject(sub);
			msgg.setContent(msg, "text/html");
			Transport.send(msgg);
			out.println("Mail Successfully Send.");
		} catch (Exception e) {
			out.println(e.toString());
		}
	}
}