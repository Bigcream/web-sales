/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Web.mapper;

import Web.model.OrderDetailModel;
import Web.model.OrderProductModel;
import Web.model.StatusOrderModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS
 */
public class OrderMapper implements IRowMapper<OrderProductModel> {

    @Override
    public OrderProductModel mapRow(ResultSet resultSet) {
        OrderProductModel orderModel = new OrderProductModel();
        try {
            orderModel.setId(resultSet.getLong("id"));
            orderModel.setAccount_Id(resultSet.getLong("account_Id"));
            orderModel.setCreateddate(resultSet.getTimestamp("createddate"));
            orderModel.setTotal_Price(resultSet.getFloat("total_Price"));
            try {
                OrderDetailModel detailModel = new OrderDetailModel();
                StatusOrderModel statusModel = new StatusOrderModel();
                detailModel.setId(resultSet.getLong("id"));
                detailModel.setOrder_Id(resultSet.getLong("order_Id"));
                detailModel.setProduct_Id(resultSet.getLong("product_Id"));
                detailModel.setProduct_Name(resultSet.getString("product_Name"));
                detailModel.setProduct_Quantity(resultSet.getLong("product_Quantity"));
                detailModel.setProduct_Price(resultSet.getFloat("product_Price"));
                detailModel.setStatus_Id(resultSet.getLong("status_Id"));
                statusModel.setStatus(resultSet.getString("status"));
                orderModel.setDetailModel(detailModel);
                orderModel.setStatusModel(statusModel);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            return orderModel;
        } catch (SQLException ex) {
            Logger.getLogger(OrderMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }
}
