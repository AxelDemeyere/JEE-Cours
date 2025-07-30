<main>
    <div class="container mt-4">
        <table class="table">
            <thead>
            <tr>
                <th scope="col">ID</th>
                <th scope="col">Nom</th>
                <th scope="col">Race</th>
                <th scope="col">Date de naissance</th>
                <th scope="col">Actions</th>
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
                        <a href="${pageContext.request.contextPath}/dog/${dog.id}" class="btn btn-success">Details</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</main>