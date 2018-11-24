<?php

  $wsdl = "http://localhost:8080/TTTWebApplication/TTTWebService?wsdl";
  $client = new SoapClient($wsdl, array('trace'=>1));
  
  
$username = $_POST['username'];
$password = $_POST['password'];
$name = $_POST['name'];
$surname = $_POST['surname'];

$params = array( 'username' => $username,'password' => $password, 'name' => $name, 'surname' => $surname);

try {
    $response = $client->register($params);
    $uId = $response->return;
    echo $uId;
    if($uId > 0)
            $_SESSION['userId'] = $uId;
        header("Location: LoginPage.php");
    } 
catch (Exception $e) 
    {
        echo "<h2>Exception Error!</h2>";
        echo $e->getMessage();
    }
