package bizlogic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LogoutServlet() {
        super();
    }
	public void init(ServletConfig config) throws ServletException {
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter output = response.getWriter();
		
		HttpSession tokenid = request.getSession(false);
		
		if(tokenid == null)
		{
			output.println("<font color=red><center>We can't let you log out....since your session somehow is not created<center></font>");
			RequestDispatcher redirect = request.getRequestDispatcher("login.htm");
			redirect.include(request, response);
			
		}else
		{
			
			tokenid.removeAttribute("userN");
			tokenid.invalidate();
			
			output.println("<body background=images\\genimg\\bg.png>");
			output.println("<font color=green>You are successfulyy logged out</font>");
			
			
		}
		

		
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service(request, response);
	}

}
