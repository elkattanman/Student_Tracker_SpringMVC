<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>

<html>

<head>
<title>List Instructors</title>

<!-- reference our style sheet -->

<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css" />

</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>ILM - Instructor List Manager</h2>
		</div>
	</div>

	<div id="container">

		<div id="content">

			<!-- put new button: Add Instructor -->

			<input type="button" value="Add Instructor"
				onclick="window.location.href='showFormForAdd'; return false;"
				class="add-button" />
				
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
					<th>Youtoube Channel</th>
					<th>Hobby</th>
					<th>Action</th>
				</tr>

				<!-- loop over and print our Instructors -->
				<c:forEach var="tempIns" items="${instructors}">
					<c:url var="updateLink" value="/instructor/showFormForUpdate">
						<c:param name="instructorId" value="${tempIns.id}" />
					</c:url>
					<c:url var="deleteLink" value="/instructor/delete">
						<c:param name="instructorId" value="${tempIns.id}" />
					</c:url>
					<tr>
						<td>${tempIns.firstName}</td>
						<td>${tempIns.lastName}</td>
						<td>${tempIns.email}</td>
						<td>${tempIns.instructorDetail.youtubeChannel}</td>
						<td>${tempIns.instructorDetail.hobby}</td>
						<td><a href="${updateLink}">Update</a> | <a
							href="${deleteLink}"
							onclick="if (!(confirm('Are you sure you want to delete this Instructor?'))) return false">Delete</a>
						</td>

					</tr>

				</c:forEach>

			</table>

		</div>

	</div>


</body>

</html>









