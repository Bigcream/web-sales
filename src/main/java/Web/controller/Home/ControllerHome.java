/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Web.controller.Home;

import Web.constant.SystemConstant;
import Web.model.ProductModel;
import Web.model.UserModel;
import Web.paging.IPageble;
import Web.paging.PageRequest;
import Web.service.ICategoryService;
import Web.service.IProductService;
import Web.service.impl.UserService;
import Web.sort.Sorter;
import Web.utill.FormUtill;
import Web.utill.MessageUtill;
import Web.utill.SessionUtill;
import java.io.IOException;
import java.util.ResourceBundle;
import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/HomeWeb", "/Login", "/Logout"})
public class ControllerHome extends HttpServlet {

    @Inject
    private ICategoryService categoryService;
    @Inject
    private IProductService productService;
    @Inject
    private UserService userService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action != null && action.equals("login")) {
            MessageUtill.showMessage(req);
            RequestDispatcher rd = req.getRequestDispatcher("/views/Login.jsp");
            rd.forward(req, resp);
        } else if (action != null && action.equals("logout")) {
            SessionUtill.getInstance().removeValue(req, "USERMODEL");
            resp.sendRedirect(req.getContextPath() + "/HomeWeb");
        } else if (action != null && action.equals("register")) {
            MessageUtill.showMessage(req);
            RequestDispatcher rd = req.getRequestDispatcher("/views/Register.jsp");
            rd.forward(req, resp);
        } else {
            ProductModel model = new ProductModel();
            IPageble pageble = new PageRequest(1, 8, new Sorter(null, null));
            model.setListResult(productService.findAll(pageble));
            req.setAttribute(SystemConstant.MODEL, model);
            req.setAttribute("categories", categoryService.findAll());
            RequestDispatcher rd = req.getRequestDispatcher("/views/Home/Home.jsp");
            rd.forward(req, resp);
        }
        req.setAttribute("categories", categoryService.findAll());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        String redirect = req.getParameter("red");
        if (action != null && action.equals("login")) {
            UserModel userModel = FormUtill.toModel(UserModel.class, req);
            userModel = userService.findByUserNameAndPassWordAndstatus(userModel.getUserName(), userModel.getPassWord(), 1);
            if (userModel != null) {
                SessionUtill.getInstance().putValue(req, "USERMODEL", userModel);
                if (userModel.getRole().getCode().equals("USER") ) {
                    resp.sendRedirect(req.getContextPath() + "/HomeWeb");
                } else if (userModel.getRole().getCode().equals("ADMIN") ) {
                    resp.sendRedirect(req.getContextPath() + "/AdminHome");
                }
            } else {
                resp.sendRedirect(req.getContextPath() + "/Login?action=login&alert=danger&message=wrong");
            }
        } else if (action != null && action.equals("register")) {
            UserModel userModel = FormUtill.toModel(UserModel.class, req);
            if (userModel.getPassWord().equals(userModel.getRepeatPassWord())) {
                userService.save(userModel);
                resp.sendRedirect(req.getContextPath() + "/Login?action=login&alert=success&message=successRegister");
            } else {
                resp.sendRedirect(req.getContextPath() + "/Login?action=login&alert=danger&message=wrongPass");
            }
        }
    }
}
