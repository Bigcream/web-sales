/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Web.service;

import Web.model.OrderDetailModel;
import Web.model.StatusOrderModel;
import Web.paging.IPageble;
import java.util.List;

/**
 *
 * @author ASUS
 */
public interface IOrderDetailService {
    OrderDetailModel findOrderDetailById(Long id);
    public void update(OrderDetailModel detailModel);
    List<OrderDetailModel> findAll(IPageble pageble);
    int getTotalItem();
    List<StatusOrderModel> findAllStatus();
}
