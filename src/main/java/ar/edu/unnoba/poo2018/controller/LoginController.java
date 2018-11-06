package ar.edu.unnoba.poo2018.controller;

import ar.edu.unnoba.poo2018.model.Usuario;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/login"})
public class LoginController extends HttpServlet {

    private static final String DEFAULT_USER = "poo2018@unnoba.edu.ar";
    private static final String DEFAULT_PASSWORD = "unnoba2018!";
//TODO: acomodar el valor de las variables de arriba
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userEmail =  request.getParameter("user-email");
        String userPassword = request.getParameter("user-password");

        if (userEmail.equals(DEFAULT_USER) && userPassword.equals(DEFAULT_PASSWORD)) {

            Usuario user = new Usuario(userEmail,userPassword,false);
            request.getSession().setAttribute("user",user);
            response.sendRedirect("welcome");
        }else {

            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            String message = "Usuario y/o contraseña incorrecta";
            request.setAttribute("loginError",message);
            request.getRequestDispatcher("index.jsp").forward(request,response);
        }
    }



}
