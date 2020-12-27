<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">

<style>
	table, td, th {  
	  border: 1px solid #ddd;
	  text-align: left;
	}
	
	table {
	  border-collapse: collapse;
	  width: 100%;
	}
	
	th, td {
	  padding: 15px;
	}
	
	body {
	  font-family: Arial, Helvetica, sans-serif;
	  background-color: black;
	}

	* {
	  box-sizing: border-box;
	}

	/* Add padding to containers */
	.container {
	  padding: 10px;
	  background-color: white;
	}

/* Set a style for the submit button */
.btn{
  background-color: #5F9EA0;
  color: white;
  padding: 10px 10px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 100%;
  opacity: 0.9;
}
.add-btn{
  background-color: #5F9EA0;
  color: white;
  padding: 10px 10px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 10%;
  opacity: 0.9;
}
.upload-csv-btn{
  background-color: #5F9EA0;
  color: white;
  padding: 10px 10px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 10%;
  opacity: 0.9;
}


.btn:hover {
  opacity: 10;
}

/* Set a grey background color and center the text*/
.add {
  background-color: #f1f1f1;
  text-align: center;
}

</style>

<body>

    <div class="container">

	     <h1>All Products</h1>

        <table class="table table-striped">
            <thead>
                <tr>
                	
                    <th>ProductID</th>
                    <th>Name</th>
                    <th>Description</th>
                    <th>Price</th>
                    <th>Discount</th>
                    <th>Quantity</th>
                    <th>DateOfExpiry</th>
                    <th>Vendor</th>
                    <th>Category</th>
                    <th>Update</th>
                    <th>Delete</th>
                </tr>
            </thead>

            <c:forEach var="product" items="${products}">
                <tr>
                <td>${product.id}</td>
                <td>${product.name}</td>
                <td>${product.description}</td>
                <td>${product.price}</td>
                <td>${product.discount}</td>
                <td>${product.quantity}</td>
                <td>${product.dateOfExpiry}</td>
                <td>${product.vendor}</td>
                <td>${product.categoryName}</td>
                <td>
                  
                  <spring:url value="/updateproduct/${product.id}" var="updateUrl" />
                  <button class="btn btn-primary" 
                                          onclick="location.href='${updateUrl}'">Update</button>
                 </td>
                 <td>                       
                  <spring:url value="showdeleteproductform/${product.id}" var="deleteUrl" /> 
                  <button class="btn btn-info" onclick="location.href='${deleteUrl}'">Delete </button>
        		 
        		 </td>
                </tr>
            </c:forEach>
        </table>
        <spring:url value="showaddproductform" var="addUrl" />
        <button class="add-btn btn-info" onclick="location.href='${addUrl}'">Add New Product</button>
        <button class="upload-csv-btn btn-info" onclick="location.href='csvfileuploadform'">Upload product list</button>
    </div>
   
</body>
</html>