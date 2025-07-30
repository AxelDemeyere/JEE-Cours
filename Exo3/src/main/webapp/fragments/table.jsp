<table class="table">
    <thead>
    <tr>
        <th scope="col">Prenom</th>
        <th scope="col">Nourriture favorite</th>
        <th scope="col">Date de naissance</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="cat" items="${catList}">
        <tr>
            <td>${cat.name}</td>
            <td>${cat.favoriteFood}</td>
            <td>${cat.birthDate}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>