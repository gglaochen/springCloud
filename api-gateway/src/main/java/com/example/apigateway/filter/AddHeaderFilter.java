package com.example.apigateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;

import java.util.UUID;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.*;

/**
 * @author:Administrator
 * @date:2019/1/21/021
 * 后置过滤器
 */
@Component
public class AddHeaderFilter extends ZuulFilter {
    @Override       //过滤器类型
    public String filterType() {
        return POST_TYPE;
    }

    @Override       //过滤器执行的优先级，数字越小优先级越高
    public int filterOrder() {
        return SEND_RESPONSE_FILTER_ORDER - 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletResponse response = context.getResponse();
        response.setHeader("X-UUID", UUID.randomUUID().toString());

        return null;
    }
}
