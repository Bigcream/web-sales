/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Web.utill;

import java.net.http.HttpRequest;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author ASUS
 */
public class SessionUtill {
    private static SessionUtill sessionUtill = null;
    public static SessionUtill getInstance(){
        if (sessionUtill == null) {
            sessionUtill = new SessionUtill();
        }
        return sessionUtill;
    }
    public void putValue(HttpServletRequest Request , String key, Object value){
        Request.getSession().setAttribute(key, value);
    }
    public Object getValue(HttpServletRequest Request , String key){
        Object obj = null;
        obj = Request.getSession().getAttribute(key);
        return obj;
    }
    public void removeValue(HttpServletRequest Request , String key){
        Request.getSession().removeAttribute(key);
    }
}
