<%@page import="HibernateHW.model.Book"%>
<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<title>修改資訊如下</title>
</head>
<body>

<% 
   Book b=(Book)session.getAttribute("updateBook");
 %>
 <h1 class="p">書籍資訊</h1>

 <form  action="./HibernateServletAction.do" method="post">
 <table >
 <tr>
 	<td width="20%">書籍代號</td>
 	<td width="80%">
 	<input type="text" name="updateid" id="" value="<%=b.getId() %>" disabled>
 	</td> 
 	
 </tr>
  <tr>
 	<td>書籍名稱</td>
 	<td>
 	<input type="text" name="bookname" id="" value="<%=b.getBookname() %>" disabled>
 	</td> 
 </tr>
 
  <tr>
  <td>書籍價錢</td>
  <td>
  <input type="text" name="price" id="" value="<%=b.getPrice() %>" disabled>
  </td> 
   </tr>
   
   
   <tr>
   <td>書籍作者</td>
   <td>
   <input type="text" name="author" id="" value="<%=b.getAuthor() %>" disabled>
   </td> 
   </tr>
   
   
 </table>
 	    <button name="update" id="update" type="submit">返回</button>
 	   

 </form>
       <button name="confirm" id="confirm" type="submit">確定</button>

  

  <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script>

$("#update").click(function(){

	$("input").prop("disabled",false);

	});


$("#confirm").click(function(){

	$(location).attr('href', 'updateSuccess.jsp');

	});


</script>
</body>
</html>