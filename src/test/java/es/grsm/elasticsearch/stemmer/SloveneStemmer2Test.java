package es.grsm.elasticsearch.stemmer;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class SloveneStemmer2Test {

    SloveneStemmer2 stemmer = new SloveneStemmer2();

    private void stem(String str) {
        stemmer.setCurrent(str);
        stemmer.stem();
    }

    @Test
    public void testStemmingGeneral() {
        stem("imam");
        assertThat(stemmer.getCurrent(), is("imam"));

        stem("probleme");
        assertThat(stemmer.getCurrent(), is("probl"));

        stem("z");
        assertThat(stemmer.getCurrent(), is("z"));

        stem("očmi");
        assertThat(stemmer.getCurrent(), is("očmi"));

        stem("in");
        assertThat(stemmer.getCurrent(), is("in"));

        stem("bi");
        assertThat(stemmer.getCurrent(), is("bi"));

        stem("šel");
        assertThat(stemmer.getCurrent(), is("šel"));

        stem("rad");
        assertThat(stemmer.getCurrent(), is("rad"));

        stem("v");
        assertThat(stemmer.getCurrent(), is("v"));

        stem("kakšne");
        assertThat(stemmer.getCurrent(), is("kakšn"));

        stem("terme");
        assertThat(stemmer.getCurrent(), is("terme"));

        stem("pri");
        assertThat(stemmer.getCurrent(), is("pri"));

        stem("murski");
        assertThat(stemmer.getCurrent(), is("mursk"));

        stem("soboti");
        assertThat(stemmer.getCurrent(), is("sobot"));
    }

    @Test
    public void testSlovenRoot() {
        stem("sloven"); // sloven
        assertThat(stemmer.getCurrent(), is("sloven"));

        stem("slovenca"); // sloven
        assertThat(stemmer.getCurrent(), is("sloven"));

        stem("slovence"); // sloven
        assertThat(stemmer.getCurrent(), is("sloven"));

        stem("slovencem"); // sloven
        assertThat(stemmer.getCurrent(), is("sloven"));

        stem("slovencev"); // sloven
        assertThat(stemmer.getCurrent(), is("sloven"));

        stem("slovenci"); // sloven
        assertThat(stemmer.getCurrent(), is("sloven"));

        stem("slovencih"); // sloven
        assertThat(stemmer.getCurrent(), is("sloven"));

        stem("slovenec"); // sloven
        assertThat(stemmer.getCurrent(), is("sloven"));

        stem("slovenija"); // sloven
        assertThat(stemmer.getCurrent(), is("sloven"));

        stem("sloveniji"); // sloven
        assertThat(stemmer.getCurrent(), is("sloven"));

        stem("slovenijo"); // sloven
        assertThat(stemmer.getCurrent(), is("sloven"));

        stem("slovenko"); // sloven
        assertThat(stemmer.getCurrent(), is("sloven"));

        stem("slovenska"); // sloven
        assertThat(stemmer.getCurrent(), is("sloven"));

        stem("slovenske"); // sloven
        assertThat(stemmer.getCurrent(), is("sloven"));

        stem("slovenskega"); // sloven
        assertThat(stemmer.getCurrent(), is("sloven"));

        stem("slovenskem"); // sloven
        assertThat(stemmer.getCurrent(), is("sloven"));

        stem("slovenskemu"); // sloven
        assertThat(stemmer.getCurrent(), is("sloven"));

        stem("slovenski"); // sloven
        assertThat(stemmer.getCurrent(), is("sloven"));

        stem("slovenskih"); // sloven
        assertThat(stemmer.getCurrent(), is("sloven"));

        stem("slovenskim"); // sloven
        assertThat(stemmer.getCurrent(), is("sloven"));

        stem("slovenskimi"); // sloven
        assertThat(stemmer.getCurrent(), is("sloven"));

        stem("slovensko"); // sloven
        assertThat(stemmer.getCurrent(), is("sloven"));

        stem("slovenstva"); // sloven
        assertThat(stemmer.getCurrent(), is("sloven"));

        stem("slovenacina"); // sloven
        assertThat(stemmer.getCurrent(), is("sloven"));

        stem("slovenacini"); // sloven
        assertThat(stemmer.getCurrent(), is("sloven"));

        stem("slovenacino"); // sloven
        assertThat(stemmer.getCurrent(), is("sloven"));

        // Next assert don't pass the test in the way that the consersation said
        // http://snowball.tartarus.org/archives/snowball-discuss/0725.html
        // But gives the same result as Python implementation
        stem("slovenačina"); // Conversation -> sloven, Python -> slovenač
        assertThat(stemmer.getCurrent(), is("slovenač"));

        stem("slovenačini"); // Conversation -> sloven, Python -> slovenač
        assertThat(stemmer.getCurrent(), is("slovenač"));

        stem("slovenačino"); // Conversation -> sloven, Python -> slovenač
        assertThat(stemmer.getCurrent(), is("slovenač"));
    }

    @Test
    public void testTelovRoot() {
        stem("telovadbe"); // telovad
        assertThat(stemmer.getCurrent(), is("telovad"));

        stem("telovadcem"); // telovad
        assertThat(stemmer.getCurrent(), is("telovad"));

        stem("telovadcev"); // telovad
        assertThat(stemmer.getCurrent(), is("telovad"));

        stem("telovadi"); // telovad
        assertThat(stemmer.getCurrent(), is("telovad"));

        stem("telovadil"); // telovad
        assertThat(stemmer.getCurrent(), is("telovad"));

        stem("telovaditi"); // telovad
        assertThat(stemmer.getCurrent(), is("telovad"));

        stem("telovadne"); // telovad
        assertThat(stemmer.getCurrent(), is("telovad"));

        stem("telovadni"); // telovad
        assertThat(stemmer.getCurrent(), is("telovad"));

        stem("telovadno"); // telovad
        assertThat(stemmer.getCurrent(), is("telovad"));

        stem("telovnik"); // telovadnik
        assertThat(stemmer.getCurrent(), is("telovnik"));
    }

    @Test
    public void testTemaRoot() {
        stem("tem"); // tem
        assertThat(stemmer.getCurrent(), is("tem"));

        stem("tema"); // tema
        assertThat(stemmer.getCurrent(), is("tema"));

        // Next assert don't pass the test in the way that the consersation said
        // http://snowball.tartarus.org/archives/snowball-discuss/0725.html
        // But gives the same result as Python implementation
        stem("temacna"); // Conversation -> tema, Python -> temacn
        assertThat(stemmer.getCurrent(), is("temacn"));

        stem("temacni"); // Conversation -> tema, Python -> temacn
        assertThat(stemmer.getCurrent(), is("temacn"));

        stem("temacno"); // Conversation -> tema, Python -> temacn
        assertThat(stemmer.getCurrent(), is("temacn"));
    }

    @Test
    public void testBesedRoot() {
        stem("besed"); // besed
        assertThat(stemmer.getCurrent(), is("besed"));

        stem("beseda"); // besed
        assertThat(stemmer.getCurrent(), is("besed"));

        // Next assert don't pass the test in the way that the consersation said
        // http://snowball.tartarus.org/archives/snowball-discuss/0725.html
        // But gives the same result as Python implementation
        stem("besedah"); // besedah <------------ Conversation -> besed, Python -> besedah
        assertThat(stemmer.getCurrent(), is("besedah"));

        stem("besedam"); // besed
        assertThat(stemmer.getCurrent(), is("besed"));

        stem("besedami"); // besed
        assertThat(stemmer.getCurrent(), is("besed"));

        stem("besede"); // besed
        assertThat(stemmer.getCurrent(), is("besed"));

        stem("besedi"); // besed
        assertThat(stemmer.getCurrent(), is("besed"));

        stem("besedice"); // besed
        assertThat(stemmer.getCurrent(), is("besed"));

        stem("besedico"); // besed
        assertThat(stemmer.getCurrent(), is("besed"));

        stem("besedila"); // besed
        assertThat(stemmer.getCurrent(), is("besed"));

        stem("besedilmiran"); // besed
        assertThat(stemmer.getCurrent(), is("besed"));

        stem("besedilo"); // besed
        assertThat(stemmer.getCurrent(), is("besed"));

        // Next assert don't pass the test in the way that the consersation said
        // http://snowball.tartarus.org/archives/snowball-discuss/0725.html
        // But gives the same result as Python implementation
        stem("besedno"); // Conversation -> besed, Python -> besedn
        assertThat(stemmer.getCurrent(), is("besedn"));
    }

    @Test
    public void testNonSlovene() {
        // words with non-Slovak Latin characters, or non-Latin characters
        stem("əliağa"); // "əliağ" // Azerbaijani
        assertThat(stemmer.getCurrent(), is("əliağ"));

        stem("año"); // "año" // Spanish
        assertThat(stemmer.getCurrent(), is("año"));

        stem("аблютомания"); // "аблютомания" // Russian
        assertThat(stemmer.getCurrent(), is("аблютомания"));

        stem("вищій"); // "вищій" // Ukrainian
        assertThat(stemmer.getCurrent(), is("вищій"));

        stem("βικιπαίδεια"); // "βικιπαίδεια" // Greek
        assertThat(stemmer.getCurrent(), is("βικιπαίδεια"));

        stem("ვიკიპედია"); // "ვიკიპედია" // Georgian
        assertThat(stemmer.getCurrent(), is("ვიკიპედია"));

        stem("위키백과"); // "위키백과" // Korean
        assertThat(stemmer.getCurrent(), is("위키백과"));

        stem("ውክፔዲያ"); // "ውክፔዲያ" // Amharic
        assertThat(stemmer.getCurrent(), is("ውክፔዲያ"));

        stem("ᐅᐃᑭᐱᑎᐊ"); // "ᐅᐃᑭᐱᑎᐊ" // Inuktitut
        assertThat(stemmer.getCurrent(), is("ᐅᐃᑭᐱᑎᐊ"));
    }
}
