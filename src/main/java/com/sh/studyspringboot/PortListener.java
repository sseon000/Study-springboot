package com.sh.studyspringboot;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.web.servlet.context.ServletWebServerApplicationContext;
import org.springframework.boot.web.servlet.context.ServletWebServerInitializedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * ApplicationListener<T>를 구현하고 빈으로 등록하면, T에 맞는 시기 이벤트 등록
 * 애플리케이션 컨텍스트가 만들어지기 전에 등록되는 이벤트라면, 스타트 클래스의 메인메서드에 추가 구현 필요
 * 애플리케이션 컨텍스트가 만들어진 후 등록되는 이벤트는 @Component를 이용해 빈으로 등록하면 리스너 등록이 됨
 */
 // 리스너를 빈으로등록
@Component
public class PortListener implements ApplicationListener<ServletWebServerInitializedEvent> {

    /**
     * 인텔리제이는 edit configuration > program arguments(프로그램 인수) 설정
     * 빈으로 등록한 클래스 기본 생성자에 인자로 ApplicationArguments를 받아서 사용 가능
     */
    public PortListener(ApplicationArguments args) {
        System.out.println("foo : " + args.containsOption("foo"));
        System.out.println("bar : " + args.containsOption("bar"));
    }

    @Override
    public void onApplicationEvent(ServletWebServerInitializedEvent event) {
        ServletWebServerApplicationContext context = event.getApplicationContext();
        System.out.println(context.getWebServer().getPort());
    }
}
