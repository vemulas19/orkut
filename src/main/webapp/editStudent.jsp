<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">
function update()
{
	document.forms[0].action="${pageContext.request.contextPath}/updateStudent";
	document.forms[0].submit();
}

</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="" name="studForm" method="post" />
	UserName : <input type="text" name="name" value="${student.name}" /> </br>
	Password : <input type="password" name="password" value = "${student.password}"/></br>
	Email Id : <input type="text" name="mail" value = "${student.mail}"/></br>
	<input type="button" value="Update" onclick="update()"/>
	<input type="button" value="Delete" />

	</form>

</body>
</html>