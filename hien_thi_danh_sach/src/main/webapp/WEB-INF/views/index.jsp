<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.codegym.hien_thi_danh_sach.model.Sandwich" %>

<html>
<head>
    <title>Sandwich</title>
</head>
<body>
<h1>Sandwich</h1>

<form method="POST" action="/save">
    <%
        List<Sandwich> list = (List<Sandwich>) request.getAttribute("sandwichList");
        if (list != null) {
            for (Sandwich s : list) {
    %>
    <label>
        <input type="checkbox" name="sandwich" value="<%= s.getName() %>"/>
        <%= s.getName() %>
    </label><br/>
    <%
            }
        }
    %>
    <br/>
    <input type="submit" value="Save">
</form>
</body>
</html>
