<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>

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


	<h1>Game Over</h1>

	<c:forEach var="it" items="${requestScope.messages}">
    Message :  <c:out value="${it}" />
		<p>
	</c:forEach>

		<a href="${pageContext.request.contextPath}/private/HomeServlet">Home</a>

		<a href="${pageContext.request.contextPath}/private/GameServlet?action=newround">New round</a>



</body>
</html>