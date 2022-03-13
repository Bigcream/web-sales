/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Web.dao.impl;

import Web.dao.IOrderDetailDao;
import Web.mapper.OrderDetailMapper;
import Web.mapper.StatusMapper;
import Web.model.CartModel;
import Web.model.ItemModel;
import Web.model.OrderDetailModel;
import Web.model.StatusOrderModel;
import Web.model.UserModel;
import Web.paging.IPageble;
import java.util.List;
import org.apache.commons.lang.StringUtils;

/**
 *
 * @author ASUS
 */
public class OrderDetailDao extends AbstractDao<OrderDetailModel> implements IOrderDetailDao {

    @Override
    public void save(CartModel cartModel, Long orderId) {
        for (ItemModel i : cartModel.getItems()) {
            String sql = "INSERT INTO Order_Detail (order_Id, product_Id, product_Name, product_Quantity, product_Price, status_Id) "
                    + "VALUES (?, ?, ?, ? , ?, 1)";
            insert(sql, orderId, i.getProductModel().getId(), i.getProductModel().getName(), i.getQuantity(), i.getPrice());
        }
    }

    @Override
    public OrderDetailModel findOrderDetailById(Long id) {
        StringBuilder sql = new StringBuilder("SELECT * FROM Order_Detail WHERE id = ?");
        List<OrderDetailModel> detailModel = querỵ̣(sql.toString(), new OrderDetailMapper(), id);
        return detailModel.isEmpty() ? null : detailModel.get(0);
    }

    @Override
    public void updateDetail(OrderDetailModel odm) {
        String sql = "UPDATE Order_Detail SET order_Id = ?, product_Id = ?, product_Name = ?,"
                + " product_Quantity = ?, product_Price = ?, status_Id = ? WHERE id = ?";
        update(sql, odm.getOrder_Id(), odm.getProduct_Id(), odm.getProduct_Name(), odm.getProduct_Quantity(), odm.getProduct_Price(), odm.getStatus_Id(), odm.getId());
    }

    @Override
    public List<OrderDetailModel> findAll(IPageble pageble) {
        StringBuilder sql = new StringBuilder("SELECT * FROM order_detail INNER JOIN status_order ON order_detail.status_Id = status_order.id");
        if (pageble.getSorter() != null && StringUtils.isNotBlank(pageble.getSorter().getSortName()) && StringUtils.isNotBlank(pageble.getSorter().getSortBy())) {
            sql.append(" ORDER BY " + pageble.getSorter().getSortName() + " " + pageble.getSorter().getSortBy() + "");
        }
        if (pageble.getOffset() != null && pageble.getLimit() != null) {
            sql.append(" LIMIT " + pageble.getOffset() + ", " + pageble.getLimit() + "");
        }
        return querỵ̣(sql.toString(), new OrderDetailMapper());
    }

    @Override
    public int getTotalItem() {
        String sql = "SELECT count(*) FROM Order_Detail";
        return count(sql);
    }

    @Override
    public List<StatusOrderModel> findAllStatus() {
        StringBuilder sql = new StringBuilder("SELECT * FROM Status_Order");
        return querỵ̣(sql.toString(), new StatusMapper());
    }

}
