package ru.splat.controller;


import com.google.gson.Gson;
import ru.splat.model.Node;
import ru.splat.model.NodeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/getRoot")
public class RootServlet extends HttpServlet{
    private NodeService nodeService = new NodeService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Node root = nodeService.getRoot();
        Gson gson = new Gson();
        response.setContentType("application/json");
        response.getWriter().write(gson.toJson(root));

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     //
    }
}
