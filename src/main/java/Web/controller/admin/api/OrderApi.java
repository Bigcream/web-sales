/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Web.controller.admin.api;

import Web.model.OrderDetailModel;
import Web.service.IOrderDetailService;
import Web.utill.HttpUtill;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ASUS
 */
@WebServlet(urlPatterns = {"/api-admin-order"})
public class OrderApi extends HttpServlet {
    @Inject
    private IOrderDetailService detailService;
    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        OrderDetailModel detailModel = HttpUtill.of(req.getReader()).toModel(OrderDetailModel.class);
        detailService.update(detailModel);
        mapper.writeValue(resp.getOutputStream(), "[]");
    }

}
