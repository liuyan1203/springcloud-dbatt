package cn.dbatt.cloudzuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.ZuulFilterResult;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @ClassName LoginFilter
 * @Description: TODO
 * @Author yanliu
 * @Date 2019/11/15
 * @Version V1.0
 **/
@Component
public class LoginFilter extends ZuulFilter {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 过滤器类型：
     * pre: 路由前
     * routing: 路由时
     * post: 路由后
     * error: 路由发生错误时
     *
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext currentContext = RequestContext.getCurrentContext();
        HttpServletRequest request = currentContext.getRequest();
        logger.info("{} >>> {}", request.getMethod(), request.getRequestURI().toString());
        String token = request.getParameter("token");
        if (token == null) {
            logger.error("Error! Request Token is Empty");
            currentContext.setSendZuulResponse(false);
            currentContext.setResponseStatusCode(401);
            try {
                currentContext.getResponse().getWriter().write("Request token is empty");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}