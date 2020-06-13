<!--  
 *
 * @author PhucTV7
 *
 * Version 1.0
 *
 * @date 06/06/2020
 *
 * Copyright
 *
 */
-->

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page session="false"%>
<!DOCTYPE >
<html>
<head>
<title>Error</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<div class="container">
		<div class="text-center">
			<div class="error-server">
				<h2 style="color: red">${errorCode}</h2>
				<p style="color: red">${errorMessage}
					<a class="btn btn-danger"
						href="${pageContext.request.contextPath}/list">Back to Home</a>
				</p>
			</div>
		</div>
	</div>

</body>
</html>