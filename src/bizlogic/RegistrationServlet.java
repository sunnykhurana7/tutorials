package bizlogic;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class RegistrationServlet extends HttpServlet {

	
	
	String country,sitevisitor;
	
	public RegistrationServlet() {
        super();
    
    }

	public void init(ServletConfig config) throws ServletException {
	

		
		country = config.getInitParameter("UserLoginCountry");
		sitevisitor = config.getInitParameter("ActiveUserOnSite");
		
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		PrintWriter out = response.getWriter();
		
		String txtuiddata = request.getParameter("txtemail");
		String txtupwddata = request.getParameter("txtpwd");
		String txtfnamedata = request.getParameter("txtfullname");
		String txtaddrdata = request.getParameter("txtAddr");
		
		
				try {
				
					
					Connection con = (Connection)request.getAttribute("keyconobj");
					
					String msg = "select * from tbl_logreg";
								
					Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
					
					
					ResultSet virtbl = stmt.executeQuery(msg);
				
					
					virtbl.moveToInsertRow();
					
					virtbl.updateString("uid",txtuiddata );
					virtbl.updateString("upwd",txtupwddata );
					virtbl.updateString("fname",txtfnamedata );
					virtbl.updateString("addr",txtaddrdata);
					
					virtbl.insertRow();
					
					out.println("<center><font color=green>Registration Successful</font><center>");
					out.println("Active user on site is/are :"+sitevisitor);
					out.println("Your login country is :"+country);
					
					
				
				
				}catch(SQLException ex)
				{
					
				}
		
		
		
		
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		service(request, response);
	}

}
