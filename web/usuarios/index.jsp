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

        <!-- Bootstrap core CSS -->
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
                        <li><a href="index.jsp">Usuarios</a></li>
                        <li><a href="../ciudades/index.jsp">Ciudades</a></li>
                    </ul>
                    </ul>
                </div><!--/.nav-collapse -->
            </div>
        </nav>

        <div class="container">

            <div class="starter-template">
                <br>
                <br>
                <br>
                 <div class="panel panel-primary">
                    <div class="panel-heading">
                        <h3 class="panel-title">Listar Ciudades</h3>
                    </div>
                    <div class="panel-body">
                <table class='table table-striped table-bordered table-hover table-condensed'>
                    <a href="crear.jsp" class="btn btn-primary">Nuevo Usuario</a>
                    <br>
                    <br>
                    <form method="post" action="index.jsp">
                        Buscar por Nombre:<input type="text" name="buscarNombre" ><input type="submit" value="Buscar">
                    </form>
                    <br>
                    <br>
                    <thead>
                        <tr>
                            <th>ID:</th>
                            <th>Nombre:</th>
                            <th>Apellido Paterno:</th>
                            <th>Apellido Materno:</th>
                            <th>Ciudad:</th>
                            <th>Acciones:</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            Conexion con = new Conexion();
                            if (request.getParameter("buscarNombre") != null) {
                                if (request.getParameter("buscarNombre").isEmpty()) {
                                    con.setConsulta("select *,ciudad_id as ciudad from Usuarios where estado='activo'");
                                } else {

                                    String nombre = request.getParameter("buscarNombre");
                                    con.setConsulta("select *,ciudad_id as ciudad from Usuarios where nombre like '%" + nombre + "%' and estado='Activo'");
                                }
                            } else {
                                con.setConsulta("select *, ciudad_id as ciudad from Usuarios where estado='Activo'");
                            }
                        %>
                        <%
                            //con.setConsulta("select Usuarios.usuario_id,Usuarios.nombre,Usuarios.apepat,Usuarios.apemat,Ciudades.nombre as ciudad from Usuarios,Ciudades where Usuarios.ciudad_id=Ciudades.ciudad_id and Usuarios.estado='Activo'");
                            while (con.getResultado().next()) {
                                out.println("<tr>");
                                out.println("<td>" + con.getResultado().getString("usuario_id") + "</td>");
                                out.println("<td>" + con.getResultado().getString("nombre") + "</td>");
                                out.println("<td>" + con.getResultado().getString("apepat") + "</td>");
                                out.println("<td>" + con.getResultado().getString("apemat") + "</td>");
                                out.println("<td>" + con.getResultado().getString("ciudad") + "</td>");
                                out.println("<td>" + "<a href='../ServletUsuario?eliminar=" + con.getResultado().getString("usuario_id") + "' class='btn btn-danger'>Eliminar</a>" + "</td>");
                                out.println("<td>" + "<a href='editar.jsp?editar=" + con.getResultado().getString("usuario_id") + "' class='btn btn-primary'>Editar</a>" + "</td>");

                                out.println("</tr>");
                            }
                        %>
                    </tbody>
                </table>
                    </div>
            </div><!-- /.container -->


            <!-- Bootstrap core JavaScript
            ================================================== -->
            <!-- Placed at the end of the document so the pages load faster -->
            <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
            <script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
            <script src="../template/js/bootstrap.min.js"></script>

    </body>
</html>
