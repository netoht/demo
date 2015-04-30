package com.demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.MyProperty;

@RestController
/**
 * Para mais configurações sobre o MVC:
 * http://docs.spring.io/spring-boot/docs/current/reference/html/boot-features-developing-web-applications.html#boot-features-spring-mvc
 */
public class MyController {

    @Autowired MyProperty property;

    /**
     * Para mais configurações de retorno e mapeamento consulte:
     * http://docs.spring.io/spring-boot/docs/current/reference/html/howto-spring-mvc.html
     **/
    @RequestMapping("/thing")
    public MyProperty thing() {
        return property;
    }
}