<%@ taglib prefix="c" uri="jakarta.tags.core" %><%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Mon application</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-LN+7fdVzj6u52u30Kp6M/trliBMCMKTyK833zpbD+pXdCLuTusPj697FH4R/5mcr" crossorigin="anonymous">
</head>
<body>

<header class="bg-primary text-white text-center py-3">
    <h1>Bienvenue dans mon application</h1>
    <nav>
        <ul class="nav justify-content-center">
            <li class="nav-item">
                <a class="nav-link text-white" href="index.jsp">Accueil</a>
            </li>
            <li class="nav-item">
                <a class="nav-link text-white" href="dogList">Liste des chiens</a>
            </li>
            <li class="nav-item">
                <a class="nav-link text-white" href="dogForm">Ajouter un chien</a>
            </li>
        </ul>
    </nav>
</header>
