package com.example.apigateway.filter;

import com.google.common.util.concurrent.RateLimiter;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.omg.CORBA.TIMEOUT;
import org.springframework.stereotype.Component;
import sun.misc.Request;

import java.util.concurrent.TimeUnit;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;
import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.SERVLET_DETECTION_FILTER_ORDER;

/**
 * @author:Administrator
 * @date:2019/1/21/021
 */
@Component
public class RateLimiterFilter extends ZuulFilter {

    private static final RateLimiter RATE_LIMITER = RateLimiter.create(100);//限制令牌桶容量为100
//    private static final RateLimiter RATE_LIMITER = RateLimiter.create(1,2, TimeUnit.SECONDS);
    @Override
    public String filterType() {
        return PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return SERVLET_DETECTION_FILTER_ORDER  - 1;//最小的数字，在所有前置过滤器之前
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext context = RequestContext.getCurrentContext();

        boolean falg = RATE_LIMITER.tryAcquire();//获取令牌，获取到为true,没有获取到为false
        if(!falg){
            context.setSendZuulResponse(false);
            context.setResponseStatusCode(400);
        }
        return null;
    }
}
