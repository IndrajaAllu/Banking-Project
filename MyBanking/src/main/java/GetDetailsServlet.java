

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/GetDetailsServlet")
public class GetDetailsServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		PrintWriter pw = response.getWriter();
		int accountNumber=Integer.parseInt(request.getParameter("accountNumber"));
		
		try
		{
			Connection con=DBConnection.get();
			
			String query="SELECT name FROM account WHERE num=?";
			PreparedStatement ps= con.prepareStatement(query);
			ps.setInt(1,accountNumber);
			
			ResultSet rs=ps.executeQuery();
			
			if(rs.next())
			{
				String name =rs.getString("name");
				request.setAttribute("accountname",name);
				request.getRequestDispatcher("/update.jsp").forward(request, response);
			}
			else
			{
				pw.println("Account Not found");
				request.getRequestDispatcher("/User.jsp").include(request, response);
			}
			rs.close();
			ps.close();
			con.close();
		}
		catch(Exception e)
		{
			pw.println("Error:" +e.getMessage());
		}
	}

}
