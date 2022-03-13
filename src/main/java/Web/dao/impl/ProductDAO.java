/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Web.dao.impl;

import static Web.dao.impl.CategoryDAO.getConnection;
import Web.model.CategoryModel;
import Web.model.NewModel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import Web.dao.IProductDao;
import Web.mapper.ProductMapper;
import Web.model.ProductModel;
import Web.paging.IPageble;
import java.sql.Statement;
import org.apache.commons.lang.StringUtils;

/**
 *
 * @author ADMIN
 */
public class ProductDAO extends AbstractDao<ProductModel> implements IProductDao {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/javaweb";
    private static final String USER_NAME = "root";
    private static final String PASSWORD = "riengminhem123";

    @Override
    public List<ProductModel> findByCategoryId(Long categoryId) {
        String sql = "SELECT * FROM products WHERE categoryid = ?";

        return querỵ̣(sql, new ProductMapper(), categoryId);
    }

    @Override
    public Long save(ProductModel pm) {
        String sql = "INSERT INTO products (name, categoryId, price, description, quantity, status, image_Link, note) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        return insert(sql, pm.getName(), pm.getCategoryId(), pm.getPrice(), pm.getDescription(), pm.getQuantity(), pm.getStatus(), pm.getImage_Link(), pm.getNote());
    }

    @Override
    public void delete(Long id) {
        String sql = "DELETE FROM products WHERE id = ?";
        this.update(sql, id);
    }

    @Override
    public ProductModel findOne(Long id) {
        String sql = "SELECT * FROM products WHERE id = ?";

        List<ProductModel> product = querỵ̣(sql, new ProductMapper(), id);
        return product.isEmpty() ? null : product.get(0);
    }

    @Override
    public void update(ProductModel pm) {
        String sql = "UPDATE products SET name = ?, categoryId = ?, price = ?,"
                + " description = ?, quantity = ?, status = ?, image_Link = ?, note = ? WHERE id = ?";
        this.update(sql, pm.getName(), pm.getCategoryId(), pm.getPrice(), pm.getDescription(), pm.getQuantity(), pm.getStatus(), pm.getImage(), pm.getNote(), pm.getId());
    }

    @Override
    public List<ProductModel> findAll(IPageble pageble) {
        StringBuilder sql = new StringBuilder("SELECT * FROM products");
        if (pageble.getSorter() != null&& StringUtils.isNotBlank(pageble.getSorter().getSortName()) && StringUtils.isNotBlank(pageble.getSorter().getSortBy())) {
            sql.append(" ORDER BY " + pageble.getSorter().getSortName() + " " + pageble.getSorter().getSortBy() + "");
        }
        if (pageble.getOffset() != null && pageble.getLimit() != null) {
            sql.append(" LIMIT " + pageble.getOffset() + ", " + pageble.getLimit() + "");
        }
        return querỵ̣(sql.toString(), new ProductMapper());
    }

    @Override
    public int getTotalItem() {
        String sql = "SELECT count(*) FROM products";
        return count(sql);
    }
}
