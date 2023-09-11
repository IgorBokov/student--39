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
    <%-- <link rel="preconnect" href="https://fonts.gstatic.com">
     <link href="https://fonts.googleapis.com/css2?family=Kelly+Slab&display=swap" rel="stylesheet">--%>
    <script src="../recourses/js/function.js"></script>
    <title>student</title>
</head>
<body>

<aside class="navigation">
    <a href="#" class="navigation-item">на главную</a>
</aside>

<main class="main">
    <h1 class="main-heading"> система управления студентами и их успеваемостью</h1>

    <div class="student-btns">
        <div class="student-btns">
            <input type="submit" onclick="progressStudent()" class="student-btn" value="посмотреть успеваемость выбранных студентов">
            <input type="submit" onclick="modifyStudents()" class="student-btn" value="модифицировать выбранного студента"/>
        </div>
        <div class="student-btns">
            <form action="/student-create" method="get">
                <button class="student-btn">создать студента</button>
            </form>
            <input type="submit" onclick="deleteStudents()" class="student-btn" value="удалить выбранных студентов">
        </div>
    </div>
    <h2 class="heading-secondary">
        Список студентов
    </h2>
    <table class="student-table" border="1">
        <tr>
            <th>&nbsp</th>
            <th>фамилия</th>
            <th>имя</th>
            <th>группа</th>
            <th>дата поступления</th>
        </tr>

        <c:forEach items="${students}" var="st">
            <tr>
                <td><input type="checkbox" value="${st.id}" class="idStudent">
                </td>
                <td>${st.surname}</td>
                <td>${st.name}</td>
                <td>${st.group}</td>
                <td><fmt:formatDate value="${st.date}" pattern="dd/MM/yyyy"/></td>
            </tr>
        </c:forEach>

    </table>

</main>
<aside class="logout">
    <a href="#" class="logout-btn">logout</a>
</aside>

<form action="/deleteSelectStudents" method="post" id="formDelete">
    <input type="hidden" value="" id="hiddenDel" name="hiddenDelete">
</form>
<form action="/student-modify" method="get" id="formModify">
    <input type="hidden" value="" id="hiddenModify" name="hiddenModify">
</form>
<form action="/student-progress" method="get" id="formProgress">
    <input type="hidden" value="" id="hiddenProgress" name="hiddenProgress">
</form>

</body>
</html>