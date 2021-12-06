<%@page contentType="text/html" pageEncoding="UTF-8" isELIgnored="false" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>UserLogin</title>
<style type="text/css">
h1 { 
  display: block;
  font-size: 3em;
  margin-top: 0.67em;
  margin-bottom: 0.67em;
  margin-left: 0;
  margin-right: 0;
  font-weight: bold;
  text-align:center;
  background-color:yellow;
}
</head>
<body>

background-color: Lightcyan;
}
td{
   width:50px;
   height:50px;
}

tbody tr td:first-child{
   text-align:right;
   padding-right:7px;
   padding-left:7px;
}
table.center {
  margin-left: auto; 
  margin-right: auto;
}



</style>
</head>
<body>
<i class="glyphicon glyphicon-user" style="font-size:60px;color:black;"></i>

<h1>Sporty Shoes</h1>
<form action = "validate" method="post" modelAttribute="users">
            <fieldset style="width:50%;height:50%; background-color:Lavender; margin:  0px auto;">
                <h2><center> Admin Login</center></h2>
                <hr>
                <table class=center>
                    <tr>
                        <td>UserName:</td>
                        <td> <input type = "text" style="height:35px;font-size:14pt;" name = "t1"></td>
                    </tr>
                    <tr>
                        <td>Password:</td>
                        <td><input type = "password" style="height:35px;font-size:14pt;" name = "t2"></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><input type = "submit" style="height:35px;font-size:14pt;background-color: LightGrey;" value="SUBMIT" name = "s1"></td>
                    </tr>
                </table>
            </fieldset>
                    </form>
        <br><br><br>
        <div align="center">
                   ${Invalid}
            </div>
            
            
            

</body>
</html>