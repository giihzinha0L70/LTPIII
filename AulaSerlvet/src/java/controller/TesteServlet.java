package controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "TesteServlet", urlPatterns = {"/TesteServlet"})
public class TesteServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        HttpSession session = request.getSession();
        String nextJSP = "/excluído-com-sucesso.jsp";
        RequestDispatcher dispatcher=
                getServletContext().getRequestDispatcher(nextJSP);
        String nome = request.getParameter("nome");
        session.setAttribute("nome", nome);
        //response.getWriter() .println("nome");
        //response.sendRedirect("index.html");
        dispatcher.forward(request, response);
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }
    
}
    