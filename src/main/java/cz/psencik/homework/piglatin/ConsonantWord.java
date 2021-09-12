package cz.psencik.homework.piglatin;

public class ConsonantWord extends Word {
    protected ConsonantWord(String word) {
        super(word);
    }

    @Override
    public String translate() {
        var word = getWordWithoutPunctuation();
        var sb = new StringBuilder(word.length()==1 ? word : word.substring(1));
        if(word.length()>1)
            sb.append(word.charAt(0));
        sb.append("ay");
        return combine(sb.toString());
    }
}
