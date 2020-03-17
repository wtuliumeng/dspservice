package com.dsp.web.service.shiro;

import com.dsp.web.common.enums.Status;
import com.dsp.web.model.vo.Response;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.springframework.stereotype.Component;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

@Component
public class SessionExpiredFilter extends FormAuthenticationFilter {


    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {

        HttpServletResponse httpServletResponse = (HttpServletResponse) response;

            httpServletResponse.setCharacterEncoding("UTF-8");
            httpServletResponse.setContentType("application/json");
            Response result=new Response();
            result.setStatus(Status.ERR_403);
            result.setMessage("未登录或认证过期");
            httpServletResponse.getWriter().write(result.toString());

        return false;

    }

}

