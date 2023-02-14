package AlumniController;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspWriter;

import org.apache.jasper.tagplugins.jstl.core.If;

import Alumni_BO.Dil_Alumni_Bo;
import Alumni_Dao.Alumni_Dao;

/**
 * Servlet implementation class Alumni_Controller
 */
@WebServlet("/Alumni_Controller")
public class Alumni_Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Alumni_Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		
		
	String Reg_No=request.getParameter("rollno");
	String Name=request.getParameter("name");
	String Email=request.getParameter("email");
	String Mob=request.getParameter("number");
    String Aadhar=request.getParameter("adhar");
	String Stream=request.getParameter("stream");
	String Course=request.getParameter("course");
	String Join_year=request.getParameter("join-year");
	String Passout_year=request.getParameter("pass-year");
	String Profession=request.getParameter("profession");
	String Gender=request.getParameter("gender");

	//pw.print(Name +" "+Reg_No+ " "+Email);
	
	Dil_Alumni_Bo ob=new Dil_Alumni_Bo(Reg_No, Name, Email, Mob, Aadhar, Stream, Course, Join_year, Passout_year, Profession, Gender);
	
	int status=Alumni_Dao.addAlumni(ob);
	
	
	 if (status>0) {
			
		 
		 pw.print("your are sucessfully data inserted...");
		
	}
	 else {
		 
		 pw.print("ja ata mag kar parat");
		 
	 }
	 
	
	}
}
