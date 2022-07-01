package by.kharchenko.text.comparator;

import by.kharchenko.text.composite.TextComponent;

import java.util.Comparator;

public class ChildrenComparator implements Comparator<TextComponent> {
    @Override
    public int compare(TextComponent o1, TextComponent o2) {
        int s1 = o1.getChildren().size();
        int s2 = o2.getChildren().size();
        if (s1 < s2) return 1;
        else if (s1 > s2) return -1;
        else return 0;
    }
}
