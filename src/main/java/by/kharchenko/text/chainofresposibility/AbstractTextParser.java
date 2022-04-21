package by.kharchenko.text.chainofresposibility;

import by.kharchenko.text.composite.TextComponent;

public abstract class AbstractTextParser {
    protected TextComponent component;

    public abstract void parse(String text);

    public TextComponent getComponent() {
        return component;
    }
}
