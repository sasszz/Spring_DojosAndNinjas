<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) -->
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Dojos and Ninjas</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<nav class="navbar navbar-dark bg-dark mr-auto">
    <div class="container">
        <span class="navbar-brand mb-0 h1">Dojos and Ninjas</span>
        <div>
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link" href="/dojos">Home</a>
                </li>
            </ul>
        </div>
    </div>
</nav>
<div class="container">
    <div class="row">
        <div class="col d-flex align-items-center justify-content-center">
            <div class="card mt-5 w-50 text-center text-white bg-dark mb-3 p-3">
                <div class="card-body">
                    <h5 class="card-title">New Ninja</h5>
                    <form:form action="/ninjas/new" method="post" modelAttribute="ninja">
                        <div class="row mt-4">
                            <div class="col">
                                <form:label path="firstName">First Name</form:label>
                                <form:errors path="firstName"/>
                                <form:input class="form-control"  path="firstName"/>
                            </div>
                            <div class="col">
                                <form:label path="lastName">Last Name</form:label>
                                <form:errors path="lastName"/>
                                <form:input class="form-control"  path="lastName"/>
                            </div>
                        </div>
                        <div class="row mt-4">
                            <div class="col-2">
                                <form:label path="age">Age</form:label>
                                <form:errors path="age"/>
                                <form:input class="form-control"  path="age"/>
                            </div>
                            <div class="col">
                                <form:label path="dojo">Dojo</form:label>
                                <form:select class="form-control" path="dojo">
                                    <c:forEach var="dojo" items="${dojos}">
                                        <form:option value="${dojo}" path="ninja.dojo">${dojo.name}</form:option>
                                    </c:forEach>
                                </form:select>
                            </div>
                            <div class="col">
                                <input class="btn btn-primary mt-4 align-self-end" type="submit" value="Submit"/>
                            </div>
                        </div>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>