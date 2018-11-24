<?php
if(!isset($_SESSION)) 
{ 
    session_start(); 
} 
?>
<?php 
$uId = $_SESSION['userId'];
    $s_array = explode(",", $_POST['data']);

$spaces=array(); //to store space
$splitString=array();
foreach($s_array as $word)
{
    if($word)
    {
        array_push($splitString,$word);
    }
}

$count=count($splitString);

for($i=0;$i<$count;$i++)
{
    for($j=0;$j<$count;$j++)
    {
        $result[$i][$j+1] = $splitString[$i];

    }
}
    print_r($splitString[0]);
    print_r($splitString[1]);
    
  $wsdl = "http://localhost:8080/TTTWebApplication/TTTWebService?wsdl";
  $client = new SoapClient($wsdl, array('trace'=>1));

$params = array( 'uid' => $uId,'gid' => $splitString[0]);

try {
    $response = $client->joinGame($params);
    $result = $response->return;
    echo $result;

    } 
catch (Exception $e) 
    {
        echo "<h2>Exception Error!</h2>";
        echo $e->getMessage();
    }

?>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <link rel="stylesheet" type="text/css" media="all" href="style.css"> 
    </head>
    <body>
        <form action="mainMenu.php" method="post">
            <table class = "box" style = "border: solid black 1px; background-color: skyblue; margin-left: 20px; margin-left: 20px;">
                <tr>
                    <td><h1 style="color: red;">Main Game</h3></td>
            
                    <td></td>

                </tr>

                <tr>
                    <!-- <?php echo $_POST['data'] ?> -->
                             
                        
                        
                    </td>
                </tr>

            </table> 
        </form> 
    </body>
</html>

         



