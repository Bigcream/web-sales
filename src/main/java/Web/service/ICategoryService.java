/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Web.service;

import Web.model.CategoryModel;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public interface ICategoryService {
    List<CategoryModel> findAll();
}
