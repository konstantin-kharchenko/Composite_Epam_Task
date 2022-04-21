package by.kharchenko.text.service;

import by.kharchenko.text.composite.TextComponent;
import by.kharchenko.text.exception.CustomException;

public interface TextChangeService {
    void paragraphSort(TextComponent textComponent) throws CustomException;

    void deleteSentence(TextComponent textComponent, int countWords) throws CustomException;
}
