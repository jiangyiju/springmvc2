<%--
  Created by IntelliJ IDEA.
  User: yishang
  Date: 2015/10/7
  Time: 12:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title></title>
</head>
<body>
  <h1>S12</h1>
  <form:form commandName="customer" action="/form/save" method="post">
    <form:input id="sex" path="sex"/>
    <input id="submit" type="submit" value="Add Customer"/>
  </form:form>
</body>
</html>
