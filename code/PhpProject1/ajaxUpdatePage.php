<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <link rel="stylesheet" type="text/css" media="all" href="style.css"> 
    </head>
    <body>
        <div if="getdata"></div>
        
        <script type="text/javascript">
            function dis()
            {
                xmlhttp.open("GET","select.php?nm="+document.getElementById("t1").value,false);
                xmlhttp.send(null);
                document.getElementById("d1").innerHTML=xmlhttp.responseText;
                document.getElementById("d1").style.visibility='visible';
            }
        </script>    
        
        
        
    </body>
</html>

