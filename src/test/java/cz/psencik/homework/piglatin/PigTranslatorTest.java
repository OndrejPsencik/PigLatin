package cz.psencik.homework.piglatin;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PigTranslatorTest
{
    PigLatinTranslator pigLatinTranslator;

    @Before
    public void setUp() {
        pigLatinTranslator = new PigLatinTranslator();
    }

    @Test
    public void base()
    {
        Assert.assertEquals("Ellohay", pigLatinTranslator.translateString("Hello"));
        Assert.assertEquals("appleway", pigLatinTranslator.translateString("apple"));
        Assert.assertEquals("stairway", pigLatinTranslator.translateString("stairway"));
        Assert.assertEquals("antca'y", pigLatinTranslator.translateString("can't"));
        Assert.assertEquals("endway.", pigLatinTranslator.translateString("end."));
        Assert.assertEquals("histay-hingtay", pigLatinTranslator.translateString("this-thing"));
        Assert.assertEquals("Eachbay", pigLatinTranslator.translateString("Beach"));
        Assert.assertEquals("CcLoudmay", pigLatinTranslator.translateString("McCloud"));
        Assert.assertEquals("Ellohay appleway stairway antca'y endway. histay-hingtay Eachbay CcLoudmay",
                pigLatinTranslator.translateString("Hello apple stairway can't end. this-thing Beach McCloud")
        );
    }

    public void emptyInput() {
        Assert.assertNull(pigLatinTranslator.translateString(null));
        Assert.assertEquals("", pigLatinTranslator.translateString(""));
    }
}
