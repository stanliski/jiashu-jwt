package com.jiashu.web.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jiashu.web.auth.TokenValidator;
import com.jiashu.web.entity.ErrorInfo;
import com.jiashu.web.entity.dto.Response;
import io.jsonwebtoken.ExpiredJwtException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.http.MediaType;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created on 2018/4/4 12:36.
 *
 * @author Stanley Huang
 */

@Order(FilterConstant.ORDER_AUTH)
@WebFilter(filterName = "AuthFilter",
        urlPatterns = {
                "/user/*",
        })
public class AuthFilter implements Filter {

    private static Logger logger = LoggerFactory.getLogger(AuthFilter.class);

    private ObjectMapper jsonMapper;
    private TokenValidator validator;
    private Response invalidError = new Response(ErrorInfo.INVALID_TOKEN);
    private Response expiredError = new Response(ErrorInfo.EXPIRED_TOKEN);

    @Autowired
    public AuthFilter(ObjectMapper jsonMapper, TokenValidator validator) {
        this.jsonMapper = jsonMapper;
        this.validator = validator;
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        String token = httpRequest.getHeader("Authorization");
        if (token == null) {
            failed(httpResponse, invalidError);
            return;
        }
        long userId = -1;
        try {
            userId = validator.validToken(token);
        } catch (ExpiredJwtException ex) {
            failed(httpResponse, expiredError);
            return;
        } catch (Exception ex) {
            logger.info(ex.toString());
            failed(httpResponse, invalidError);
            return;
        }
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }

    private void failed(HttpServletResponse response, Response error) {
        try {
            String errorMsg = jsonMapper.writeValueAsString(error);
            logger.error(errorMsg);
            response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
            response.setStatus(error.getStatusCode().value());
            response.getWriter().print(errorMsg);
        } catch (Exception ex) {
            logger.error("This should never happen!", ex);
        }
    }

}
