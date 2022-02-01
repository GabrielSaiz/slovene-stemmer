package es.grsm.elasticsearch.stemmer;

import org.elasticsearch.common.util.set.Sets;
import org.tartarus.snowball.Among;
import org.tartarus.snowball.SnowballProgram;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SloveneStemmer2 extends SnowballProgram {

    private static final Set<Character> CRKE = new HashSet<>(Arrays.asList('a','b','c','č','d','e','f','g','h','i','j','k','l','m','n','o','p','r','s','š','t','u','v','z','ž'));
    private static final Set<Character> SAMOGLASNIKI = new HashSet<>(Arrays.asList('a','e','i','o','u'));
    private static final Set<Character> SOGLASNIKI = Sets.difference(CRKE, SAMOGLASNIKI);

    private static final java.lang.invoke.MethodHandles.Lookup methodObject = java.lang.invoke.MethodHandles.lookup();

    private static final Among[] a_1 = {
            new Among ( "anski", -1, 5, "", methodObject ),
            new Among ( "evski", -1, 5, "", methodObject ),
            new Among ( "ovski", -1, 5, "", methodObject ),
    };

    private static final Among[] a_2 = {
            new Among ( "stvo", -1, 4, "", methodObject ),
            new Among ( "štvo", -1, 4, "", methodObject )
    };

    private static final Among[] a_3 = {
            new Among ( "ega", -1, 3, "", methodObject ),
            new Among ( "vna", -1, 3, "", methodObject ),
            new Among ( "ija", -1, 3, "", methodObject ),
            new Among ( "ila", -1, 3, "", methodObject ),
            new Among ( "ema", -1, 3, "", methodObject ),
            new Among ( "ite", -1, 3, "", methodObject ),
            new Among ( "ste", -1, 3, "", methodObject ),
            new Among ( "šče", -1, 3, "", methodObject ),
            new Among ( "ski", -1, 3, "", methodObject ),
            new Among ( "ški", -1, 3, "", methodObject ),
            new Among ( "iti", -1, 3, "", methodObject ),
            new Among ( "ovi", -1, 3, "", methodObject ),
            new Among ( "ček", -1, 3, "", methodObject ),
            new Among ( "ovm", -1, 3, "", methodObject ),
            new Among ( "čan", -1, 3, "", methodObject ),
            new Among ( "len", -1, 3, "", methodObject ),
            new Among ( "ven", -1, 3, "", methodObject ),
            new Among ( "šen", -1, 3, "", methodObject ),
            new Among ( "ejo", -1, 3, "", methodObject ),
            new Among ( "ijo", -1, 3, "", methodObject ),
            new Among ( "ast", -1, 3, "", methodObject ),
            new Among ( "ost", -1, 3, "", methodObject ),
    };

    private static final Among[] a_4 = {
            new Among("ja", -1, 2, "", methodObject),
            new Among("ka", -1, 2, "", methodObject),
            new Among("ma", -1, 2, "", methodObject),
            new Among("ec", -1, 2, "", methodObject),
            new Among("je", -1, 2, "", methodObject),
            new Among("eg", -1, 2, "", methodObject),
            new Among("eh", -1, 2, "", methodObject),
            new Among("ih", -1, 2, "", methodObject),
            new Among("mi", -1, 2, "", methodObject),
            new Among("ti", -1, 2, "", methodObject),
            new Among("ij", -1, 2, "", methodObject),
            new Among("al", -1, 2, "", methodObject),
            new Among("il", -1, 2, "", methodObject),
            new Among("em", -1, 2, "", methodObject),
            new Among("om", -1, 2, "", methodObject),
            new Among("an", -1, 2, "", methodObject),
            new Among("en", -1, 2, "", methodObject),
            new Among("in", -1, 2, "", methodObject),
            new Among("do", -1, 2, "", methodObject),
            new Among("jo", -1, 2, "", methodObject),
            new Among("ir", -1, 2, "", methodObject),
            new Among("at", -1, 2, "", methodObject),
            new Among("ev", -1, 2, "", methodObject),
            new Among("iv", -1, 2, "", methodObject),
            new Among("ov", -1, 2, "", methodObject),
            new Among("oč", -1, 2, "", methodObject),
    };

    private static final Among[] a_5 = {
            new Among ( "a", -1, 1, "", methodObject ),
            new Among ( "c", -1, 1, "", methodObject ),
            new Among ( "e", -1, 1, "", methodObject ),
            new Among ( "i", -1, 1, "", methodObject ),
            new Among ( "m", -1, 1, "", methodObject ),
            new Among ( "o", -1, 1, "", methodObject ),
            new Among ( "u", -1, 1, "", methodObject ),
            new Among ( "š", -1, 1, "", methodObject ),
    };

    private static final Among[] a_6 = {
            new Among ( "a", -1, 1, "", methodObject ),
            new Among ( "e", -1, 1, "", methodObject ),
            new Among ( "i", -1, 1, "", methodObject ),
            new Among ( "o", -1, 1, "", methodObject ),
            new Among ( "u", -1, 1, "", methodObject )
    };

    private int iP1;

    protected void copy_from(SloveneStemmer2 other) {
        iP1 = other.iP1;
        super.copy_from(other);
    }

    @Override
    public boolean stem() {
        String s = getCurrent();

        iP1 = limit;

        int var40 = cursor;
        int var41 = s.length() - limit;

        invert();


        for (int var38 = 0; var38 < 4; var38++ ) {
            s = processWord(s, 8, a_1, false);
            s = processWord(s, 7, a_2, false);
            s = processWord(s, 6, a_3, true);
            s = processWord(s, 6, a_4, true);
            s = processWord(s, 5, a_5, true);

            s = processWordInSoglasniki(s);

            s = processWord(s, 5, a_6, true);
        }

        cursor = var40;
        limit = s.length() - var41;

        return true;
    }

    private void invert() {
        int cursorInverse = limit;
        int limitInverse = cursor;
        cursor = cursorInverse;
        limit = limitInverse;
    }

    private String processWord(String s, int lenMax, Among[] among, boolean assignIP1) {
        boolean r;
        if (assignIP1) {
            iP1 = s.length();
        }
        int var1 = s.length() - cursor;
        if (iP1 > lenMax) {
            r = find_among_b(among, among.length) > 0;

            if (r) {
                s = deleteAmong();
            }

        } else {
            r = false;
        }

        if (!r) {
            cursor = s.length() - var1;
        }

        return s;
    }

    private String processWordInSoglasniki(String s) {
        iP1 = s.length();
        int var31 = s.length() - cursor;

        boolean r = false;
        if (iP1 > 6) {
            if (cursor != limit) {
                r = SOGLASNIKI.contains(s.toCharArray()[cursor - 1]);
            }
            if (r){
                cursor -= 1;
                int var30 = s.length() - cursor;
                if (cursor == limit) {
                    r = false;
                } else {
                    r = SOGLASNIKI.contains(s.toCharArray()[cursor - 1]);
                }

                cursor = s.length() - var30;

                if (r) {
                    s = deleteAmong();
                }
            }
        }

        if (!r) {
            cursor = s.length() - var31;
        }

        return s;
    }

    private String deleteAmong() {

        // delete among
        int cursorAux = cursor;
        int limitAux = limit;
        int limitBackwardAux = limit_backward;
        setCurrent(new String(getCurrentBuffer(), 0, cursor));
        String s = getCurrent();
        cursor = cursorAux;
        limit = limitAux;
        limit_backward = limitBackwardAux;

        return s;
    }

//

}
