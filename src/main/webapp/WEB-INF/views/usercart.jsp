<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<%--------add product style--%>
	<style>
	table, td, th {  
	  border: 1px solid #ddd;
	  text-align: left;
	}
	
	table {
	  border-collapse: collapse;
	  width: 80%;
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
/* Set a style for the submit button */
.btn-lg {
  background-color: #5F9EA0;
  color: white;
  padding: 16px 20px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 10%;
  opacity: 0.9;
}

.btn-lg:hover {
  opacity: 10;
}

</style>


<div class="container">  
       <h1>Shopping Cart</h1>
       <table class="cartatble table-striped">
            <thead>
                <tr>
                    <th>Name</th>
                    <th>Price</th>
                    <th>Discount</th>
                    <th>Quantity</th>
                    <th>Remove</th>
                </tr>
            </thead>
            <c:forEach var="cartitem" items="${usercart}">
                <tr>
                
                			
                <td>${cartitem.product.name}</td>
                <td>${cartitem.product.price}</td>
                <td>${cartitem.product.discount}</td>
                <td>
                <form:form class="form-horizontal" method="post"
                			modelAttribute="cartitem"
                			action="/updatequantity">
                			
                	<input name="quantity" value="${cartitem.quantity}" type="text"/>
                	<button class="btn btn-info" type="submit">Update</button>
                	
                	<input name="productId" value="${cartitem.product.id}" type="hidden"/>
           			<input name="quantity" value="${cartitem.quantity}" type="hidden"/>
                </form:form> 
               
                </td>
                <td>  
                	<form:form class="form-horizontal" method="post"
                			modelAttribute="cartitem"
                			action="/deletecartitem">                     
	                 <button class="deletecartitem-btn btn-info" type="submit">Remove</button>
	                 <input name="productId" value="${cartitem.product.id}" type="hidden"/>
	                 </form:form>
	                 
       		 	</td>
           			
                
                </tr>
            </c:forEach>
       </table>
            
        <div class="form-group">
          <div class="col-sm-offset-2 col-sm-10">
              <button type="submit" class="btn-lg btn-primary pull-right">Place order</button>
          </div>
        </div>
</div>
</body>
</html>