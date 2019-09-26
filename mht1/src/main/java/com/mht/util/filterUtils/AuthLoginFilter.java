package com.mht.util.filterUtils;


import com.mht.util.jwtutil.JwtResult;
import com.mht.util.jwtutil.JwtUtil;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName="authLoginFilter",urlPatterns= {"/*"})
public class AuthLoginFilter implements Filter {

    private final String url = "/mht/user/appSave,/mht/user/pcRegister,/mht/user/pcLogin,/mht/user/createToken,/mht/user/noLogin";

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        String requestURI = req.getRequestURI();

        chain.doFilter(request, response);
        return;

//        if (url.contains(requestURI)){
//            chain.doFilter(request, response);
//            return;
//        }
//
//        String token = ((HttpServletRequest) request).getHeader("token");
//        JwtResult jwtResult = JwtUtil.parseJWT(token);
//        if (jwtResult.getFlag() == 0 ){
//            //成功
//            chain.doFilter(request , response);
//            return;
//        }
//        if (jwtResult.getFlag() == 1){
//            //超时
//            req.getRequestDispatcher("/mht/user/createToken").forward(request,response);
//            return;
//        }
//
//        req.getRequestDispatcher("/mht/user/noLogin").forward(request ,response);
//        return;
    }

}
