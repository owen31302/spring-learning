<%--
  Created by IntelliJ IDEA.
  User: yuchlin
  Date: 3/16/19
  Time: 4:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Student Confirmation</title>
</head>
<body>

    The student is confirmed: ${student.firstName} ${student.lastName}

    <br><br>

    Country: ${student.country}

    <br><br>

    Favorite Language: ${student.favoriteLanguage}

    <br><br>

    Operating Systems:

    <ul>
        <c:forEach var="temp" items="${student.operatingSystems}">

            <li> ${temp} </li>

        </c:forEach>
    </ul>

</body>
</html>
