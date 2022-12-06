package LoginSer;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/login")
public class validation extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)  
	        throws ServletException, IOException {  
	  
	          
	    String user=req.getParameter("user");  
	    String password=req.getParameter("password");  
	          
	    if(user.equals("Ashvini") && password.equals("123") ){  
	        RequestDispatcher rd=req.getRequestDispatcher("Welcomelink");  
	        rd.forward(req,resp);  
	    }  
	    else{  
		    PrintWriter pw = resp.getWriter();  

	        pw.print("<h1 style='color:red'>INVALID LOGIN DETAILS</h1>");  
	        RequestDispatcher rd=req.getRequestDispatcher("index1.html");  
	        rd.include(req,resp);  
	    }  
	          
	    }
}