package com.demo;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.Ordered;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * http://docs.spring.io/spring-boot/docs/current/reference/html/boot-features-spring-application.html#boot-features-command-line-runner
 */
@Component
public class MyCommandLine implements CommandLineRunner, Ordered {

    @Autowired MyProperty property;
    @Autowired Environment env;

    public void run(String... args) {
        System.out.println("CMD>>>>>>>> command line raw: " + Arrays.toString(args));
        System.out.println("CMD>>>>>>>> with property: " + property.getAppName() + " >>> secret random: " + property.getSecretRandom());
        System.out.println("CMD>>>>>>>> enviroment with property 'test': " + env.getProperty("test"));
        System.out.println("CMD>>>>>>>> remote ip: " + property.getRemoteAddress());
    }

    @Override
    public int getOrder() {
        return 0;
    }

}