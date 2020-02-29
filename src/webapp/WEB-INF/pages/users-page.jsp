<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>User Management Application</title>
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">
</head>
<body>
<header>
    <nav class="navbar navbar-expand-md navbar-dark"
         style="background-color: #b3159b">
        <div>
            <a href="http://localhost:8080/" class="navbar-brand"> All Users </a>
        </div>

    </nav>
</header>
<br>
<div class="row">
    <div class="container">
        <h3 class="text-center">All Users</h3>
        <hr>
        <div class="container text-left">

            <a href="<%=request.getContextPath()%>/new" class="btn btn-success">Add New User</a>
        </div>
        <br>
        <table class="table table-bordered">
            <thead>
            <tr>
                <th>Login</th>
                <th>Password</th>
                <th>Email</th>
                <th>Actions</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="users" items="${users}">

                <tr>
                    <td><c:out value="${users.login}"/></td>
                    <td><c:out value="${users.password}"/></td>
                    <td><c:out value="${users.email}"/></td>

                    <td><a href="/edit?id=<c:out value='${users.id}' />">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp; <a href="${pageContext.request.contextPath}delete?id=<c:out value='${users.id}' />">Delete</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>
