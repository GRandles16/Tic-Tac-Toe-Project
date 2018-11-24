<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" media="all" href="style.css"
    </head>
    <body>
        <form action="register.php" method="post">
            <table class = "box" style = "border: solid black 1px; background-color: skyblue; margin-left: 20px; margin-left: 20px;">
                <tr>
                    <td><h1 style="color: red;">Registration Page</h3></td>
                    <td></td>
                </tr>
                <tr><td>Username:  </td><td><input type="text" name="username"></td></tr>
                <tr><td>Password:  </td><td><input type="password" name="password"></td></tr>
                <tr><td>Name:   </td><td><input type="text" name="name"></td></tr>
                <tr><td>Surname:  </td><td><input type="text" name="surname"></td></tr>

                <tr><td><input class = "button" onclick="myFunction()" type="submit" name="submit" value="register"></td></tr>

            </table> 
        </form> 
<script>
function myFunction()
{
alert("You have Sucessfully Registered, Please Login to continue");
}
</script>
    </body>
</html>
