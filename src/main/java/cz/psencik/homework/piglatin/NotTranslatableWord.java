package cz.psencik.homework.piglatin;

public class NotTranslatableWord extends Word {
    protected NotTranslatableWord(String word) {
        super(word);
    }

    @Override
    public String translate() {
        return getInputWord();
    }
}
