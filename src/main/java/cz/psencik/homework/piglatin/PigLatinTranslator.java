package cz.psencik.homework.piglatin;

public class PigLatinTranslator
{
    public String translateString(String input) {
        if(input==null)
            return null;

        var wpi = new WordParser(input).iterator();

        var sb = new StringBuilder();

        while(wpi.hasNext()) {
            sb.append(wpi.next().translate());
        }

        return sb.toString();
    }
}
