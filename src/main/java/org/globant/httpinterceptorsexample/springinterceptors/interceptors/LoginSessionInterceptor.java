package org.globant.httpinterceptorsexample.springinterceptors.interceptors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Component("loginInterceptor")
public class LoginSessionInterceptor implements HandlerInterceptor{

   private static final Logger logger = LoggerFactory.getLogger(LoadingTimeInterceptor.class); 

   
    @SuppressWarnings("null")
    @Override
    public boolean preHandle(HttpServletRequest req, HttpServletResponse response, Object handler) throws Exception 
    {   
        HttpSession session = req.getSession();
        System.out.println(session.getId());
      
        return (boolean) session.getAttribute("validated") ? true : false;
    }
   
    @SuppressWarnings("null")
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           @Nullable ModelAndView modelAndView) throws Exception 
    {
        logger.info("Post handler login, exiting...");
    }
}
