package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;
import java.net.URI;


@EnableScheduling
@SpringBootApplication
public class Semester4Application {
    public static void main(String[] args) {
        SpringApplication.run(Semester4Application.class, args);
        // 输出网页链接
        String url = "http://localhost:8080/page/index.html";
        System.out.println("请手动点击以下链接访问网页：");
        System.out.println(url);
    }

}
