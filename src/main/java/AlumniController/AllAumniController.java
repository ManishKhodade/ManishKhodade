package AlumniController;

import java.io.IOException;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Alumni_BO.Dil_Alumni_Bo;
import Alumni_Dao.Alumni_Dao;



/**
 * Servlet implementation class AllAumniController
 */
@WebServlet("/AllAumniController")
public class AllAumniController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AllAumniController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		
		
		pw.print("<a href ='home.html'>Back</a>");
		
         pw.print("<table border ='1px' width =100% backgroung-color : green > ");
		
		pw.print("<tr> <th>ID</th> <th>Reg_No</th> <th>NAME</th> <th>EMAIL</th> <th>PHONE</th> <th>Aadhar</th> <th>Stream</th> <th>Course</th> <th>Join_year</th> <th>Passout_year</th> <th>Profession</th><th>Gender</th><th>ACTION</th><th>ACTION</th> </tr>");
		
		List<Dil_Alumni_Bo> list= Alumni_Dao.getAllAlumni();
		
		for(Dil_Alumni_Bo ob: list)
		{
			pw.print("<tr> <td>"+ob.getID()+"</td><td>"+ob.getReg_no()+"</td><td>"+ob.getName()+"</td><td>"+ob.getEmail()+"</td><td>"+ob.getMob()+"</td><td>"+ob.getAadhar()+"</td><td>"+ob.getStream()+"</td><td>"+ob.getCourse()+"</td><td>"+ob.getJoin_year()+"</td><td>"+ob.getPassout_year()+"</td><td>"+ob.getProfession()+"</td><td>"+ob.getGender()+"</td><td><a href='EditServlet?id="+ob.getID()+"'> edit </a></td> <td><a href='DeleteController?id="+ob.getID()+"'>delete </a></td>  </tr>");
		}
		
		pw.print("</table>");
		
		
	}

}
