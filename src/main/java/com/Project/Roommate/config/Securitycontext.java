package com.Project.Roommate.config;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

public class Securitycontext{

    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

    User user=(User)authentication.getPrincipal();

}
