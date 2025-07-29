<%@include file="/fragment/header.fragment.jsp"%>

<div class="container mt-5">
    <h2>Ajouter une personne</h2>
    <form action="addPerson" method="post">
        <div class="mb-3">
            <label for="firstName" class="form-label">Prénom</label>
            <input type="text" class="form-control" id="firstName" name="firstName" required>
        </div>
        <div class="mb-3">
            <label for="lastName" class="form-label">Nom</label>
            <input type="text" class="form-control" id="lastName" name="lastName" required>
        </div>
        <div class="mb-3">
            <label for="age" class="form-label">Âge</label>
            <input type="number" class="form-control" id="age" name="age" required>
        </div>
        <button type="submit" class="btn btn-primary">Ajouter</button>
    </form>
</div>

<%@include file="/fragment/footer.fragment.jsp"%>