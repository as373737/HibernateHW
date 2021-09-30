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

 <form>
 <table >
 <tr>
 	<td width="20%">書籍代號</td>
 	<td width="80%">
 	<input type="text" name="bookId" id="" value="<%=b.getId() %>" disabled>
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
 	   

 </form>
       <button name="confirm" type="submit">確定</button>
       <button name="return" type="submit">返回</button>

  

  <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script>



</script>
</body>
</html>