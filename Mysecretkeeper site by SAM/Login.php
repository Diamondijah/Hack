<html>
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
   <title>SecretKeeper</title>
   <style> 
   
*{
  margin: 0;
  padding: 0;
  box-sizing: border-box;
  font-family: "bold",
    sans-serif;
}
body {
  min-height: 100vh;
  display: flex;
  align-items: center;
  justify-content: center;
  background: #ffffff;
}
.wrapper {
  position: relative;
  max-width: 470px;
  width: 100%;
  border-radius: 12px;
  padding: 20px
    30px
    120px;
  background: #ffd1dc;
  box-shadow: 0
    5px
    10px
    rgba(
      0,
      0,
      0,
      0.1
    );
  overflow: hidden;
}
.form.login {
  position: absolute;
  left: 50%;
  bottom: -86%;
  transform: translateX(
    -50%
  );
  width: calc(
    100% +
      220px
  );
  padding: 20px
    140px;
  border-radius: 50%;
  height: 100%;
  background: #fff;
  transition: all
    0.6s
    ease;
}
.wrapper.active
  .form.login {
  bottom: -15%;
  border-radius: 35%;
  box-shadow: 0 -5px
    10px rgba(0, 0, 0, 0.1);
}
.form
  header {
  font-size: 30px;
  text-align: center;
  color: #fff;
  font-weight: 600;
  cursor: pointer;
}
.form.login
  header {
  color: #333;
  opacity: 0.6;
}
.wrapper.active
  .form.login
  header {
  opacity: 1;
}
.wrapper.active
  .signup
  header {
  opacity: 0.6;
}
.wrapper
  form {
  display: flex;
  flex-direction: column;
  gap: 20px;
  margin-top: 40px;
}
form
  input {
  height: 60px;
  outline: none;
  border: none;
  padding: 0
    15px;
  font-size: 16px;
  font-weight: 400;
  color: #333;
  border-radius: 8px;
  background: #fff;
}
.form.login
  input {
  border: 1px
    solid
    #aaa;
}
.form.login
  input:focus {
  box-shadow: 0
    1px 0
    #ddd;
}

form a {
  color: #333;
  text-decoration: none;
}
form
  a:hover {
  text-decoration: underline;
}
form
  input {
  height: 60px;
  outline: none;
  border: none;
  padding: 0
    15px;
  font-size: 16px;
  font-weight: 400;
  color: #333;
  border-radius: 8px;
  background: #fff;
}
.form.login
  input[type="submit"] {
  background: #ffd1dc;
  color: #fff;
  border: none;
}
</style>
  </head>
  <body>
    <?php
    session_start();
        if(isset($_SESSION['nom']))
        {
          header("Location: Home.php");
          exit();
        }
    ?>
    <section class="wrapper">
      <div class="form signup">
        <header>My Secret Keeper</header>
        <form action="log.php" method="post">
          <input type="text" placeholder="Nom" name="rnom" required />
          <input type="text" placeholder="Prenom" name="rpnom" required />
          <input type="text" placeholder="Username" name="ruser"required />
          <input type="text" placeholder="votre secret" name="rsecret" required />
          <input type="password" placeholder="Password"name="rpwd" required />
          <input type="submit" value="S'inscrire" />
        </form>
      </div>

      <div class="form login">
        <header>Connexion</header>
        <form action="log.php" method="post">
          <input type="text" placeholder="Username" name="user" required />
          <input type="password" placeholder="Password" name="pwd" required />
          <input type="submit" value="Login" />
        </form>
      </div>

      <script>
        const wrapper = document.querySelector(".wrapper"),
          signupHeader = document.querySelector(".signup header"),
          loginHeader = document.querySelector(".login header");

        loginHeader.addEventListener("click", () => {
          wrapper.classList.add("active");
        });
        signupHeader.addEventListener("click", () => {
          wrapper.classList.remove("active");
        });
      </script>
    </section>
  </body>
</html>