

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/GetdataServlet")
public class GetdataServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	 {
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		HttpSession session=request.getSession(false);  
        if(session!=null)
        {  
        	String user=(String)session.getAttribute("username");  
            pw.print("<h1 align='center'>Welcome, " + user + " Continue with your transactions</h1>");
			Connection con = null;
			try
			{
				con=DBConnection.get();
				int num=Integer.parseInt(request.getParameter("num"));
				
				String query= "select* from account where num=?";
				PreparedStatement ps= con.prepareStatement(query);
				ps.setInt(1, num);
			 
				ResultSet rs= ps.executeQuery();
					   if(rs.next())
					   {
						 pw.println("<html>");
						 pw.println("<body>");
						 pw.println("<form action='Update' method='post'>");
						 pw.println  ("Account num:");
						    		  pw.println ("<input type='text' value='"+rs.getInt(1)+"' name='num'/>");
						    		  pw.println("<br/>");  
						    		  pw.println("<input type='text' value='"+rs.getString(2)+"' name='name'/>");
						    		  pw.println("<br/>");
						    		  pw.println ("<input type='text' value='"+rs.getInt(3)+"' name='balance'/>");
						    		  pw.println("<br/>");
				
						    
						    		  pw.println ("</form>");
						    		  pw.println("</body>");
						    		  pw.println("</html>");
						 
					   }
		  
				else
				{
					pw.print("<h3 align='center'>No such records - Try Again</h3>");  
			        request.getRequestDispatcher("/User.jsp").include(request, response);  
				}
				}
			
			catch(Exception e)
			{
				pw.print("<h3 align='center'>No such record - Try Again</h3>");  
				request.getRequestDispatcher("/User.jsp").include(request, response);
			}
			finally
			{
				if(con != null)
				{
					try 
					{
						con.close();
					} 
					catch (SQLException e) {}
				}
			}
        }
        else
        {
        	 pw.print("<h3>You logged out from previous Session - Please Login</h3>");  
             request.getRequestDispatcher("Login.jsp").include(request, response);  
        }
			
        
	 }
}


