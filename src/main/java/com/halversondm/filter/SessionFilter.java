package com.halversondm.filter;

import com.halversondm.dto.AppSessionData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Component
@Order(1)
public class SessionFilter implements Filter {

    private static final Logger LOGGER = LoggerFactory.getLogger(SessionFilter.class);

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession(false);

        if (request.getRequestURI().contains("actuator")) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else if (session == null) {
            session = request.getSession(true);
            AppSessionData appSessionData = new AppSessionData();
            appSessionData.setName(request.getRemoteUser() == null ? "no user provided" : request.getRemoteUser());
            session.setAttribute("AppSessionData", appSessionData);
            LOGGER.info("new session ID {} and data {}", session.getId(), appSessionData);
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            LOGGER.info("existing session ID {}", session.getId());
            filterChain.doFilter(servletRequest, servletResponse);
        }

    }
}
