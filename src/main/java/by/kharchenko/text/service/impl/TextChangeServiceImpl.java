package by.kharchenko.text.service.impl;

import by.kharchenko.text.comparator.ParagraphComparator;
import by.kharchenko.text.composite.TextComponent;
import by.kharchenko.text.exception.CustomException;
import by.kharchenko.text.service.TextChangeService;

import java.util.Objects;

public class TextChangeServiceImpl implements TextChangeService {
    @Override
    public void paragraphSort(TextComponent textComponent) throws CustomException {
        textComponent.getChildren().sort(new ParagraphComparator());
    }

    @Override
    public void deleteSentence(TextComponent textComponent, int countWords) throws CustomException {
        for (int i = 0; i < textComponent.getChildren().size(); i++) {
            for (int j = 0; j < textComponent.getChildren().get(i).getChildren().size(); j++) {
                if (textComponent.getChildren().get(i).getChildren().get(j).getChildren().size() < countWords) {
                    textComponent.getChildren().get(i).getChildren().remove(j);
                    j = 0;
                    i = 0;
                }
            }
        }
        for (int i = 0; i < textComponent.getChildren().size(); i++) {
            if (Objects.equals(textComponent.getChildren().get(i).toString(), "")) {
                textComponent.getChildren().remove(i);
            }
        }
    }
}
