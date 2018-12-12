<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="sb" uri="/struts-bootstrap-tags"%>

<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>

<%@ taglib prefix="sjdt" uri="/struts-jquery-datatables-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Student Management App</title>
<sj:head jquerytheme="redmond" />
<sb:head />

</head>
<body>
	<div class="container">
		<div class="col-md-9">



			<h1>Enregitrer un nouvel étudiant</h1>
			<s:actionerror theme="bootstrap" />
			<s:actionmessage theme="bootstrap" />
			<s:fielderror theme="bootstrap" />
			<s:form action="addStudent" method="post" cssClass="form-horizontal"
				theme="bootstrap">

				<s:textfield label="nom" name="student.nom"
					tooltip="Entrer votre nom ici" />

				<s:textfield label="prénom" name="student.prenom"
					tooltip="Entrer votre prénom ici" />

				<sj:datepicker label="Date de naissance" cssClass="form-control"
					maxDate="-1d" displayFormat="dd/mm/yy" showOn="focus"
					inputAppendIcon="calendar" name="student.dateNaissance"
					tooltip="Entrer votre date de naissance" />

				<s:select label="Genre" name="student.gender" list="{'m', 'f'}" />

				<s:textfield label="email" name="student.email"
					tooltip="Entrer votre email ici" />

				<div class="row">
					<div class="col-sm-offset-3 col-md-9">
						<s:submit cssClass="btn btn-primary"
							value="Enregistrer l'étudiant" />
					</div>
				</div>
			</s:form>
		</div>
		<div class="col-md-9">


			<h2>Liste des étudiants</h2>
			<sjdt:datatables datatablesTheme="jqueryui" buttons="true"
				class="table" dom="Blfrtip" lengthMenu="[5,10,15,20]"
				pageLength="15" responsive="true" style="width:100%;">
				<caption class="ui-widget-header">Liste des étudiants</caption>
				<thead>
					<tr>
						<th>Nom</th>
						<th>Prénom</th>
						<th>Email</th>
						<th>Date naissance</th>
						<th>Genre</th>

					</tr>
				</thead>
				<tbody>
					<s:iterator value="studentList">
						<tr>
							<td>${nom}</td>
							<td>${prenom}</td>
							<td>${dateNaissance}</td>
							<td>${email}</td>
							<td>${gender}</td>

						</tr>
					</s:iterator>
				</tbody>
			</sjdt:datatables>

		</div>

	</div>

</body>
</html>