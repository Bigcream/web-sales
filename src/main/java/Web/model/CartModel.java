/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Web.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class CartModel {

    private List<ItemModel> items;
    private float totalMoney;

    public void setTotalMoney(float totalMoney) {
        this.totalMoney = totalMoney;
    }
    
    public CartModel() {
        items = new ArrayList<>();
    }

    public List<ItemModel> getItems() {
        return items;
    }

    public void setItems(List<ItemModel> items) {
        this.items = items;
    }

    private ItemModel getItemByID(Long id) {
        for (ItemModel i : items) {
            if (i.getProductModel().getId() == id) {
                return i;
            }
        }
        return null;
    }

    public Long getQuantityById(Long id) {

        return getItemByID(id).getQuantity();
    }

    public void addItem(ItemModel itemModel) {
        if (getItemByID(itemModel.getProductModel().getId()) != null) {
            ItemModel item = getItemByID(itemModel.getProductModel().getId());
            item.setQuantity(item.getQuantity() + itemModel.getQuantity());
        } else {
            items.add(itemModel);
        }
    }

    public void removeItem(Long id) {
        if(getItemByID(id) != null){
            items.remove(getItemByID(id));
        }
    }
    public float getTotalMoney(){
        float totalmoney = 0;
        for(ItemModel i : items){
            totalmoney += (i.getQuantity()*i.getProductModel().getPrice());
        }
        return totalmoney;
        
    }

}
