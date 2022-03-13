/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Web.service.impl;

import Web.controller.admin.ProductController;
import Web.dao.IProductDao;
import Web.dao.Icategory;
import Web.mapper.ProductMapper;
import Web.model.CategoryModel;
import Web.model.ProductModel;
import Web.paging.IPageble;
import Web.service.IProductService;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;

/**
 *
 * @author ADMIN
 */
public class ProductService implements IProductService {

    @Inject
    private IProductDao productDao;
    @Inject
    private Icategory categoryDao;

    @Override
    public List<ProductModel> findByCategoryId(Long category_Id) {

        return productDao.findByCategoryId(category_Id);

    }

    @Override
    public ProductModel save(ProductModel pm) {
        CategoryModel categoryModel = categoryDao.findByCode(pm.getCategoryCode());
        pm.setCategoryId(categoryModel.getId());
        Long productId = productDao.save(pm);
        return productDao.findOne(productId);
    }

    @Override
    public ProductModel update(ProductModel pm) {
        ProductModel oldProduct = productDao.findOne(pm.getId());
        CategoryModel categoryModel = categoryDao.findByCode(pm.getCategoryCode());
        pm.setCategoryId(categoryModel.getId());
        productDao.update(pm);
        return productDao.findOne(pm.getId());
    }

    @Override
    public void delete(Long[] ids) {
        for (Long id : ids) {
            productDao.delete(id);
        }
    }

    @Override
    public List<ProductModel> findAll(IPageble pageble) {
        List<ProductModel> modelList = new ArrayList<>();
        modelList = productDao.findAll(pageble);
        int blobLength;
        try {
            for (int i = 0; i < modelList.size(); i++) {
                blobLength = (int) modelList.get(i).getImage().length();
                byte[] blobAsBytes = modelList.get(i).getImage().getBytes(1, blobLength);
                String image_Link = new String(blobAsBytes, StandardCharsets.UTF_8);
                modelList.get(i).setImage_Link(image_Link);
                modelList.set(i, modelList.get(i));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return modelList;
    }

    @Override
    public int getTotalItem() {
        return productDao.getTotalItem();
    }

    @Override
    public ProductModel findOne(Long id) {
        ProductModel productModel = productDao.findOne(id);
        CategoryModel categoryModel = categoryDao.findOne(productModel.getCategoryId());
        productModel.setCategoryCode(categoryModel.getCode());
        return productModel;
    }

}
