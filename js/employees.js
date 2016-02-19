$(document).ready(function(){
    
    $('#employees tbody').empty();
    $.ajax({
        url:'/servlet/Employees',
        type:'get',
        success:function(data){
            str = ''
            $.each(data, function(idx,value){
                var age = (value.age==0)?"Не указан!":value.age;
                $('#employees tbody').append("<tr id='employee"+value.id+"'><td>"+value.name+"</td><td>"+age+"</td><td>"+(value.wage).toFixed(1)+"</td>\n\
                    <td><button id='del"+value.id+"'>Delete</button></td></tr>")
                $("#del"+value.id).click(function(){
                    deleteEmployee(value.id)
                })
                
            }); 
        }
    });
    function deleteEmployee(employee_id) { 
       $.post("/servlet/Employees",{id:employee_id,action:"del"},function(data){
           alert(data.message);
           $("#employee"+employee_id).remove();
           $("#del"+employee_id).remove();
       });
    }
    $("#update").click(function() {
        $('#employees').empty();
        $.ajax({
            url:'/servlet/Employees',
            data: {id: 1},
            type:'get',
            success:function(data){
                $('#employees').html(data);
            }
        });
    });
    $("#exit").click(function(){
        window.location.href="/servlet/Users?action=logout";
    })

})
window.onload = init;
function init(){
    var button = document.getElementById("test");
    button.onclick = function(){
        window.location.assign('http://ya.ru')
    }
}