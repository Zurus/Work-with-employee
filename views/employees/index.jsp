<%-- 
    Document   : index
    Created on : Sep 3, 2015, 4:48:37 PM
    Author     : Артур
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="../../css/bootstrap.min.css" rel="stylesheet">
        <link href="../../css/heroic-features.css" rel="stylesheet">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script src="../../js/jquery-1.9.1.js"></script>
        <script src="../../js/bootstrap.min.js"></script>
        <script src ="../../js/employees.js"></script>
    </head>
    <body>
        <% 
        Cookie[] arrOfCookies = request.getCookies();
        String lg = null;
        for(Cookie value:arrOfCookies){
            if(value.getName().equals("Login")){
                lg=value.getValue();
            }
        }
        if(lg==null){
            response.sendRedirect("/servlet/index.jsp");
        }
        //out.println("<h1>Привет "+lg+" </h1>");
        %>
        <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#">Start Bootstrap</a>
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li>
                        <a href="#">About</a>
                    </li>
                    <li>
                        <a href="#">Services</a>
                    </li>
                    <li>
                        <a href="#">Contact</a>
                    </li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>
        <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <h2>
                    <p class="text-center">Add employee</p>
                </h2>
            </div>
        </div>
            <div class="row">
            <div class="col-lg-12">
                <table class="table" id ="employees">
                    <thead>
                        <tr>
                            <th>Фио</th>
                            <th>Возраст</th>
                            <th>Зарплата</th>
                            <th>Действия</th>
                        </tr>
                    </thead>
                    <tbody>
                        
                    </tbody>
                </table>
            </div>
        </div>
        <h1></h1>
        <a href="addEmployees.jsp" class="btn btn-success"> Добавить нового сотрудника </a>
        <h1></h1>
        <a id="exit" class="btn btn-success"> Выйти </a>
        </div>
    </body>
</html>
