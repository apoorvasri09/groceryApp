<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>

<%--Style format --%>
<style>
		body {
		  font-family: Arial, Helvetica, sans-serif;
		  background-color: black;
		}
		
		* {
		  box-sizing: border-box;
		}
		
		/* Add padding to containers */
		.container {
		  padding: 16px;
		  background-color: white;
		}
		
		/* Full-width input fields */
		input[type=text], input[type=textarea] {
		  width: 40%;
		  padding: 15px;
		  margin: 5px 0 22px 0;
		  display: inline-block;
		  border: none;
		  background: #f1f1f1;
		}
		
		input[type=text]:focus, input[type=textarea]:focus{
		  background-color: #ddd;
		  outline: none;
		}
		
		/* Overwrite default styles of hr */
		hr {
		  border: 1px solid #f1f1f1;
		  margin-bottom: 25px;
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
		
		/* Set a grey background color and center the text of the "sign in" section */
		.add {
		  background-color: #f1f1f1;
		  text-align: center;
		}
				
</style>
<div class="container">

    <form:form class="form-horizontal" method="post" 
                modelAttribute="product" action="/deleteproduct">

        <%--  <form:hidden path="id" /> --%>
        
        <spring:bind path="id">
          <div class="form-group ${status.error ? 'has-error' : ''}">
            <label class="col-sm-2 control-label">Product Id</label>
            <div class="col-sm-10">
                <form:input path="id" type="text" class="form-control" 
                                id="id" placeholder="id" />
                <form:errors path="id" class="control-label" />
            </div>
          </div>
        </spring:bind>
        
        <spring:bind path="name">
          <div class="form-group ${status.error ? 'has-error' : ''}">
            <label class="col-sm-2 control-label">Product Name</label>
            <div class="col-sm-10">
                <form:input path="name" type="text" class="form-control" 
                                id="name" placeholder="Name" />
                <form:errors path="name" class="control-label" />
            </div>
          </div>
        </spring:bind>

        <spring:bind path="description">
          <div class="form-group ${status.error ? 'has-error' : ''}">
            <label class="col-sm-2 control-label">Description</label>
            <div class="col-sm-10">
                <form:input path="description" type="text" class="form-control" 
                                id="description" placeholder="description" />
                <form:errors path="description" class="control-label" />
            </div>
          </div>
        </spring:bind>

        <spring:bind path="price">
          <div class="form-group ${status.error ? 'has-error' : ''}">
            <label class="col-sm-2 control-label">Price</label>
            <div class="col-sm-10">
                <form:input path="price" type="text" class="form-control" 
                                id="price" placeholder="price" />
                <form:errors path="price" class="control-label" />
            </div>
          </div>
        </spring:bind>

        <spring:bind path="discount">
          <div class="form-group ${status.error ? 'has-error' : ''}">
            <label class="col-sm-2 control-label">Discount</label>
            <div class="col-sm-10">
                <form:input path="discount" type="text" class="form-control" 
                                id="discount" placeholder="discount" />
                <form:errors path="discount" class="control-label" />
            </div>
          </div>
        </spring:bind>

        <spring:bind path="dateOfExpiry">
          <div class="form-group ${status.error ? 'has-error' : ''}">
            <label class="col-sm-2 control-label">DateOfExpiry</label>
            <div class="col-sm-10">
                <form:input path="dateOfExpiry" type="text" class="form-control" 
                                id="pricdateOfExpirye" placeholder="dateOfExpiry" />
                <form:errors path="dateOfExpiry" class="control-label" />
            </div>
          </div>
        </spring:bind>

		<spring:bind path="quantity">
         <div class="form-group ${status.error ? 'has-error' : ''}">
            <label class="col-sm-2 control-label">Quantity</label>
            <div class="col-sm-10">
                <form:input path="quantity" type="text" class="form-control" 
                                id="quantity" placeholder="quantity" />
                <form:errors path="quantity" class="control-label" />
            </div>
          </div>
        </spring:bind>
        
		<spring:bind path="vendor">
          <div class="form-group ${status.error ? 'has-error' : ''}">
            <label class="col-sm-2 control-label">Vendor</label>
            <div class="col-sm-10">
                <form:input path="vendor" type="text" class="form-control" 
                                id="vendor" placeholder="vendor" />
                <form:errors path="vendor" class="control-label" />
            </div>
          </div>
        </spring:bind>
        
        <div class="form-group">
          <div class="col-sm-offset-2 col-sm-10">
              <button type="submit" class="btn-lg btn-primary pull-right">Delete</button>
          </div>
        </div>
    </form:form>

</div>
</body>
</html>