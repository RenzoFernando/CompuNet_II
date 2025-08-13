package org.example.servlets;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.AppContext;
import org.example.services.ShopService;

import java.io.IOException;

@WebServlet("/shop")
public class ShopServlet extends HttpServlet {

    private ShopService shopService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        shopService = (ShopService) AppContext.getInstance().getBean("shopService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
        resp.getWriter().println("<h1>Este es un servlet<h1>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String compra = req.getParameter("compra");
        shopService.addItem(compra);
        System.out.println(shopService.getItems().size());
        resp.sendRedirect("./");
    }
}