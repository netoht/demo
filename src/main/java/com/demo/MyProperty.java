package com.demo;

import java.net.InetAddress;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
/**
 * http://docs.spring.io/spring-boot/docs/current/reference/html/boot-features-external-config.html
 */
@ConfigurationProperties(prefix="connection")
public class MyProperty {

    @Value("${my.secret.random}")
    private String secretRandom;

    @Value("${info.app.name}")
    private String appName;

    public String getAppName() {
        return appName;
    }

    public String getSecretRandom() {
        return secretRandom;
    }

    @NotNull // se a propriedade 'connection.remoteAddress' no application.properties nao tiver preenchida vai da um erro de execucao
    // eh necessario ter o setter da propriedade e tambem eh Typesafe
    private InetAddress remoteAddress;
    public InetAddress getRemoteAddress() {
        return remoteAddress;
    }
    public void setRemoteAddress(InetAddress remoteAddress) {
        this.remoteAddress = remoteAddress;
    }
}