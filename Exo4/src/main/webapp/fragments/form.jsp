<form action="${pageContext.request.contextPath}/dogSave" method="post">
    <div class="mb-3">
        <label for="name" class="form-label">Nom</label>
        <input type="text" class="form-control" id="name" name="name" required>
    </div>
    <div class="mb-3">
        <label for="breed" class="form-label">Race</label>
        <input type="text" class="form-control" id="breed" name="breed" required>
    </div>
    <div class="mb-3">
        <label for="birthDate" class="form-label">Date de naissance</label>
        <input type="date" class="form-control" id="birthDate" name="birthDate" required>
    </div>
    <button type="submit" class="btn btn-primary">Ajouter</button>
</form>