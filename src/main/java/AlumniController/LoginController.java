package AlumniController;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Alumni_Dao.Alumni_Dao;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		PrintWriter pw=response.getWriter();
		
		
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		
		
		if (Alumni_Dao.adminlogin(email, password)) 
		{
			
			 RequestDispatcher rd=request.getRequestDispatcher("home.html");
				rd.forward(request, response); 
			
			
		}
		else {
			
			
			RequestDispatcher rd=request.getRequestDispatcher("login.html");
			rd.include(request, response); 
			
			pw.print("Check Your Email and Password");
			
			
		}
		
		
	}

}
