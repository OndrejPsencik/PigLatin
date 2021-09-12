package cz.psencik.homework.piglatin;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public abstract class Word {
    protected static final Set<Character> PUNCTUATION_CHARS = new HashSet<>(Arrays.asList('.', '!', '?', '\''));

    private String inputWord;

    @Override
    public String toString() {
        return inputWord;
    }

    public abstract String translate();

    protected Word(String inputWord) {
        this.inputWord = inputWord;
    }

    protected String getInputWord() {
        return inputWord;
    }

    protected String getWordWithoutPunctuation() {
        var sb = new StringBuilder();
        for (var i = 0; i < inputWord.length(); i++) {
            var ch = inputWord.charAt(i);
            if(!PUNCTUATION_CHARS.contains(ch))
                sb.append(ch);
        }
        return sb.toString();
    }

    protected String combine(String input) {
        return punctuationCombine(caseCombine(input));
    }

    private String caseCombine(String input) {
        var sb = new StringBuilder();
        var io = 0;
        var i = 0;

        for (; i < inputWord.length(); i++) {
            var chi = inputWord.charAt(i);
            var cho = input.charAt(io);

            if (!PUNCTUATION_CHARS.contains(chi)) {
                if (Character.isLowerCase(chi)) {
                    sb.append(Character.toLowerCase(cho));
                } else {
                    sb.append(Character.toUpperCase(cho));
                }
                io++;
            }
        }

        if(io<input.length())
            sb.append(input.substring(io));

        return sb.toString();
    }

    private String punctuationCombine(String input) {
        var sb = new StringBuilder();
        var cho = input.length() - 1;

        for (int i = inputWord.length()-1; i>=0 ; i--) {
            var chi = inputWord.charAt(i);
            if(PUNCTUATION_CHARS.contains(chi)) {
                sb.append(chi);
            } else {
                sb.append(input.charAt(cho));
                cho--;
            }
        }

        if(cho>=0) {
            sb.append(new StringBuilder(input.substring(0, cho + 1)).reverse());
        }

        return sb.reverse().toString();
    }
}
