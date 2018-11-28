<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <link rel="stylesheet" type="text/css" media="all" href="style.css"
    </head>
    <body>
            <table class = "box" style = "border: solid black 1px; background-color: skyblue; margin-left: 20px; margin-left: 20px;">
                <tr>
                    <td><h1 style="color: red;">LEADERBOARD</h1></td>
                                </tr>    
                    <td>
                <?php
                  $wsdl = "http://localhost:8080/TTTWebApplication/TTTWebService?wsdl";
                   $client = new SoapClient($wsdl, array('trace'=>1));
                                            try {
                                                $response = $client->leagueTable();
                                                $result = $response->return;
                                                    echo $result;


                                            }
                                            catch (Exception $e) 
                                                {
                                                    echo "<h2>Exception Error!</h2>";
                                                    echo $e->getMessage();
                                                }
                  ?>                              
                    </td>

            </table> 

    </body>
</html>

