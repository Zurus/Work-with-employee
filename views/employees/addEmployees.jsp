<%-- 
    Document   : addEmployees
    Created on : Jan 18, 2016, 5:00:36 PM
    Author     : Артур
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="../../css/bootstrap.min.css" rel="stylesheet">
        <link href="../../css/heroic-features.css" rel="stylesheet">
        <script src="../../js/jquery-1.9.1.js"></script>
        <script src="../../js/bootstrap.min.js"></script>
        <script type="text/javascript" src="check.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h2>
            <p class="text-center">Add employee</p>
        </h2>
        <div class="container">
        <div class="row">
        <div class="col-lg-6">
        <form action="/servlet/Employees" role="form" method="POST">
            <div class="form-group"> 
                <label for="name"> Name employee </label> 
                <input type="text" class="form-control" id="name" name="name"/>
                <label for="name"> Age employee </label>   
                <input type="text" class="form-control" id="age" name="age"/>
                <label for="name"> Wage employee </label>  
                <input type="text" class="form-control" id="wage" name="wage"/>
            <input type="hidden" name ="action" value="add"/>
            <input  type="submit" name ="send" value="send"/>
            </div>
        </form>
        </div>
        </div>
        </div>
    </body>
</html>
