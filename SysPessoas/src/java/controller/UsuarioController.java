/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.UsuarioDAO;
import model.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 363707
 */
@WebServlet(name = "UsuarioController", urlPatterns = {"/UsuarioController"})
public class UsuarioController extends HttpServlet {

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
            out.println("<title>Servlet UsuarioController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UsuarioController at " + request.getContextPath() + "</h1>");
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
        
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        
        if("deletar".equals(request.getAttribute("action"))){
            String id = request.getParameter("id");
            try{
                usuarioDAO.deletar(Integer.parseInt(id));
            } catch (SQLException ex){
                System.out.println(ex.getMessage());
            }
            response.sendRedirect("UsuarioController");
            processRequest(request, response);
            
        }else if ("alterar".equals(request.getParameter("action"))) {
            Usuario usuario
                    = usuarioDAO.buscarPorId(
                    Integer.parseInt(request.getParameter("id")));
            
            request.setAttribute("usuario", usuario);
            
            RequestDispatcher rs = request.getRequestDispatcher("/index.jsp");
            
            rs.forward(request, response);        
            
        }else{
            List<Usuario> usuarios = usuarioDAO.listarTodos(); 
            
            request.setAttribute("usuarios", usuarios);       
            
            RequestDispatcher dispatcher = request.getRequestDispatcher("/listaUsuarios.jsp");    
            
            dispatcher.forward(request, response);
    	} 
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

        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        int acesso = Integer.parseInt(request.getParameter("acesso"));
        int id = Integer.parseInt(request.getParameter("id"));

        Usuario usuario = new Usuario();
        usuario.setNome(nome);
        usuario.setSenha(senha);
        usuario.setEmail(email);
        usuario.setAcesso(acesso);
        usuario.setId(id);

        UsuarioDAO uDAO = new UsuarioDAO();

        try {
            if (id == 0) {
                uDAO.inserir(usuario);
            } else {
                uDAO.atualizar(usuario);
            }
            response.sendRedirect("UsuarioController");
        } catch (SQLException e) {
            e.printStackTrace(); // Mostra o erro no console
            request.setAttribute("erro", "Erro ao salvar usuário: " + e.getMessage());
            request.getRequestDispatcher("/erro.jsp").forward(request, response);
        }
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