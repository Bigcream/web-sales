/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Web.controller.Home;

import Web.model.AddressModel;
import Web.model.UserModel;
import Web.service.IUserService;
import Web.utill.FormUtill;
import Web.utill.MessageUtill;
import Web.utill.SessionUtill;
import java.io.IOException;
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
@WebServlet(urlPatterns = {"/CheckOut"})
public class CheckOutController extends HttpServlet {

    @Inject
    private IUserService userService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserModel userModel = (UserModel) SessionUtill.getInstance().getValue(req, "USERMODEL");
        AddressModel address = userService.findAddressById(userModel.getId());
        req.setAttribute("address", address);
        RequestDispatcher rd = req.getRequestDispatcher("/views/Home/CheckOut.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserModel userModel = (UserModel) SessionUtill.getInstance().getValue(req, "USERMODEL");
        String action = req.getParameter("action");
//        if (userModel.getAddressId() == null ) {
//            MessageUtill.showMessage(req);
//            RequestDispatcher rd = req.getRequestDispatcher("/views/Home/CheckOut.jsp");
//            rd.forward(req, resp);
//        } else 
        if (userModel.getAddressId() == null && action.equals("newAddress")) {
            AddressModel address = FormUtill.toModel(AddressModel.class, req);
            address.setUser_Id(userModel.getId());
            Long adressID = userService.saveAddress(address);
            userModel.setAddressId(adressID);
            userService.update(userModel);
            req.setAttribute("address", address);
            MessageUtill.showMessage(req);
            RequestDispatcher rd = req.getRequestDispatcher("/views/Home/CheckOut.jsp");
            rd.forward(req, resp);
        }

    }

}
