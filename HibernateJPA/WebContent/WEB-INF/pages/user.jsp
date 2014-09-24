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
		<form:form action="saveuser" method="post" >
			<table border="0">
				<tr>
					<td colspan="2" align="center"><h2>Spring MVC Form Demo - Registration</h2></td>
				</tr>
				<tr>
					<td>FirstName:</td>
					<td>
						<form:input path="firstName" />
						<form:errors path="firstName" cssClass="error" />
					</td>
				</tr>
				<tr>
					<td>LastName:</td>
					<td><form:password path="lastName" />
						<form:errors path="lastName" cssClass="error" />
					</td>
				</tr>
				<tr>
					<td>Role:</td>
					<td><form:input path="role" />
						<form:errors path="role" cssClass="error" />
					</td>
				</tr>
				<tr>
					<td>Region:</td>
					<td><form:input path="region" />
						<form:errors path="region" cssClass="error" />
					</td>
				</tr>
				<tr>
					<td>SalesForceId:</td>
					<td><form:input path="salesForceId" />
						<form:errors path="salesForceId" cssClass="error" />
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit" value="Save" /></td>
				</tr>
			</table>
		</form:form>
	</div>
</body>
</html>