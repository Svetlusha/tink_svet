package ru.tinkoff.edu.java.scrapper.сonfiguration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import parser.LinkParser;

@Configuration
public class LinkParserConfiguration {

    @Bean
    public LinkParser linkParser(){
        return new LinkParser();
    }
}