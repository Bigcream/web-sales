/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Web.filter;

import Web.model.UserModel;
import Web.utill.SessionUtill;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ASUS
 */
public class AuthorizationFilter implements Filter {

    private ServletContext context;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.context = filterConfig.getServletContext();
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        StringBuilder url = new StringBuilder();
        url.append(req.getRequestURI());
        if (url.toString().startsWith("/Shopefake/Admin")) {
            UserModel userModel = (UserModel) SessionUtill.getInstance().getValue(req, "USERMODEL");
            if (userModel != null) {
                if (userModel.getRole().getCode().equals("ADMIN")) {
                    chain.doFilter(request, response);
                } else if (userModel.getRole().getCode().equals("USER")) {
                    resp.sendRedirect(req.getContextPath() + "/Login?action=login&message=notPermission&alert=danger");
                }
            } else {
                resp.sendRedirect(req.getContextPath() + "/Login?action=login&message=notlogin&alert=danger");
            }
        } else {
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
