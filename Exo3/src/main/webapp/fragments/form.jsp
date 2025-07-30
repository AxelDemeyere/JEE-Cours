<form action="${pageContext.request.contextPath}/catForm" method="post">
    <div class="mb-3">
        <label for="name" class="form-label">Nom</label>
        <input type="text" class="form-control" id="name" name="name" required>
    </div>
    <div class="mb-3">
        <label for="race" class="form-label">Race</label>
        <input type="text" class="form-control" id="race" name="race" required>
    </div>
    <div class="mb-3">
        <label for="favoriteFood" class="form-label">Nourriture favorite</label>
        <input type="text" class="form-control" id="favoriteFood" name="favoriteFood" required>
    </div>
    <div class="mb-3">
        <label for="birthDate" class="form-label">Date de naissance</label>
        <input type="date" class="form-control" id="birthDate" name="birthDate" required>
    </div>
    <button type="submit" class="btn btn-primary">Ajouter</button>
</form>