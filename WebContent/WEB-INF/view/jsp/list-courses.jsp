<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

<head>
	<title>List Courses</title>
	
	<!-- reference our style sheet -->

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css" />

</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>CLM - Courses List Manager</h2>
		</div>
	</div>
	
	<div id="container">
	
		<div id="content">
		
			<!-- put new button: Add Customer -->
			<input type="button" value="Add Course"
				   onclick="window.location.href='showFormForAdd'; return false;"
				   class="add-button"
			/>
			
			<!--  add our html table here -->
		
			<table>
				<tr>
					<th>ID</th>
					<th>Title</th>
					
				</tr>
				
				<!-- loop over and print our customers -->
				<c:forEach var="tempCourse" items="${courses}">
				
					<tr>
						<td> ${tempCourse.id} </td>
						<td> ${tempCourse.title} </td>
					</tr>
				
				</c:forEach>
						
			</table>
				
		</div>
	
	</div>
	

</body>

</html>









