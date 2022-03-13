/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Web.service.impl;

import Web.dao.IOrderDao;
import Web.dao.IOrderDetailDao;
import Web.dao.impl.OrderDAO;
import Web.model.CartModel;
import Web.model.OrderProductModel;
import Web.model.UserModel;
import Web.service.IOrderService;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author ASUS
 */
public class OrderService implements IOrderService {

    @Inject
    private IOrderDao orderDao;
    @Inject
    private IOrderDetailDao detailDao;

    @Override
    public Long save(UserModel userModel, CartModel cartModel) {
        
        Long orderId = orderDao.save(userModel, cartModel);
        detailDao.save(cartModel, orderId);
        return orderId;
        
    }

    @Override
    public List<OrderProductModel> findAllOrderById(Long id) {
        return (List<OrderProductModel>) orderDao.findAllOrderById(id);
    }

}
