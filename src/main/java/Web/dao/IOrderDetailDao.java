/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Web.dao;

import Web.model.CartModel;
import Web.model.OrderDetailModel;
import Web.model.StatusOrderModel;
import Web.model.UserModel;
import Web.paging.IPageble;
import java.util.List;

/**
 *
 * @author ASUS
 */
public interface IOrderDetailDao extends IGenericDao<OrderDetailModel> {

    public void save(CartModel cartModel, Long orderId);

    OrderDetailModel findOrderDetailById(Long id);

    public void updateDetail(OrderDetailModel detailModel);

    List<OrderDetailModel> findAll(IPageble pageble);
    int getTotalItem();
    List<StatusOrderModel> findAllStatus();
}
