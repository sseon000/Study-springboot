package com.sh.studyspringboot;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

// 빈으로등록
@Component
// 프로퍼티 파일 읽어오기 
@ConfigurationProperties("sseon")
/**
 * 메인클래스에 EnableAutoConfigurationProperties(SseonProperties.class)를 원래 등록해야하지만 
 * SpringBootApplication 안에 자동 설정되어있어서 생략가능 
 */
public class SseonProperties {
    private String name;
    private int age;
    private String fullName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
