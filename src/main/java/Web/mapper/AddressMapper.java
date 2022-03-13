/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Web.mapper;

import Web.model.AddressModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS
 */
public class AddressMapper implements IRowMapper<AddressModel> {

    @Override
    public AddressModel mapRow(ResultSet resultSet) {
        AddressModel addressModel = new AddressModel();
        try {
            addressModel.setId(resultSet.getLong("id"));
            addressModel.setName(resultSet.getString("name"));
            addressModel.setPhoneNumber(resultSet.getString("phoneNumber"));
            addressModel.setEmail(resultSet.getString("email"));
            addressModel.setAddress(resultSet.getString("address"));
            addressModel.setCity(resultSet.getString("city"));
            addressModel.setCountry(resultSet.getString("country"));
            addressModel.setUser_Id(resultSet.getLong("user_Id"));
        } catch (SQLException ex) {
            Logger.getLogger(AddressMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return addressModel;
    }

}
