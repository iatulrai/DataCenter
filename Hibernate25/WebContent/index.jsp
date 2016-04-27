<%@page import="java.util.List"%>
<%@page import="org.hibernate.Criteria"%>
<%@page import="pac.Student"%>
<%@page import="org.hibernate.Transaction"%>
<%@page import="org.hibernate.SessionFactory"%>
<%
    SessionFactory factory = pac.HU.getSessionFactory();
    org.hibernate.Session ses = factory.openSession();
    Transaction tr = ses.beginTransaction();
 
     // for add new student	
     pac.Student s = new pac.Student("Jitin",76);       
     int x = (Integer) ses.save(s);     
     tr.commit();
     out.println("Record inserted with rollno - "+x);
     
     /* // for update 

     Student s = (Student) ses.get(Student.class, 3);
     out.println("Name" + s.getName());
     out.println("Marks" + s.getMarks());
     s.setName("Khatnak Shikari");
     s.setMarks(10);
     ses.update(s);
     tr.commit();
     out.println("Record successfully updated");
   

    Criteria cr = ses.createCriteria(Student.class);
    List<Student> list = cr.list();
    out.println("<table width=80% border= 1");
    for (Student st : list) {
        out.println(st.getRow());
    }
    out.println("</table>");
    tr.commit();
    */

%>