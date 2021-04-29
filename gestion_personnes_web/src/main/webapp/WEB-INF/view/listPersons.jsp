<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<title>registration form</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6"
	crossorigin="anonymous">

<style>
h3 {
	margin-top: 20px;
}
</style>


</head>
<body>
	<div class="container">

		<nav class="navbar navbar-expand-lg navbar-light bg-light">
			<div class="container-fluid">

				<div class="collapse navbar-collapse" id="navbarNav">
					<ul class="navbar-nav">
						<li class="nav-item"><a class="nav-link active"
							aria-current="page"
							href="${pageContext.request.contextPath}/showForm">Home</a></li>
						<li class="nav-item"><a class="nav-link"
							href="${pageContext.request.contextPath}/showForm">Add Person</a></li>
						<li class="nav-item"><a class="nav-link"
							href="${pageContext.request.contextPath}/managePersons">Manage
								Persons</a></li>



					</ul>
				</div>
			</div>
		</nav>


		<div>
			<f:form action="searchPerson" method="POST" modelAttribute="personModel">

				<div class="row">
			
					<div class="col">
						<label>First Name</label>
						<f:input path="firstName" type="text" class="form-control"
							placeholder="First Name" />
					</div>
				</div>
			</f:form>
		</div>


		<div>
			<h3>List of Persons</h3>
		</div>

		<div>

			<table class="table">
				<thead>
					<tr>
						<th scope="col">National Id Number</th>
						<th scope="col">First Name</th>
						<th scope="col">Last Name</th>
						<th scope="col">Email</th>
						<th scope="col">Age</th>
						<th scope="col">Community</th>
						<th scope="col">Actions</th>
					</tr>
				</thead>
				<c:forEach items="${personList}" var="p">
					<tr>
						<td><c:out value="${p.nationalIdNumber}" /></td>
						<td><c:out value="${p.firstName}" /></td>
						<td><c:out value="${p.lastName}" /></td>
						<td><c:out value="${p.email}" /></td>
						<td><c:out value="${p.age}" /></td>
						<td>
							<ul>
								<c:forEach items="${p.community}" var="c">
									<li><c:out value="${c}" /></li>
								</c:forEach>
							</ul>
						</td>

						<td>
							<ul>
								<li><a href="deletePerson/${p.idPersonne}">Delete</a></li>

								<li><a href="updatePersonForm/${p.idPersonne}">Update</a></li>
							</ul>
						</td>

					</tr>

				</c:forEach>

			</table>
		</div>
	</div>
</body>
</html>