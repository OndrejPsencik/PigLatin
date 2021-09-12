package cz.psencik.homework.piglatin;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class WordFactory {
    private static final Set<Character> WOWEL_CHARS = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));

    private WordFactory() {}

    static Word createWord(String input) {
        if(input.toLowerCase().endsWith("way") || !Character.isAlphabetic(input.charAt(0)) || input.equals("-")) {
            return new NotTranslatableWord(input);
        } else if(WOWEL_CHARS.contains(Character.toLowerCase(input.charAt(0)))) {
            return new WovelWord(input);
        } else {
            return new ConsonantWord(input);
        }
    }
}
