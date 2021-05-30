package com.company.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HibernateController {

    @RequestMapping
    public String getHelloWorld(){
        return "hello-world";
    }
}
