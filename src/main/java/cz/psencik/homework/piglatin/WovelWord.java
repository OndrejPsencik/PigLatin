package cz.psencik.homework.piglatin;

public class WovelWord extends Word {
    protected WovelWord(String word) {
        super(word);
    }

    @Override
    public String translate() {
        return combine(getWordWithoutPunctuation() + "way");
    }
}
