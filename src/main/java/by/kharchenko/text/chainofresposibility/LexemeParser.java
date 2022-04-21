package by.kharchenko.text.chainofresposibility;

import by.kharchenko.text.composite.TextComponent;
import by.kharchenko.text.composite.TextComponentType;
import by.kharchenko.text.composite.TextComposite;

public class LexemeParser extends AbstractTextParser {
    private static final String REGEX = "\\s";

    @Override
    public void parse(String text) {
        String[] lexemes = text.split(REGEX);

        for (String lexeme : lexemes) {
            TextComponent lexemeComponent = new TextComposite(TextComponentType.LEXEME);
            component.add(lexemeComponent);
            WordParser wordParser = new WordParser();
            wordParser.component = lexemeComponent;
            wordParser.parse(lexeme);
            char punctuation = lexeme.charAt(lexeme.length() - 1);
            if (!Character.isLetter(punctuation)) {
                SymbolParser parser = new SymbolParser();
                parser.component = lexemeComponent;
                parser.parse(Character.toString(punctuation));
            }
        }
    }
}
