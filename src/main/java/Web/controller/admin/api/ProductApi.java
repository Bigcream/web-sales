/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Web.controller.admin.api;

import Web.model.ProductModel;
import Web.service.IProductService;
import Web.utill.HttpUtill;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.sql.rowset.serial.SerialBlob;
import org.apache.commons.io.FilenameUtils;

/**
 *
 * @author ADMIN
 */
@WebServlet(urlPatterns = {"/api-admin-product"})
@MultipartConfig
public class ProductApi extends HttpServlet {

    @Inject
    private IProductService productService;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        Blob blob = null;
        ProductModel productModel = HttpUtill.of(req.getReader()).toModel(ProductModel.class);
//        byte[] byteData = productModel.getImage_Link().getBytes("UTF-8");//Better to specify encoding
        byte[] byteArrray = productModel.getImage_Link().getBytes();
        try {
            blob = new SerialBlob(byteArrray);
        } catch (SQLException ex) {
            Logger.getLogger(ProductApi.class.getName()).log(Level.SEVERE, null, ex);
        }
        productModel.setImage(blob);
        productModel = productService.save(productModel);
        mapper.writeValue(resp.getOutputStream(), productModel);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        ProductModel updateProduct = HttpUtill.of(req.getReader()).toModel(ProductModel.class);
        byte[] byteData = updateProduct.getImage_Link().getBytes("UTF-8");//Better to specify encoding
        Blob blob = null;
        try {
            blob = new SerialBlob(byteData);
        } catch (SQLException ex) {
            Logger.getLogger(ProductApi.class.getName()).log(Level.SEVERE, null, ex);
        }
        updateProduct.setImage(blob);
        updateProduct = productService.update(updateProduct);
        mapper.writeValue(resp.getOutputStream(), updateProduct);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        ProductModel productModel = HttpUtill.of(req.getReader()).toModel(ProductModel.class);
        productService.delete(productModel.getIds());
        mapper.writeValue(resp.getOutputStream(), "[]");
    }

}
