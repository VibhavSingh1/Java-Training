<%@ page import="com.thunderdrive.db.DB" %>
<%@ page import="com.thunderdrive.model.User" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>REGISTER USER</title>
	<style type="text/css">
		.content{
			margin: auto;
			align-content: center;
			max-width: 500px;
			background-color: pink;
			}
	</style>
</head>
<body>
	
	<div class="content">
			
		<%
			
			User user = new User();
			user.name = request.getParameter("txtName");
			user.email = request.getParameter("txtEmail");
			user.password = request.getParameter("txtPassword");
			
			DB db = DB.getDB();
			String sql = user.insertSQL();
			int result = db.executeUpdate(sql);
			
			if(result > 0){
	
		%>
				<h3> User Registered Successfully with Email: <%= user.email %> </h3>
				<jsp:forward page="tags.jsp"/>
				
		<% 			
			}else{
		%>
				<h3>User Not Registered</h3>
		<%
			}
		%>
	
	</div>  

</body>
</html>