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


			<h1>Recherche multi-critères</h1>
			<s:actionerror theme="bootstrap" />
			<s:actionmessage theme="bootstrap" />
			<s:fielderror theme="bootstrap" />
			<s:form enctype="multipart/form-data" theme="bootstrap"
				cssClass="form-horizontal well" action="searchStudent">
				<div class="row">
				
				<div class="col-md-6">
						<s:textfield label="Cne" name="student.cne"
							elementCssClass="col-md-8" labelCssClass="col-md-4"
							tooltip="Entrer le Cne de l'étudiant" />
					</div>
					<div class="col-md-6">
						<s:textfield label="Nom" name="student.nom"
							elementCssClass="col-md-8" labelCssClass="col-md-4"
							tooltip="Entrer le nom de l'étudiant" />
					</div>
					<div class="col-md-6">
						<s:textfield label="Prénom" name="student.prenom"
							elementCssClass="col-md-8" labelCssClass="col-md-4"
							tooltip="Entrer le prénom de l'étudiant" />
					</div>
				</div>
				<div class="row">
					<div class="col-md-6">
						<s:select label="Genre" name="student.gender" list="{'m', 'f'}"
							elementCssClass="col-md-8" labelCssClass="col-md-4" />
					</div>
					<div class="col-md-6">
						<sj:datepicker parentTheme="bootstrap" label="Date de naissance" name="student.dateNaissance"
							cssClass="form-control" elementCssClass="col-md-8"
							labelCssClass="col-md-4" displayFormat="dd/mm/yy" showOn="focus"
							inputAppendIcon="calendar" />
					</div>
				</div>


				<div class="row">
					<div class="col-sm-offset-3 col-md-9">
						<s:submit cssClass="btn btn-primary" value="Rechercher" />
					</div>
				</div>
			</s:form>


		</div>
	</div>


</body>
</html>