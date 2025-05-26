<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*" %>
<html>
<head>
    <title>Sandwich Result</title>
</head>
<body>

<h2>Sandwich Selected</h2>

<%
    String[] sandwichs = (String[]) request.getAttribute("sandwichs");
    if (sandwichs != null && sandwichs.length > 0) {
%>
<ul>
    <% for (String item : sandwichs) { %>
    <li><%= item %></li>
    <% } %>
</ul>
<%
} else {
%>
<p>No sandwich selected.</p>
<%
    }
%>

</body>
</html>
