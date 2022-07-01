package by.kharchenko.text.composite;

public enum TextComponentType {
    TEXT(""), PARAGRAPH("\n\t"), SENTENCE(""), LEXEME(" "), WORD(""), SYMBOL("");
    private final String delimiter;

    TextComponentType(String s) {
        delimiter = s;
    }

    public String getDelimiter() {
        return delimiter;
    }
}
