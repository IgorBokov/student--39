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
    <title>student-creating</title>
</head>
<body>
<aside class="navigation">
    <a href="#" class="navigation-item">на главную</a>
    <a href="#" class="navigation-item">назад</a>

</aside>

<main class="main">
    <h1 class="main-heading"> система управления студентами и их успеваемостью</h1>
    <h2 class="heading-secondary">для создания студента заполните все поля и нажмите кнопку "создать"</h2>


    <form action="/student-create" method="post">
    <table>
        <tr>
            <td class="cell1" align="right"> <h3>фамилия</h3></td>
            <td> <input name="surname" type="text" id="name"></td>
        </tr>
    </table>
    <br>
    <table>
        <tr>
            <td class="cell1" align="right"><h3>имя</h3></td>
            <td><input name="name" id="name"> </td>
        </tr>
    </table>
    <br>
    <table>
        <tr>
            <td class="cell1" align="right"> <h3>группа</h3></td>
            <td><input name="group" id="name"> </td>
        </tr>
    </table>
    <br>
    <table>
        <tr>
            <td class="cell1" align="right"> <h3>дата поступления</h3></td>
            <td> <input name="date" id="name"></td>

        </tr>
    </table>
    <br>

    <input type="submit" value="создать" class="field">
    </form>
    <c:if test = "${message eq 1}">
        <p>Поля не должны быть пустыми: </p>
    </c:if>
    </div>

</main>
<aside class="logout">
    <a href="#" class="logout-btn">logout</a>

</aside>

</body>
</html>
