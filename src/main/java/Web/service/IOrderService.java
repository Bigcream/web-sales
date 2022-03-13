/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Web.service;

import Web.model.CartModel;
import Web.model.OrderProductModel;
import Web.model.UserModel;
import java.util.List;

/**
 *
 * @author ASUS
 */
public interface IOrderService {
    Long save(UserModel userModel, CartModel cartModel);
    List<OrderProductModel> findAllOrderById(Long id);
}
