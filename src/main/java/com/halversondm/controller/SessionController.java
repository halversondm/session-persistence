package com.halversondm.controller;

import com.halversondm.dto.AppSessionData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(path = "/api")
public class SessionController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SessionController.class);

    @GetMapping(path = "/data")
    public AppSessionData establishSession(HttpServletRequest httpServletRequest) {
        return (AppSessionData) httpServletRequest.getSession().getAttribute("AppSessionData");
    }

}
