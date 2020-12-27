<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">
<div class="container">

    <h1>Product Detail</h1>
    <br/>
    
    <table class="table table-striped">
            <thead>
            	<tr>
            		<td><b><u>Property</b></u></td>
            		<td><b><u>Value</u></b></td>
            	</tr>
            </thead>
            <tr>
            	<td><b>ProductID : </b></td>
            	<td>${product.id}</td>
            </tr>
            <tr>
            	<td><b>Name : </b></td>
            	<td>${product.name}</td>
            </tr>
            <tr>
            	<td><b>Description : </b></td>
            	<td>${product.description}</td>
            </tr>
            <tr>
            	<td><b>Price : </b></td>
            	<td>${product.price}</td>
            </tr>
            <tr>
            	<td><b>Discount : </b></td>
            	<td>${product.discount}</td>
            </tr>
            <tr>
            	<td><b>Quantity : </b></td>
            	<td>${product.quantity}</td>
            </tr>
            <tr>
            	<td><b>DateOfExpiry : </b></td>
            	<td>${product.dateOfExpiry}</td>
            </tr>
            <tr>
            	<td><b>Vendor : </b></td>
            	<td>${product.vendor}</td>
            </tr>
        </table>
</div>

</body>
</html>