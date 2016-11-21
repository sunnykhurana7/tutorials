package filters;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpSession;

public class LoginAuthenticator implements Filter {

	public LoginAuthenticator() {

	}

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		System.out.println("Before login servlet filter will get invoked and will do db mapping");
		
		String useremail = request.getParameter("txtemail");
		String userpwd = request.getParameter("txtpwd");

		PrintWriter out = response.getWriter();

		try {

			Connection con = (Connection) request.getAttribute("keyconobj");

			String msg = "select * from tbl_logreg where uid= ? and upwd = ?";

			PreparedStatement pstmt = con.prepareStatement(msg);

			pstmt.setString(1, useremail);
			pstmt.setString(2, userpwd);

			ResultSet virtbl = pstmt.executeQuery();

			if (virtbl.next()) {

				request.setAttribute("reqscopeuser", useremail );
				chain.doFilter(request, response);
				
			} else {
				out.println("<font color=red>Incorrect UserName/Password</font>");
				RequestDispatcher redirect = request.getRequestDispatcher("login.htm");
				redirect.include(request, response);

				// out.println("<frame src=webpage.htm target=_self>");
				// response.sendRedirect("http://www.google.com");
				// out.println("</frame");

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
package filters;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpSession;

public class LoginAuthenticator implements Filter {

	public LoginAuthenticator() {

	}

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		System.out.println("Before login servlet filter will get invoked and will do db mapping");
		
		String useremail = request.getParameter("txtemail");
		String userpwd = request.getParameter("txtpwd");

		PrintWriter out = response.getWriter();

		try {

			Connection con = (Connection) request.getAttribute("keyconobj");

			String msg = "select * from tbl_logreg where uid= ? and upwd = ?";

			PreparedStatement pstmt = con.prepareStatement(msg);

			pstmt.setString(1, useremail);
			pstmt.setString(2, userpwd);

			ResultSet virtbl = pstmt.executeQuery();

			if (virtbl.next()) {

				request.setAttribute("reqscopeuser", useremail );
				chain.doFilter(request, response);
				
			} else {
				out.println("<font color=red>Incorrect UserName/Password</font>");
				RequestDispatcher redirect = request.getRequestDispatcher("login.htm");
				redirect.include(request, response);

				// out.println("<frame src=webpage.htm target=_self>");
				// response.sendRedirect("http://www.google.com");
				// out.println("</frame");

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
package filters;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpSession;

public class LoginAuthenticator implements Filter {

	public LoginAuthenticator() {

	}

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		System.out.println("Before login servlet filter will get invoked and will do db mapping");
		
		String useremail = request.getParameter("txtemail");
		String userpwd = request.getParameter("txtpwd");

		PrintWriter out = response.getWriter();

		try {

			Connection con = (Connection) request.getAttribute("keyconobj");

			String msg = "select * from tbl_logreg where uid= ? and upwd = ?";

			PreparedStatement pstmt = con.prepareStatement(msg);

			pstmt.setString(1, useremail);
			pstmt.setString(2, userpwd);

			ResultSet virtbl = pstmt.executeQuery();

			if (virtbl.next()) {

				request.setAttribute("reqscopeuser", useremail );
				chain.doFilter(request, response);
				
			} else {
				out.println("<font color=red>Incorrect UserName/Password</font>");
				RequestDispatcher redirect = request.getRequestDispatcher("login.htm");
				redirect.include(request, response);

				// out.println("<frame src=webpage.htm target=_self>");
				// response.sendRedirect("http://www.google.com");
				// out.println("</frame");

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
package filters;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpSession;

public class LoginAuthenticator implements Filter {

	public LoginAuthenticator() {

	}

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		System.out.println("Before login servlet filter will get invoked and will do db mapping");
		
		String useremail = request.getParameter("txtemail");
		String userpwd = request.getParameter("txtpwd");

		PrintWriter out = response.getWriter();

		try {

			Connection con = (Connection) request.getAttribute("keyconobj");

			String msg = "select * from tbl_logreg where uid= ? and upwd = ?";

			PreparedStatement pstmt = con.prepareStatement(msg);

			pstmt.setString(1, useremail);
			pstmt.setString(2, userpwd);

			ResultSet virtbl = pstmt.executeQuery();

			if (virtbl.next()) {

				request.setAttribute("reqscopeuser", useremail );
				chain.doFilter(request, response);
				
			} else {
				out.println("<font color=red>Incorrect UserName/Password</font>");
				RequestDispatcher redirect = request.getRequestDispatcher("login.htm");
				redirect.include(request, response);

				// out.println("<frame src=webpage.htm target=_self>");
				// response.sendRedirect("http://www.google.com");
				// out.println("</frame");

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
package filters;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpSession;

public class LoginAuthenticator implements Filter {

	public LoginAuthenticator() {

	}

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		System.out.println("Before login servlet filter will get invoked and will do db mapping");
		
		String useremail = request.getParameter("txtemail");
		String userpwd = request.getParameter("txtpwd");

		PrintWriter out = response.getWriter();

		try {

			Connection con = (Connection) request.getAttribute("keyconobj");

			String msg = "select * from tbl_logreg where uid= ? and upwd = ?";

			PreparedStatement pstmt = con.prepareStatement(msg);

			pstmt.setString(1, useremail);
			pstmt.setString(2, userpwd);

			ResultSet virtbl = pstmt.executeQuery();

			if (virtbl.next()) {

				request.setAttribute("reqscopeuser", useremail );
				chain.doFilter(request, response);
				
			} else {
				out.println("<font color=red>Incorrect UserName/Password</font>");
				RequestDispatcher redirect = request.getRequestDispatcher("login.htm");
				redirect.include(request, response);

				// out.println("<frame src=webpage.htm target=_self>");
				// response.sendRedirect("http://www.google.com");
				// out.println("</frame");

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
package filters;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpSession;

public class LoginAuthenticator implements Filter {

	public LoginAuthenticator() {

	}

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		System.out.println("Before login servlet filter will get invoked and will do db mapping");
		
		String useremail = request.getParameter("txtemail");
		String userpwd = request.getParameter("txtpwd");

		PrintWriter out = response.getWriter();

		try {

			Connection con = (Connection) request.getAttribute("keyconobj");

			String msg = "select * from tbl_logreg where uid= ? and upwd = ?";

			PreparedStatement pstmt = con.prepareStatement(msg);

			pstmt.setString(1, useremail);
			pstmt.setString(2, userpwd);

			ResultSet virtbl = pstmt.executeQuery();

			if (virtbl.next()) {

				request.setAttribute("reqscopeuser", useremail );
				chain.doFilter(request, response);
				
			} else {
				out.println("<font color=red>Incorrect UserName/Password</font>");
				RequestDispatcher redirect = request.getRequestDispatcher("login.htm");
				redirect.include(request, response);

				// out.println("<frame src=webpage.htm target=_self>");
				// response.sendRedirect("http://www.google.com");
				// out.println("</frame");

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
package filters;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpSession;

public class LoginAuthenticator implements Filter {

	public LoginAuthenticator() {

	}

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		System.out.println("Before login servlet filter will get invoked and will do db mapping");
		
		String useremail = request.getParameter("txtemail");
		String userpwd = request.getParameter("txtpwd");

		PrintWriter out = response.getWriter();

		try {

			Connection con = (Connection) request.getAttribute("keyconobj");

			String msg = "select * from tbl_logreg where uid= ? and upwd = ?";

			PreparedStatement pstmt = con.prepareStatement(msg);

			pstmt.setString(1, useremail);
			pstmt.setString(2, userpwd);

			ResultSet virtbl = pstmt.executeQuery();

			if (virtbl.next()) {

				request.setAttribute("reqscopeuser", useremail );
				chain.doFilter(request, response);
				
			} else {
				out.println("<font color=red>Incorrect UserName/Password</font>");
				RequestDispatcher redirect = request.getRequestDispatcher("login.htm");
				redirect.include(request, response);

				// out.println("<frame src=webpage.htm target=_self>");
				// response.sendRedirect("http://www.google.com");
				// out.println("</frame");

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
package filters;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpSession;

public class LoginAuthenticator implements Filter {

	public LoginAuthenticator() {

	}

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		System.out.println("Before login servlet filter will get invoked and will do db mapping");
		
		String useremail = request.getParameter("txtemail");
		String userpwd = request.getParameter("txtpwd");

		PrintWriter out = response.getWriter();

		try {

			Connection con = (Connection) request.getAttribute("keyconobj");

			String msg = "select * from tbl_logreg where uid= ? and upwd = ?";

			PreparedStatement pstmt = con.prepareStatement(msg);

			pstmt.setString(1, useremail);
			pstmt.setString(2, userpwd);

			ResultSet virtbl = pstmt.executeQuery();

			if (virtbl.next()) {

				request.setAttribute("reqscopeuser", useremail );
				chain.doFilter(request, response);
				
			} else {
				out.println("<font color=red>Incorrect UserName/Password</font>");
				RequestDispatcher redirect = request.getRequestDispatcher("login.htm");
				redirect.include(request, response);

				// out.println("<frame src=webpage.htm target=_self>");
				// response.sendRedirect("http://www.google.com");
				// out.println("</frame");

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
