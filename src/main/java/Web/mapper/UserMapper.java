/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Web.mapper;

import Web.model.RoleModel;
import Web.model.UserModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class UserMapper implements IRowMapper<UserModel> {

    @Override
    public UserModel mapRow(ResultSet resultSet) {
        UserModel user = new UserModel();
        try {
            user.setId(resultSet.getLong("id"));
            user.setUserName(resultSet.getString("username"));
            user.setPassWord(resultSet.getString("password"));
            user.setFullName(resultSet.getString("fullname"));
            user.setStatus(resultSet.getInt("status"));
            user.setCreatedDate(resultSet.getTimestamp("createddate"));
            user.setCreateDby(resultSet.getString("createdby"));
            user.setEmail(resultSet.getString("email"));
            user.setAddressId(resultSet.getLong("addressId"));
            
            try {
                RoleModel role = new RoleModel();
                role.setCode(resultSet.getString("code"));
                role.setName(resultSet.getString("name"));
                user.setRole(role);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            return user;
        } catch (SQLException ex) {
            Logger.getLogger(UserMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
