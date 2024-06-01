

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateNameServlet
 */
@WebServlet("/UpdateNameServlet")
public class UpdateNameServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		int accountNumber=Integer.parseInt(request.getParameter("accountNumber"));
		String accountName=request.getParameter("accountName");
		
		PrintWriter pw= response.getWriter();
		
		Connection con=null;
		try
		{
			con=DBConnection.get();
			String query ="update account set name =? WHERE num=?";
			PreparedStatement ps= con.prepareStatement(query);
			   ps.setString(1,accountName);
			   ps.setInt(2,accountNumber);
			     int count=ps.executeUpdate();
			     if(count>0)
			     {
			    	 pw.println("<h1>record updated successfully</h1>");
			    	 request.getRequestDispatcher("/User.jsp").include(request, response);
			     }
			     else
			     {
			    	 pw.println("<h1>failed in insertion</h1>");
			    	 request.getRequestDispatcher("/Login.jsp").include(request, response);
			     }
			     ps.close();
			     con.close();
		}
			     catch(Exception e)
			     {
			    	 pw.println("<h1>Exception : " + e.getMessage() + "</h1>");
			    	 
			     }
		 }
	}
	



