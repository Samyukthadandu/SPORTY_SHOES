
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ChangePassword</title>
<style type="text/css">
table, td, th {
  border: 1px solid black;
  color:green
}
table.center {
  margin-left: auto; 
  margin-right: auto;
}
</style>
</head>
<body>
<form action ="dashboardpage" method="post" >
<button class="button button1" type="submit" name="b1" value="dash">DashBoard</button>
</form>
<div align="center">
		<h1>Change Password</h1>
		<table align="center">
			<form:form action="/SportyShoes/save" method="post" modelAttribute="user">
			<form:hidden path="userId"/>
			<tr>
				<td></td>
				<td><form:hidden path="userName" /></td>
			</tr>
			<tr>
				<td>NewPassword:</td>
				<td><form:input path="userPassword"/></td>
			</tr>			
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="Save">
				</td>
			</tr>			
			</form:form>
		</table>
	</div>
</body>
</html>