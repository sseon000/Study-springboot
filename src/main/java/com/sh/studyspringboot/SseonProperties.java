package com.sh.studyspringboot;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.convert.DurationUnit;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

// 빈으로등록
@Component
// 프로퍼티 파일 읽어오기 
@ConfigurationProperties("sseon")
/**
 * 메인클래스에 EnableAutoConfigurationProperties(SseonProperties.class)를 원래 등록해야하지만 
 * SpringBootApplication 안에 자동 설정되어있어서 생략가능 
 */
// org.hibernate.validate 구현체(값검증)
@Validated
public class SseonProperties {
    //@Validated와 함께 값 검증
    @NotEmpty
    private String name;
    //@Validated와 함께 값 검증
    @Size(min = 1, max = 100)
    private int age;
    private String fullName;

    @DurationUnit(ChronoUnit.SECONDS)
    private Duration sessionTimeout = Duration.ofSeconds(30);

    public Duration getSessionTimeout() {
        return sessionTimeout;
    }

    public void setSessionTimeout(Duration sessionTimeout) {
        this.sessionTimeout = sessionTimeout;
    }

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
