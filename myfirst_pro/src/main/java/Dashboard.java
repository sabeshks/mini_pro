

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Dashboard
 */
@WebServlet("/Dashboard")
public class Dashboard extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	PrintWriter	pw=res.getWriter();
		RequestDispatcher rd=req.getRequestDispatcher("general.html");
		rd.include(req, res);
		HttpSession hp = req.getSession(false);
		if(hp !=null)
		{
			
		String name=(String)hp.getAttribute("un");
		pw.print("welcome "+name);
		}
		else
		{
			pw.print("oops's you need to login first ");		}
	}

}
