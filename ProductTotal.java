package AddToCart;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/nextlink")
public class ProductTotal extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)  
	        throws ServletException, IOException {
		double totalAmt=(double)req.getAttribute("total");
		double finalAmt=totalAmt+totalAmt*0.15;
		PrintWriter pw=resp.getWriter();
		pw.print("<h1>TOTAL AMT:"+totalAmt+"</h1>");
		pw.print("<h1>FINAL AMT:"+finalAmt+"</h1>");

	}
}