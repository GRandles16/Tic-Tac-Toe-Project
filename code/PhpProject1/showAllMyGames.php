<?php
////////////////////////////////////RESUME GAME////////////////////////////////////////
if (!isset($_SESSION)) {
    session_start();
}

  $wsdl = "http://localhost:8080/TTTWebApplication/TTTWebService?wsdl";
  $client = new SoapClient($wsdl, array('trace'=>1));
$uId = $_SESSION['userId'];
  
$s_array1 = explode(",", $_POST['data5']);

$spaces1 = array(); //to store space
$splitString1 = array();
foreach ($s_array1 as $word) {
    if ($word) {
        array_push($splitString1, $word);
    }
}

$count1 = count($splitString1);

for ($i = 0; $i < $count1; $i++) {
    for ($j = 0; $j < $count1; $j++) {
        $result1[$i][$j + 1] = $splitString1[$i];
    }
}
//print_r($splitString[0]);
//print_r($splitString[1]);


$params1 = array('uid' => $uId, 'gid' => $splitString1[0]);

$_SESSION['gameid'] = $splitString1[0];

try {
    $response1 = $client->joinGame($params1);
    $result1 = $response1->return;
    // $result;
} catch (Exception $e) {
    echo "<h2>Exception Error!</h2>";
    echo $e->getMessage();
}
?>
<?php
if($result1 == 1)
{
    echo "<script>";
    echo"alert('You have sucessfully resumed the game, good luck!');";
    echo "</script>";
}
else{
    echo "<script>";
    echo "alert('You have unsucessfully resumed the game');";
    echo "</script>";
    }
?>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <link rel="stylesheet" type="text/css" media="all" href="style.css"> 
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
      <script type="text/javascript" src="script.js"></script>
    </head>
    <body>
        <div id="container">
        <header>
            <h1> Tic Tac Toe </h1>
        </header>
        <ul id="board">
            
            <li id="spot1">+</li>
            <li id="spot2">+</li>
            <li id="spot3">+</li>
            <li id="spot4">+</li>
            <li id="spot5">+</li>
            <li id="spot6">+</li>
            <li id="spot7">+</li>
            <li id="spot8">+</li>
            <li id="spot9">+</li>
        </ul>
        <div class="clearfix"></div>
        <footer>

        </footer>
        </div>
                                <?php
                        if (!isset($_SESSION)) {
                                session_start();
                            }
                        
$params6 = array('gid' => $_SESSION['gameid']);
                                            try {
                                                $response4 = $client->getBoard($params6);
                                                $result4 = $response4->return;
                                                ?>
            <table>
                <tr>
                    <td><h1>MOVES SO FAR</h1></td>
                    <td><?php echo $result4; ?></td>
                </tr>
            </table> 
                                                
                                                
                                                <?php
                                            }
                                            catch (Exception $e) 
                                                {
                                                    echo "<h2>Exception Error!</h2>";
                                                    echo $e->getMessage();
                                                }
                ?> 

    </body>
</html>    