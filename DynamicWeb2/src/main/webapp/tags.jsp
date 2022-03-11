<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<%@ page errorPage="errorpage.jsp" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>JSP TAGS INTRODUCTION</title>
	<style type="text/css">
		.content{
			margin: auto;
			align-content: center;
			max-width: 500px;
			}
	</style>
</head>
<body>
	<div class="content">
		<h3> Welcome to JSP Page</h3>
	
	
		<ul>
			<li>Scriptlet Tag</li>
			<li>Declarative Tag</li>
			<li>Expression Tag</li>
		</ul>
		
		<%-- <h3>PromoCode is: <% out.print(promoCode); %></h3>--%>
		<h3>PromoCode is: <%= promoCode %></h3>
		<h3>Discount on amount 1000 is: <%= getDiscount("JUMBO", 1000)*100 %> %</h3>
		 
		<%
			// Java Code goes here
			int age = 27;
			String name = "John Watson";
			
			if(age > 18)
			{
				//out is available implicitly in the JSP Pages,
				//which is used to write response to the Client
				//from code (PrintWriter Class)
		%>
		
				<p><b><i>You Can Vote, Dear <% out.print(name); %> </i></b></p>	
		<%	
			}
			else 
			{
		%>
				<p><b><i>You Can Not Vote</i></b>
		
		<%
			}
		%>	
		
		<%!
		
			String promoCode = "JUMBO";
			double getDiscount(String code, double amount)
			{
				if(promoCode.equals(code) && amount >= 500){
					return 0.40;
				} else {
					return 0.10;
				}
			}
			
			int [] cashBacks = {10, 20, 30, 50, 100};
		%> 
		
		<h3>CashBack Earned is: <%= cashBacks[3] %></h3>
		
		<!-- Action Tag -->
		<jsp:include page="header.jsp"/>
			
	
	
	
	</div>
</body>
</html> 