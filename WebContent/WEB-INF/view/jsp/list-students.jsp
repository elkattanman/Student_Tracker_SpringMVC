<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html>

<head>
<title>List Students</title>

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

			<!-- put new button: Add Student -->

			<input type="button" value="Add Student"
				onclick="window.location.href='showFormForAdd'; return false;"
				class="add-button" />

			<!--  add a search box -->
			<form:form action="search" method="GET">
				Search Student: <input type="text" name="theSearchName" />
				<input type="submit" value="Search" class="add-button" />
			</form:form>
			<!--  add our html table here -->

			<table>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Action</th>
				</tr>

				<!-- loop over and print our Students -->
				<c:forEach var="tempstudent" items="${students}">
					<c:url var="updateLink" value="/student/showFormForUpdate">
						<c:param name="studentId" value="${tempstudent.id}" />
					</c:url>
					<!-- construct an "delete" link with Student id -->
					<c:url var="deleteLink" value="/student/delete">
						<c:param name="studentId" value="${tempstudent.id}" />
					</c:url>
					<tr>
						<td>${tempstudent.firstName}</td>
						<td>${tempstudent.lastName}</td>
						<td>${tempstudent.email}</td>
						<td><a href="${updateLink}">Update</a> | <a
							href="${deleteLink}"
							onclick="if (!(confirm('Are you sure you want to delete this Student?'))) return false">Delete</a>
						</td>
					</tr>

				</c:forEach>

			</table>

		</div>

	</div>


</body>

</html>









