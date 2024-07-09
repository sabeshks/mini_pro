

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


@WebServlet("/student_mark")
public class student_mark extends HttpServlet {
	public void service(HttpServletRequest req,HttpServletResponse res) {
		
	try {
	String sname=req.getParameter("s_name");
	int mark1=Integer.parseInt(req.getParameter("mark1"));
	int mark2=Integer.parseInt(req.getParameter("mark2"));
	String str="insert into student_mark values(?,?,?)";
	
	Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/vsb","root","Sabesh@9080");
	PreparedStatement ps=cn.prepareStatement(str);
	ps.setString(1,sname);
    ps.setInt(2, mark1);
    ps.setInt(3,mark2);
	ps.execute();
	PrintWriter pw=res.getWriter();
	PreparedStatement ps1 = cn.prepareStatement("select *from student_mark ;");
	ResultSet rs = ps1.executeQuery();
	
	pw.println("Table");
	while(rs.next())
	{
		String name= rs.getString(1);
		int mar1=rs.getInt(2);
		int mar2=rs.getInt(3);
		pw.println("Name : "+name+" mark1 : "+mar1+" mark2 : "+mar2);
	}
	}
	catch(SQLException | IOException e){
		e.printStackTrace();
	}
	
	}
}

