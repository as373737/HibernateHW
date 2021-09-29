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
	書名:<input type="text" name="bookname"><br>
	作者:<input type="text" name="author"><br>
	價格:<input type="text" name="price"><br>
	
	<button type="submit" name="insert">送出</button>
</form>
</body>
</html>