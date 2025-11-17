<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Detalle de receta</title>
</head>
<body>

<c:choose>
    <c:when test="${not empty error}">
        <h2>${error}</h2>
        <a href="/recetas">Volver</a>
    </c:when>

    <c:otherwise>
        <h1>${nombre}</h1>
        <ul>
            <c:forEach var="ing" items="${ingredientes}">
                <li>${ing}</li>
            </c:forEach>
        </ul>
        <a href="/recetas">Volver</a>
    </c:otherwise>
</c:choose>

</body>
</html>
