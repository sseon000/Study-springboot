package com.sh.studyspringboot;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
// TestPropertySource에 properties 애트리뷰트 사용
// @TestPropertySource(properties = "sseon.name=sunhyuk2")
// TestPropertySource에 location 애트리뷰트 사용
@TestPropertySource(locations = "classpath:/test.properties")
@SpringBootTest
// SpringBootTest에 properties 애트리뷰트 사용
// @SpringBootTest(properties = "sseon.name=sunhyuk2")
class StudySpringbootApplicationTests {

    @Autowired
    Environment env;

    @Test
    void contextLoads() {
        assertThat(env.getProperty("sseon.name")).isEqualTo("sseonhyeok");
    }

}
