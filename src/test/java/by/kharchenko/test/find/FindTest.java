package by.kharchenko.test.find;

import by.kharchenko.test.FilePath;
import by.kharchenko.text.chainofresposibility.TextParser;
import by.kharchenko.text.composite.TextComponent;
import by.kharchenko.text.exception.CustomException;
import by.kharchenko.text.reader.CustomFileReader;
import by.kharchenko.text.service.TextFindService;
import by.kharchenko.text.service.impl.TextFindServiceImpl;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class FindTest {

    TextParser textParser;
    private static final String MAX_WORD_IN_SENTENCE = "So far So far, we've shown you how to use linear and compositional layouts.";
    private static final int COUNT_REPEATING = 25;
    int VOWELS = 19;
    int CONSONANTS = 21;

    @BeforeTest
    public void load() throws CustomException, IOException {
        CustomFileReader fileReader = CustomFileReader.getInstance();
        String text = fileReader.read(FilePath.PATH);
        textParser = new TextParser();
        textParser.parse(text);
    }

    @Test
    public void maxWordTest() throws CustomException {
        TextFindService textFindService = new TextFindServiceImpl();
        TextComponent textComponent = textFindService.findSentenceWithLongestWord(textParser.getComponent());
        System.out.println(textComponent);
        Assert.assertEquals(MAX_WORD_IN_SENTENCE, textComponent.toString().trim());
    }

    @Test
    public void countRepeatingTest() throws CustomException {
        TextFindService textFindService = new TextFindServiceImpl();
        List<TextComponent> textComponents = textFindService.findAllRepeatingWords(textParser.getComponent());
        Assert.assertEquals(COUNT_REPEATING, textComponents.size());
    }

    @Test
    public void vowelsConsonantsTest() throws CustomException {
        TextFindService textFindService = new TextFindServiceImpl();
        var a = textFindService.vowelsConsonants(textParser.getComponent().getChild(0).getChild(0));
        Assert.assertEquals(a.getKey(), CONSONANTS);
        Assert.assertEquals(a.getValue(), VOWELS);
    }
}
