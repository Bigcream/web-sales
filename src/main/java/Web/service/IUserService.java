/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Web.service;

import Web.model.AddressModel;
import Web.model.UserModel;

/**
 *
 * @author ASUS
 */
public interface IUserService {
    UserModel findByUserNameAndPassWordAndstatus(String userName, String passWord, Integer status);
    Long save(UserModel userModel);
    Long saveAddress(AddressModel addressModel);
    AddressModel findAddressById(Long id);
    public void update(UserModel userModel);
}
