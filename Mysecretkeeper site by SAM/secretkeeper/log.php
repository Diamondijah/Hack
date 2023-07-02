<?php
    session_start();
       $pdo = new PDO("mysql:host=localhost;dbname=secretkeeper","secretadmin","notfound");
       array(PDO::ATTR_ERRMODE => PDO::ERRMODE_EXCEPTION);

       if (isset($_REQUEST['ruser'])) {
		$rdata = [
            'nom' =>$_REQUEST['rnom'],
            'prenom' => $_REQUEST['rpnom'],
            'username' => $_REQUEST['ruser'],
            'mysecret' => $_REQUEST['rsecret'],
            'mot_de_passe' => md5($_REQUEST['rpwd'])
        ];
        
        $sql = 'insert into users(nom,prenom,username,mysecret,mot_de_passe) values(:nom,:prenom,:username,:mysecret,:mot_de_passe)';
          $resultat =  $pdo->prepare($sql);
          $resultat->execute($rdata);
          $_SESSION['nom'] = $rdata['nom'];
          $_SESSION['prenom'] = $rdata['prenom'];
          $_SESSION['user'] = $rdata['username'];
          $_SESSION['mysecret'] = $rdata['mysecret'];
          header("Location: Login.php");
          exit();
        }

        if (isset($_REQUEST['user'])) {
            $pwd =  md5($_REQUEST['pwd']) ;
            $resultat = $pdo->prepare("select * from users where username='".$_REQUEST['user']."' and mot_de_passe='".$pwd."';");
		    $resultat->execute();
            $data=$resultat->fetchAll(PDO::FETCH_ASSOC);	

            if(!empty($data)){
                $_SESSION['nom'] = $data[0]['nom'];
                $_SESSION['prenom'] = $data[0]['prenom'];
                $_SESSION['user'] = $data[0]['username'];
                $_SESSION['mysecret'] = $data[0]['mysecret'];

                if(isset($_GET['getsecret'])){

                    http_response_code(200);
                    header('Content-Type: application/json');
                    $secret = ['prenom' => $_SESSION['prenom'],'nom' => $_SESSION['nom'],'username' => $_SESSION['user'],'mysecret' => $_SESSION['mysecret']];
                    $sec = json_encode($secret);
                    echo($sec);
                    //echo "Hello ".$_SESSION['prenom']." ".$_SESSION['nom']." !\n"."votre secret est : ".$_SESSION['mysecret'] ;
                }

                else header("Location: Home.php");
                exit();
            }

            else{
                http_response_code(500);
                header("Location: Login.php");
                exit();
                
            }

        }
    ?>