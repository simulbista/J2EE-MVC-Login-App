//EmployeeDAO.java - access database
package week12ga;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class EmployeeDAO {
	Connection conn;

	public EmployeeDAO() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			String dburl = "jdbc:mysql://localhost:3306/W11_simul";
			String uname = "root";
			String pass = "root";
			conn = DriverManager.getConnection(dburl, uname, pass);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// crud operations

	// insert records into the db
	public String[] getUserRecord(EmployeeModel empModel) throws Exception {
		String resultArray[] = new String[2];
		String selectQry = "Select username,password from USER where username = ?";
		PreparedStatement pstmt = conn.prepareStatement(selectQry);
		
		pstmt.setString(1, empModel.getUsername());
		
		ResultSet rs = pstmt.executeQuery();
		
//		using if instead of while since we know resultset will return 1 matched record only (as username in the db is unique)
		if(rs.next()) {
	        resultArray[0] = rs.getString("username");
	        resultArray[1] = rs.getString("password");
		}
		
		return resultArray;
	}
}
