package es.grsm.elasticsearch.stemmer;


import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class SloveneStemmerTest {
    SloveneStemmer stemmer = new SloveneStemmer();

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

        stem("slovenačina"); // sloven
        assertThat(stemmer.getCurrent(), is("sloven"));

        stem("slovenačini"); // sloven
        assertThat(stemmer.getCurrent(), is("sloven"));

        stem("slovenačino"); // sloven
        assertThat(stemmer.getCurrent(), is("sloven"));
    }

    @Test
    public void testTelovRoot() {
        stem("telovadbe"); // telov
        assertThat(stemmer.getCurrent(), is("telov"));

        stem("telovadcem"); // telov
        assertThat(stemmer.getCurrent(), is("telov"));

        stem("telovadcev"); // telov
        assertThat(stemmer.getCurrent(), is("telov"));

        stem("telovadi"); // telov
        assertThat(stemmer.getCurrent(), is("telov"));

        stem("telovadil"); // telov
        assertThat(stemmer.getCurrent(), is("telov"));

        stem("telovaditi"); // telov
        assertThat(stemmer.getCurrent(), is("telov"));

        stem("telovadne"); // telov
        assertThat(stemmer.getCurrent(), is("telov"));

        stem("telovadni"); // telov
        assertThat(stemmer.getCurrent(), is("telov"));

        stem("telovadno"); // telov
        assertThat(stemmer.getCurrent(), is("telov"));

//        stem("telovnik"); // telovnik
//        assertThat(stemmer.getCurrent(), is("telovnik"));
    }

    @Test
    public void testTemaRoot() {
        stem("tem"); // tem
        assertThat(stemmer.getCurrent(), is("tem"));

        stem("tema"); // tema
        assertThat(stemmer.getCurrent(), is("tema"));

//        stem("temacna"); // tema
//        assertThat(stemmer.getCurrent(), is("tema"));

//        stem("temacni"); // tema
//        assertThat(stemmer.getCurrent(), is("tema"));

//        stem("temacno"); // tema
//        assertThat(stemmer.getCurrent(), is("tema"));
    }

    @Test
    public void testBesedRoot() {
        stem("besed"); // besed
        assertThat(stemmer.getCurrent(), is("besed"));

        stem("beseda"); // besed
        assertThat(stemmer.getCurrent(), is("besed"));

        stem("besedah"); // besedah <------------
        assertThat(stemmer.getCurrent(), is("besed"));

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

//        stem("besedno"); // besed
//        assertThat(stemmer.getCurrent(), is("besed"));
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
