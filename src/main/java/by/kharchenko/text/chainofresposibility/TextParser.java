package by.kharchenko.text.chainofresposibility;

import by.kharchenko.text.composite.TextComponentType;
import by.kharchenko.text.composite.TextComposite;

public class TextParser extends AbstractTextParser {

    @Override
    public void parse(String text) {
        ParagraphParser parser = new ParagraphParser();
        parser.component = new TextComposite(TextComponentType.TEXT);
        component = parser.component;
        parser.parse(text);
    }
}
