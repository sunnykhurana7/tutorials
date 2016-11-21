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


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
 
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
 
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
 

/**
 * Servlet implementation class ReadXmlAds
 */
@WebServlet("/ReadXmlAds")
public class ReadXmlAds extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReadXmlAds() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// We need to cross check whether id is generated or not
				// i.e., whether user is coming from the login page or not
				// if not send him/her to login page for starting the session.
				

				PrintWriter output = response.getWriter();
				
				
				HttpSession tokenid = request.getSession(false);
				
				if(tokenid == null)
				{
					output.println("<font color=red><center>You cant access Ads Display page directly....Session need to be begin<center></font>");
					RequestDispatcher redirect = request.getRequestDispatcher("login.htm");
					redirect.include(request, response);
					
				}else
				{

					String usr = (String)tokenid.getAttribute("userN");
					output.println("<body background=images\\genimg\\bg.png>");
					output.println("<font color=green>Welcome ADD Display Section</font>");
					
								
					 String filePath = "D:\\employee.xml";
					//String filePath = "xmlinfo\\employee.xml";
					
				        File xmlFile = new File(filePath);
				        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
				        DocumentBuilder dBuilder;
				        try {
				            dBuilder = dbFactory.newDocumentBuilder();
				            Document doc = dBuilder.parse(xmlFile);
				            doc.getDocumentElement().normalize();
				            output.println("Root element :" + doc.getDocumentElement().getNodeName());
				            NodeList nodeList = doc.getElementsByTagName("Employee");
				            //now XML is loaded as Document in memory, lets convert it to Object List
				            List<Employee> empList = new ArrayList<Employee>();
				            for (int i = 0; i < nodeList.getLength(); i++) {
				                empList.add(getEmployee(nodeList.item(i)));
				            }
				            //lets print Employee list information
				            for (Employee emp : empList) {
				                output.println(emp.toString());
				            }
				        } catch (SAXException | ParserConfigurationException | IOException e1) {
				            e1.printStackTrace();
				        }
					
					
					
					
					output.println("<a href=logoutserv>Logout</a>");
					
					
				}
				
				

		
	}
	
	
	private static Employee getEmployee(Node node) {
        //XMLReaderDOM domReader = new XMLReaderDOM();
        Employee emp = new Employee();
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            Element element = (Element) node;
            emp.setName(getTagValue("name", element));
            emp.setAge(Integer.parseInt(getTagValue("age", element)));
            emp.setGender(getTagValue("gender", element));
            emp.setRole(getTagValue("role", element));
        }
 
        return emp;
    }
 
 
    private static String getTagValue(String tag, Element element) {
        NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
        Node node = (Node) nodeList.item(0);
        return node.getNodeValue();
    }
 

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service(request, response);
	}

}
