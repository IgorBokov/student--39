<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../recourses/css/style.css">
<%--    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Kelly+Slab&display=swap" rel="stylesheet">--%>
    <script src="../recourses/js/function.js"></script>
    <title>disceplines</title>
</head>
<body>
<aside class="navigation">
    <a href="#" class="navigation-item">на главную</a>

</aside>

<main class="main">
    <h1 class="main-heading"> система управления студентами и их успеваемостью</h1>
    <h2 class="heading-secondary">список дисциплин</h2>

    <div class="container">
        <table class="discipline-table" border="1">
            <tr>
                <th>&nbsp</th>
                <th> название дисциплин</th>
            </tr>

            <c:forEach items="${disciplines}" var="d">
                <tr>
                    <td><input type="checkbox" id="" value="${d.id}" class="idDiscipline"></td>
                    <td>${d.discepline}</td>
                </tr>
            </c:forEach>

        </table>
        <div class="discipline-btns">
            <form action="/crateNewDiscipline" target="_top">
                <button>создать дисциплину</button>
            </form>
            <form action="/modifySelectDiscipline" target="_top">
                <button>модифицировать выбранную дисциплину</button>
            </form>

            <input type="submit" onclick="deleteDiscipline()" class="discipline-btns" value="удалить выбранную дисциплину">

        </div>
    </div>

</main>
<aside class="logout">
    <a href="#" class="logout-btn">logout</a>

</aside>

<form action="/deleteSelectDiscipline" method="post" id="fieldID">
    <input type="hidden" value="" id="typeHiddenID" name="typeNameDeleteDiscipline">
</form>
</body>
</html>
