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

public abstract ParserLink parser_Link(URL url);


}
