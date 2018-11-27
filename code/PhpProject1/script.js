
             $(document).ready(function(){
                 $isItClicked1 = 0;
                 $isItClicked2 = 0;
                 $isItClicked3 = 0;
                 $isItClicked4 = 0;
                 $isItClicked5 = 0;
                 $isItClicked6 = 0;
                 $isItClicked7 = 0;
                 $isItClicked8 = 0;
                 $isItClicked9 = 0;
                 
                 
                 
             $('#spot1').click(function(){ 
                Square1();
   
             });
             
              $('#spot2').click(function(){  
                Square2();
                 
             });
             
              $('#spot3').click(function(){  
                Square3();
                 
             });
             
              $('#spot4').click(function(){  
                Square4();
                 
             });
             
             $('#spot5').click(function(){  
                Square5();
                 
             });
            
             $('#spot6').click(function(){  
                Square6();
                 
             }); 
             
             $('#spot7').click(function(){  
                Square7();
                 
             });
             
             $('#spot8').click(function(){  
                Square8();
                 
             });
             
             $('#spot9').click(function(){  
                Square9();
                 
             });
                 
            });

            function Square1(){

                var x = "0";
                var y = "0";
                var gid = "56";
                var method = "submit";
                
                if($isItClicked1 == 0)
                {
                   $('#spot1').text("x"); 
                }
                else if($isItClicked1 == 1)
                {
                    alert("youve already taken this space dummy");
                }
                $isItClicked1 = 1;
                

                $.ajax({
                    cache: false,
                    url: "phpcode.php",
                    type: "post",
                    data: {Method : method, x : x, y : y, gid: gid},
                    success: function(phpresponse){
                        alert(phpresponse);
                    }
                    
                });
            }
            
            function Square2(){

                var x = "0";
                var y = "1";
                var gid = "56";
                var method = "submit";
                
                if($isItClicked2 == 0)
                {
                   $('#spot2').text("x"); 
                }
                else if($isItClicked2 == 1)
                {
                    alert("youve already taken this space dummy");
                }
                $isItClicked2 = 1;
                

                $.ajax({
                    cache: false,
                    url: "phpcode.php",
                    type: "post",
                    data: {Method : method, x : x, y : y, gid: gid},
                    success: function(phpresponse){
                        alert(phpresponse);
                    }
                    
                });
            }
            
               function Square3(){

                var x = "0";
                var y = "2";
                var gid = "56";
                var method = "submit";
                
                if($isItClicked3 == 0)
                {
                   $('#spot3').text("x"); 
                }
                else if($isItClicked3 == 1)
                {
                    alert("youve already taken this space dummy");
                }
                $isItClicked3 = 1;
                
                $.ajax({
                    cache: false,
                    url: "phpcode.php",
                    type: "post",
                    data: {Method : method, x : x, y : y, gid: gid},
                    success: function(phpresponse){
                        alert(phpresponse);
                    }
                    
                });
            }
            
            function Square4(){

                var x = "1";
                var y = "0";
                var gid = "56";
                var method = "submit";
                
                if($isItClicked4 == 0)
                {
                   $('#spot4').text("x"); 
                }
                else if($isItClicked4 == 1)
                {
                    alert("youve already taken this space dummy");
                }
                $isItClicked4 = 1;
                
                $.ajax({
                    cache: false,
                    url: "phpcode.php",
                    type: "post",
                    data: {Method : method, x : x, y : y, gid: gid},
                    success: function(phpresponse){
                        alert(phpresponse);
                    }
                    
                });
            }
            function Square5(){

                var x = "1";
                var y = "1";
                var gid = "56";
                var method = "submit";
                
                if($isItClicked5 == 0)
                {
                   $('#spot5').text("x"); 
                }
                else if($isItClicked5 == 1)
                {
                    alert("youve already taken this space dummy");
                }
                $isItClicked5 = 1;

                $.ajax({
                    cache: false,
                    url: "phpcode.php",
                    type: "post",
                    data: {Method : method, x : x, y : y, gid: gid},
                    success: function(phpresponse){
                        alert(phpresponse);
                    }
                    
                });
            }
            
            function Square6(){

                var x = "1";
                var y = "2";
                var gid = "56";
                var method = "submit";
                
                if($isItClicked6 == 0)
                {
                   $('#spot6').text("x"); 
                }
                else if($isItClicked6 == 1)
                {
                    alert("youve already taken this space dummy");
                }
                $isItClicked6 = 1;

                $.ajax({
                    cache: false,
                    url: "phpcode.php",
                    type: "post",
                    data: {Method : method, x : x, y : y, gid: gid},
                    success: function(phpresponse){
                        alert(phpresponse);
                    }
                    
                });
            }
            
            function Square7(){

                var x = "2";
                var y = "0";
                var gid = "56";
                var method = "submit";
                
                if($isItClicked7 == 0)
                {
                   $('#spot7').text("x"); 
                }
                else if($isItClicked7 == 1)
                {
                    alert("youve already taken this space dummy");
                }
                $isItClicked7 = 1;

                $.ajax({
                    cache: false,
                    url: "phpcode.php",
                    type: "post",
                    data: {Method : method, x : x, y : y, gid: gid},
                    success: function(phpresponse){
                        alert(phpresponse);
                    }
                    
                });
            }
            
            function Square8(){

                var x = "2";
                var y = "1";
                var gid = "56";
                var method = "submit";
                
                if($isItClicked8 == 0)
                {
                   $('#spot8').text("x"); 
                }
                else if($isItClicked8 == 1)
                {
                    alert("youve already taken this space dummy");
                }
                $isItClicked8 = 1;

                $.ajax({
                    cache: false,
                    url: "phpcode.php",
                    type: "post",
                    data: {Method : method, x : x, y : y, gid: gid},
                    success: function(phpresponse){
                        alert(phpresponse);
                    }
                    
                });
            }
            
            function Square9(){

                var x = "2";
                var y = "2";
                var gid = "56";
                var method = "submit";
                
                if($isItClicked9 == 0)
                {
                   $('#spot9').text("x"); 
                }
                else if($isItClicked9 == 1)
                {
                    alert("youve already taken this space dummy");
                }
                $isItClicked9 = 1;

                $.ajax({
                    cache: false,
                    url: "phpcode.php",
                    type: "post",
                    data: {Method : method, x : x, y : y, gid: gid},
                    success: function(phpresponse){
                        alert(phpresponse);
                    }
                    
                });
            }