package ru.tinkoff.edu.java.linkparser.parser;

import java.net.MalformedURLException;
import java.net.URL;
import ru.tinkoff.edu.java.linkparser.link.ParserLink;

public class LinkParser {
    public ParserLink parseUrl(String url) {

        URL urlToCheck = tweakUrl(url);

        if (urlToCheck == null) {
            return null;
        }

    	Abstract parser1 = new GitHub(null);
    	Abstract parser2 = new StackOverFlow(parser1);

        return parser2.parser_Link(urlToCheck);
    }


    public final URL tweakUrl(String urlString) {
        URL url;
        try {
            url = new URL(urlString);
        } catch (MalformedURLException e) {
            return null;
        }
        return url;
    }
}