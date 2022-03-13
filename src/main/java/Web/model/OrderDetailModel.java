/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Web.model;

/**
 *
 * @author ASUS
 */
public class OrderDetailModel extends AbstractModel<OrderDetailModel>  {

    private Long id;
    private Long order_Id;
    private Long product_Id;
    private String product_Name;
    private Long product_Quantity;
    private float product_Price;
    private Long status_Id;
    private StatusOrderModel statusModel;

    public StatusOrderModel getStatusModel() {
        return statusModel;
    }

    public void setStatusModel(StatusOrderModel statusModel) {
        this.statusModel = statusModel;
    }
    public Long getStatus_Id() {
        return status_Id;
    }

    public void setStatus_Id(Long status_Id) {
        this.status_Id = status_Id;
    }
    public OrderDetailModel() {
    }

    public OrderDetailModel(Long id, Long order_Id, Long product_Id, String product_Name, Long product_Quantity, float product_Price) {
        this.id = id;
        this.order_Id = order_Id;
        this.product_Id = product_Id;
        this.product_Name = product_Name;
        this.product_Quantity = product_Quantity;
        this.product_Price = product_Price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrder_Id() {
        return order_Id;
    }

    public void setOrder_Id(Long order_Id) {
        this.order_Id = order_Id;
    }

    public Long getProduct_Id() {
        return product_Id;
    }

    public void setProduct_Id(Long product_Id) {
        this.product_Id = product_Id;
    }

    public String getProduct_Name() {
        return product_Name;
    }

    public void setProduct_Name(String product_Name) {
        this.product_Name = product_Name;
    }

    public Long getProduct_Quantity() {
        return product_Quantity;
    }

    public void setProduct_Quantity(Long product_Quantity) {
        this.product_Quantity = product_Quantity;
    }

    public float getProduct_Price() {
        return product_Price;
    }

    public void setProduct_Price(float product_Price) {
        this.product_Price = product_Price;
    }
}
