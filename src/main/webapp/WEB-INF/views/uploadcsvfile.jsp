<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">
<body>
						
	<h2>Upload your CSV File</h2>
					
	<form action="/bulkproductuploadcsv" method="post" enctype="multipart/form-data">
	  <input type="file" name="file" id="txtFileUpload" accept=".csv" />
	  <p><button type="submit">Upload</button>
	</form>
	
</body>
</html>