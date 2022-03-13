/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Web.controller.Home;

import Web.model.CartModel;
import Web.model.ItemModel;
import Web.utill.SessionUtill;
import java.io.IOException;
import java.util.List;
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
@WebServlet(urlPatterns = {"/RemoveCart"})
public class RemoveCart extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("/views/Home/Cart.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CartModel cartModel = (CartModel) SessionUtill.getInstance().getValue(req, "cart");
        Long id = Long.parseLong(req.getParameter("id"));
        cartModel.removeItem(id);
        List<ItemModel> listItem = cartModel.getItems();
        cartModel.setTotalMoney(cartModel.getTotalMoney());
        SessionUtill.getInstance().putValue(req, "cart", cartModel);
        SessionUtill.getInstance().putValue(req, "size", listItem.size());
        RequestDispatcher rd = req.getRequestDispatcher("/views/Home/Cart.jsp");
        rd.forward(req, resp);

    }

}
