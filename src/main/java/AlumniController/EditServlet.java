package AlumniController;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Alumni_BO.Dil_Alumni_Bo;
import Alumni_Dao.Alumni_Dao;



/**
 * Servlet implementation class EditServlet
 */
@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		 PrintWriter pw=response.getWriter();
		
		 
	      String id=request.getParameter("id");
          
	      int eid= Integer.parseInt(id);
	    
	    
	    Dil_Alumni_Bo eb=Alumni_Dao.getEmployeeById(eid);
		
		pw.print("<form  action='UpdateController' method='get'> ");
	    
		pw.print("<table>");
		
		pw.print("<tr><td></td><td><input type='hidden' name='id' value='"+eb.getID()+"'/></td></tr>");  
		pw.print("<tr><td>Register No: </td> <td><input type='number'name='rollno' value='"+eb.getReg_no()+"'/></td></tr>");
	   	pw.print("<tr><td>Name: </td> <td><input type='text' name='name' value='"+eb.getName()+"'/></td></tr>");
	   	pw.print("<tr><td>Email:</td> <td><input type='email' name='email' value='"+eb.getEmail()+"'/></td></tr>");
	   	pw.print("<tr><td>Phone Number: </td> <td><input type='number' name='number' value='"+eb.getMob()+"'/></td></tr>");
	   	pw.print("<tr><td>Aadhar  No: </td> <td><input type='text' name='adhar' value='"+eb.getAadhar()+"'/></td></tr>");
	   	pw.print("<tr><td>Stream: </td> <td><input type='text' name='stream' value='"+eb.getStream()+"'/></td></tr>");
	   	pw.print("<tr><td>Course: </td> <td><input type='text' name='course' value='"+eb.getCourse()+"'/></td></tr>");
	   	pw.print("<tr><td>Joining Year: </td> <td><input type='date' name='join-year' value='"+eb.getJoin_year()+"'/></td></tr>");
	   	pw.print("<tr><td>Pass Out Year: </td> <td><input type='date' name='pass-year' value='"+eb.getPassout_year()+"'/></td></tr>");
	   	pw.print("<tr><td>Profession: </td> <td><input type='text' name='profession' value='"+eb.getProfession()+"'/></td></tr>");
	   	pw.print("<tr><td>Gender: </td> <td><input type='text' name='gender' value='"+eb.getGender()+"'/></td></tr>");
	   	
	    pw.print("<tr><td><input type='submit' value='UPDATE '/></td></tr>"); 
	    
	   	pw.print("</table>");
		
		pw.print("</form>");
		
		
		
		
	}

}
