

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/hello")
public class hello extends HttpServlet {
	public void service(HttpServletRequest req,HttpServletResponse res)
	{
	
		try {
			int num1 =Integer.parseInt(req.getParameter("f1")) ;
			int num2 =Integer.parseInt(req.getParameter("f2")) ;
			int result = num1 + num2;
			PrintWriter pw=res.getWriter();
			pw.print(result);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
