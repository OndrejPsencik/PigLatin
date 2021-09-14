package cz.psencik.homework.piglatin;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class PigLatinTranslator
{
    public String translateString(String input) {
        if(input==null)
            return null;

        var wordStream = StreamSupport.stream(new WordParser(input).spliterator(), false);

        return wordStream.map(Word::translate).collect(Collectors.joining());
    }
}
