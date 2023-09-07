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
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Kelly+Slab&display=swap" rel="stylesheet">
    <script type="javascript" src="../recourses/js/funcktion.js"></script>
    <title>student</title>
</head>
<body>
<aside class="navigation">
    <a href="#" class="navigation-item">на главную</a>

</aside>

<main class="main">
    <h1 class="main-heading"> система управления студентами и их успеваемостью

    </h1>

    <div class="student-btns">
        <div class="student-btns1">
            <button class="student-btn"> посмотреть успеваемость выбранных студентов</button>
            <button class="student-btn"> модифицировать выбранного студента</button>
        </div>
        <div class="student-btns1">
            <form action="<c:url value="/student-create"/>" method="get">
                <button class="student-btn">создать студента</button>
            </form>
            <form action="<c:url value="/deleteSelectStudents"/>" method="post">
                <button class="idStudent" onclick="deleteStudents()">удалить выбранных студентов</button>
            </form>

        </div>
    </div>
    <h2 class="heading-secondary">
        Список студентов
    </h2>
    <table class="student-table">
        <tr>
            <th>&nbsp</th>
            <th>фамилия</th>
            <th>имя</th>
            <th>группа</th>
            <th>дата поступления</th>
        </tr>

        <%--@elvariable id="students" type="java.util.List"--%>
        <c:forEach items="${students}" var="st">
            <tr>
                <td>
                    <label for="select_checkbox"></label>
                    <input type="checkbox" id="select_checkbox" value="${st.id}">
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

<form action="${pageContext.request.contextPath}/student-delete" method="post" id="formDelete">
    <input type="hidden" value="" id="hiddenDelete" name="hiddenDelete">
</form>

</body>
</html>