package com.sh.studyspringboot;

import org.apache.catalina.connector.Connector;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;


@SpringBootApplication
@RestController
public class StudySpringbootApplication {

    @GetMapping("/hello")
    public String hello() {
        return "Hello World";
    }

    public static void main(String[] args) {
        SpringApplication.run(StudySpringbootApplication.class, args);
    }

    @Bean
    public ServletWebServerFactory serverFactory() throws IOException {
        TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory();
        tomcat.addAdditionalTomcatConnectors(createStandardConnector());
        return tomcat;
    };

    private Connector createStandardConnector() {
        Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
        connector.setPort(8080);
        return connector;
    }

}
