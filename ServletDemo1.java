package ServletChain;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/firstlink")
public class ServletDemo1 extends HttpServlet {
  @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
	  PrintWriter pw = resp.getWriter();

	  pw.print("<h1 style='color:red'>RESPONSE FROM First SERVLET</h1>");
      RequestDispatcher rd=req.getRequestDispatcher("sevlet2");  

	  rd.include(req,resp);
	}
}
