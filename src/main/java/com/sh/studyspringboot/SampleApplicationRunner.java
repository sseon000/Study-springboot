package com.sh.studyspringboot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 애플리케이션을 실행시킨 후 추가로 실행시키려면 ApplicationRunner 구현하는 방법도있음 
 */
// 빈으로등록
@Component
// 여러개의 러너를 구현하고 실행순서 지정가능
@Order(1)
public class SampleApplicationRunner implements ApplicationRunner {

    @Value("${sseon.name}")
    private String name;

    @Value("${sseon.age}")
    private int age;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("foo : " + args.containsOption("foo"));
        System.out.println("bar : " + args.containsOption("bar"));
        System.out.println("name : " + name);
    }
}
