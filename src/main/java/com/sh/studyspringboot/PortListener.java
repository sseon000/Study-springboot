package com.sh.studyspringboot;

import org.springframework.boot.web.servlet.context.ServletWebServerApplicationContext;
import org.springframework.boot.web.servlet.context.ServletWebServerInitializedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

// 리스너를 빈으로등록
@Component
public class PortListener implements ApplicationListener<ServletWebServerInitializedEvent> {

    @Override
    public void onApplicationEvent(ServletWebServerInitializedEvent event) {
        ServletWebServerApplicationContext context = event.getApplicationContext();
        System.out.println(context.getWebServer().getPort());
    }
}
