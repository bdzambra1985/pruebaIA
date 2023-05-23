<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="utf-8" />
    <title>Login con singleton y pdo</title>
    <style type="text/css">
        body{
            background: #d1e0e5;
        }
        .content{
             margin: 0 auto;
             width: 500px;
             height: 300px;
             margin-top: 9%;
             background: #000;
             color: #fff;
             border: 6px solid #dc2d29;
        }
        label{
            display: block;
        }
        .caja_login{
            margin: 30px 0px 0px 70px;
        }
        .caja_login input[type=text],input[type=password]{
            width: 280px;
            padding: 8px 6px;
            border-radius: 8px;
        }
        .caja_login input[type=submit]{
            padding: 5px 60px;
            text-align: center;
            border-radius: 4px;
            color: #fff;
            background: #dc2d29; 
            border: 1px solid #fff;
            margin-top: 10px;
        }
    </style>
</head>
 
<body>
<div class="content">
    <div class="caja_login">
    <h2>Login con PDO y php</h2>
    <form class="form" action="login.php" method="post">
        
        <label>Nick</label>
        <input type="text" name="nick" required="true" placeholder="Introduce tu nick" />
        
        <label>Password</label>
        <input type="password" name="password" required="true" placeholder="Introduce tu password" />
        
        <input type="submit" value="Login" />
        
    </form>
    </div>
</div>
</body>
</html>
```
Simplemente es la estructura de una página web y un formulario con algunos estilos, si nos fijamos el atributo action de nuestro formulario apunta a un archivo llamado login.php, este es para nosotros nuestro controlador, el que hace la comunicación entre la vista y la base de datos, con esto ya habremos terminado nuestro sistema de login, veamos. 

Creamos un archivo en la raíz de la aplicación llamado login.php, dentro colocamos el siguiente código que será el encargado de hacer la comunicación con el método login_users para comprobar si los datos son correctos. 
```php
<?php
require_once 'class_login/login.class.php';
//accedemos al método singleton que es quién crea la instancia
//de nuestra clase y así podemos acceder sin necesidad de
//crear nuevas instancias, lo que ahorra consumo de recursos
$nuevoSingleton = Login::singleton_login();
 
if(isset($_POST['nick']))
{
    $nick = $_POST['nick'];
    $password = $_POST['password'];
    //accedemos al método usuarios y los mostramos
    $usuario = $nuevoSingleton->login_users($nick,$password);
    
    if($usuario == TRUE)
    {
        header("Location:home.php");
    }
}
?>