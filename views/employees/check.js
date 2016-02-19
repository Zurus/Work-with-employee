$(document).ready(function(){
  $("form input:last-child").click(function(){
        var name = $("form input:first-child").val();
        alert(name);
    });  
});