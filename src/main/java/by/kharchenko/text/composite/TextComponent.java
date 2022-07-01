package by.kharchenko.text.composite;

import java.util.List;

public interface TextComponent {

    TextComponentType getComponentType();

    void add(TextComponent textComponent);

    void remove(TextComponent textComponent);

    TextComponent getChild(int id);

    List<TextComponent> getChildren();

}
