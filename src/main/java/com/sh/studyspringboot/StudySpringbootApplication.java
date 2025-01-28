package com.sh.studyspringboot;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

//@SpringBootApplication
public class StudySpringbootApplication {

    public static void main(String[] args) throws LifecycleException {
//        SpringApplication.run(StudySpringbootApplication.class, args);
        Tomcat tomcat = new Tomcat();
        // 포트 설정
        tomcat.setPort(8080);
        // 컨텍스트 추가
        Context context = tomcat.addContext("/", "/");
        // 서블릿 만들기(1) get요청
        HttpServlet servlet = new HttpServlet() {
            @Override
            protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
                PrintWriter out = resp.getWriter();
                out.println("<html>");
                out.println("<head><title>Hello World</title></head>");
                out.println("<body><h1>Hello World</h1></body>");
                out.println("</html>");
            }
        };
        // 톰캣에 서블릿 추가
        String servletName = "Hello Servlet";
        tomcat.addServlet("/", servletName, servlet);
        // 컨텍스트에 서블릿 패밍
        context.addServletMappingDecoded("/hello", servletName);

        // 톰캣 서버 시작
        tomcat.start();
    }

}
