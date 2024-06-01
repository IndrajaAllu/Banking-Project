

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


@WebServlet("/TransferAmountServlet")
public class TransferAmountServlet extends HttpServlet 
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
				con =DBConnection.get();
				int src= Integer.parseInt(request.getParameter("src"));
				int amount = Integer.parseInt(request.getParameter("amount"));
				int dest = Integer.parseInt(request.getParameter("dest"));

				String q1 = "select balance from account where num=?";
				PreparedStatement ps1 = con.prepareStatement(q1);
				ps1.setInt(1, src);
				ResultSet rs1 = ps1.executeQuery();
				if(rs1.next())
				{
					int balance = rs1.getInt(1);
					if(balance>=amount)
					{
				String q2 = "update account set balance=balance-? where num=?";
						PreparedStatement ps2 = con.prepareStatement(q2);
						ps2.setInt(1, amount);
						ps2.setInt(2, src);
						ps2.executeUpdate();
				   pw.println("<h3 style='text-align:center'>Amount deducted from source account - Login Now</h3>");
				  
				   
				String q3 = "update account set balance=balance+? where num=?";
						PreparedStatement ps3 = con.prepareStatement(q3);
						ps3.setInt(1, amount);
						ps3.setInt(2, dest);
						int count = ps3.executeUpdate();
						if(count>0)
						{
							pw.println("<h3 style='text-align:center'>Amount Transferred successfully - Login Now</h3>");
							request.getRequestDispatcher("/User.jsp").include(request, response);
							con.commit();
						}
						else
						{
							pw.print("<h3 align='center'>Destination account missing - Try Again</h3>"); 
							request.getRequestDispatcher("/User.jsp").include(request, response);
						}
					}
						else
						{
						pw.println("<h3 align='center'>Insufficient account balance in source account - Try Again</h3>");
						request.getRequestDispatcher("/User.jsp").include(request, response);
						}
					}
					else
					{
					pw.println("<h3 align='center'>Source account number is not valid - Try Again</h3>");
					request.getRequestDispatcher("/User.jsp").include(request, response);
					}
				}
				catch(Exception e)
				{
					pw.print("<h3 align='center'>No such record- Try Again</h3>");  
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


	


