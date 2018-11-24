<?php
if(!isset($_SESSION)) 
{ 
    session_start(); 
} 
?>
<!-- ///////////////////////////////showMyOpenGames////////////////////////////////////////////////-->
<?php
  $wsdl = "http://localhost:8080/TTTWebApplication/TTTWebService?wsdl";
$trace = true;
 $client = new SoapClient($wsdl, array('trace' => $trace));
 

$GId = $_SESSION['data'];
$s_array = explode(".", $GId);

//to remove spaces

$spaces=array(); //to store space
$others=array(); //to store characters
$allGames=array();
foreach($s_array as $word)
{
    $endsWith = substr($word, -1);
    $startsWith = substr( $word, 0, 1 );
    if($startsWith=='0')
    {
        $word = ltrim($word, '0');
        array_push($others,$word);
        array_push($allGames,$word);
    }
       // else if(in_array($endsWith, array("6")))
    else if($word)
    {
        array_push($others,$word);  //string variables are stored into others array
        array_push($allGames,$word);
    }
}

$count=count($others);

for($i=0;$i<$count;$i++)
{
    for($j=0;$j<$count;$j++)
    {
        //$result[$i][$j] = $value;
        $result[$i][$j+1] = $others[$i];
        $result[$i][$j+1] = $allGames[$i];

    }
           // print_r ($others[$i]) ;
}
 ///////////////////////////////All OpenGames///showOpenGames/////////////////////////////////////////////-->


        try{
         $response = $client->showOpenGames();  
         
         $data = $response->return;
         //print_r ($data);
     
    }catch (Exception $e) {
        echo "<h2>Exception Error!</h2>";
        echo $e->getMessage();}

$s_array = explode(".", $data);

$spaces=array(); //to store space
$allGames=array();
foreach($s_array as $word)
{
    $endsWith = substr($word, -1);
    $startsWith = substr( $word, 0, 1 );
    if($startsWith=='0')
    {
        $word = ltrim($word, '0');
        array_push($allGames,$word);
    }
       // else if(in_array($endsWith, array("6")))
    else if($word)
    {
        array_push($allGames,$word);
    }
}

$count=count($others);

for($i=0;$i<$count;$i++)
{
    for($j=0;$j<$count;$j++)
    {
        $result[$i][$j+1] = $allGames[$i];

    }
}


?>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <link rel="stylesheet" type="text/css" media="all" href="style.css"> 
    </head>
    <body>
        <h1 style="color: red;">Displaying My Open Games</h1>
        <form>
            <select name = "others" id="array">
                <?php
                foreach($others as $value)
                {
                    printf('<option>%s</option>option>', $value);
                }
                ?>    
            </select>  
            <input type="submit" value="Resume">
            
        </form>
        <h1 style="color: red;">Showing All Open Games</h1>
        <form action="mainGame.php" method="post">
            <select name = "data" id="array">
                <?php
                foreach($allGames as $value)
                {
                    printf('<option>%s</option>option>', $value);
                }
                ?>    
            </select>  
            <input type="submit" value="Join">
            
        </form>
    </body>
</html>


