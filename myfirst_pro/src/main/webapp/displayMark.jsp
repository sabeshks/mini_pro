<%@page import="org.apache.jasper.tagplugins.jstl.core.Catch"%>
<%@ page import="java.sql.*" %>
<%@ page import="javax.sql.*" %>
<%
    String studname=request.getParameter("name");
	String str = "select mark1,mark2 from student_mark where s_name=?";
	
	Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/vsb","root","Sabesh@9080");
	PreparedStatement ps = cn.prepareStatement(str);
	ps.setString(1,studname);
	ResultSet rs = ps.executeQuery();
	if(rs.next())
	{
		int mark1 = rs.getInt("mark1");
		int mark2 = rs.getInt("mark2");
		out.print("Mark1 "+mark1+" and mark2 "+mark2);
	}	
%>


