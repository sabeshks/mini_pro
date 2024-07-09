<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>HELLO</h1>
<% int num1 =Integer.parseInt( request.getParameter("num1"));
int num2 =Integer.parseInt( request.getParameter("num2"));


%>
<%! public static int add(int n1,int n2)
{
	return n1+n2;
}
%>
<h1>result is <%= add(num1,num2) %></h1>

</body>
</html>