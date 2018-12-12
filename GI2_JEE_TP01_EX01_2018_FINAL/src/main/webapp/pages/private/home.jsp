<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page import="com.ensah.bo.Message"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=windows-1256"
	pageEncoding="windows-1256"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type"
	content="text/html; charset=windows-1256">
<title>Insert title here</title>
</head>
<body>


	<h1>Welcome !</h1>

	<c:forEach var="it" items="${requestScope.messages}">
  	<p>  Message :  <c:out value="${it}" />
		</p>
	</c:forEach>

	<a href="${pageContext.request.contextPath}/private/GameServlet?action=newround">New round</a>


</body>
</html>