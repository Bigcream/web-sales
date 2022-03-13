/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Web.controller.admin;

import Web.constant.SystemConstant;
import Web.model.OrderDetailModel;
import Web.model.OrderProductModel;
import Web.model.StatusOrderModel;
import Web.paging.IPageble;
import Web.paging.PageRequest;
import Web.service.IOrderDetailService;
import Web.sort.Sorter;
import Web.utill.FormUtill;
import Web.utill.MessageUtill;
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

@WebServlet(urlPatterns = {"/Admin-Order"})
public class OrderController extends HttpServlet {
    static Integer oldPage = 1;
    @Inject
    private IOrderDetailService detailService;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        OrderDetailModel detailModel = FormUtill.toModel(OrderDetailModel.class, req);
        String type = req.getParameter("type");
        String view = "";
        if (type.equals(SystemConstant.LIST)) {
            IPageble pageble = new PageRequest(detailModel.getPage(), detailModel.getMaxPageItem(),
                    new Sorter(null, null));
            detailModel.setListResult(detailService.findAll(pageble));
            detailModel.setTotalItem(detailService.getTotalItem());
            detailModel.setTotalPage((int) Math.ceil((double) detailModel.getTotalItem() / detailModel.getMaxPageItem()));
            List<OrderDetailModel> a = detailModel.getListResult();
            oldPage = detailModel.getPage();
            req.setAttribute("page", req.getParameter("page"));
        } 
//        else if (type.equals(SystemConstant.EDIT)) {
//            Long id = model.getCategoryId();
//            String name = detailModel.getName();
//            if (name != null) {
//                model = productService.findOne(model.getId());
//                model.setImage_Link(ImageUtill.convertBlobToImage(model));
//            } else {
//
//            }
//            req.setAttribute("oldPage", oldPage);
//            view = "/views/Admin/Product/Edit.jsp";
//        }
        MessageUtill.showMessage(req);
        List<StatusOrderModel> status = detailService.findAllStatus();
        req.setAttribute("oldPage", oldPage);
        req.setAttribute("status", status);
        req.setAttribute(SystemConstant.MODEL, detailModel);
        RequestDispatcher rd = req.getRequestDispatcher("/views/Admin/Order/List.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        OrderDetailModel detailModel = FormUtill.toModel(OrderDetailModel.class, req);
        
    }

}
