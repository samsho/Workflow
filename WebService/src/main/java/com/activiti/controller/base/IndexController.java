package com.activiti.controller.base;

import com.activiti.log.MethodAnnotation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class IndexController {
    @RequestMapping("/")
    @MethodAnnotation(type = MethodAnnotation.MethodType.READ, desc = "首页")
    public String index() {
        return "index";
    }

}
