<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">

<style>
/* Style the tab */
.tab {
  overflow: hidden;
  border: 1px solid #ccc;
  background-color: #5F9EA0;
}

/* Style the buttons that are used to open the tab content */
.tab button {
  background-color: inherit;
  float: left;
  border: none;
  outline: none;
  cursor: pointer;
  padding: 14px 16px;
  transition: 0.3s;
}

/* Change background color of buttons on hover */
.tab button:hover {
  background-color: #ddd;
}

/* Create an active/current tab link class */
.tab button.active {
  background-color: #ccc;
}

/* Style the tab content */
.tabcontent {
  display: none;
  padding: 6px 12px;
  border: 1px solid #ccc;
  border-top: none;
}

</style>

<body>
    <div class="tab">
    
		  <button class="tablinks" id="home-tab-btn" onclick="">Home</button>
		  
		  <spring:url value="customerviewproducts" var="addUrl" />
		  <button class="add-btn btn-info" onclick="location.href='${addUrl}'">Products</button>
		  
		  
		  <spring:url value="usercart" var="usercart" />
		  <button class="cart-btn btn-info" onclick="location.href='${usercart}'">Cart</button>
	</div> 
	
	
</body>
</html>