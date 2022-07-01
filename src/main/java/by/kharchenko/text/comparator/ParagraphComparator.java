package by.kharchenko.text.comparator;

import by.kharchenko.text.composite.TextComponent;

import java.util.Comparator;

public class ParagraphComparator implements Comparator<TextComponent> {
    @Override
    public int compare(TextComponent o1, TextComponent o2) {
        return Integer.compare(o1.getChildren().size(), o2.getChildren().size());
    }
}
