/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Web.dao.impl;

import Web.dao.IOrderDao;
import Web.mapper.OrderDetailMapper;
import Web.mapper.OrderMapper;
import Web.model.AddressModel;
import Web.model.CartModel;
import Web.model.CategoryModel;
import Web.model.OrderProductModel;
import Web.model.UserModel;
import Web.paging.IPageble;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang.StringUtils;

/**
 *
 * @author ASUS
 */
public class OrderDAO extends AbstractDao<OrderProductModel> implements IOrderDao {

    @Override
    public Long save(UserModel userModel, CartModel cartModel) {
        Timestamp timeNow = new Timestamp(System.currentTimeMillis());
        String sql = "INSERT INTO Order_Product (account_Id, createddate, total_Price) "
                + "VALUES (?, ?, ?)";
        return insert(sql, userModel.getId(), timeNow, cartModel.getTotalMoney());
    }

    @Override
    public List<OrderProductModel> findAllOrderById(Long id) {
        String sql = "SELECT * FROM order_detail INNER JOIN order_product ON order_detail.order_Id = order_product.id  INNER JOIN status_order ON order_detail.status_Id = status_order.id where status_Id != 5 AND account_Id = ?";
//        StringBuilder sql = new StringBuilder("SELECT * FROM order_product");
//        sql.append(" INNER JOIN order_detail ON order_product.id = order_detail.order_Id");
//        sql.append(" INNER JOIN status_order ON order_product.status = status_order.id ;");
        List<OrderProductModel> listOrder = querỵ̣(sql, new OrderMapper(), id);
        return listOrder;
    }

}
