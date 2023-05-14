package ru.tinkoff.edu.java.linkparser.link;

public record GitHubLink(String username, String repository) implements ParserLink {

}