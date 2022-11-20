<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>
    <title>Weather forecast</title>
</head>
<body>

<form action="exampleServlet" method="get" style="display: flex; flex-direction: column">
    <button style="margin-top: 20px" type="submit" id="btn">Check temperature</button>
</form>
<p>
        <%="Hello World"%>
        <%= new java.util.Date()%>
<p>

</body>
</html>
