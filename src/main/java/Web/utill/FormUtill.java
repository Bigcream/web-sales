/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Web.utill;

import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.beanutils.BeanUtils;

/**
 *
 * @author ASUS
 */
public class FormUtill {
        public static <T> T toModel(Class<T> clazz, HttpServletRequest request) {
            T object = null;
            try {
                object = clazz.newInstance();
                BeanUtils.populate(object, request.getParameterMap());
            } catch (InstantiationException |InvocationTargetException| IllegalAccessException ex) {
                Logger.getLogger(FormUtill.class.getName()).log(Level.SEVERE, null, ex);
            }
        return object;
    }
}
