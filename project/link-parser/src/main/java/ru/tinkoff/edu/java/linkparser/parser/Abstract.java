package ru.tinkoff.edu.java.linkparser.parser;

import ru.tinkoff.edu.java.linkparser.link.ParserLink;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

public abstract class Abstract {

Abstract nextParser;

public Abstract(Abstract nextParser) {

this.nextParser = nextParser;
}
public abstract ParserLink parser_Link(String url);

public final URL tweakUrl(String urlString) {
    URL url;
    try{
        url = new URL(urlString);
    } catch (MalformedURLException e){
        System.out.println("Incorrect URL");
        return null;
    }
    return url;
}
}