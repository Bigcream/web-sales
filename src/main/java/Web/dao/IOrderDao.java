/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Web.dao;

import Web.model.AddressModel;
import Web.model.CartModel;
import Web.model.OrderProductModel;
import Web.model.UserModel;
import Web.paging.IPageble;
import java.util.List;

/**
 *
 * @author ASUS
 */
public interface IOrderDao extends IGenericDao<OrderProductModel> {
    Long save(UserModel userModel, CartModel cartModel);
    List<OrderProductModel> findAllOrderById(Long id);
}
