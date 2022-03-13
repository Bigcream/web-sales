/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Web.controller.admin;

import Web.constant.SystemConstant;
import Web.model.CategoryModel;
import Web.model.ProductModel;
import Web.paging.IPageble;
import Web.paging.PageRequest;
import Web.service.ICategoryService;
import Web.service.IProductService;
import Web.sort.Sorter;
import Web.utill.FormUtill;
import Web.utill.ImageUtill;
import Web.utill.MessageUtill;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.servlet.DispatcherType;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.Size;
import static sun.jvm.hotspot.runtime.BasicObjectLock.size;

@WebServlet(urlPatterns = {"/Admin-Product"})
public class ProductController extends HttpServlet {

    static Integer oldPage = 1;
    @Inject
    private IProductService productService;
    @Inject
    private ICategoryService categoryService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductModel model = FormUtill.toModel(ProductModel.class, req);
        String view = "";
        if (model.getType().equals(SystemConstant.LIST)) {
            IPageble pageble = new PageRequest(model.getPage(), model.getMaxPageItem(),
                    new Sorter(model.getSortName(), model.getSortBy()));
            model.setListResult(productService.findAll(pageble));
            model.setTotalItem(productService.getTotalItem());
            model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getMaxPageItem()));
            view = "/views/Admin/Product/List.jsp";
            oldPage = model.getPage();
            req.setAttribute("page", req.getParameter("page"));
        } else if (model.getType().equals(SystemConstant.EDIT)) {
            Long id = model.getCategoryId();
            String name = model.getName();
            if (name != null) {
                model = productService.findOne(model.getId());
                model.setImage_Link(ImageUtill.convertBlobToImage(model));
            } else {

            }
            req.setAttribute("oldPage", oldPage);
            view = "/views/Admin/Product/Edit.jsp";
        }
        MessageUtill.showMessage(req);
        req.setAttribute(SystemConstant.MODEL, model);
        req.setAttribute("categories", categoryService.findAll());
        RequestDispatcher rd = req.getRequestDispatcher(view);
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

}
