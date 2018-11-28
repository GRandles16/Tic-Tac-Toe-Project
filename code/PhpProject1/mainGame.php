<?php
include 'Soap.php';
if (!isset($_SESSION)) {
    session_start();
}
?>
<?php
$uId = $_SESSION['userId'];
$s_array = explode(",", $_POST['data']);

$spaces = array(); //to store space
$splitString = array();
foreach ($s_array as $word) {
    if ($word) {
        array_push($splitString, $word);
    }
}

$count = count($splitString);

for ($i = 0; $i < $count; $i++) {
    for ($j = 0; $j < $count; $j++) {
        $result[$i][$j + 1] = $splitString[$i];
    }
}
//print_r($splitString[0]);
//print_r($splitString[1]);

//$wsdl = "http://localhost:8080/TTTWebApplication/TTTWebService?wsdl";
//$client = new SoapClient($wsdl, array('trace' => 1));

$params = array('uid' => $uId, 'gid' => $splitString[0]);

$_SESSION['gameid'] = $splitString[0];

try {
    $response = $client->joinGame($params);
    $result = $response->return;
    $result;
} catch (Exception $e) {
    echo "<h2>Exception Error!</h2>";
    echo $e->getMessage();
}
?>
<?php
if ($result == 1) {
    echo "<script>";
    echo"alert('You have sucessfully joined the game, good luck!');";
    echo "</script>";
} else {
    echo "<script>";
    echo "alert('You have unsucessfully joined the game');";
    echo "</script>";
}
?>
////////////////////////////////////RESUME GAME////////////////////////////////////////
<?php ?>

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
} catch (Exception $e) {
    echo "<h2>Exception Error!</h2>";
    echo $e->getMessage();
}
?> 

    </body>
</html> 




