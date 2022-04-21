package by.kharchenko.text.chainofresposibility;

import by.kharchenko.text.composite.TextComponent;
import by.kharchenko.text.composite.TextComponentType;
import by.kharchenko.text.composite.TextComposite;

public class WordParser extends AbstractTextParser {
    private static final String REGEX = "[,!?;:.]";

    @Override
    public void parse(String text) {
        String[] words = text.split(REGEX);
        for (String word : words) {
            TextComponent wordComponent = new TextComposite(TextComponentType.WORD);
            component.add(wordComponent);
            SymbolParser parser = new SymbolParser();
            parser.component = wordComponent;
            parser.parse(word);
        }
    }
}
