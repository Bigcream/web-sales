/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Web.mapper;

import Web.model.StatusOrderModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS
 */
public class StatusMapper implements IRowMapper<StatusOrderModel> {

    @Override
    public StatusOrderModel mapRow(ResultSet resultSet) {
                StatusOrderModel statusModel = new StatusOrderModel();
        try {
            statusModel.setIdS(resultSet.getLong("id"));
            statusModel.setStatus(resultSet.getString("status"));
            return statusModel;
        } catch (SQLException ex) {
            Logger.getLogger(StatusMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
