<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<title>Insert title here</title>
</head>
<body>

<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>

	<script>
		Swal.fire({
			position : 'center',
			icon : 'success',
			title : '修改成功 ! !',

			showConfirmButton : false,
			timer : 3000
		})

		window.setTimeout(function() {
			location.href = "./afterUpdateData";
		}, 1000);
	</script>

</body>
</html>