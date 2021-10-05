<%@page import="HibernateHW.model.Book"%>
<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<title>�ק��T�p�U</title>
<style type="text/css">

body {
 font-family: "�L�n������";
 background-color: rgb(203, 218, 218);
 align-items: center;
 justify-content: center;
 position: relative;
}

h1 {
 background-color: #f7f7f7;
 /* �i�D�q���I���C�� */
 padding: 18px 0 16px 22px;
 /* �i�D�q�����Z�n�h�j */
 border-left: 8px solid #33779e;
 /* �i�D�q������حn�h�e�B���C�� */
 color: #333 !important;
 /* �i�D�q����r�C�� */
 width: 300px;
}

form {
 background-color: rgb(255, 255, 255, 0.8);
 margin: 20px auto;
 max-width: 600px;
 padding: 60px 80px;
 /* border-radius: 20px; */
 box-shadow: 0 10px 10px 0 rgba(177, 175, 175, 0.2);
}

table {
 border: 1px solid rgba(147, 156, 165, 0.2);
 border-radius: 20px;
 border-collapse: collapse;
 margin: auto;
 width: 600px;
 height: 400px;
 text-align: center;
}

input, textarea, select {
 border: 1px solid rgb(155, 153, 153, 0.4);
 background-color: rgb(203, 218, 218, 0.2);
 font-size: 21px;
}

.leftSide {
 float: left;
}
    .wrap {
            text-align: center;
            margin-top: 50px;
        }

        .button {
            width: 140px;
            height: 45px;
            font-family: 'Roboto', sans-serif;
            font-size: 11px;
            text-transform: uppercase;
            letter-spacing: 2.5px;
            font-weight: 500;
            color: #000;
            background-color: #fff;
            border: none;
            border-radius: 45px;
            box-shadow: 0px 8px 15px rgba(0, 0, 0, 0.1);
            transition: all 0.3s ease 0s;
            cursor: pointer;
            outline: none;
        }

        .button:hover {
            background-color: #33779e;
            color: #fff;
            transform: translateY(-7px);
        }
        a {
	display: block;
	margin: 40px auto;
	max-width: 180px;
	text-decoration: none;
	border-radius: 4px;
	padding: 20px 30px;
}


</style>
</head>
<body>

<% 
   Book b=(Book)session.getAttribute("updateBook");
 %>
 <h1 class="p">���y��T</h1>

 <form  action="./HibernateServletAction.do" method="post">
 <table >
  <h4 style="font-size: 20px;">�нT�{�ק���</h4>
 <tr>
 	<td width="20%">���y�N��</td>
 	<td width="80%">
 	<input type="text" name="updateid" id="" value="<%=b.getId() %>" disabled>
 	</td> 
 	
 </tr>
  <tr>
 	<td>���y�W��</td>
 	<td>
 	<input type="text" name="bookname" id="" value="<%=b.getBookname() %>" disabled>
 	</td> 
 </tr>
 
  <tr>
  <td>���y����</td>
  <td>
  <input type="text" name="price" id="" value="<%=b.getPrice() %>" disabled>
  </td> 
   </tr>
   
   
   <tr>
   <td>���y�@��</td>
   <td>
   <input type="text" name="author" id="" value="<%=b.getAuthor() %>" disabled>
   </td> 
   </tr>
   
   
 </table>
 	   
 	    <a><button name="update" id="update" type="submit" class="button">��^</button></a>

 </form>
	  	<a href="updateSuccess.jsp"><button  name="confirm" id="confirm" class="button">�T�w</button></a>
  

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