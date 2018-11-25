<?php
if(!isset($_SESSION)) 
{ 
    session_start(); 
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
                    <td><h1 style="color: red;">Main Menu</h3></td>
            
                    <td></td>

                </tr>

                <tr>
                    <td>
                    <td><input onclick="myFunction()" type="submit" name="New-Game" value="newGame" /></td><br>
                    <td><input type="submit" name="League-Table" value="leagueTable" /></td><br>
                    <td><input type="submit" name="Show-My-Open-Games" value="showMyOpenGames" /></td><br>
                             
                        
                        
                    </td>
                </tr>

            </table> 
        </form> 
<script>
function myFunction()
{
alert("New Game has been Created!");
}
</script>
    </body>
</html>

         

