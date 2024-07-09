package myfirst_pro;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class validate {
	
	public static boolean isvalidate(int id)
	{	boolean check=false;
		String str="select username from  userdetails  where user=?";
		try {
			Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/vsb","root","Sabesh@9080");
			PreparedStatement ps = cn.prepareStatement(str);
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				check = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return check;
		
	}
}
