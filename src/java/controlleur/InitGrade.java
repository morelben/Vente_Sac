/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlleur;

import connexion.Connexion;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.AchatMp;
import model.Client;
import model.Grade;
import model.Look;
import model.Metier;
import model.MetierPoketra;
import model.Mp;
import model.Poketra;
import model.StockMp;
import model.TaillePoketra;

/**
 *
 * @author morel
 */
public class InitGrade extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String message="";
        if(request.getAttribute("message")!=null){
            message=(String) request.getAttribute("message");
        }
        try {
            Connection c=Connexion.getConnection();
            Grade[] grade=Grade.getAll(c);
            c.close();
            request.setAttribute("grades",grade);
            request.setAttribute("message",message);
            request.getRequestDispatcher("grade.jsp").forward(request, response);
        } catch (Exception ex) {
            Logger.getLogger(InsertLook.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
