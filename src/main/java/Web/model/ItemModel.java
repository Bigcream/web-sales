/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Web.model;

/**
 *
 * @author ASUS
 */
public class ItemModel {
    private ProductModel productModel;
    private Long quantity;
    private float price;

    public ItemModel() {
    }

    public ItemModel(ProductModel productModel, Long quantity, float price) {
        this.productModel = productModel;
        this.quantity = quantity;
        this.price = price;
    }

    public ProductModel getProductModel() {
        return productModel;
    }

    public void setProductModel(ProductModel productModel) {
        this.productModel = productModel;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
    
    
}
