<%@page import="HibernateHW.model.Book"%>
<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<title>修改資料</title>
</head>
<body>
<body>

<% 
   Book b=(Book)session.getAttribute("update");
 %>
 <h1 class="p">書籍資訊</h1>

 <form action="./HibernateServletAction.do" method="post">
 <table >
 <tr>
 	<td width="20%">書籍代號</td>
 	<td width="80%">
 	<input type="text" name="bookId" id="" value="<%=b.getId() %>"  disabled>
 	</td> 
 	
 </tr>
  <tr>
 	<td>書籍名稱</td>
 	<td>
 	<input type="text" name="bookname" id="" value="<%=b.getBookname() %>">
 	</td> 
 </tr>
 
  <tr>
  <td>書籍價錢</td>
  <td>
  <input type="text" name="price" id="" value="<%=b.getPrice() %>">
  </td> 
   </tr>
   
   
   <tr>
   <td>書籍作者</td>
   <td>
   <input type="text" name="author" id="" value="<%=b.getAuthor() %>">
   </td> 
   </tr>
   
   
 </table>
       <button name="update2" id="submit" type="submit">送出</button>
 </form>
        <button name="return" id="return" type="submit">返回</button>
 	   



  <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
  	
  
<script>

$("#submit").click(function(){

	$("input").prop("disabled",false);

	});

$("#return").click(function(){

	$(location).attr('href', 'update.jsp');

});


</script>
</body>
</html>