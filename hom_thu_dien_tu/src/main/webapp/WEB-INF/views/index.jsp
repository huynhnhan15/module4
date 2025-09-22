<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Email Settings</title>
</head>
<body>
<h2>Settings</h2>
<%--@elvariable id="setting" type=""--%>
<form:form modelAttribute="setting" action="/settings" method="post">
    <div>
        <label>Languages</label>
        <form:select path="language">
            <form:options items="${languages}"/>
        </form:select>
    </div>

    <div>
        <label>Page Size:</label>
        Show <form:select path="pageSize">
        <form:options items="${pageSizes}"/>
    </form:select> emails per page
    </div>

    <div>
        <label>Spams filter:</label>
        <form:checkbox path="spamsFilter"/> Enable spams filter
    </div>

    <div>
        <label>Signature:</label><br/>
        <form:textarea path="signature"/>
    </div>

    <div>
        <input type="submit" value="Update"/>
        <button type="reset">Cancel</button>
    </div>
</form:form>
</body>
</html>