/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Web.dao;

import Web.model.ProductModel;
import Web.paging.IPageble;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public interface IProductDao extends IGenericDao<ProductModel> {

    ProductModel findOne(Long id);

    List<ProductModel> findByCategoryId(Long categoryId);

    Long save(ProductModel productModel);
    void delete(Long id);
    void update(ProductModel updateProduct);
    List<ProductModel> findAll(IPageble pageble);
    int getTotalItem();
}
