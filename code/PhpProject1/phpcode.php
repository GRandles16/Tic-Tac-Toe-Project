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

        
$wsdl = "http://localhost:8080/TTTWebApplication/TTTWebService?wsdl";
$client = new SoapClient($wsdl, array('trace' => 1));
        
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
                                   echo "You have taken this space";
                                }
                                else if($result3 == 0){
                                    echo "You cannot take this space";
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
                         echo "This space has already been taken";
                     }
                     else{
                         echo "Theres a problem connecting";
                     }
                } catch (Exception $e) {
                    echo "<h2>Exception Error!</h2>";
                    echo $e->getMessage();
                }
    }

