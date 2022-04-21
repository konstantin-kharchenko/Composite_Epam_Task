package by.kharchenko.text.composite;

import java.util.List;
import java.util.Objects;

public class Symbol implements TextComponent {
    private static final String ERROR_MESSAGE = "it's a leaf";

    private char symbol;

    public char getSymbol() {
        return symbol;
    }

    private final TextComponentType componentType;

    public Symbol(char symbol) {
        this.symbol = symbol;
        componentType = TextComponentType.SYMBOL;
    }

    @Override
    public TextComponentType getComponentType() {
        return componentType;
    }

    @Override
    public void add(TextComponent textComponent) {
        throw new UnsupportedOperationException(ERROR_MESSAGE);
    }

    @Override
    public void remove(TextComponent textComponent) {
        throw new UnsupportedOperationException(ERROR_MESSAGE);
    }

    @Override
    public TextComponent getChild(int id) {
        throw new UnsupportedOperationException(ERROR_MESSAGE);
    }

    @Override
    public List<TextComponent> getChildren() {
        throw new UnsupportedOperationException(ERROR_MESSAGE);
    }

    @Override
    public String toString() {
        return String.valueOf(symbol);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Symbol symbol1 = (Symbol) o;
        return symbol == symbol1.symbol && componentType == symbol1.componentType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(symbol, componentType);
    }
}
