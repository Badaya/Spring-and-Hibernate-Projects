<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Registration</title>
	
	<style>
	    	body { background-color: #eee; font: helvetica; }
	    	.green { font-weight: bold; color: green; }
	    	.message { margin-bottom: 10px; }
	    	label {width:70px; display:inline-block;}
	    	input { display:inline-block; margin-right: 10px; }
	    	form {line-height: 160%; }
	    	.hide { display: none; }
	    	.error { color: red; font-size: 0.9em; font-weight: bold; }
	 </style>
    
</head>

<body>
	<div align="center">
		<form:form action="register" method="post" commandName="userForm">
			<table border="0">
				<tr>
					<td colspan="2" align="center"><h2>Spring MVC Form Demo - Registration</h2></td>
				</tr>
				<tr>
					<td>User Name:</td>
					<td>
						<form:input path="username" />
						<form:errors path="username" cssClass="error" />
					</td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><form:password path="password" />
						<form:errors path="password" cssClass="error" />
					</td>
				</tr>
				<tr>
					<td>E-mail:</td>
					<td><form:input path="email" />
						<form:errors path="email" cssClass="error" />
					</td>
				</tr>
				<tr>
					<td>Birthday (dd-MMM-yyyy):</td>
					<td><form:input path="birthDate" />
						<form:errors path="birthDate" cssClass="error" />
					</td>
				</tr>
				<tr>
					<td>Profession:</td>
					<td><form:select path="profession" items="${professionList}" />
						<form:errors path="profession" cssClass="error" />
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit" value="Register" /></td>
				</tr>
			</table>
		</form:form>
	</div>
</body>
</html>