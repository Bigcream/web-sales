/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Web.controller.Home;

import Web.constant.SystemConstant;
import Web.model.CartModel;
import Web.model.ItemModel;
import Web.model.ProductModel;
import Web.service.IProductService;
import Web.utill.FormUtill;
import Web.utill.ImageUtill;
import Web.utill.SessionUtill;
import com.sun.org.apache.bcel.internal.generic.AALOAD;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ASUS
 */
@WebServlet(urlPatterns = {"/HomeDetail"})
public class ProductDetailController extends HttpServlet {

    @Inject
    private IProductService productService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductModel model = FormUtill.toModel(ProductModel.class, req);
        String view = "";
        Long id = model.getCategoryId();
        model = productService.findOne(model.getId());
        model.setImage_Link(ImageUtill.convertBlobToImage(model));
        view = "/views/Home/ProductDetail.jsp";
        req.setAttribute(SystemConstant.MODEL, model);
        RequestDispatcher rd = req.getRequestDispatcher(view);
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

}
