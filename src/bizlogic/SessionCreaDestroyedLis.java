package bizlogic;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;


public class SessionCreaDestroyedLis implements HttpSessionListener {

    public SessionCreaDestroyedLis() {
    }

    public void sessionCreated(HttpSessionEvent arg0)  { 

    	System.out.println("Session got created");
    	
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent arg0)  { 
         // TODO Auto-generated method stub
    	System.out.println("Session got destroyed");
    	
    }
	
}
