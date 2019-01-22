
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome to Spring Web MVC project</title>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script>
        $(document).ready(function () { // Οταν φορτώσει η σελίδα τρέξε....
        $("#triger").keyup(function () { // Βάλε handler στο input type
          var text = $(this).val(); // Το κείμενο το χρήστη
          // alert(text);
          $.ajax({
            url: 'usersrest/usersinput.htm?usersinput=' + text,
            contentType: 'aplication/json',
            success: function (result) {
              
              $("#ajaxoutpout").empty();
              var jsonobj = $.parseJSON(result);
              
              $.each(jsonobj, function (i, item) {
                    $tr = $('<tr>').append(
                    $('<td>').text(item.name),
                    $('<td>').text(item.lastname)

                    );
                $("#ajaxoutpout").append($tr);
              });
            }
          });
        });      
    });      
          </script>
    </head>

    <body>
        
    <form action="users/name.htm">
  First name:<br>
  <input type="text" name="name" value=""><br>
  <br>
  <input type="submit" value="Submit">
</form>
    <input id="triger" type="text" name="ajaxname">
    <div id="ajaxoutpout"> </div>
    
    </body>

</html>
