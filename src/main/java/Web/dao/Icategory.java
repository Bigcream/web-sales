/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Web.dao;

import java.util.List;
import Web.model.CategoryModel;

/**
 *
 * @author ADMIN
 */
public interface Icategory extends IGenericDao<CategoryModel>{
    List<CategoryModel> findAll();
    CategoryModel findOne(Long id);
    CategoryModel findByCode(String code);
}
