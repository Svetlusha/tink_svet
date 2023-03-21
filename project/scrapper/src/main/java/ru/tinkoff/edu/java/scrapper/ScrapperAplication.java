package ru.tinkoff.edu.java.scrapper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import ru.tinkoff.edu.java.scrapper.Configuration.ApplicationConfig;

@SpringBootApplication
@EnableConfigurationProperties(ApplicationConfig.class)
public class ScrapperAplication {
public static void main(String[] args) {
var ctx = SpringApplication.run(ScrapperAplication.class, args);
ApplicationConfig config = ctx.getBean(ApplicationConfig.class);
System.out.println(config);
}
}
