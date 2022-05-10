package com.controllar;

import com.dao.ProductDao;
import com.model.Category;
import com.model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;

@WebServlet("/admin/addProduct")
@MultipartConfig(maxFileSize = 16177215)
public class AddProductServlet extends HttpServlet {
    private Connection con = null;
    //private static final Logger Log = Logger.getLogger(String.valueOf(AddProductServlet.class));
    public void init(){
        con = (Connection) getServletContext().getAttribute("con");
    }

    public void destroy(){
        super.destroy();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String productName = request.getParameter("productName");
        Double price = request.getParameter("price")!=null?Double.parseDouble(request.getParameter("price")):0.0 ;
        int categoryId = request.getParameter("categoryId")!=null?Integer.parseInt(request.getParameter("categoryId")):0;
        String productDescription = request.getParameter("productDescription");
        InputStream inputStream = null;
        Part filePart = request.getPart("picture");
        if(filePart != null){
            System.out.println("file name :"+filePart.getName()+"size"+filePart.getSize()+"file type"+filePart.getContentType());
            inputStream = filePart.getInputStream();
        }
        Product product = new Product();
        product.setProductName(productName);
        product.setPrice(price);
        product.setProductDescrption(productDescription);
        product.setCategoryId(categoryId);
        product.setPicture(inputStream);
        ProductDao dao = new ProductDao();
        int i = 0;
        try {
            i = dao.save(product,con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(i > 0){
            response.sendRedirect("productList");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            List<Category> categoryList = Category.finAllCategory(con);
            request.setAttribute("categoryList",categoryList);
            String path = "/WEB-INF/views/admin/addProduct.jsp";
            request.getRequestDispatcher(path).forward(request,response);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
