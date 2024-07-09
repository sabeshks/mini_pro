

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.protocol.Resultset;

@WebServlet("/login")
public class login extends HttpServlet {

	protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException, IOException
	{	
		String user = req.getParameter("username");
		String pass=req.getParameter("password");
		PrintWriter pw = res.getWriter();
		
		RequestDispatcher rd=req.getRequestDispatcher("general.html");
		rd.include(req, res);
		if(user.equals("amos") && pass.equals("9999")){
			HttpSession hp=req.getSession();
			hp.setAttribute("un", user);
//			RequestDispatcher rp=req.getRequestDispatcher("Dashboard");
//			rd.forward(req, res);
			pw.println("login successful");	
		}
		else {
			RequestDispatcher rp=req.getRequestDispatcher("login.html");
			{
				rp.forward(req, res);
			
			}
		}
	}
		
	
}
