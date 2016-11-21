package bizlogic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;



public class ReqArrivedResSent implements ServletRequestListener {

	String driver,dbl,dbu,dbp;
    public ReqArrivedResSent() {
        // TODO Auto-generated constructor stub
    }

	
    public void requestDestroyed(ServletRequestEvent refvar)  { 
         // TODO Auto-generated method stub
    	
    	System.out.println("Response went off from server");
    	
    }

	/**
     * @see ServletRequestListener#requestInitialized(ServletRequestEvent)
     */
    public void requestInitialized(ServletRequestEvent refvar)  { 
         // TODO Auto-generated method stub
    	
    	//System.out.println("Request Arrived At Server");
    	
    	ServletContext ctxobj = refvar.getServletContext();
    	
    	driver = ctxobj.getInitParameter("drivername");
		dbl = ctxobj.getInitParameter("dbloc");
		dbu = ctxobj.getInitParameter("dbusername");
		dbp = ctxobj.getInitParameter("dbpassword");   	
    	
		// Jdbc support
				try {
					Class.forName(driver);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
				
					
					Connection con = DriverManager.getConnection(dbl,dbu,dbp);
				
				
					ServletRequest broadcastobj = refvar.getServletRequest();
					
					broadcastobj.setAttribute("keyconobj",con);
				
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
    	
    	
    }
	
}
