package com.springmvc.angular.bookapi.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
@ComponentScans(value = {@ComponentScan("com.springmvc.angular.bookapi.controller")})
public class WebConfig extends WebMvcConfigurerAdapter{

}
