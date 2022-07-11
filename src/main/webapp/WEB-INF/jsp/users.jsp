<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 7/3/2022
  Time: 6:29 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Training Page</title>
</head>
<body>
<h3>Training Form</h3>
<form method="post" action="users">
    <input type="text" id="name" name="name" placeholder="Имя"/><br/>
    <input type="text" id="surname" name="surname" placeholder="Surname"/><br/>
    <input type="text" id="email" name="email" placeholder="Email"/><br/>
    <input type="number" id="roleId" name="roleId" placeholder="RoleId"/><br/>
    <input type="text" id="login" name="login" placeholder="Login"/><br/>
    <input type="number" id="password" name="password" placeholder="Password"/><br/>
    <input type="submit" value="Post"/>
</form>
<br/>
<br/>

<form method="post" action="users">
    <input type="number" id="id" name="id" placeholder="ID"/><br/>
    <input type="text" id="gname" name="gname" placeholder="Name"/><br/>
    <input type="text" id="gsurname" name="gsurname" placeholder="Surname"/><br/>
    <input type="text" id="gemail" name="gemail" placeholder="Email"/><br/>
    <input type="number" id="groleId" name="groleId" placeholder="RoleId"/><br/>
    <input type="text" id="glogin" name="glogin" placeholder="Login"/><br/>
    <input type="number" id="gpassword"name="gpassword" placeholder="Password"/><br/>
    <input type="submit" value="Get"/>
</form>
</body>
</html>
