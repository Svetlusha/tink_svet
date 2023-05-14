package ru.tinkoff.edu.java.linkparser.parser;


import ru.tinkoff.edu.java.linkparser.link.ParserLink;
import ru.tinkoff.edu.java.linkparser.link.StackOverFlowLink;
import java.net.URL;
public class StackOverFlow extends Abstract {
public StackOverFlow(Abstract nextParser) {
super(nextParser);
}

@Override
public ParserLink parser_Link(String url) {
	 URL toParse = tweakUrl(url);
     if (toParse == null) return null;


     if (toParse.getHost().equals("stackoverflow.com")) {
         String[] tokens = toParse.getFile().substring(1).split("/");
         if (tokens.length >= 2 && tokens[0].equals("questions")) {
             try {
                 return new StackOverFlowLink(Long.parseLong(tokens[1]));
             } catch (NumberFormatException e) {
                 System.out.println("Incorrect question ID");
                 return null;
             }
         } else return null;
     }

     if (nextParser != null) return nextParser.parser_Link(url);

     return null;
 }
}