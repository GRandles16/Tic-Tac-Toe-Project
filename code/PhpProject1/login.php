<?php

if(!isset($_SESSION)) 
{ 
    session_start(); 
} 

  $wsdl = "http://localhost:8080/TTTWebApplication/TTTWebService?wsdl";
  $client = new SoapClient($wsdl, array('trace'=>1));
  
  
$username = $_POST['username'];
$password = $_POST['password'];

$params = array( 'username' => $username,'password' => $password);

try {
    $response = $client->login($params);
    $uId = $response->return;
    echo $uId;
    if($uId > 0){
    header("Location: mainMenuPage.php");
    $_SESSION['userId'] = $uId;
    die();   
    return;
    }
    else
     {
        echo "Inavlid login Please try again or Register as a new user";
       header("Location: LoginPage.php");
die(); 
     }

    } 
catch (Exception $e) 
    {
        echo "<h2>Exception Error!</h2>";
        echo $e->getMessage();
    }