<main>
    <div class="container mt-4">
        <h1>${dog != null ? 'Modifier le chien' : 'Ajouter un chien'}</h1>

        <form action="${pageContext.request.contextPath}/dogSave" method="post">
            <c:if test="${dog != null}">
                <input type="hidden" name="id" value="${dog.id}">
            </c:if>

            <div class="mb-3">
                <label for="name" class="form-label">Nom</label>
                <input type="text" class="form-control" id="name" name="name" value="${dog.name}" required>
            </div>

            <div class="mb-3">
                <label for="breed" class="form-label">Race</label>
                <input type="text" class="form-control" id="breed" name="breed" value="${dog.breed}" required>
            </div>

            <div class="mb-3">
                <label for="birthDate" class="form-label">Date de naissance</label>
                <input type="date" class="form-control" id="birthDate" name="birthDate" value="${dog.birthDate}" required>
            </div>

            <div class="mb-3">
                <button type="submit" class="btn btn-primary">
                    ${dog != null ? 'Modifier' : 'Ajouter'}
                </button>
                <a href="${pageContext.request.contextPath}/dogList" class="btn btn-secondary">Annuler</a>
            </div>
        </form>
    </div>
</main>