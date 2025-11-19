<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Recetas</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/estilos.css">
</head>
<body>
    <h1>Lista de Recetas</h1>
    <ul>
        <c:forEach var="receta" items="${listaRecetas}">
            <li><a href="/recetas/${receta}">${receta}</a></li>
        </c:forEach>
    </ul>
</body>
</html>
