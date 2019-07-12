<%--
  Created by IntelliJ IDEA.
  User: Emmanuel Cadet
  Date: 7/11/2019
  Time: 10:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
  <head>
    <title>Homework Servlet 2</title>
    <link href="index.css" rel="stylesheet"/>
  </head>
  <body>
  <div id="centerDiv">
    <% Cookie[] cok=request.getCookies(); String usr=""; String remember=null;
      for(Cookie c: cok){
        if(c.getName().equals("userName")){
          usr=c.getValue();
        }
        if(c.getName().equals("rememberMe")){
          remember=c.getValue();
        }

      }%>
  <form action="http://localhost:8086/wapServlet2_war_exploded/login" method="post">
    <div><label>Username : <input type="text" name="user" value="<%=usr%>"/> </label></div>
    <div><label>Password : <input type="password" name="password"/> </label></div>
    <div><input type="submit" name="submitButton"/> <label> <input type="checkbox" name="rememberMe" <%if(remember!=null){%>checked="checked"<%}%>> Remember me </label></div>
    <div></div>
  </form>
  </div>
  </body>
</html>
