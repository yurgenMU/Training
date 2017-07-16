package ru.splat.controller;

import ru.splat.model.NodeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/move")
public class MoveServlet extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        PrintWriter out = response.getWriter();request.get
        final long id = Long.parseLong(request.getParameter("id"));
        final long parentId = Long.parseLong(request.getParameter("ParentId"));
        NodeService nodeService = new NodeService();
        nodeService.moveNode(id, parentId);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
