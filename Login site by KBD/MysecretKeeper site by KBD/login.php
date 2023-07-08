<?php
// Vérifier si le formulaire est soumis
if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    // Récupérer les valeurs du formulaire
    $username = $_POST['username'];
    $password = $_POST['password'];

    // Chemin du fichier texte contenant les informations des utilisateurs
    $filePath = 'bdd.txt';

    // Vérifier si l'utilisateur existe dans le fichier texte
    $utilisateurs = file($filePath, FILE_IGNORE_NEW_LINES); // Lire le contenu du fichier en tant que tableau
    foreach ($utilisateurs as $utilisateur) {
        list($nomUtilisateur, $motdepasse) = explode(',', $utilisateur); //  les valeurs sont séparées par une virgule
        if ($username === $nomUtilisateur && $password === $motdepasse) {
            // Authentification réussie, redirection vers la page de succès
            header('Location: succes.php');
            exit;
        }
    }

    // Si l'authentification a échoué, redirection vers la page d'échec
    header('Location: echec.php');
    exit;
}
?>

<!DOCTYPE html>
<html>
<head>
    <title>Page de connexion</title>
</head>
<body>
    <h2>Connexion</h2>
    <form method="POST" action="">
        <label for="username">Nom d'utilisateur :</label>
        <input type="text" name="username" id="username" required><br><br>
        <label for="password">Mot de passe :</label>
        <input type="password" name="password" id="password" required><br><br>
        <input type="submit" value="Se connecter">
    </form>
</body>
</html>
