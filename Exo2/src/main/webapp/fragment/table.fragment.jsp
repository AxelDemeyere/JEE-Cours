<jsp:useBean id="personList" scope="request" />
<table class="table">
    <thead>
    <tr>
        <th scope="col">Prenom</th>
        <th scope="col">Nom</th>
        <th scope="col">Age</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="person" items="${personList}">
        <tr>
            <td>${person.firstName}</td>
            <td>${person.lastName}</td>
            <td>${person.age}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
