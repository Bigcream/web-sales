/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Web.utill;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author ASUS
 */
public class MessageUtill {

    public static void showMessage(HttpServletRequest request) {
        if (request.getParameter("message") != null) {
            String messageResponse = "";
            String alert = "";
            String message = request.getParameter("message");
            if (message.equals("insert_success")) {
                messageResponse = "Insert success";
                alert = "success";
            } else if (message.equals("update_success")) {
                messageResponse = "Update success";
                alert = "success";
            } else if (message.equals("delete_success")) {
                messageResponse = "Delete success";
                alert = "success";
            } else if (message.equals("error_system")) {
                messageResponse = "Error system";
                alert = "danger";
            }
            request.setAttribute("messageResponse", messageResponse);
            request.setAttribute("alert", alert);
        }
        if (request.getParameter("alert") != null) {
            String messageLogin = "";
            String alertLogin = "";
            String messageL = request.getParameter("message");
            String alertL = request.getParameter("alert");
            if (alertL.equals("danger") && messageL.equals("wrong")) {
                messageLogin = "Danger! UserName or Password is wrong";
                alertLogin = "danger";
            } else if (alertL.equals("danger") && messageL.equals("notPermission")) {
                messageLogin = "Danger! notPermission";
                alertLogin = "danger";
            } else if (alertL.equals("danger") && messageL.equals("notlogin")) {
                messageLogin = "Danger! notLogin";
                alertLogin = "danger";
            }
            request.setAttribute("messageLogin", messageLogin);
            request.setAttribute("alertLogin", alertLogin);
        }
        if (request.getParameter("alert") != null) {
            String messageRegister = "";
            String alertRegister = "";
            String messageR = request.getParameter("message");
            String alertR = request.getParameter("alert");
            if (alertR.equals("danger") && messageR.equals("wrongPass")) {
                messageRegister = "Danger! Passwords do not match";
                alertRegister = "danger";
            } else if (alertR.equals("success") && messageR.equals("successRegister")) {
                messageRegister = "Success! registered";
                alertRegister = "success";
            }
            request.setAttribute("messageRegister", messageRegister);
            request.setAttribute("alertRegister", alertRegister);
        }
        if (request.getParameter("alert") != null) {
            String messageOrder = "";
            String alertOrder = "";
            String messageO = request.getParameter("message");
            String alertO = request.getParameter("alert");
            if (alertO.equals("danger") && messageO.equals("notAddress")) {
                messageOrder = "Danger! Please add Address";
                alertOrder = "danger";
            } else if (alertO.equals("success") && messageO.equals("successOrder")) {
                messageOrder = "Success! Ordered";
                alertOrder = "success";
            }
            request.setAttribute("messageOrder", messageOrder);
            request.setAttribute("alertOrder", alertOrder);
        }
    }
}
