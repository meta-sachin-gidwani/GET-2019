<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="/js/bootstrap-4.3.1-dist/css/bootstrap.min.css">
<title>Upload Image</title>
<script type="text/javascript">
	function changeImage() {
		var image = document.getElementById("imageList").value;
		document.getElementById("SelectedImage").value = image;
		document.getElementById("image").src = image;
	}
	function imageUpload() {
		var pic=document.getElementById("pic");
		var image = "/images/"+ pic.files.item(0).name;
		document.getElementById("uploadedImage").value = image + "";
		document.getElementById("image").src = image + "";
	}
</script>
</head>
<body>
	<div class="container">
		<h1 align="center">${welcomeMessage}</h1>

		<div class="card">
			<div class="card-header">
				<h3>Change image</h3>
			</div>
			<div class="card-body">
				<form modelAttribute="image" action="/imageUpload">
					<input name="empId" id="empId" type="hidden" value="${empId}" />
					<input name="imageSrc" id="SelectedImage" type="hidden" value="" />
					<div class="form-group">
						<input type="image" id="image" alt="no image" src="" height="70" value="">
					</div>
					<div class="form-group">
						<select id="imageList" onchange="changeImage()"
							cssClass="form-control">
							<option value="no image" disabled="disabled" selected>Select
								Image</option>
							<option value="/images/shinchan.jpg">shinchan</option>
							<option value="/images/sachin.jpg">sachin</option>
							<option value="/images/vrinda.jpg">vrinda</option>
							<option value="/images/dhoni.jpg">dhoni</option>
						</select> </br>
					</div>
					<button type="submit" class="btn btn-primary">Set Image</button>
				</form>
                </br>
				<form modelAttribute="image" action="/imageUpload">
					<input name="empId" type="hidden" value="${empId}" />
					<input name="imageSrc" id="uploadedImage" type="hidden" value="" />
					<div class="form-group">
						<input type="file" id="pic" accept="image/*" onchange="imageUpload()"> 
					</div>
					<button type="submit" class="btn btn-primary">Set Image</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>