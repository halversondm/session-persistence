package com.halversondm.controller;

import com.halversondm.dto.AppSessionData;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(path = "/api")
public class SessionController {

    @GetMapping(path = "/data")
    public AppSessionData establishSession(HttpServletRequest httpServletRequest) {
        return (AppSessionData) httpServletRequest.getSession().getAttribute("AppSessionData");
    }

}
