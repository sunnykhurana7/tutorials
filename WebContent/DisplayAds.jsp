<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="java.util.Date" 
    %>


<html>
<head>
<title>Display Ads Section</title>
</head>
<body>
<p> Dear User Welcome To Our Ads Display Section</p>
<p>We got your request : 
<!--
JSP Elements : 
1. Scriptlet
 -->
<%
	Date currentdtime = new Date();

%>

<%--
2. Expression Syntax
 --%>
<%@ include file="DateTime.jsp" %>
<br/>
<%--
3. Declarative Syntax
 --%>
 <%!
 	int i = 10;
 
 %>
 <br/>
 <%= i %>
 








</body>
</html>