package servlet;

import com.google.gson.Gson;
import dao.service.ProductService;
import dao.service.implService.ProductServiceImpl;
import domain.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/product")
public class ProductController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ProductService productService = ProductServiceImpl.getProductService();


    //to create resource(product)
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        String price = request.getParameter("price");

        Product product = new Product(name, description, getValidatedPrice(price));
        productService.create(product);
        response.setContentType("text/text");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write("200");
    }

    private double getValidatedPrice(String price) {
        if (price == null || price.isEmpty()) {
            return 0;
        }
        return Double.parseDouble(price);
    }

    //to get resource(product)
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().append("Served at : ").append(request.getContextPath());
    }

    //to update resource(product)
    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPut(req, resp);
    }

    //to delete resource(product)
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doDelete(req, resp);
    }
}
