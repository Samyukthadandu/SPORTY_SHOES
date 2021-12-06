<%@page contentType="text/html" pageEncoding="UTF-8" isELIgnored="false" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">

a {
  position:Relative;
   left:15px;
  top: 20px;
  text-decoration: none;
  display: inline-block;
  padding: 8px 16px;
}

a:hover {
  background-color: #ddd;
  color: black;
}
</style>
</head>
<body>
	       
<form action ="dashboardpg" method="post" >
<button class="button button1" type="submit" name="b1" value="dash">DashBoard</button>
</form>	       
	        <div align="center">
	         <h1><a href="/SportyShoes/all-customers">Click Here To View The Signed-In Customers</a></h1>
	       
        	<table border="1">
	        	<th>cID</th>	
	        	<th>cName</th>  	
	        	      	
	 				<c:forEach var="c" items="${customers}" varStatus="status">
	        	<tr>
	        	    <td>${status.index + 1}</td>
	        	    <td>${c.cName}</td>					 										
	        	</tr>
				</c:forEach>	        	
        	</table>
        </div>         
        
        <div align="center">
		<h1>Search User And His Purchase Record</h1>
		<table>
			<form action="search" method="post" modelAttribute="customer">
			               
                <hr>
                <table class=center>
                    <tr>
                        <td>CustomerName:</td>
                        <td> <input type = "text" style="height:35px;font-size:14pt;" name = "t1"></td>
                    </tr>                   
                    <tr>
                        <td></td>
                        <td><input type = "submit" style="height:35px;font-size:14pt;background-color: LightGrey;" value="Search" name = "s1"></td>
                    </tr>
                </table>           
	</div>                   

</body>
</html>