<table class="table">
    <thead>
    <tr>
        <th scope="col">Nom</th>
        <th scope="col">Race</th>
        <th scope="col">Nourriture favorite</th>
        <th scope="col">Date de naissance</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="cat" items="${cats}">
        <tr>
            <td>${cat.name}</td>
            <td>${cat.race}</td>
            <td>${cat.favoriteFood}</td>
            <td>${cat.birthDate}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>