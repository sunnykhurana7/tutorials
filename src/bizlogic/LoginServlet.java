package bizlogic;

import java.io.IOException;
import java.io.PrintWriter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;


import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {

	
	String driver,dbl,dbu,dbp;
	
	String country,sitevisitor;
	
	
	public LoginServlet() {
        super();
    }
	public void init(ServletConfig config) throws ServletException {

			
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		System.out.println("Servlet invocation after filter authentication");
		
		String user = (String)request.getAttribute("reqscopeuser");
		

		// We need to generate his/her tokenid
		HttpSession sessionId = request.getSession(); 
		sessionId.setAttribute("userN", user );
		
					
		RequestDispatcher redirect = request.getRequestDispatcher("/profile");
		redirect.forward(request, response);
	
		
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		service(request, response);
	}

}
