package AlumniController;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Alumni_BO.Alumni_Bo;
import Alumni_Dao.Alumni_Dao;


/**
 * Servlet implementation class SignupControllre
 */
@WebServlet("/SignupControllre")
public class SignupControllre extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignupControllre() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String number=request.getParameter("number");
		String password=request.getParameter("password");
		
		//pw.print(name+"  "+email+" "+number+"  "+password);
		
		
		Alumni_Bo ab=new Alumni_Bo();
		
		ab.setName(name);
		ab.setEmail(email);
		ab.setNumber(number);
		ab.setPassword(password);
		
int status=Alumni_Dao.signup(ab);
		
		if (status>0) {
			
			pw.print("your are sucessfully signed up... ");
		}
		else {
			pw.print("sorry");
		}
		
		
		
		
	}

}
