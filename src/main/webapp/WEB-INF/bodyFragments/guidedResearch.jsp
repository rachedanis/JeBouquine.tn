<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div align="center">
	
	<table border="0" width="90%">
		<form:form action="guidedResearch" commandName="guidedResearchForm">
			<tr>
				<td align="left" width="20%">titre:</td>
				<td align="left" width="40%"><form:input path="titre" size="30" /></td>
				
			</tr>
			<tr>
				<td align="left" width="20%">ISBN:</td>
				<td align="left" width="40%"><form:input path="isbn" size="30" /></td>
				
			</tr>
			<tr>
				<td>autheur:</td>
				<td><form:password path="nom_autheur" size="30" /></td>
				
			</tr>
			<tr>
				<td>editeur:</td>
				<td><form:password path="nom_editeur" size="30" /></td>
				
			</tr>
			
			<tr>
				<td></td>
				<td align="center"><input type="submit" value="search" /></td>
				<td></td>
			</tr>
		</form:form>
	</table>
</div>