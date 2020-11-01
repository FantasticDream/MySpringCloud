package pers.zc.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;
/*
 *   @创建人  zc
 *   @创建时间 2020/11/2 2:32
 *   @包名: pers.zc.filter
 *   @描述：
 */
@Component
public class MyTestFilter extends ZuulFilter {

    public String filterType() {
        return PRE_TYPE;
    }

    public int filterOrder() {
        return 3;
    }

    public boolean shouldFilter() {
        return true;
    }

    public Object run() throws ZuulException {
        System.out.println("这是SecondPreFilter！");
        //从RequestContext获取上下文
        RequestContext ctx = RequestContext.getCurrentContext();
        //从上下文获取HttpServletRequest
        HttpServletRequest request = ctx.getRequest();
        //从request尝试获取a参数值
        String a = request.getParameter("a");
        String b = request.getParameter("b");
        //如果a参数值为空则进入此逻辑
        if (null == a) {
            //对该请求禁止路由，也就是禁止访问下游服务
            ctx.setSendZuulResponse(false);
            //设定responseBody供PostFilter使用
            //ctx.setResponseBody("{\"status\":500,\"message\":\"a参数为空！\"}");
            //logic-is-success保存于上下文，作为同类型下游Filter的执行开关
            //ctx.set("logic-is-success", false);
            //到这里此Filter逻辑结束
            return null;
        }
        if (null == b) {
            //对该请求禁止路由，也就是禁止访问下游服务
            //ctx.setSendZuulResponse(false);
            //设定responseBody供PostFilter使用
            //ctx.setResponseBody("{\"status\":500,\"message\":\"b参数为空！\"}");
            //logic-is-success保存于上下文，作为同类型下游Filter的执行开关
            //ctx.set("logic-is-success", false);
            //到这里此Filter逻辑结束
            return null;
        }
        System.out.println("1111");
        //设置避免报空
        //ctx.set("logic-is-success", true);
        return null;
    }
}
