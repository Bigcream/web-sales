/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Web.dao.impl;

import Web.dao.IUserDao;
import Web.mapper.AddressMapper;
import Web.mapper.UserMapper;
import Web.model.AddressModel;
import Web.model.UserModel;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class UserDAO extends AbstractDao<UserModel> implements IUserDao {

    @Override
    public UserModel findByUserNameAndPassWordAndstatus(String userName, String passWord, Integer status) {
        StringBuilder sql = new StringBuilder("SELECT * FROM user AS u");
        sql.append(" INNER JOIN role AS r ON r.id = u.roleid");
        sql.append(" WHERE username = ? AND password = ? AND status = ?");
        List<UserModel> users = querỵ̣(sql.toString(), new UserMapper(), userName, passWord, status);
        return users.isEmpty() ? null : users.get(0);
    }

    @Override
    public Long save(UserModel userModel) {
        String sql = "INSERT INTO user (username, password, fullname, status, roleid, email, createddate, createdby, addressId) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        return insert(sql, userModel.getUserName(), userModel.getPassWord(), userModel.getFullName(),
                userModel.getStatus(), userModel.getRoleId(), userModel.getEmail(), userModel.getCreatedDate(), userModel.getCreateDby(), userModel.getAddressId());
    }

    @Override
    public Long saveAddress(AddressModel addressModel) {
        String sql = "INSERT INTO user_address (name, phoneNumber, email, address, city, country, user_Id) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?)";
        return insert(sql, addressModel.getName(), addressModel.getPhoneNumber(), addressModel.getEmail(),
                addressModel.getAddress(), addressModel.getCity(), addressModel.getCountry(), addressModel.getUser_Id());
    }

    @Override
    public AddressModel findAddressById(Long id) {
        StringBuilder sql = new StringBuilder("SELECT * FROM user_address WHERE user_Id = ?");
        List<AddressModel> addressModel = querỵ̣(sql.toString(), new AddressMapper(), id);
        return addressModel.isEmpty() ? null : addressModel.get(0);
    }

    @Override
    public void update(UserModel um) {
        String sql = "UPDATE user SET username = ?, password = ?, fullname = ?,"
                + " status = ?, createddate = ?, createdby = ?, email = ?, addressId = ? WHERE id = ?";
        this.update(sql, um.getUserName(), um.getPassWord(), um.getFullName(), um.getStatus(), um.getCreatedDate(), um.getCreateDby(), um.getEmail(), um.getAddressId(), um.getId());
    }
}
