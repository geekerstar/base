package com.geekerstar.filter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureException;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author geekerstar
 * date: 2020/1/8 22:22
 * description: JWT过滤器
 */
public class JwtFilter extends GenericFilterBean {

    @Override
    public void doFilter(final ServletRequest req, final ServletResponse res, final FilterChain chain)
            throws IOException, ServletException {

        final HttpServletRequest request = (HttpServletRequest) req;
        final HttpServletResponse response = (HttpServletResponse) res;

        // 从HTTP请求获取authorization
        final String authHeader = request.getHeader("authorization");

        // 如果是OPTIONS请求则放行，返回OK
        if ("OPTIONS".equals(request.getMethod())) {
            response.setStatus(HttpServletResponse.SC_OK);
            chain.doFilter(req, res);
        }
        // 其他请求需要被JWT校验
        else {
            // 检查authorization,是否由 "Bearer " 开头
            if (authHeader == null || !authHeader.startsWith("Bearer ")) {
                throw new ServletException("Token格式有误!");
            }
            // 获取Token
            final String token = authHeader.substring(7);
            try {
                // 检查JWT Token是否以 "secretkey" 开头
                final Claims claims = Jwts.parser().setSigningKey("secretkey").parseClaimsJws(token).getBody();
                // 添加Claims到请求头
                request.setAttribute("claims", claims);
            } catch (final SignatureException e) {
                throw new ServletException("无效的Token!");
            }
            chain.doFilter(req, res);
        }
    }
}
