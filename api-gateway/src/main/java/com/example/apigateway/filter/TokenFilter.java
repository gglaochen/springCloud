package com.example.apigateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_DECORATION_FILTER_ORDER;
import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;

/**
 * @author:Administrator
 * @date:2019/1/21/021
 * 前置过滤器
 */
//@Component
public class TokenFilter extends ZuulFilter {
    /*  路由的4种类型
    pre,post,route,error
     */
    @Override
    public String filterType() {
        return PRE_TYPE;
    }
    @Override
    public int filterOrder() {
        return PRE_DECORATION_FILTER_ORDER - 1;
    }
    @Override
    public boolean shouldFilter() {
        return true;//表示一定要监控
    }
    @Override
    public Object run() throws ZuulException {
        //获取请求对象
        RequestContext context = RequestContext.getCurrentContext();//获取请求的上下文对象，一般通过cookie传
        HttpServletRequest request = context.getRequest();
        //获取地址栏的参数
//        request.getCookies();//通过cookie获取
        String token = request.getParameter("token");
        if(StringUtils.isEmpty(token)){     //如果没有token
            context.setSendZuulResponse(false); //停止传递
            context.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());//设置相应状态码为未授权401
        }
        return null;
    }
}
