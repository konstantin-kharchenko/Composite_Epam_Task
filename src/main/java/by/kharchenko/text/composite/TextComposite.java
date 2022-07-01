package by.kharchenko.text.composite;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TextComposite implements TextComponent {

    private final TextComponentType componentType;

    private final List<TextComponent> components;

    public TextComposite(TextComponentType componentType) {
        this.componentType = componentType;
        components = new ArrayList<>();
    }

    @Override
    public TextComponentType getComponentType() {
        return componentType;
    }

    @Override
    public void add(TextComponent textComponent) {
        components.add(textComponent);
    }

    @Override
    public void remove(TextComponent textComponent) {
        components.remove(textComponent);
    }

    @Override
    public TextComponent getChild(int id) {
        return components.get(id);
    }

    @Override
    public List<TextComponent> getChildren() {
        return components;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (TextComponent component : components) {
            stringBuilder.append(component);
            stringBuilder.append(component.getComponentType().getDelimiter());
        }
        return stringBuilder.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TextComposite that = (TextComposite) o;
        return componentType == that.componentType && Objects.equals(components, that.components);
    }

    @Override
    public int hashCode() {
        return Objects.hash(componentType, components);
    }
}
