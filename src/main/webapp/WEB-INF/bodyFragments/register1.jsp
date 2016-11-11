<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<div align="center">
	
	<table border="0" width="90%">
		<form:form action="register1" commandName="register1Form">
			<tr>
				<td align="left" width="20%">Nom:</td>
				<td align="left" width="40%"><form:input path="nom" size="30" /></td>
				<td align="left"><form:errors path="nom" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Prenom:</td>
				<td><form:input path="prenom" size="30" /></td>
				<td><form:errors path="prenom" cssClass="error" /></td>
			</tr>
			
			<tr>
				<td>Adresse:</td>
				<td><form:input path="adresse" size="50" /></td>
				<td><form:errors path="adresse" cssClass="error" /></td>
			</tr>
			
			<tr>
				<td>Email:</td>
				<td><form:input path="email" size="30" /></td>
				<td><form:errors path="email" cssClass="error" /></td>
			</tr>
			
			<tr>
				<td>numero GSM:</td>
				<td><form:password path="numTel" size="30" /></td>
				<td><form:errors path="numTel" cssClass="error" /></td>
			</tr>
			
		
			
			
			<tr>
				<td></td>
				<td align="center"><input type="submit" value="next" /></td>
				<td></td>
			</tr>
		</form:form>
	</table>
</div>
