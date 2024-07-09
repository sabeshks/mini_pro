

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.protocol.Resultset;

import myfirst_pro.validate;

/**
 * Servlet implementation class EmpCredentialServlet
 */
@WebServlet("/EmpCredentialServlet")
public class EmpCredentialServlet extends HttpServlet {
	public  void service(HttpServletRequest req,HttpServletResponse res)
	{
		int id=Integer.parseInt(req.getParameter("id"));
		boolean check=validate.isvalidate(id);
		if(check)
		{
		String str="select E_name,salary,age,gender,D_O_J from employee where E_id=?";
		try {
			Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/vsb","root","Sabesh@9080");
			PreparedStatement ps = cn.prepareStatement(str);
			ps.setInt(1,id);
			ResultSet rs = ps.executeQuery();
			try {
				PrintWriter pw = res.getWriter();
					while(rs.next()) {
					String str1=rs.getString(1);
					int salary=rs.getInt(2);
					int age=rs.getInt(3);
					String gender=rs.getString(4);
					String doj=rs.getString(5);
					pw.println("e_name :  "+str1+" salary : "+salary+" age : "+age+" gender : "+gender+" date_of_joining : "+doj);
					}
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		else
		{
	RequestDispatcher rd = req.getRequestDispatcher("employeeCredential.html");
		}
	}

	
}
