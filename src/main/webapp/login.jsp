<!DOCTYPE html>
<html>
<head>
  <title>Login</title>
</head>
<body>
<h1>Login</h1>
<form action="Authentication" method="post">
  <label for="login">Login:</label>
  <input type="text" id="login" name="login" required><br>
  <label for="password">Password:</label>
  <input type="password" id="password" name="password" required><br>
  <button type="submit">Submit</button>
</form>
<%
  String error = (String) request.getAttribute("error");
  if (error != null) {
%>
<p style="color: red;"><%= error %></p>
<% } %>
</body>
</html>
