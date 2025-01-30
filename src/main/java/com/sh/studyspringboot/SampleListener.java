package com.sh.studyspringboot;

import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * ApplicationListener<T>를 구현하고 빈으로 등록하면, T에 맞는 시기 이벤트 등록
 * ApplicationStartingEvent은 애플리케이션 컨텍스트가 만들어지기 전에 등록되는 이벤트라면, 스타트 클래스의 메인메서드에 추가 구현 필요
 * SpringApplication 객체에 addListener()를 이용하면 되고, 이 경우엔 빈으로 따로 등록할 필요없음
 */
public class SampleListener implements ApplicationListener<ApplicationStartingEvent> {

    @Override
    public void onApplicationEvent(ApplicationStartingEvent event) {
        System.out.println("=====================");
        System.out.println("Application started");
        System.out.println("=====================");
    }
}