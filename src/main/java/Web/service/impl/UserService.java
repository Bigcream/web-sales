/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Web.service.impl;

import Web.dao.IUserDao;
import Web.dao.impl.UserDAO;
import Web.model.AddressModel;
import Web.model.UserModel;
import Web.service.IUserService;
import java.sql.Timestamp;
import javax.inject.Inject;

/**
 *
 * @author ASUS
 */
public class UserService implements IUserService{
    @Inject
    private IUserDao userDao;
    @Override
    public UserModel findByUserNameAndPassWordAndstatus(String userName, String passWord, Integer status) {
        return userDao.findByUserNameAndPassWordAndstatus(userName, passWord, status);
    }

    @Override
    public Long save(UserModel userModel) {
        userModel.setStatus(1);
        userModel.setRoleId(2);
        userModel.setCreateDby("a");
        userModel.setAddressId(0L);
        userModel.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        return userDao.save(userModel);
    }

    @Override
    public Long saveAddress(AddressModel addressModel) {
        
        return userDao.saveAddress(addressModel);
    }

    @Override
    public AddressModel findAddressById(Long id) {
        return userDao.findAddressById(id);
    }

    @Override
    public void update(UserModel um) {
        userDao.update(um);
    }
    
}
