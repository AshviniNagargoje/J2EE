package test2;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql. *;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/displaylink")
public class display extends HttpServlet{
Connection con=null;
@Override
public void init() throws ServletException {
try {
//load mysql driver
Class.forName("com.mysql.cj.jdbc.Driver");
con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql","root","Sql@12345");
} catch (SQLException | ClassNotFoundException e) {
// TODO Auto-generated catch block
e.printStackTrace();
}
}
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
PrintWriter pw=resp.getWriter();
Statement stmt=null;
ResultSet rs=null;
String query="select * from empweb";


try {
stmt=con.createStatement();
rs=stmt.executeQuery(query);
pw.print("<table border='2'>");
pw.print("<tr>");
pw.print("<th>EMPID</th>");
pw.print("<th>EMPNAME</th>");
pw.print("<th>EMPSALARY</th>");
pw.print("<th>EMPDESG</th>");
pw.print("</tr>");

while(rs.next()) {
int id=rs.getInt(1);
String name=rs.getString(2);
double salary=rs.getDouble(3);
String desg=rs.getString(4);
pw.print("<tr>");
pw.print("<td>"+id+"</td>");
pw.print("<td>"+name+"</td>");
pw.print("<td>"+salary+"</td>");
pw.print("<td>"+desg+"</td>");
pw.print("</tr>");

}
pw.print("</table>");

} catch (SQLException e) {
// TODO Auto-generated catch block
e.printStackTrace();
}
}

}
