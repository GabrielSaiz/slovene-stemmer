package es.grsm.elasticsearch.stemmer;


import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class SloveneStemmerTest {
    SloveneStemmer stemmer = new SloveneStemmer();

    private void stem(String str) {
        stemmer.setCurrent(str);
        stemmer.stem();
    }

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
