<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="HibernateHW.model.Book"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="./HibernateServletAction.do" method="post">
		<label>書名關鍵字</label> <input type="text" name="bookname">

		<button type="submit" name="select">送出</button>
		<button type="submit" name="selectALL">查詢全部</button>
	</form>
	<hr>
	<%  List<Book> selectAll = (List<Book>)request.getSession(true).getAttribute("resultList");
	if (selectAll != null) {  %>
			<table border="1">
			<th>編號</th>
			<th>書名</th>
			<th>作者</th>
			<th>價錢</th>
		<% for (int i = 0; i < selectAll.size(); i++) {
			Book book = selectAll.get(i);%>
			<tr>
			<td><% out.write("ID:"+book.getId()); %></td>
			<td><% out.write(book.getBookname()); %></td>
			<td><% out.write(book.getAuthor()); %></td>
			<td><% out.write("$"+book.getPrice() + "元<br>");%></td>
			<% }}request.getSession(true).removeAttribute("resultList");%>	
			</tr>
			</table>
	
	
		<%  List<Book> selectLikeName = (List<Book>)request.getSession(true).getAttribute("resultBean");
	if (selectLikeName != null) {  %>
			<table border="1">
			<th>編號</th>
			<th>書名</th>
			<th>作者</th>
			<th>價錢</th>
		<% for (int i = 0; i < selectLikeName.size(); i++) {
			Book book = selectLikeName.get(i);%>
			<tr>
			<td><% out.write("ID:"+book.getId()); %></td>
			<td><% out.write(book.getBookname()); %></td>
			<td><% out.write(book.getAuthor()); %></td>
			<td><% out.write("$"+book.getPrice() + "元<br>");%></td>
			<% }}request.getSession(true).removeAttribute("resultBean");%>	
			</tr>
			</table>
</body>
</html>