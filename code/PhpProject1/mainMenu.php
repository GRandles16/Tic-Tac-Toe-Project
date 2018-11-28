
<?php
include 'Soap.php';
 // $wsdl = "http://localhost:8080/TTTWebApplication/TTTWebService?wsdl";
//$trace = true;
 //$client = new SoapClient($wsdl, array('trace' => $trace));
 
 
if(!isset($_SESSION)) 
{ 
    session_start(); 
} 
$uId = $_SESSION['userId'];

if($_REQUEST['New-Game']=="newGame")
{
    try{


        $params = array('uid'=>$uId);

         $response = $client->newGame($params);
         $GId = $response->return;


         $_SESSION['gameId'] = $GId;
         header("Location: mainMenuPage.php");
         
    }catch (Exception $e) {
        echo "<h2>Exception Error!</h2>";
        echo $e->getMessage();}
}
else if($_REQUEST['League-Table']=="leagueTable")
{
    try{

         $response = $client->leagueTable();
         $GId = $response->return;
         print_r($GId);
         
    }catch (Exception $e) {
        echo "<h2>Exception Error!</h2>";
        echo $e->getMessage();}

}
else if($_REQUEST['Show-My-Open-Games']=="showMyOpenGames")
{
        try{
        $uId = $_SESSION['userId'];
        $params = array('uid'=>$uId);
         $response = $client->showMyOpenGames($params);
        
         
         $GId = $response->return;
         echo $Gid;
         $_SESSION['data'] = $GId;
         header("Location: showMyOpenGames.php");
     
    }catch (Exception $e) {
        echo "<h2>Exception Error!</h2>";
        echo $e->getMessage();}
}