package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@EnableWebMvc
@SpringBootApplication
@EnableSwagger2
public class DemoApplication {
    public static void main(String[] args) {
//        SpringApplication.run(DemoApplication.class, args)
        SpringApplication app = new SpringApplication(DemoApplication.class);
        app.setDefaultProperties(Collections
                .singletonMap("server.port", "8008"));
        app.run(args);
    }

}
