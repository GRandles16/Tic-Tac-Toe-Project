<?php 
if (!isset($_SESSION)) {
    session_start();
}

    
    $method = $_POST['Method'];
    
    $method();
    
    function submit(){
        $x = $_POST['x'];
        $y = $_POST['y'];
       // $check = $_POST['check'];

        $gid1 = $_SESSION['gameid'];
        $uid1 = $_SESSION['userId'];

    include 'Soap.php';    
//$wsdl = "http://localhost:8080/TTTWebApplication/TTTWebService?wsdl";
//$client = new SoapClient($wsdl, array('trace' => 1));
        
        $params2 = array('x' => $x,'y' => $y, 'gid' => $gid1);
        $params3 = array('x' => $x,'y' => $y, 'gid' => $gid1, 'pid' => $uid1);

                try {
                    $response2 = $client->checkSquare($params2);
                    $result2 = $response2->return;
                     echo $result2;
                     if($result2 == 0)
                     {
                                    try {
                               $response2 = $client->takeSquare($params3);
                               $result3 = $response2->return;
                                echo $result3;
                                if($result3 == 1)
                                {
                                   echo "You have taken this space...";
                                   $params = array('gid' => $gid1);

                                            try {
                                                $response = $client->getGameState($params);
                                                $result = $response->return;
                                                if($result == -1)
                                                    echo "Waiting for a second palyer to join";
                                                else if($result == 0)
                                                    echo "The game is still in progress...";
                                                else if($result == 1)
                                                    echo "Player 1 has won";
                                                else if($result == 2)
                                                    echo "Player 2 has won";
                                                else if($result == 3)
                                                    echo "The game is a draw";
                                                else
                                                    echo "Error";
                                            $param2 = array('gid' => $gid1, 'gstate' => $result);
                                            try {
                                                $response4 = $client->setGameState($param2);
                                                $result4 = $response4->return;
                                                if($result4 == 1)
                                                    echo "Game state updated";
                                                else
                                                    echo "game state cannot update";

                                            }
                                            catch (Exception $e) 
                                                {
                                                    echo "<h2>Exception Error!</h2>";
                                                    echo $e->getMessage();
                                                }
                                            }
                                            catch (Exception $e) 
                                                {
                                                    echo "<h2>Exception Error!</h2>";
                                                    echo $e->getMessage();
                                                }
                                                ////////////////////////////////check if game has been won after every button click ////////////////////////////
                                                $param3 = array('gid' => $gid1);
                                            try {
                                                $response5 = $client->checkWin($param3);
                                                $result5 = $response5->return;
                                                if($result5 == 0)
                                                    echo "hasnt been won yet...";
                                                else if($result5 == 1){
                                                    echo "Player 1 has WON THE GAME!!!...";
                                                }
                                                else if($result5 == 2){
                                                header("Location: mainMenuPage.php");
                                                echo "Player 2 has WON THE GAME!!!...";
                                                }
                                                else if($result5 == 3){
                                                header("Location: mainMenuPage.php");
                                                echo "The game has ended a draw!...";
                                                }
                                                else
                                                    echo "Theres a problem checking who won...";

                                            }
                                            catch (Exception $e) 
                                                {
                                                    echo "<h2>Exception Error!</h2>";
                                                    echo $e->getMessage();
                                                }
                                                
                                }
                                else if($result3 == 0){
                                    echo "You cannot take this space...";
                                }
                                else{
                                    echo "Theres a problem connecting";
                                }
                           } catch (Exception $e) {
                               echo "<h2>Exception Error!</h2>";
                               echo $e->getMessage();
                           }
                     }
                     else if($result2 == 1){
                         echo "This space has already been taken...";
                     }
                     else{
                         echo "Theres a problem connecting";
                     }
                } catch (Exception $e) {
                    echo "<h2>Exception Error!</h2>";
                    echo $e->getMessage();
                }
    }

