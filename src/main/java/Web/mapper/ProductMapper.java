/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Web.mapper;

import Web.model.ProductModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class ProductMapper implements IRowMapper<ProductModel> {

    @Override
    public ProductModel mapRow(ResultSet resultSet) {
        ProductModel product = new ProductModel();
        try {
            product.setId(resultSet.getLong("id"));
            product.setName(resultSet.getString("name"));
            product.setCategoryId(resultSet.getLong("categoryId"));
            product.setPrice(resultSet.getFloat("price"));
            product.setDescription(resultSet.getString("description"));
            product.setQuantity(resultSet.getLong("quantity"));
            product.setStatus(resultSet.getLong("status"));
            product.setImage(resultSet.getBlob("image_Link"));
            product.setNote(resultSet.getString("note"));
            return product;
        } catch (SQLException ex) {
            Logger.getLogger(ProductMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
