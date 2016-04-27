package pac;

import java.util.List;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Report extends TagSupport {

	@Override
	public int doStartTag() throws JspException {

		try {
			JspWriter out = pageContext.getOut();
			SessionFactory factory = HU.getSessionFactory();
			org.hibernate.Session ses = factory.openSession();
			Transaction tr = ses.beginTransaction();
			Criteria cr = ses.createCriteria(Stu.class);
			List<Stu> s = cr.list();
			for (Stu n : s) {
				out.print(n.getReport());
			}

		} catch (Exception ex) {
		}

		return 0;
	}

}
