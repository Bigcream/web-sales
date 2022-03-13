/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Web.dao;

import Web.mapper.IRowMapper;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public interface IGenericDao<T> {
    <T> List<T> querỵ̣(String sql, IRowMapper<T> rowMapper, Object... parameters);
    void update(String sql, Object... parameters);
    Long insert(String sql, Object... parameters);
    int count(String sql, Object... parameters);
}
