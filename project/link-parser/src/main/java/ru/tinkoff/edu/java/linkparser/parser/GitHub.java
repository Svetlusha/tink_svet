package ru.tinkoff.edu.java.linkparser.parser;

import ru.tinkoff.edu.java.linkparser.link.GitHubLink;
import ru.tinkoff.edu.java.linkparser.link.ParserLink;

import java.util.Arrays;

public class GitHub extends Abstract {
public GitHub(Abstract nextParser) {
super(nextParser);
}

@Override
public ParserLink parser_Link(String url) {
if (url == null) return null;
String toParse = tweakUrl(url);
String[] tokens = toParse.split("/");

System.out.println(Arrays.toString(tokens));

if (tokens.length >= 1 && tokens[0].equals("github.com")) {
if (tokens.length >= 3) {
return new GitHubLink(tokens[1], tokens[2]);
} else return null;
}

if (nextParser != null) return nextParser.parser_Link(url);

return null;
}
}