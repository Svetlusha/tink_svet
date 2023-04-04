package ru.tinkoff.edu.java.linkparser.parser;

import ru.tinkoff.edu.java.linkparser.parser.Abstract;
import ru.tinkoff.edu.java.linkparser.parser.GitHub;
import ru.tinkoff.edu.java.linkparser.parser.StackOverFlow;
import ru.tinkoff.edu.java.linkparser.link.ParserLink;

public class LinkParser {
    public ParserLink parseUrl(String url) {
    	Abstract parser1 = new GitHub(null);
    	Abstract parser2 = new StackOverFlow(parser1);

        return parser2.parser_Link(url);
    }

}