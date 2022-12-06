package AddToCart;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



	@WebServlet("/cartlink")
	public class AtCa extends HttpServlet{
		String[] productList= {"AC","TV","FRIDGE","FAN"};
		double[] priceList= {50000.12, 25000.45, 45000.48, 40000.45};
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
			PrintWriter pw=resp.getWriter();
		    String[] data=req.getParameterValues("product");
			double sum = 0.0;
			for (int a=0;a<data.length;a++)
			for (int b=0;b<productList.length;b++) {
				if(data[a].equalsIgnoreCase(productList[b])) {
					double cost = priceList[b];
					pw.print("<h1>"+data[b]+":"+cost);
					sum+=cost;
				}
				
			}
			req.setAttribute("total", sum);
			RequestDispatcher rd=req.getRequestDispatcher("nextlink");
			rd.forward(req, resp);
		}
			
	}

