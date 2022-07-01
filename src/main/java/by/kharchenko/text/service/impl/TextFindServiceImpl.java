package by.kharchenko.text.service.impl;

import by.kharchenko.text.composite.Symbol;
import by.kharchenko.text.composite.TextComponent;
import by.kharchenko.text.composite.TextComponentType;
import by.kharchenko.text.exception.CustomException;
import by.kharchenko.text.service.TextFindService;
import javafx.util.Pair;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.util.*;

public class TextFindServiceImpl implements TextFindService {
    private static final Logger logger = LogManager.getLogger(TextFindServiceImpl.class);
    private static final String ERROR_MESSAGE = "TextComponent must be TEXT!";

    @Override
    public TextComponent findSentenceWithLongestWord(TextComponent text) throws CustomException {
        if (text.getComponentType() != TextComponentType.TEXT) {
            logger.log(Level.ERROR, ERROR_MESSAGE);
            throw new CustomException(ERROR_MESSAGE);
        }
        int maxLength = 0;
        int length;
        TextComponent maxSentence = null;
        for (TextComponent paragraph : text.getChildren()) {
            for (TextComponent sentence : paragraph.getChildren()) {
                length = longestWordInSentence(sentence);
                if (length > maxLength) {
                    maxLength = length;
                    maxSentence = sentence;
                }
            }
        }
        return maxSentence;
    }

    @Override
    public List<TextComponent> findAllRepeatingWords(TextComponent text) throws CustomException {
        Set<TextComponent> words = new HashSet<>();
        List<TextComponent> repeatingWords = new ArrayList<>();
        if (TextComponentType.TEXT != text.getComponentType()) {
            logger.error(ERROR_MESSAGE + text);
            throw new CustomException(ERROR_MESSAGE + text);
        }
        List<TextComponent> paragraphs = text.getChildren();
        for (TextComponent paragraph : paragraphs) {
            List<TextComponent> sentences = paragraph.getChildren();
            for (TextComponent sentence : sentences) {
                List<TextComponent> lexemes = sentence.getChildren();
                for (TextComponent lexeme : lexemes) {
                    List<TextComponent> lexemeParts = lexeme.getChildren();
                    for (TextComponent lexemePart : lexemeParts) {
                        if (TextComponentType.WORD == lexemePart.getComponentType()) {
                            words.add(lexemePart);
                        }
                    }
                }
            }
        }
        int count = 0;
        for (TextComponent uniqWord : words) {
            for (TextComponent paragraph : paragraphs) {
                List<TextComponent> sentences = paragraph.getChildren();
                for (TextComponent sentence : sentences) {
                    List<TextComponent> lexemes = sentence.getChildren();
                    for (TextComponent lexeme : lexemes) {
                        List<TextComponent> lexemeParts = lexeme.getChildren();
                        for (TextComponent lexemePart : lexemeParts) {
                            if (TextComponentType.WORD == lexemePart.getComponentType()) {
                                if (Objects.equals(lexemePart.toString().toLowerCase(), uniqWord.toString().toLowerCase())) {
                                    count++;
                                }
                            }
                        }
                    }
                }
            }
            if (count > 1) {
                System.out.println(uniqWord + " -> " + count);
                repeatingWords.add(uniqWord);
            }
            count = 0;
        }
        return repeatingWords;
    }

    @Override
    public Pair<Integer, Integer> vowelsConsonants(TextComponent textComponent) {
        int consonants = 0;
        int vowels = 0;
        for (TextComponent lexeme : textComponent.getChildren()) {
            for (TextComponent lexemeType : lexeme.getChildren()) {
                if (TextComponentType.WORD == lexemeType.getComponentType()) {
                    for (TextComponent symbol : lexemeType.getChildren()) {
                        Character s = ((Symbol) symbol).getSymbol();
                        if (s == 'a' || s == 'y' || s == 'i' || s == 'o' || s == 'e' || s == 'u') {
                            vowels++;
                        } else if (Character.isLetter(s)) {
                            consonants++;
                        }
                    }
                }
            }
        }
        System.out.println(textComponent);
        System.out.println("vowels:" + vowels);
        System.out.println("consonants:" + consonants);
        Pair<Integer, Integer> pair = new Pair<>(consonants, vowels);
        return pair;
    }

    private int longestWordInSentence(TextComponent sentence) {
        int length;
        int maxlength = 0;
        for (TextComponent lexeme : sentence.getChildren()) {
            for (TextComponent lexemeType : lexeme.getChildren()) {
                if (TextComponentType.WORD == lexemeType.getComponentType()) {
                    length = lexemeType.getChildren().size();
                    if (length > maxlength) {
                        maxlength = length;
                    }
                }
            }
        }
        return maxlength;
    }
}
