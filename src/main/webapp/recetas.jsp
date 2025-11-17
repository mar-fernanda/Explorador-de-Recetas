<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Recetas</title>
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
