<?php            
    session_start();

    if(!isset($_SESSION['nom'])){
        http_response_code(401);
        header("Location: Login.php");
        exit();
    }
    
    else{
            header('Content-Type: text/html');
            echo "Hello ".$_SESSION['prenom']." ".$_SESSION['nom']." !\n"."votre secret est : ".$_SESSION['mysecret'] ;

            ?>
                <form method="post" action="">
                <input type="submit" name="logout" value="Déconnexion">
                </form>
            <?php
    }


    if (isset($_REQUEST['logout'])) {
        session_unset();

        session_destroy();

        header('Location: Login.php');
        exit;
    }


 
?>


