package formValidation;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.spi.DirStateFactory.Result;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/jdbcserlink")
public class loginValidation extends HttpServlet {
static Connection conn;

@Override
	public void init() throws ServletException{
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
	    conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql\",\"root\",\"Sql@12345"); 
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
  @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String user = req.getParameter("username");
	String pass = req.getParameter("password");
	PrintWriter pw = resp.getWriter();
	
	String query = "select * from Login_data where username=? and password=?";
	try {
		PreparedStatement pstmt = conn.prepareStatement(query);
		pstmt.setString(1, user);
		pstmt.setString(2, pass);
		
	    ResultSet  rs = pstmt.executeQuery();
	    while(rs.next())
	    {
	    	if(rs.getString("name").equals(user) && rs.getString("pass").equals(pass))
	    	{
	    		pw.print("<h1>Login Sucessful</h1>"+user);
	    	}
	    	else
	    	{
	    		pw.print("<h2>Login not Sucessful</21>"+pass);

	    	}
	    }
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  }
}
