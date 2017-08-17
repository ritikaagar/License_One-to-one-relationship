<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<h2>Create a person</h2>
<!-- ... -->
<form:form method="POST" action="/persons/new" modelAttribute="person">
<form:hidden path="id"/>
	<p>
    <form:label path="firstName">First Name:
    <form:errors path="firstName"/>
    <form:input path="firstName"/></form:label>
    </p>
    
    <p>
    <form:label path="lastName">Last Name:
    <form:errors path="lastName"/>
    <form:input path="lastName"/></form:label>
    </p>
    
    <p>
    <input type="submit" value="Create"/>
    </p>
</form:form> 
<!-- ... -->