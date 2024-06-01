

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/DepositAmountServlet")
public class DepositAmountServlet extends HttpServlet 
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
				int amount=Integer.parseInt(request.getParameter("amount"));
				
				String query = "update account set balance=balance+? where num=?";
				PreparedStatement ps = con.prepareStatement(query);
				ps.setInt(1, amount);
				ps.setInt(2, num);
				int count =ps.executeUpdate();
				if(count>0)
				{
					pw.print("<h3 align='center'> Amount Deposited Successfully</h3>");  
			        RequestDispatcher rd=request.getRequestDispatcher("/User.jsp");  
			        rd.include(request, response);  
				}
				else
				{
					pw.print("<h3 align='center'>Invalid account number - Try Again</h3>");  
			        request.getRequestDispatcher("/User.jsp").include(request, response);  
				}
			}
			catch(Exception e)
			{
				pw.print("<h3 align='center'>Invalid Account Number - Try Again</h3>");  
				request.getRequestDispatcher("/User.jsp").include(request, response);
			}
			finally
			{
				if(con != null)
				{
					try {
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
