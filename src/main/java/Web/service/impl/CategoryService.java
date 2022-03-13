/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Web.service.impl;

import Web.dao.Icategory;
import Web.dao.impl.CategoryDAO;
import Web.model.CategoryModel;
import Web.service.ICategoryService;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author ADMIN
 */
public class CategoryService implements ICategoryService {
    @Inject
    private Icategory categoryDao;

    @Override
    public List<CategoryModel> findAll() {
        return categoryDao.findAll();

    }

}
