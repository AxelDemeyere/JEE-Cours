<table class="table">
    <thead>
    <tr>
        <th scope="col">ID</th>
        <th scope="col">Nom</th>
        <th scope="col">Race</th>
        <th scope="col">Date de naissance</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="dog" items="${dogs}">
        <tr>
            <td>${dog.id}</td>
            <td>${dog.name}</td>
            <td>${dog.breed}</td>
            <td>${dog.birthDate}</td>
            <td>
                <a href="${pageContext.request.contextPath}/dogEdit?id=${dog.id}" class="btn btn-warning">Modifier</a>
                <a href="${pageContext.request.contextPath}/dogDelete?id=${dog.id}" class="btn btn-danger">Supprimer</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>