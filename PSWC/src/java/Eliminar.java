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
public class Eliminar extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            //para eliminar necesitamos obtener el id
            
            int id;
            
            id = Integer.parseInt(request.getParameter("ideliminar"));
            
            //preparo mi sentencia
            //delete from tabla where atributo = valor
            
            String q = "delete from mregistro where id_usu = "+id+";";
            
            
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Eliminar</title>"
                    + "<link rel=\"stylesheet\" href=\"./CSS/cssINFO.css\">");            
            out.println("</head>");
            out.println("<body>");
            
            
            try{
                
                set.executeUpdate(q);
                System.out.println("Registro eliminado");
                out.println("<h1>Usuario Eliminado</h1>");
                //set.close();
            }catch(Exception e){
                out.println("<h1>Usuario No Eliminado</h1>");
                System.out.println("No se pudo eliminar el usuario");
                System.out.println(e.getMessage());
                System.out.println(e.getStackTrace());
             
            }
           
            
            
            out.println("<br>"
                    + "<hr>"
                    + "<br>"
                    + "<a href='index.html'>Regresar a la pagina principal</a>"
                    + "<br>"
                    + "<br>"
                    + "<a href='Consultar'>Consultar Tabla General de Usuarios</a>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    
    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    
    public void destroy(){
        try{
            set.close();
            con.close();
        }catch(Exception e){
            super.destroy();
            
        }
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}