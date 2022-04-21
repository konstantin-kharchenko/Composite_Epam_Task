package by.kharchenko.text.service;

import by.kharchenko.text.composite.TextComponent;
import by.kharchenko.text.exception.CustomException;
import javafx.util.Pair;

import java.util.List;

public interface TextFindService {
    TextComponent findSentenceWithLongestWord(TextComponent text) throws CustomException;

    Pair<Integer, Integer> vowelsConsonants(TextComponent textComponent) throws CustomException;

    List<TextComponent> findAllRepeatingWords(TextComponent text) throws CustomException;
}
