<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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

			<!-- put new button: Add Customer -->
		
			<input type="button" value="Add Instructor"
				   onclick="window.location.href='showFormForAdd'; return false;"
				   class="add-button"
			/>
			
			<!--  add our html table here -->

			<table>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Youtoube Channel</th>
					<th>Hobby</th>
				</tr>

				<!-- loop over and print our customers -->
				<c:forEach var="tempIns" items="${instructors}">

					<tr>
						<td>${tempIns.firstName}</td>
						<td>${tempIns.lastName}</td>
						<td>${tempIns.email}</td>
						<td>${tempIns.instructorDetail.youtubeChannel}</td>
						<td>${tempIns.instructorDetail.hobby}</td>
					</tr>

				</c:forEach>

			</table>

		</div>

	</div>


</body>

</html>









