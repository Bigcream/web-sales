/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Web.model;

import java.sql.Timestamp;

/**
 *
 * @author ASUS
 */
public class OrderProductModel {

    private Long id;
    private Long account_Id;
    private Timestamp createddate;
    private float total_Price;

    private OrderDetailModel detailModel;
    private StatusOrderModel statusModel;
    public StatusOrderModel getStatusModel() {
        return statusModel;
    }

    public void setStatusModel(StatusOrderModel statusModel) {
        this.statusModel = statusModel;
    }

    public OrderDetailModel getDetailModel() {
        return detailModel;
    }

    public void setDetailModel(OrderDetailModel detailModel) {
        this.detailModel = detailModel;
    }
    public OrderProductModel() {
    }

    public OrderProductModel(Long id, Long account_Id, Timestamp createddate, float total_Price, Long status) {
        this.id = id;
        this.account_Id = account_Id;
        this.createddate = createddate;
        this.total_Price = total_Price;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAccount_Id() {
        return account_Id;
    }

    public void setAccount_Id(Long account_Id) {
        this.account_Id = account_Id;
    }

    public Timestamp getCreateddate() {
        return createddate;
    }

    public void setCreateddate(Timestamp createddate) {
        this.createddate = createddate;
    }

    public float getTotal_Price() {
        return total_Price;
    }

    public void setTotal_Price(float total_Price) {
        this.total_Price = total_Price;
    }

    
}
