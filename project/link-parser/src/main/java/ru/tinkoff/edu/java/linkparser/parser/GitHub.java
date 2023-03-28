package ru.tinkoff.edu.java.linkparser.parser;

import ru.tinkoff.edu.java.linkparser.link.GitHubLink;
import ru.tinkoff.edu.java.linkparser.link.ParserLink;

import java.util.Arrays;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Arrays;


public class GitHub extends Abstract {
public GitHub(Abstract nextParser) {
super(nextParser);
}

@Override
public ParserLink parser_Link(String url) {
	 URL toParse = tweakUrl(url);
     if (toParse == null) return null;

     if (toParse.getHost().equals("github.com")) {
         String[] tokens = toParse.getFile().substring(1).split("/");
         if (tokens.length >= 2) {
             return new GitHubLink(tokens[0], tokens[1]);
         } else return null;
     }


     if (nextParser != null) return nextParser.parser_Link(url);

     return null;
 }
}