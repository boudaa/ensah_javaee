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


	<h1>Connexion</h1>


   <!-- With JSTL tags and EL  -->

	<c:forEach var="it" items="${requestScope['messages']}">
    <p>   Error (with JSTL) : <c:out value="${it}" /> </p>

	</c:forEach>


	<%
		// with Java code
		List<Message> messages = (List<Message>) request.getAttribute("messages");

		if (messages != null) {

			for (Message it : messages) {
				out.print("Error (with Java Scriplets) :" + it);
			}
		}
	%>




	<form method="post"
		action="<%=request.getServletContext().getContextPath()%>/LoginServlet">

		<label>Login</label> <input type="text" name="login"> <br />
		<label>Password</label> <input type="password" name="password">
		<br /> <input type="submit" value="Envoyer" />
	</form>



</body>
</html>