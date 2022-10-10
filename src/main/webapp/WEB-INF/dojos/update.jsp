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
<nav class="navbar navbar-expand-lg navbar-dark bg-dark mr-auto">
    <div class="container">
        <span class="navbar-brand mb-0 h1">Dojos and Ninjas</span>
        <div>
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link" href="/dojos">Home</a>
                </li>
                <li>
                    <a class="nav-link" href="/ninjas">Add Ninja</a>
                </li>
            </ul>
        </div>
    </div>
</nav>
<div class="container">
    <div class="row">
        <div class="col d-flex align-items-center justify-content-center">
            <div class="card w-50 mt-5 text-center text-white bg-dark mb-3 p-3">
                <div class="card-body">
                    <h5 class="card-title">Update Dojo</h5>
                    <form:form action="/dojos/${dojo.id}" method="post" modelAttribute="dojo">
                        <input type="hidden" name="_method" value="put">
                        <div class="row mt-4">
                            <div class="col">
                                <form:label path="name">Name</form:label>
                                <form:errors path="name"/>
                                <form:input class="form-control"  path="name"/>
                            </div>
                        </div>
                        <input class="btn btn-primary mt-4 align-self-end" type="submit" value="Submit"/>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>