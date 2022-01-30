package es.grsm.elasticsearch.stemmer;

import org.apache.lucene.analysis.util.StemmerUtil;
import org.elasticsearch.common.util.set.Sets;
import org.tartarus.snowball.SnowballProgram;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SloveneStemmer extends SnowballProgram {

    private static final Set<Character> CRKE = new HashSet<>(Arrays.asList('a','b','c','č','d','e','f','g','h','i','j','k','l','m','n','o','p','r','s','š','t','u','v','z','ž'));
    private static final Set<Character> SAMOGLASNIKI = new HashSet<>(Arrays.asList('a','e','i','o','u'));
    private static final Set<Character> SOGLASNIKI = Sets.difference(CRKE, SAMOGLASNIKI);

    @Override
    public boolean stem() {
        int len = this.limit;
        for (int i = 0; i < 4; i++) {
            len = stem(getCurrentBuffer(), len);
            this.setCurrent(new String(getCurrentBuffer(), 0, len));
        }

        return true;
    }

    public int stem(char[] s, int len) {
        return removeCase(s, len);
    }

    private int removeCase(char[] s, int len) {
        if (greaterThan8(s, len)) {
            return len - 5;
        }

        if (greaterThan7(s, len)) {
            return len - 4;
        }

        if (greaterThan6_large_suffix(s, len)) {
            return len - 3;
        }

        if (greaterThan6_short_suffix(s, len)) {
            return len - 2;
        }

        if (greaterThan5_extended_suffix(s, len)) {
            return len - 1;
        }

        if (checkSoglasniki(s, len)) {
            return len - 1;
        }

        if (greaterThan5(s, len)) {
            return len - 1;
        }
        return len;
    }

    private boolean checkSoglasniki(char[] s, int len) {
        return len > 6 && SOGLASNIKI.contains(s[len - 1]);
    }

    private boolean greaterThan8(char[] s, int len) {
        return len > 8
                && (StemmerUtil.endsWith(s, len, "ovski")
                || StemmerUtil.endsWith(s, len, "evski")
                || StemmerUtil.endsWith(s, len, "anski"));
    }

    private boolean greaterThan7(char[] s, int len) {
        return len > 7
                && (StemmerUtil.endsWith(s, len, "stvo")
                || StemmerUtil.endsWith(s, len, "štvo"));
    }

    private boolean greaterThan6_large_suffix(char[] s, int len) {
        return len > 6
                && (StemmerUtil.endsWith(s, len, "šen")
                || StemmerUtil.endsWith(s, len, "ski")
                || StemmerUtil.endsWith(s, len, "ček")
                || StemmerUtil.endsWith(s, len, "ovm")
                || StemmerUtil.endsWith(s, len, "ega")
                || StemmerUtil.endsWith(s, len, "ovi")
                || StemmerUtil.endsWith(s, len, "ijo")
                || StemmerUtil.endsWith(s, len, "ija")
                || StemmerUtil.endsWith(s, len, "ema")
                || StemmerUtil.endsWith(s, len, "ste")
                || StemmerUtil.endsWith(s, len, "ejo")
                || StemmerUtil.endsWith(s, len, "ite")
                || StemmerUtil.endsWith(s, len, "ila")
                || StemmerUtil.endsWith(s, len, "šče")
                || StemmerUtil.endsWith(s, len, "ški")
                || StemmerUtil.endsWith(s, len, "ost")
                || StemmerUtil.endsWith(s, len, "ast")
                || StemmerUtil.endsWith(s, len, "len")
                || StemmerUtil.endsWith(s, len, "ven")
                || StemmerUtil.endsWith(s, len, "vna")
                || StemmerUtil.endsWith(s, len, "čan")
                || StemmerUtil.endsWith(s, len, "iti"));
    }

    private boolean greaterThan6_short_suffix(char[] s, int len) {
        return len > 6
                && (StemmerUtil.endsWith(s, len, "al")
                || StemmerUtil.endsWith(s, len, "ih")
                || StemmerUtil.endsWith(s, len, "iv")
                || StemmerUtil.endsWith(s, len, "eg")
                || StemmerUtil.endsWith(s, len, "ja")
                || StemmerUtil.endsWith(s, len, "je")
                || StemmerUtil.endsWith(s, len, "em")
                || StemmerUtil.endsWith(s, len, "en")
                || StemmerUtil.endsWith(s, len, "ev")
                || StemmerUtil.endsWith(s, len, "ov")
                || StemmerUtil.endsWith(s, len, "jo")
                || StemmerUtil.endsWith(s, len, "ma")
                || StemmerUtil.endsWith(s, len, "mi")
                || StemmerUtil.endsWith(s, len, "eh")
                || StemmerUtil.endsWith(s, len, "ij")
                || StemmerUtil.endsWith(s, len, "om")
                || StemmerUtil.endsWith(s, len, "do")
                || StemmerUtil.endsWith(s, len, "oč")
                || StemmerUtil.endsWith(s, len, "ti")
                || StemmerUtil.endsWith(s, len, "il")
                || StemmerUtil.endsWith(s, len, "ec")
                || StemmerUtil.endsWith(s, len, "ka")
                || StemmerUtil.endsWith(s, len, "in")
                || StemmerUtil.endsWith(s, len, "an")
                || StemmerUtil.endsWith(s, len, "at")
                || StemmerUtil.endsWith(s, len, "ir"));
    }

    private boolean greaterThan5_extended_suffix(char[] s, int len) {
        return len > 5
                && (StemmerUtil.endsWith(s, len, "š")
                || StemmerUtil.endsWith(s, len, "m")
                || StemmerUtil.endsWith(s, len, "c")
                || StemmerUtil.endsWith(s, len, "a")
                || StemmerUtil.endsWith(s, len, "e")
                || StemmerUtil.endsWith(s, len, "i")
                || StemmerUtil.endsWith(s, len, "o")
                || StemmerUtil.endsWith(s, len, "u"));
    }

    private boolean greaterThan5(char[] s, int len) {
        return len > 5
                && (StemmerUtil.endsWith(s, len, "a")
                || StemmerUtil.endsWith(s, len, "e")
                || StemmerUtil.endsWith(s, len, "i")
                || StemmerUtil.endsWith(s, len, "o")
                || StemmerUtil.endsWith(s, len, "u"));
    }


}
