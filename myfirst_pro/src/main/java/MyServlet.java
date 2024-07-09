
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



@WebServlet("/MyServlet")
public class MyServlet extends HttpServlet {
	public void service(HttpServletRequest req,HttpServletResponse res)
	{			
		PrintWriter pw;
			try {
				Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/vsb","root","Sabesh@9080");
				PreparedStatement ps = cn.prepareStatement("select*from employee");
				ResultSet rs = ps.executeQuery();
				pw=res.getWriter();
				pw.println("Table");
				while(rs.next())
				{
					int a=rs.getInt(1);
					String str=rs.getString(2);
					int salary=rs.getInt(3);
					int age=rs.getInt(4);
					String gender=rs.getString(5);
					String doj=rs.getString(6);
					pw.println(a+" "+str+" "+salary+" "+age+" "+gender+" "+doj);
				}
			} catch (SQLException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}
