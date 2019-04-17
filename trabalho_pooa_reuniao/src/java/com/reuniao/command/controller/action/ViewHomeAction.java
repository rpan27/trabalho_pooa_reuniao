/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reuniao.command.controller.action;

import com.reuniao.command.controller.faces.ICommandAction;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author aluno
 */
public class ViewHomeAction implements ICommandAction{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        RequestDispatcher rd = request.getRequestDispatcher("template.jsp");

        rd.forward(request, response);   
    }
    
}
