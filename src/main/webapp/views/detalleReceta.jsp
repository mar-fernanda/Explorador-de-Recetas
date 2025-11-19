<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Detalle de Receta</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/estilos.css">


</head>
<body>
    <c:choose>
        <c:when test="${not empty ingredientes}">
            <h1>${nombreReceta}</h1>
            <ul>
                <c:forEach var="ingrediente" items="${ingredientes}">
                    <li>${ingrediente}</li>
                </c:forEach>
            </ul>
        </c:when>
        <c:otherwise>
            <p class="error">La receta no se encuentra en nuestra lista.</p>
        </c:otherwise>
    </c:choose>
</body>
</html>