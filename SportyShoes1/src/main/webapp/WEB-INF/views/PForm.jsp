<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta charset="UTF-8">
<title>Product Editing</title>

<style>
table {
  border-collapse: collapse;
  width: 100%;
}

th, td {
  text-align: left;
  padding: 8px;
}

tr:nth-child(even){background-color: #f2f2f2}

th {
  background-color: #04AA6D;
  color: white;
}
</style>
</head>
<body>

<div align="center">
		<h1>New/Edit Product</h1>
		<table>
			<form:form action="saving" method="post" modelAttribute="product">
			<form:hidden path="productID"/>
			<tr>
				<td>ProductName:</td>
				<td><form:input path="productName"/></td>
			</tr>
			<tr>
				<td>ProductPrice:</td>
				<td><form:input path="productPrice"/></td>
			</tr>
			<tr>
				<td>Size:</td>
				<td><form:input path="size"/></td>
			</tr>
			
			<tr>
				<td>Category:</td>
				<td><form:input path="category"/></td>
			</tr>
			<tr>
				<td>Status:</td>
				<td><form:input path="status"/></td>
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