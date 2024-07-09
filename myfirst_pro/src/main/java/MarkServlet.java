import java.sql.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.Provider.Service;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MarkServlet
 */
@WebServlet("/MarkServlet")
public class MarkServlet extends HttpServlet {
	public void service(HttpServletRequest req,HttpServletResponse res) throws IOException {
		String name = req.getParameter("name");
		try {
			String str ="select mark1,mark2 from student_mark where s_name=?";
			Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/vsb","root","Sabesh@9080");
			PreparedStatement ps = cn.prepareStatement(str);
			ps.setString(1, name);
			PrintWriter pw = res.getWriter();
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				int mar1=rs.getInt("mark1");
				int mar2 = rs.getInt("mark2");
				pw.println("mark1 :"+mar1+" mark2 :"+mar2);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
