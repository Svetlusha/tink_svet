package ru.tinkoff.edu.java.linkparser.parser;


import ru.tinkoff.edu.java.linkparser.link.ParserLink;
import ru.tinkoff.edu.java.linkparser.link.StackOverFlowLink;

public class StackOverFlow extends Abstract {
public StackOverFlow(Abstract nextParser) {
super(nextParser);
}

@Override
public ParserLink parser_Link(String url) {

if (url == null) return null;
String toParse = tweakUrl(url);
String[] tokens = toParse.split("/");

if (tokens.length >= 1 && tokens[0].equals("stackoverflow.com")) {
if (tokens.length >= 2 && tokens[1].equals("questions")) {
if (tokens.length >= 3) {
try {
return new StackOverFlowLink(Long.parseLong(tokens[2]));
} catch (NumberFormatException e) {
return null;
}
}
} else return null;
}

if (nextParser != null) return nextParser.parser_Link(url);

return null;
}
}