
<?php

  $wsdl = "http://localhost:8080/TTTWebApplication/TTTWebService?wsdl";
$trace = true;
 $client = new SoapClient($wsdl, array('trace' => $trace));
 
 
if(!isset($_SESSION)) 
{ 
    session_start(); 
} 

//$userId = $_POST[$_SESSION['userId']];
$xml_array['uId'] = $_SESSION['userId'];


if($_REQUEST['New-Game']=="newGame")
{
    try{
  // echo $_SESSION[$uId];
  // $uId = $_SESSION['userId'];
 //  echo $uId;
           
//$uId = $_POST['userId'];

   // $params = array('newGame'=>$xml_array);
   print_r ($xml_array);
    
    $response = $client->newGame($xml_array);
    $GId = $response->return;
    echo $GId;
    }catch (Exception $e) {
        echo "<h2>Exception Error!</h2>";
    echo $e->getMessage();}
}
else if($_REQUEST['League-Table']=="leagueTable")
{
echo "You pressed Button 2";

}
else if($_REQUEST['Show-All-Games']=="showAllMyGames")
{
echo "You pressed Button 3";
}