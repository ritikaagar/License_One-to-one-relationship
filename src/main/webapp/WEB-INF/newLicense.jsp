<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<h2>Create a license</h2>
<!-- ... -->
	<form:form method="POST" action="/licenses/new" modelAttribute="newlicense">
	
	   <p> <form:label path="person">Person:
	    		<form:select path="person">
				<c:forEach items="${allpersons}" var="person">
					<form:option value="${person}" label="${person.firstName}"/>				
				</c:forEach>
	    		</form:select>
	    </form:label>
	     <form:errors path="person"/></p>
	     
	  <p>  <form:label path="state">State: 
		    <form:input path="state"/></form:label>
		    <span style="color:red"><form:errors path="state"/></span>
		    <br/> </p>
		    
		<p>    Expiration date: <input type="date" name="myDate" />
		    <span style="color:red"><form:errors path="expiration_date"/></span>
		    <br/></p>
		    
		    
		  <p>  <input type="submit" value="Submit"/> </p>
		</form:form>
<!-- ... -->