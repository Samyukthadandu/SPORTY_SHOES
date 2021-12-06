<%@page contentType="text/html" pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Product Management</title>
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
<form action ="dashboardpg" method="post" >
<button class="button button1" type="submit" name="b1" value="dash">DashBoard</button>
</form>

 <div align="center">
	        <h1>Products List</h1>
	        <h2><a href="/SportyShoes/new">Add/Edit Products</a></h2>
	        <h3><a href="/SportyShoes/category">Categorize</a></h3>	        
        	<table border="1">
	        	<th>ProductID</th>
	        	<th>ProductName</th>
	        	<th>ProductPrice</th>
	        	<th>Size</th>
	        	<th>Category</th>
	        	<th>Status</th>
	        	
				<c:forEach var="product" items="${productList}" varStatus="status">
	        	<tr>
	        		<td>${status.index + 1}</td>
					<td>${product.productName}</td>
					<td>${product.productPrice}</td>
					<td>${product.size}</td>
					<td>${product.category}</td>
					<td>${product.status}</td>
					<td>
						<a href="edit?productID=${product.productID}">Edit</a>
						&nbsp;&nbsp;&nbsp;&nbsp;
						<a href="delete?productID=${product.productID}">Delete</a>
					</td>
	        	</tr>
				</c:forEach>	        	
        	</table>
        </div>

</body>
</html>