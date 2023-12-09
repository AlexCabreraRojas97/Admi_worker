/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;


import Modelos.Usuario;
import Modelos.UsuarioDAO;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author AdminSena
 */
@WebServlet(name = "Controlador", urlPatterns = {"/Controlador"})
public class Controlador extends HttpServlet {

    Usuario usuario = new Usuario();
    UsuarioDAO usuarioDAO = new UsuarioDAO();
    int idUsuario;
    
    
    

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

        String menu = request.getParameter("menu");
        String accion = request.getParameter("accion");
        if (menu.equals("Principal")) {
            request.getRequestDispatcher("Principal.jsp").forward(request, response);
        }
        
        
        if (menu.equals("Empleados")) {

            switch (accion) {
                
                case "Listar":
                    List lista = usuarioDAO.Listar();
                    request.setAttribute("a_user", lista);

                    break;
                case "Agregar":
                    String nombre = request.getParameter("txtnombre");
                    String apellido = request.getParameter("txtapellido");
                    int tipodocumento = Integer.parseInt(request.getParameter("txttipodocumento"));
                    String documento = request.getParameter("txtdocumento");
                    String correo = request.getParameter("txtcorreo");
                    String celular = request.getParameter("txtcelular");
                    String password = request.getParameter("txtpassword");
                    String fecha = request.getParameter("txtdate");
                    String tipousuario = request.getParameter("txttipousuario");
                    
                    usuario.setTipousuario(tipousuario);
                    usuario.setNombre(nombre);
                    usuario.setApellido(apellido);
                    usuario.setTipodocumento(tipodocumento);
                    usuario.setDocumento(documento);
                    usuario.setCorreo(correo);
                    usuario.setCelular(celular);
                    usuario.setPassword(password);
                    usuario.setFecha(fecha);
                    //usuario.setCreatedUser(tipoacceso);
                    
                    usuarioDAO.Agregar(usuario);
                    
                    request.getRequestDispatcher("Controlador?menu=Empleados&accion=Listar").forward(request, response);
                         
                    break;
                case "Actualizar":

                    Usuario usuario1 = new Usuario();
                    String documentoUpdate = request.getParameter("txtdocumento");
                    String nombreUpdate = request.getParameter("txtnombre");
                    String correoUpdate = request.getParameter("txtcorreo");
                    String passwordUpdate = request.getParameter("txtpassword");
                    String apellidoUpdate=request.getParameter("txtapellido");
                    int tipodocumentoUpdate=Integer.parseInt(request.getParameter("txttipodocumento"));
                    String fechaUpdate=request.getParameter("txtfecha");
                    String tipousuarioUpdate=request.getParameter("txttipousuario");
                    
                    usuario1.setFecha(fechaUpdate);
                    usuario1.setTipodocumento(tipodocumentoUpdate);
                    usuario1.setTipousuario(tipousuarioUpdate);
                    usuario1.setDocumento(documentoUpdate);
                    usuario1.setNombre(nombreUpdate);
                    usuario1.setApellido(apellidoUpdate);
                    usuario1.setCorreo(correoUpdate);        
                    usuario1.setPassword(passwordUpdate);
                    usuario1.setId(idUsuario);
                    usuarioDAO.Actualizar(usuario1);
                    request.getRequestDispatcher("Controlador?menu=Empleados&accion=Listar").forward(request, response);

                    break;
                case "Cargar":

                    idUsuario = Integer.parseInt(request.getParameter("ID"));
                    Usuario usuario = usuarioDAO.ListarPorId(idUsuario);
                    request.setAttribute("usuarioSeleccionado", usuario);
                    request.getRequestDispatcher("Controlador?menu=Empleados&accion=Listar").forward(request, response);

                    break;
                case "Eliminar":

                    idUsuario = Integer.parseInt(request.getParameter("ID"));
                    usuarioDAO.Eliminar(idUsuario);
                    request.getRequestDispatcher("Controlador?menu=Empleados&accion=Listar").forward(request, response);

                    break;
            }
            request.getRequestDispatcher("Empleados.jsp").forward(request, response);
            
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
