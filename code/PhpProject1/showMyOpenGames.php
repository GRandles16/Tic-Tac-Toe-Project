<?php
include 'Soap.php';
if (!isset($_SESSION)) {
    session_start();
}
?>
<!-- ///////////////////////////////showMyOpenGames////////////////////////////////////////////////-->
<?php
//$wsdl = "http://localhost:8080/TTTWebApplication/TTTWebService?wsdl";
//$trace = true;
//$client = new SoapClient($wsdl, array('trace' => $trace));

$uId = $_SESSION['userId'];
$GId = $_SESSION['data'];
$s_array = explode(".", $GId);

//to remove spaces

$spaces = array(); //to store space
$others = array(); //to store characters
$allGames = array();
foreach ($s_array as $word) {
    $endsWith = substr($word, -1);
    $startsWith = substr($word, 0, 1);
        if ($startsWith == '0') {
            $word = ltrim($word, '0');
            array_push($others, $word);
            array_push($allGames, $word);
        }

        else if ($word) {
            array_push($others, $word);  //string variables are stored into others array
            array_push($allGames, $word);
        }
}

$count = count($others);

for ($i = 0; $i < $count; $i++) {
    for ($j = 0; $j < $count; $j++) {
        //$result[$i][$j] = $value;
        $result[$i][$j + 1] = $others[$i];
        $result[$i][$j + 1] = $allGames[$i];
    }
    // print_r ($others[$i]) ;
}
///////////////////////////////All OpenGames///showOpenGames/////////////////////////////////////////////-->


try {
    $response = $client->showOpenGames();
    $data = $response->return;

} catch (Exception $e) {
    echo "<h2>Exception Error!</h2>";
    echo $e->getMessage();
}

$s_array1 = explode(".", $data);

$spaces1 = array(); //to store space
$allGames1 = array();
foreach ($s_array1 as $word) {
    $endsWith = substr($word, -1);
    $startsWith = substr($word, 0, 1);
        if ($startsWith == '0') {
            $word = ltrim($word, '0');
            array_push($allGames1, $word);
        }

        else if ($word) {
            array_push($allGames1, $word);
        }
}

$count1 = count($others);

for ($i = 0; $i < $count1; $i++) {
    for ($j = 0; $j < $count1; $j++) {
        $result[$i][$j + 1] = $allGames1[$i];
    }
   // print_r ($allGames1[$i]) ;
}
/////////////////////////////////retrieve all games user has played/playing/////////////////////////////////////////////
try {
    $params = array('uid'=>$uId);
    $response5 = $client->showAllMyGames($params);
    $data5 = $response5->return;
    echo $data5;
    echo $uId;

} catch (Exception $e) {
    echo "<h2>Exception Error!</h2>";
    echo $e->getMessage();
}

$s_array5 = explode(".", $data5);

$spaces5 = array(); //to store space
$resumeGames = array();
foreach ($s_array5 as $word) {
    $endsWith = substr($word, -1);
    $startsWith = substr($word, 0, 1);
        if ($startsWith == '0') {
            $word = ltrim($word, '0');
            array_push($resumeGames, $word);
        }

        else if ($word) {
            array_push($resumeGames, $word);
        }
}

$count5 = count($others);

for ($i = 0; $i < $count5; $i++) {
    for ($j = 0; $j < $count5; $j++) {
        $result1[$i][$j + 1] = $resumeGames[$i];
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
        <h1 style="color: red;">Displaying My Open Games That 2nd player has not joined</h1>
        <form>
            <select name = "others" id="array">
                    <?php
                        foreach ($others as $value) {
                            printf('<option>%s</option>option>', $value);
                        }
                    ?>    
            </select>  
            <input type="submit" value="Resume">

        </form>
        <h1 style="color: red;">Showing All Open Games (list of games awaiting 2nd player)</h1>
            <form action="mainGame.php" method="post">
                <select name = "data" id="array">
                    <?php
                        foreach ($allGames1 as $value) {
                            printf('<option>%s</option>option>', $value);
                        }
                    ?>    
                </select>  
                <input type="submit" value="Join">

            </form>
         <h1 style="color: red;">Showing All games user has played/playing</h1>
         <form action="showAllMyGames.php" method="post">
                <select name = "data5" id="array">
                    <?php
                        foreach ($resumeGames as $value) {
                            printf('<option>%s</option>option>', $value);
                        }
                    ?>    
                </select>  
                <input type="submit" value="Re-Join">

            </form> 
    </body>
</html>


