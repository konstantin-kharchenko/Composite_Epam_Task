package by.kharchenko.text.chainofresposibility;

import by.kharchenko.text.composite.TextComponent;
import by.kharchenko.text.composite.TextComponentType;
import by.kharchenko.text.composite.TextComposite;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenceParser extends AbstractTextParser {

    private static final String REGEX = ".*?[.!?]\\s*";

    @Override
    public void parse(String text) {
        Pattern pattern = Pattern.compile(REGEX);
        Matcher match = pattern.matcher(text);
        while (match.find()) {
            TextComponent sentenceComponent = new TextComposite(TextComponentType.SENTENCE);
            component.add(sentenceComponent);
            LexemeParser parser = new LexemeParser();
            parser.component = sentenceComponent;
            parser.parse((match.group()).trim());
        }
    }
}
