/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Web.utill;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class HttpUtill {

    private String value;

    public HttpUtill(String value) {
        this.value = value;
    }
    public <T> T toModel(Class<T> tClass){
        
        try {
            return new ObjectMapper().readValue(value, tClass);
        } catch (IOException ex) {
            System.out.print(ex.getMessage());
            Logger.getLogger(HttpUtill.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public static HttpUtill of(BufferedReader reader) {
        StringBuilder sb = new StringBuilder();

        String line;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
        } catch (IOException ex) {
            System.out.print(ex.getMessage());
            Logger.getLogger(HttpUtill.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new HttpUtill(sb.toString());
    }
}
