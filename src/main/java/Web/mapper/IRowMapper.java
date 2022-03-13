/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Web.mapper;

import java.sql.ResultSet;

/**
 *
 * @author ADMIN
 */
public interface IRowMapper<T> {
    T mapRow(ResultSet resultSet);
}
