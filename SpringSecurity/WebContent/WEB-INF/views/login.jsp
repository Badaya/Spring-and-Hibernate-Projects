<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<div xmlns:c="http://java.sun.com/jsp/jstl/core">
<jsp:include page="common/header.jsp">
	<jsp:param name="pageTitle" value="Login"/>
</jsp:include>

<h1>Please Log Into Your Account</h1>
<p>
	Please use the form below to log into your account.
</p>
<form action="j_spring_security_check" method="post">


<%-- For experimentation with an alternate checkbox name
	<input id="_remember_me" name="_remember_me" type="checkbox" value="true"/>
	<label for="_remember_me">Remember Me?</label>
	<br />
--%>
<table>
	<tr>
		<td><label for="j_username">Login</label>:</td>
		<td><input id="j_username" name="j_username" size="20" maxlength="50" type="text"/>
			 <c:if test="${not empty param.user_error}">
			      <div class="errors">
			          <c:out value="Invalid username or password entered." />
			      </div>
		      </c:if>
		       <c:if test="${not empty param.login_error}">
			      <div class="errors">
			          <c:out value="Invalid username or password entered." />
			      </div>
		      </c:if>
		</td>
	</tr>
  <tr>
    <td><label for="j_password">Password</label>:</td>
    <td><input id="j_password" name="j_password" size="20" maxlength="50" type="password"/>
    	  <c:if test="${not empty param.pwd_error}">
		      <div class="errors">
		          <c:out value="Invalid password entered." />
		      </div>
	      </c:if>
    </td>
  </tr>
  <tr>
	<td><input id="_spring_security_remember_me" name="_spring_security_remember_me" type="checkbox" value="true"/></td>
	<td><label for="_spring_security_remember_me">Remember Me?</label></td>
  </tr>
  <tr>
	 <td colspan="2" align="center"><input type="submit" value="Login"/></td>
  </tr>	
</table>
</form>

<jsp:include page="common/footer.jsp"/>

</div>