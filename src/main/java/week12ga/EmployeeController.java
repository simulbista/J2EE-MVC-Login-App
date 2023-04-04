//EmployeeController.java - logic for checking if data from view.jsp form matches with the data from the database
package week12ga;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EmployeeController")
public class EmployeeController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	EmployeeDAO empDAO;
	
	public void init() {
		empDAO = new EmployeeDAO();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//storing data(username, password) from the form in view.jsp to the model 
		//and then passing the model to the DAO to select data from the database based on the username
		String credentials[]= new String[2];
		EmployeeModel empModel = new EmployeeModel();
		empModel.setUsername(req.getParameter("uname"));
		empModel.setPassword(req.getParameter("pass"));
		
		try{
			credentials = empDAO.getUserRecord(empModel);
			//input from login form matches value from db, then login success else failure
			if(empModel.getUsername().equals(credentials[0]) && empModel.getPassword().equals(credentials[1])) {
				resp.sendRedirect("success.jsp");
			}else {
				resp.sendRedirect("error.jsp");
			}

		}catch(Exception e) {
			e.printStackTrace();
		}

	}
}
