<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<table>
	<tr>
		<th>Je bouquine &nbsp;&nbsp;&nbsp; <a href="home">home</a>
			&nbsp;&nbsp;&nbsp; <a href="contact">contact us</a>
		</th>
		<th>&nbsp;&nbsp;&nbsp;</th>
		<th><form:form action="home" commandName="searchKeyWord">



				<form:input path="keyWord" />
				<input type="submit" value="search" />




			</form:form></th>
		<th>&nbsp;&nbsp;&nbsp;</th>


		<th><a href="login">connect</a> &nbsp;&nbsp;&nbsp; <a
			href="register">register</a> &nbsp;&nbsp;&nbsp; <a href="panier">panier</a>
			&nbsp;&nbsp;&nbsp;<a href="MyAccount">My account</a>
		</th>
	</tr>
</table>
