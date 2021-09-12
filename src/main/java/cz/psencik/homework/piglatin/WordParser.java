package cz.psencik.homework.piglatin;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Spliterator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;

public class WordParser implements Iterable<Word> {
    private String input;

    public WordParser(String input) {
        this.input = input;
    }

    @Override
    public Iterator<Word> iterator() {
        return new Iterator<>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return input != null && index < input.length();
            }

            @Override
            public Word next() {
                if (index >= input.length())
                    throw new NoSuchElementException();

                var stringBuilder = new StringBuilder();

                BiPredicate<Character, Boolean> shouldBreak = (ch, whiteSpace) ->
                        ch == '-' || (!Character.isAlphabetic(ch) && stringBuilder.length() == 0)
                                || Character.isWhitespace(ch) ^ whiteSpace;

                boolean whiteSpace = Character.isWhitespace(input.charAt(index));
                for (; index < input.length(); index++) {
                    var ch = input.charAt(index);

                    if (shouldBreak.test(ch, whiteSpace)) {
                        if (stringBuilder.length() == 0) {
                            stringBuilder.append(ch);
                            index++;
                        }
                        break;
                    }

                    stringBuilder.append(ch);
                }
                return WordFactory.createWord(stringBuilder.toString());
            }
        };
    }

    @Override
    public void forEach(Consumer<? super Word> action) {
        Iterable.super.forEach(action);
    }

    @Override
    public Spliterator<Word> spliterator() {
        return Iterable.super.spliterator();
    }
}