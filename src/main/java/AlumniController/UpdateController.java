package AlumniController;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Alumni_BO.Dil_Alumni_Bo;
import Alumni_Dao.Alumni_Dao;

/**
 * Servlet implementation class UpdateController
 */
@WebServlet("/UpdateController")

public class UpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateController() 
    {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");
		
		 PrintWriter pw=response.getWriter();
		 
		 int id=Integer.parseInt(request.getParameter("id"));
		 String Reg_No=request.getParameter("rollno");
		 String name=request.getParameter("name");
		 String email=request.getParameter("email");
		 String Mob=request.getParameter("number");
		 String Aadhar=request.getParameter("adhar");
		 String Stream=request.getParameter("stream"); 
		 String Course=request.getParameter("course");
		 String Join_year=request.getParameter("join-year");
		 String Passout_year=request.getParameter("pass-year");
		 String Profession=request.getParameter("profession");
		 String Gender=request.getParameter("gender");
		
		 Dil_Alumni_Bo ab=new Dil_Alumni_Bo();
		 
		 
		 ab.setID(id);
		 ab.setReg_no(Reg_No);
		 ab.setName(name);
		 ab.setEmail(email);
		 ab.setMob(Mob);
		 ab.setAadhar(Aadhar);
		 ab.setStream(Stream);
		 ab.setCourse(Course);
		 ab.setJoin_year(Join_year);
		 ab.setPassout_year(Passout_year);
		 ab.setProfession(Profession);
		 ab.setGender(Gender);
		 
		 int status=Alumni_Dao.update(ab);
		 
		 if(status>0)
		 {
			 RequestDispatcher rd=request.getRequestDispatcher("AllAumniController");
			 rd.forward(request, response);
		 }
		 else {
			 
			pw.print("something wrong");
			
		}	}

}
