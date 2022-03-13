/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Web.controller.Home;

import Web.model.CartModel;
import Web.model.ItemModel;
import Web.model.ProductModel;
import Web.service.IProductService;
import Web.utill.FormUtill;
import Web.utill.ImageUtill;
import Web.utill.SessionUtill;
import java.io.IOException;
import java.util.List;
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
@WebServlet(urlPatterns = {"/Cart"})
public class CartController extends HttpServlet {

    @Inject
    private IProductService productService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("/views/Home/Cart.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Object object = SessionUtill.getInstance().getValue(req, "cart");
        ProductModel model = FormUtill.toModel(ProductModel.class, req);
        CartModel cartModel = null;
        String Squantity = req.getParameter("sumProductBuy");
        Long quantity = Long.parseLong(Squantity);
        if (object != null) {
            cartModel = (CartModel) object;
        } else {
            cartModel = new CartModel();
        }
        model = productService.findOne(model.getId());
        model.setImage_Link(ImageUtill.convertBlobToImage(model));
        float price = (float) (model.getPrice());
        ItemModel itemModel = new ItemModel(model, quantity, price);
        cartModel.addItem(itemModel);
        List<ItemModel> listItem = cartModel.getItems();
        cartModel.setTotalMoney(cartModel.getTotalMoney());
        SessionUtill.getInstance().putValue(req, "cart", cartModel);
        SessionUtill.getInstance().putValue(req, "size", listItem.size());
        resp.sendRedirect(req.getContextPath() + "/HomeDetail?id=" + model.getId());
    }

}
