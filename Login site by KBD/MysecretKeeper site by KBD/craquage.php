 
 <?php
function lireFichierTexte($filePath) {
    $lines = file($filePath, FILE_IGNORE_NEW_LINES);
    $data = array();

    foreach ($lines as $line) {
        list($nomUtilisateur, $motdepasse) = explode(',', $line);
        $data[] = array('nomUtilisateur' => $nomUtilisateur, 'motdepasse' => $motdepasse);
    }

    return $data;
}

function authentifier($username, $password) {
    $filePath = 'bdd.txt';
    $utilisateurs = lireFichierTexte($filePath);

    foreach ($utilisateurs as $utilisateur) {
        if ($utilisateur['nomUtilisateur'] === $username && $utilisateur['motdepasse'] === $password) {
            echo "Connexion réussie pour : <br>";
            echo "Nom d'utilisateur: " . $utilisateur['nomUtilisateur'] . "<br>";
            echo "Mot de passe: " . $utilisateur['motdepasse'] . "<br>";

            return true; // Authentification réussie
        }
    }

    return false; // Authentification échouée
}

$success = false;
$filePath = 'bdd.txt';
$utilisateurs = lireFichierTexte($filePath);

foreach ($utilisateurs as $utilisateur) {
    $username = $utilisateur['nomUtilisateur'];
    $motdepasse = $utilisateur['motdepasse'];

    // Appel à la fonction d'authentification
    $success = authentifier($username, $motdepasse);

    if ($success) {
        break; // Sortir de la boucle si la connexion réussit
    }
}



  
 
?>
