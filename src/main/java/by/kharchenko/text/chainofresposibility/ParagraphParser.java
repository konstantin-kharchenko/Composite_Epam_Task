package by.kharchenko.text.chainofresposibility;

import by.kharchenko.text.composite.TextComponent;
import by.kharchenko.text.composite.TextComponentType;
import by.kharchenko.text.composite.TextComposite;

import java.util.*;

public class ParagraphParser extends AbstractTextParser {
    private static final String REGEX = "\\t|\\s{4}";

    @Override
    public void parse(String text) {
        String[] paragraphs = text.split(REGEX);
        List<String> paragraphs2 = new ArrayList<>();
        for (String paragraph : paragraphs) {
            if (!Objects.equals(paragraph, "")) {
                paragraphs2.add(paragraph);
            }
        }
        for (String paragraph : paragraphs2) {
            TextComponent paragraphComponent = new TextComposite(TextComponentType.PARAGRAPH);
            component.add(paragraphComponent);
            SentenceParser parser = new SentenceParser();
            parser.component = paragraphComponent;
            parser.parse(paragraph);
        }
    }
}
