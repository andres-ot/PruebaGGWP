/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import accesodato.Conexion;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import negocio.Ciudad;

/**
 *
 * @author ricardotoledo
 */
@WebServlet(urlPatterns = {"/ServletCiudad"})
public class ServletCiudad extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            Ciudad city = new Ciudad();
            if (request.getParameter("eliminar") != null) {
                int eliminar_id = Integer.parseInt(request.getParameter("eliminar"));
                city.setCiudad_id(eliminar_id);
                city.eliminar();
                response.sendRedirect("ciudades/index.jsp");
                // SI LA VARIABLE ENVIADA DESDE EDITAR.JSP DE NOMBRE EDITAR NO VIENE VACIA "RECIBE LOS DATOS"
            } else if (request.getParameter("editar") != null) {
                // OJO CON LA VARIABLE ID QUE ESTA EN EL CAMPO HIDDEN DEL FORMULARIO EDITAR
                int id = Integer.parseInt(request.getParameter("id"));
                String nombre = request.getParameter("nombre");

                
                city.setCiudad_id(id);
                city.setNombre(nombre);

                //SE LLAMA AL METODO ACTUALIZAR DE LA CLASE USUARIO
                city.actualizar();
                //SE REDIRECCIONA AL INDEX
                response.sendRedirect("ciudades/index.jsp");
            } // EN CASO DE QUE NO SE ELIMINE NI SE ACTUALICE SE GUARDA
            else {
                String nombre = request.getParameter("nombre");

                //int ciudad_id = Integer.parseInt(request.getParameter("ciudad_id"));

                city.setNombre(nombre);

                //city.setCiudad_id(ciudad_id);
                city.crear();
                response.sendRedirect("ciudades/index.jsp");

            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
