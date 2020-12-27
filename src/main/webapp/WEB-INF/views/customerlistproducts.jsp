<%@ page session="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
	  width: 90%;
	}
	
	th, td {
	  padding: 10px;
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
	  padding: 15px;
	  background-color: white;
	}

/* Set a style for the submit button */
.search-btn{
  background-color: #5F9EA0;
  color: white;
  padding: 10px 10px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 10%;
  opacity: 0.9;
}
.add-tocart-btn{
  background-color: #5F9EA0;
  color: white;
  padding: 10px 10px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 100%;
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
	     
	    <p>
          <label>Search by product or category : </label>
          <form method="get" action="/searchproduct">
          <input type = "text"
                 id = "searchText" name="q"
                 value = "" />
                <input type="submit" value="Submit">
          </form>
               
        </p>
        
        <table class="table table-striped">
            <thead>
                <tr>
                	
                    <th>ProductID</th>
                    <th>Name</th>
                    <th>Description</th>
                    <th>Price</th>
                    <th>Discount</th>
                    <th>Available Quantity</th>
                    <th>Date Of Expiry</th>
                    <th>Vendor</th>
                    <th>Category</th>
                    <th>Quantity</th>
                    <th>Cart</th>
                </tr>
            </thead>

            <c:forEach var="product" items="${products}" varStatus="status">
                <tr>
               <form:form class="form-horizontal" method="post"
                			modelAttribute="cartItems"
                			action="/savecartitem">
                	<!--  <input name="cartItems[${status.index}].productId" value="${product.id}" type="hidden"/> -->
                	
                	<input name="productId" value="${product.id}" type="hidden"/>
                  
                  <%--<form:form class="form-horizontal" method="post"
                			modelAttribute="cartItem"
                			action="/savecartitem">
                	<input name="cartItem.productId" value="${product.id}" type="hidden"/>--%>
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
                     <!--  <input name="cartItems[${status.index}].quantity" type="text"/> -->
                     
                     <input name="quantity" type="text"/>
                     <!-- <input name="cartItem.quantity" type="text"/>-->
                </td>
                <td>     
                	
                  <button class="add-tocart-btn btn-info" type="submit">Add to cart </button>
        		 
                 </td>
                </form:form></tr>
            </c:forEach>
        </table>
        </div>
   
</body>
</html>