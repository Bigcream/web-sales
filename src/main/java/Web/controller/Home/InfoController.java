/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Web.controller.Home;

import Web.model.AddressModel;
import Web.model.CartModel;
import Web.model.OrderDetailModel;
import Web.model.OrderProductModel;
import Web.model.UserModel;
import Web.service.IOrderDetailService;
import Web.service.IOrderService;
import Web.service.IUserService;
import Web.utill.FormUtill;
import Web.utill.SessionUtill;
import java.io.IOException;
import java.util.ArrayList;
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
@WebServlet(urlPatterns = {"/Info", "/PlaceOrder"})
public class InfoController extends HttpServlet {

    @Inject
    private IOrderService orderService;
    @Inject
    private IUserService userService;
    @Inject
    private IOrderDetailService detailService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserModel userModel = (UserModel) SessionUtill.getInstance().getValue(req, "USERMODEL");
        OrderDetailModel detailModel = FormUtill.toModel(OrderDetailModel.class, req);
        if (detailModel.getId() != null) {
            detailModel = detailService.findOrderDetailById(detailModel.getId());
            detailModel.setStatus_Id(4l);
            detailService.update(detailModel);
        }
        List<OrderProductModel> listOrder = orderService.findAllOrderById(userModel.getId());
        req.setAttribute("listOrder", listOrder);
        RequestDispatcher rd = req.getRequestDispatcher("/views/Home/Info.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserModel userModel = (UserModel) SessionUtill.getInstance().getValue(req, "USERMODEL");

        CartModel cartModel = (CartModel) SessionUtill.getInstance().getValue(req, "cart");
        if (userModel.getAddressId() == 0) {
            String messageOrder = "Danger! Please add Address";
            String alertOrder = "danger";
            req.setAttribute("messageOrder", messageOrder);
            req.setAttribute("alertOrder", alertOrder);
            RequestDispatcher rd = req.getRequestDispatcher("/views/Home/CheckOut.jsp");
            rd.forward(req, resp);
        } else if (userModel.getAddressId() != null) {
            if (cartModel != null) {
                Long idOrder = orderService.save(userModel, cartModel);
                SessionUtill.getInstance().removeValue(req, "cart");
            } else if (cartModel == null) {
                String messageOrder = "No item in Cart";
                String alertOrder = "danger";
                req.setAttribute("messageOrder", messageOrder);
                req.setAttribute("alertOrder", alertOrder);
                AddressModel address = userService.findAddressById(userModel.getId());
                req.setAttribute("address", address);
                RequestDispatcher rd = req.getRequestDispatcher("/views/Home/CheckOut.jsp");
                rd.forward(req, resp);
            }
            List<OrderProductModel> listOrder = orderService.findAllOrderById(userModel.getId());
            req.setAttribute("listOrder", listOrder);
            RequestDispatcher rd = req.getRequestDispatcher("/views/Home/Info.jsp");
            rd.forward(req, resp);
        }
    }

}
