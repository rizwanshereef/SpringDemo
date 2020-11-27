<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<title>Policy Details</title>
</head>

<body onload="">
	<div class="container">
		<div class="jumbotron" style="margin: 45px 0px">
			<h2 class="text-center">Policy CRUD APP</h2>
		</div>

		<form method="POST" action="savePolicy" modelAttribute="ipData">

			<div class="form-group">
				<label for="newsid">Policy ID</label> <input type="text"
					class="form-control" id="ipId" aria-describedby="name"
					placeholder="Enter Policy ID" name="ipId">
			</div>

			<div class="form-group">
				<label for="exampleInputTitle">Policy Title</label> 
				<input type="text"
					class="form-control" id="ipTitle" aria-describedby="name"
					placeholder="Enter Policy Title" name="ipTitle">
			</div>
			
			<div class="form-group">
				<label for="exampleInputPolicyDesc">Policy Description</label> 
				<input type="text" class="form-control" id="ipDesc"
					placeholder="Enter Policy Text" name="ipDesc">
			</div>
			
			<div class="form-group">
				<label for="exampleInputPolicyPremium">Policy Premium</label> 
				<input type="text" class="form-control" id="ipPremium"
					placeholder="Enter Policy Premium" name="ipPremium">
			</div>

			<button type="submit" class="btn btn-primary">Submit</button>
		</form>


		<div style="margin-top: 1em; text-align: center">
			<h2>All POlicy Information</h2>
			<table class="table table-striped">
				<thead>
					<tr>
						<th scope="col">Policy ID</th>
						<th scope="col">Policy Title</th>
						<th scope="col">Policy Description</th>
						<th scope="col">Policy Premium</th>
					</tr>
				</thead>
				<tbody id='table-body'>
					<c:forEach items="${ipList}" var="ipObj">
						<tr>
							<td>${ipObj.ipId}</td>
							<td>${ipObj.ipTitle}</td>
							<td>${ipObj.ipDesc}</td>
							<td>${ipObj.ipPremium}</td>
							<td>Update</td>
							<td>Delete</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>

	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
		integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"
		integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T"
		crossorigin="anonymous"></script>
</body>
</html>