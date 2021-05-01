/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import javax.servlet.ServletConfig;

/**
 *
 * @author user
 */
public class Actualizar extends HttpServlet {

    private Connection con;
    private Statement set;
    private ResultSet rs;
            
    public void init(ServletConfig cfg) throws ServletException{
        
        String URL = "jdbc:mysql://localhost/registro4iv8";
        //driver:gestor:puerto//IP/nombreDB
        
        String userName = "root";
        String password = "Dante@23$";
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            
            con = DriverManager.getConnection(URL,userName,password);
            set = con.createStatement();
            System.out.println("Conexion exitosa");
            
        }catch(Exception e){
            
            System.out.println("Conexion no exitosa");
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
            
        }
    }
        
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
            /* TODO output your page here. You may use following sample code. */
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Actualizar</title>"
                    + "<link rel=\"stylesheet\" href=\"./CSS/cssINFO.css\">");            
            out.println("</head>");
            out.println("<body>"
                    + "<h1>Actualización de Usuario</h1>");
               
            String nom, appat, apmat, correo;
            int edad, id;            

            nom = request.getParameter("nombre_a");   
            appat = request.getParameter("appat_a");
            apmat = request.getParameter("appmat_a");
            correo = request.getParameter("correo_a");
            id = Integer.parseInt(request.getParameter("idactualizar"));             
            edad = Integer.parseInt(request.getParameter("edad_a"));
            
            try{

               String q = "UPDATE mregistro \n"
                        + "SET nom_usu = '"+nom+"', ap_usu = '"+appat+"', am_usu = '"+apmat+"', edad_usu = "+edad+", corr_usu = '"+correo+"' \n"
                        + "WHERE id_usu ="+id+" ;";
                

                set.executeUpdate(q);
                
               out.println("Tu nombre actualizado es: " + nom
                    + "<br>"
                    + "Tu apellido paterno actualizado es: " + appat
                    + "<br>"
                    + "Tu apellido materno actualizado es: " + apmat
                    + "<br>"
                    + "Tu edad actualizada es: " +edad
                    + "<br>"
                    + "Tu correo electronico actualizado es:  "+correo);
                out.println("<br>"
                        + "<h1>Registro Exitoso</h1>"); 
              
            }catch(Exception e){
                out.println("<h1>Usuario No Actulaizado</h1>");
                System.out.println("No se pudo actualizar el usuario");
                System.out.println(e.getMessage());
                System.out.println(e.getStackTrace());
             
            }
           
            
            
            out.println("<br>"
                    + "<a href='index.html'>Regresar a la pagina principal</a>"
                    + "<br>"
                    + "<a href='Consultar'>Consultar Tabla General de Usuarios</a>");
            out.println("</body>");
            out.println("</html>");
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
    
    public void destroy(){
        try{
            rs.close();
            set.close();
            con.close();
        }catch(Exception e){
            super.destroy();
            
        }
    }
    
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}