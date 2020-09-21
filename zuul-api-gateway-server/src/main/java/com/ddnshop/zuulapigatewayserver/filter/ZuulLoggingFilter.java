package com.ddnshop.zuulapigatewayserver.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class ZuulLoggingFilter extends ZuulFilter {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public String filterType() {//kiểu của filter
        return "pre";//chạn + kiểm tra request trước khi execute
    }

    @Override
    public int filterOrder() {// sắp xếp độ ưu tiên của các filter-số càng nhỏ filter order ưu tiên càng cao
        return 1;
    }

    @Override
    public boolean shouldFilter() {// xác định filter có được execute or not
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        HttpServletRequest request= RequestContext.getCurrentContext().getRequest();
        logger.info("FROM : {} --> TO SERVICE : {}",request,request.getRequestURI());
        return null;
    }
}
