<%@page import="accesodato.Conexion"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
        <meta name="description" content="">
        <meta name="author" content="">
        <link rel="icon" href="../../favicon.ico">
        <title>Starter Template for Bootstrap</title>
        <link href="../template/css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body>
        <nav class="navbar navbar-inverse navbar-fixed-top">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="../index.jsp">CRUD JSP</a>
                </div>
                <div id="navbar" class="collapse navbar-collapse">
                    <ul class="nav navbar-nav">
                        
                        <li><a href="../usuarios/index.jsp">Usuarios</a></li>
                        <li><a href="index.jsp">Ciudades</a></li>
                    </ul>
                </div><!--/.nav-collapse -->
            </div>
        </nav>
        <div class="container">
            <br><br><br>
            <div class="row">
                <div class="panel panel-primary">
                    <div class="panel-heading">
                        <h3 class="panel-title">Actualizar Usuario</h3>
                    </div>
                    <% 
                        int id=Integer.parseInt(request.getParameter("editar"));
                        Conexion con=new Conexion();
                        con.setConsulta("select * from Ciudades where ciudad_id='"+id+"'");
                    %>
                    <div class="panel-body">
                        <% while(con.getResultado().next()){  %>
                        
                        <form method="POST" action="../ServletCiudad?editar=si">
                            <!-- OJO CON EL CAMPO READONLY QUE ES ENVIADO POR EL FORMULARIO PARA ACTUALIZAR -->
                            <input type="text" readonly="true" value='<% out.println(""+con.getResultado().getString("ciudad_id")); %>' name="id">
                            <div class="form-group">
                                <label for="nombre">Nombre </label>
                                <input type="text" class="form-control" name="nombre" value='<% out.println(""+con.getResultado().getString("nombre")); %>' id="nombre" placeholder="Ingresar Nombre">
                            </div>
                           
                            
                            <button type="submit" class="btn btn-default">ACTUALIZAR</button>
                        </form>
                       <% } %> 

                    </div>
                </div>
            </div>
        </div><!-- /.container -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
        <script src="../template/js/bootstrap.min.js"></script>

    </body>
</html>
