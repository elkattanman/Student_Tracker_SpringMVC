<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>

<html>

<head>
<title>List Customers</title>

<!-- reference our style sheet -->

<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css" />

</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>SRM - Students Relationship Manager</h2>
		</div>
	</div>

	<div id="container">

		<div id="content">

			<!-- put new button: Add Customer -->

			<input type="button" value="Add Student"
				onclick="window.location.href='showFormForAdd'; return false;"
				class="add-button" />
			<!--  add our html table here -->

			<table>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Action</th>
				</tr>

				<!-- loop over and print our customers -->
				<c:forEach var="tempstudent" items="${students}">
					<c:url var="updateLink" value="/student/showFormForUpdate">
						<c:param name="studentId" value="${tempstudent.id}" />
					</c:url>
					<tr>
						<td>${tempstudent.firstName}</td>
						<td>${tempstudent.lastName}</td>
						<td>${tempstudent.email}</td>
						<td><a href="${updateLink}">Update</a></td>
					</tr>

				</c:forEach>

			</table>

		</div>

	</div>


</body>

</html>









