/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Web.mapper;

import Web.model.OrderDetailModel;
import Web.model.StatusOrderModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS
 */
public class OrderDetailMapper implements IRowMapper<OrderDetailModel> {

    @Override
    public OrderDetailModel mapRow(ResultSet resultSet) {
        OrderDetailModel detailModel = new OrderDetailModel();
        try {
            detailModel.setId(resultSet.getLong("id"));
            detailModel.setOrder_Id(resultSet.getLong("order_Id"));
            detailModel.setProduct_Id(resultSet.getLong("product_Id"));
            detailModel.setProduct_Name(resultSet.getString("product_Name"));
            detailModel.setProduct_Quantity(resultSet.getLong("product_Quantity"));
            detailModel.setProduct_Price(resultSet.getFloat("product_Price"));
            detailModel.setStatus_Id(resultSet.getLong("status_Id"));
            try {
                StatusOrderModel statusModel = new StatusOrderModel();
                statusModel.setStatus(resultSet.getString("status"));
                detailModel.setStatusModel(statusModel);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            return detailModel;
        } catch (SQLException ex) {
            Logger.getLogger(OrderDetailMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
