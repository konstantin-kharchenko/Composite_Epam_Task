package by.kharchenko.text.chainofresposibility;

import by.kharchenko.text.composite.Symbol;

public class SymbolParser extends AbstractTextParser {
    @Override
    public void parse(String text) {
        for (char a : text.toCharArray()) {
            Symbol symbol = new Symbol(a);
            component.add(symbol);
        }
    }
}
