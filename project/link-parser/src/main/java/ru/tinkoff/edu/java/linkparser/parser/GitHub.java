package ru.tinkoff.edu.java.linkparser.parser;

import ru.tinkoff.edu.java.linkparser.link.GitHubLink;
import ru.tinkoff.edu.java.linkparser.link.ParserLink;
import java.net.URL;


public class GitHub extends Abstract {
public GitHub(Abstract nextParser) {
super(nextParser);
}

@Override
public ParserLink parser_Link(URL url) {
	
	 if (url.getHost().equals("github.com")) {
         String[] tokens = url.getFile().substring(1).split("/");
         if (tokens.length >= 2) {
             return new GitHubLink(tokens[0], tokens[1]);
         }
     }


     if (nextParser != null) {
    	 return nextParser.parser_Link(url);
     }

     return null;
 }
}