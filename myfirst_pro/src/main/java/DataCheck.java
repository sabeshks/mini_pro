

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/DataCheck")
public class DataCheck extends HttpServlet {
	public void service(HttpServletRequest req,HttpServletResponse res)
	{
		try {
			int id= Integer.parseInt(req.getParameter("id"));
			String name=req.getParameter("name");
			String str = "select* from employee where E_if=? and E_name=? ";
			Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/vsb","root","Sabesh@9080");
			PreparedStatement ps=cn.prepareStatement(str);
			ps.setInt(1,id);
			ps.setString(2,name);
			PrintWriter pw=res.getWriter();
			pw.println("check for data");
			ResultSet rs=ps.executeQuery();
			if (rs.next()) {
                pw.println("<p>Data found in the database: " + id + name + "</p>");
            } else {
                pw.println("<p>Data not found in the database.</p>");
            }
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}
	}


