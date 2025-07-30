<main>
    <div class="container mt-4">
        <h1>Details du chien</h1>

        <div class="card">
            <div class="card-header">
                <h3>Informations du chien</h3>
            </div>
            <div class="card-body">
                <div class="row">
                    <div class="col-md-6">
                        <p><strong>ID:</strong> ${dog.id}</p>
                        <p><strong>Nom:</strong> ${dog.name}</p>
                        <p><strong>Race:</strong> ${dog.breed}</p>
                        <p><strong>Date de naissance:</strong> ${dog.birthDate}</p>
                    </div>
                </div>

                <div class="mt-3">
                    <a href="${pageContext.request.contextPath}/dogList" class="btn btn-primary">Retour a la liste</a>
                    <a href="${pageContext.request.contextPath}/dogEdit?id=${dog.id}" class="btn btn-warning">Modifier</a>
                    <a href="${pageContext.request.contextPath}/dogDelete?id=${dog.id}" class="btn btn-danger"
                       onclick="return confirm('Êtes-vous sûr de vouloir supprimer ce chien ?')">Supprimer</a>
                </div>
            </div>
        </div>
    </div>
</main>