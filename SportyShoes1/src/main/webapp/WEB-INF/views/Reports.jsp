<%@page contentType="text/html" pageEncoding="UTF-8" isELIgnored="false" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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
 <form action ="dashpg" method="post" >
<button class="button button1" type="submit" name="b1" value="dash">DashBoard</button>
</form>
	       
	       <div align="center">
	         <h2><a href="/SportyShoes/purchase-reports">Click Here To View PurchaseOrder Reports</a></h2>
	         </div>
	       
	        <div align="center">	        
	       
        	<table border="1">
	        	<th>PurchaseID</th>	
	        	<th>Date</th>	        	
	        	<th>Category</th>
	        	<th>ProductName</th>
	        	<th>ProductPrice</th>	        	        	
	        	<th>Customer</th>	       	
	        	
				<c:forEach var="report" items="${purchasereport}" varStatus="status">
	        	<tr>
	        	    <td>${status.index + 1}</td>
	        	    <td>${report.date}</td>
					<td>${report.category}</td>
					<td>${report.productName}</td>
					<td>${report.productPrice}</td>	        	    					
					<td>${report.customer}</td> 										
	        	</tr>
				</c:forEach>	        	
        	</table>
        </div>          
       
       

</body>
</html>