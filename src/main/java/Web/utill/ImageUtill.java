/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Web.utill;

import Web.controller.admin.ProductController;
import Web.model.ProductModel;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS
 */
public class ImageUtill {

    public static String convertBlobToImage(ProductModel model) {
        int blobLength;
        try {
            blobLength = (int) model.getImage().length();
            byte[] blobAsBytes = model.getImage().getBytes(1, blobLength);
            String image_Link = new String(blobAsBytes, StandardCharsets.UTF_8);
            model.setImage_Link(image_Link);
        } catch (SQLException ex) {
            Logger.getLogger(ProductController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return model.getImage_Link();
    }
}
