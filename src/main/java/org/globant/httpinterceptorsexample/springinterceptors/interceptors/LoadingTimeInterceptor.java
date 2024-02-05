package org.globant.httpinterceptorsexample.springinterceptors.interceptors;

import java.util.Random;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component("timeinterceptor")
public class LoadingTimeInterceptor implements HandlerInterceptor{

   private static final Logger logger = LoggerFactory.getLogger(LoadingTimeInterceptor.class); 

   
    @SuppressWarnings("null")
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception 
    {   
        logger.info("Pre handler some, initialazing..."); 
        long startTime = System.currentTimeMillis();
        request.setAttribute("startTime", startTime);
        Random randon = new Random();
        int delay = randon.nextInt(500);
        Thread.sleep(delay);
        return true;
    }
   
    @SuppressWarnings("null")
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           @Nullable ModelAndView modelAndView) throws Exception 
    {
        long finishTime = System.currentTimeMillis();
        long startTime = (long) request.getAttribute("startTime");
        long result = finishTime - startTime;
        logger.info("Time transcurred:" + result + "ms");
        logger.info("Post handler some, exiting...");
    }
}
