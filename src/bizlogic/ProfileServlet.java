package bizlogic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;


import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ProfileServlet extends HttpServlet {
   
	String country,sitevisitor;
	
	
	public ProfileServlet() {
        super();
    }

	public void init(ServletConfig config) throws ServletException {
		
		country = config.getInitParameter("UserLoginCountry");
		sitevisitor = config.getInitParameter("ActiveUserOnSite");
		
	
		
		
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// We need to cross check whether id is generated or not
		// i.e., whether user is coming from the login page or not
		// if not send him/her to login page for starting the session.
		

		PrintWriter output = response.getWriter();
		
		
		HttpSession tokenid = request.getSession(false);
		
		if(tokenid == null)
		{
			output.println("<font color=red><center>You cant access profile page directly....Session need to be begin<center></font>");
			RequestDispatcher redirect = request.getRequestDispatcher("login.htm");
			redirect.include(request, response);
			
		}else
		{

			String usr = (String)tokenid.getAttribute("userN");
			output.println("<body background=images\\genimg\\bg.png>");
			output.println("<font color=green>Welcome To Your Profile Page</font>"+usr);
			
			output.println("Active user on site is/are :"+sitevisitor);
			output.println("Your login country is :"+country);
			output.println("Your unique sessionid/tokenid is "+tokenid.getId());
			
			output.println("<a href=logoutserv>Logout</a>");
			
			
		}
		
		
		
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service(request,response);
	}

}
