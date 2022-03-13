/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Web.service.impl;

import Web.dao.IOrderDetailDao;
import Web.model.OrderDetailModel;
import Web.model.StatusOrderModel;
import Web.paging.IPageble;
import Web.service.IOrderDetailService;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author ASUS
 */
public class OrderDetailService implements IOrderDetailService{
    @Inject
    private IOrderDetailDao detailDao;
    @Override
    public OrderDetailModel findOrderDetailById(Long id) {
        return detailDao.findOrderDetailById(id);
    }

    @Override
    public void update(OrderDetailModel odm) {
        this.detailDao.updateDetail(odm);
    }

    @Override
    public List<OrderDetailModel> findAll(IPageble pageble) {
        return detailDao.findAll(pageble);
    }

    @Override
    public int getTotalItem() {
        return detailDao.getTotalItem();
    }

    @Override
    public List<StatusOrderModel> findAllStatus() {
        return detailDao.findAllStatus();
    }
    
}
