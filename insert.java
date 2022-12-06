package test2;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/addemployee")
public class insert extends HttpServlet{
Connection con=null;
@Override

	public void init() throws ServletException {
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql","root","Sql@12345");

	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		// TODO Auto-generated method stub
	
	}
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
// fetch html form data

String name=req.getParameter("empname");
String salary=req.getParameter("empsalary");
double sal=Double.parseDouble(salary);
String desg=req.getParameter("empdesg");


PreparedStatement pstmt=null;
String query="insert into empweb values(?,?,?)";

try {
  
pstmt=con.prepareStatement(query);
pstmt.setInt(1, 0);
pstmt.setString(2, name);
pstmt.setDouble(3, sal);
pstmt.setString(4, desg);
pstmt.executeUpdate();

PrintWriter pw=resp.getWriter();
pw.print("<h1>EMPLOYEE DETAILS INSERTED SUCCESSUFULLY</h1>");
} catch (SQLException e) {
// TODO Auto-generated catch block
e.printStackTrace();
}

}

}
