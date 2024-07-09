package controller;
import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Model.Palindrome;

/**
 * Servlet implementation class PalindromServ
 */
@WebServlet("/PalindromServ")
public class PalindromServ extends HttpServlet {
	public void service(HttpServletRequest req,HttpServletResponse res) throws IOException {
		int num=Integer.parseInt(req.getParameter("num"));
		int result =Palindrome. isPalindrome(num);
		PrintWriter pw = res.getWriter();
		if(num==result) {
			pw.println(num+" is a palindrome number ....");
		}
		else {
			pw.println("OOPS!.. "+num+" is not a palindrome number !!...");
		}
	}

}
