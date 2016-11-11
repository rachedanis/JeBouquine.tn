<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<div align="center">
	
	<table border="0" width="90%">
		<form:form action="register2" commandName="register2Form">
			<tr>
				<td align="left" width="20%">Enter your Login:</td>
				<td align="left" width="40%"><form:input path="login" size="30" /></td>
				<td align="left"><form:errors path="login" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Enter your Password:</td>
				<td><form:password path="password" size="30" /></td>
				<td><form:errors path="password" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Confirm your Password:</td>
				<td><form:password path="password1" size="30" /></td>
				<td><form:errors path="password1" cssClass="error" /></td>
			</tr>
			<tr>
				<td></td>
				<td align="center"><input type="submit" value="Register" /></td>
				<td></td>
			</tr>
		</form:form>
	</table>
</div>