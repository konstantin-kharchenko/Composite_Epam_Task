package by.kharchenko.test.change;

import by.kharchenko.test.FilePath;
import by.kharchenko.text.chainofresposibility.TextParser;
import by.kharchenko.text.exception.CustomException;
import by.kharchenko.text.reader.CustomFileReader;
import by.kharchenko.text.service.TextChangeService;
import by.kharchenko.text.service.impl.TextChangeServiceImpl;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class ChangeTest {

    private static final int COUNT_WORDS = 9;
    TextParser textParser;
    TextParser sortTextParser;
    TextParser deleteTextParser;

    @BeforeTest
    public void load() throws CustomException, IOException {
        CustomFileReader fileReader = CustomFileReader.getInstance();
        String text = fileReader.read(FilePath.PATH);
        textParser = new TextParser();
        textParser.parse(text);
        String sortText = fileReader.read(FilePath.SORT_PATH);
        sortTextParser = new TextParser();
        sortTextParser.parse(sortText);
        String deleteText = fileReader.read(FilePath.DELETE_PATH);
        deleteTextParser = new TextParser();
        deleteTextParser.parse(deleteText);
    }

    @Test
    public void sortTest() throws CustomException {
        TextChangeService textChangeService = new TextChangeServiceImpl();
        textChangeService.paragraphSort(textParser.getComponent());
        Assert.assertEquals(textParser.getComponent(), sortTextParser.getComponent());
    }

    @Test
    public void deleteTest() throws CustomException {
        TextChangeService textChangeService = new TextChangeServiceImpl();
        textChangeService.deleteSentence(textParser.getComponent(), COUNT_WORDS);
        Assert.assertEquals(textParser.getComponent(), deleteTextParser.getComponent());
    }
}
