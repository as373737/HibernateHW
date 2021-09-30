<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="./HibernateServletAction.do" method="post">
	BOOKID:<input type="text" name="BOOKID"><br>
	
	
	<button type="submit"  name="select">送出</button>
</form>

	<a href="./HibernateServletAction.do"><button type="submit"  name="selectALL">查詢全部</button></a>

</body>
</html>