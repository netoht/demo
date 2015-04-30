package com.demo;

import javax.annotation.PreDestroy;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements DisposableBean /**shutdown hook**/, ExitCodeGenerator {

    /**
     * Mais informações sobre a classe de inicializacao:
     * http://docs.spring.io/spring-boot/docs/current/reference/html/boot-features-spring-application.html
     * http://docs.spring.io/spring-boot/docs/1.2.3.RELEASE/api/org/springframework/boot/SpringApplication.html
     * http://docs.spring.io/spring-boot/docs/1.2.3.RELEASE/api/org/springframework/boot/builder/SpringApplicationBuilder.html
     */
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(DemoApplication.class);

        // ... customize app settings here
        /** app.setAddCommandLineProperties(false); # aqui desabilita a passagem de parametros para o @Environment **/
        app.addListeners(e -> System.out.println("TESTE>>>> " + e.getClass()));
//      app.setWebEnvironment(false); // desabilita aplicacao web
        app.run(args);

//        SpringApplication app = new SpringApplicationBuilder()
//            .sources(DemoApplication.class)
//            .build();
//        app.run(args);

    }

    @Override
    public void destroy() throws Exception {
        /**shutdown hook com a interface @DisposableBean ou utilizando @PreDestroy **/
        System.out.println("destroyyyyyyyyyyyyyyy com interface");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("destroyyyyyyyyyyyyyyy com annotation");
    }

    @Override
    public int getExitCode() {
        /** retornando um código especifico para a saida da aplicacao com a interface @ExitCodeGenerator **/
        return 0;
    }
}
