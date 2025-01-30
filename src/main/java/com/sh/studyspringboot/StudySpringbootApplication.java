package com.sh.studyspringboot;

import org.apache.catalina.connector.Connector;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.PrintStream;


@SpringBootApplication
public class StudySpringbootApplication {
    public static void main(String[] args) {
        /**
         * 커스텀하기 위해 스프링애플리케이션 객체를 생성해서 run메서드 실행
         * SpringApplication.run(StudySpringbootApplication.class, args);
         */
        SpringApplication app = new SpringApplication(StudySpringbootApplication.class);
        app.addListeners(new SampleListener());
        app.run(args);

        // 배너 커스텀하기
        /*
        app.setBanner(new Banner() {
            @Override
            public void printBanner(Environment environment, Class<?> sourceClass, PrintStream out) {
                out.println("===================================");
                out.println("Spring Boot Banner Custom");
                out.println("===================================");
            }
        });
         */

        // 람다식 활용
        /*
        app.setBanner((Environment environment, Class<?> sourceClass, PrintStream out) -> {
            out.println("===================================");
            out.println("Spring Boot Banner Custom");
            out.println("===================================");
        });
        */

        // 배너 끄기
        // app.setBannerMode(Banner.Mode.OFF);

        /**
         * SpringApplicationBuilder
         * 다중 컨텍스트를 관리하거나 특정 설정을 동적으로 조정해야 할 때 SpringApplicationBuilder 사용 고려
         */
        // SpringApplicationBuilder 사용
        /*
        SpringApplicationBuilder builder = new SpringApplicationBuilder(StudySpringbootApplication.class);
        builder.run(args);
         */
    }

}
