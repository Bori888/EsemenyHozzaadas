package hu.szamalk.controller;

import hu.szamalk.model.EsemenyModel;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class EsemenyControllerTest {

    @Test
    void testVisszajelzesHibasNev() {
        EsemenyController c = new EsemenyController();
        var e = new EsemenyModel(LocalDateTime.now(), "", "Aula", 10);

        String v = c.visszajelzes(e);
        assertTrue(v.startsWith("Hibás"));
    }

    @Test
    void testVisszajelzesHibasHelyszin() {
        EsemenyController c = new EsemenyController();
        var e = new EsemenyModel(LocalDateTime.now(), "Koncert", "", 10);

        String v = c.visszajelzes(e);
        assertTrue(v.startsWith("Hibás"));
    }

    @Test
    void testVisszajelzesJolKitoltve() {
        EsemenyController c = new EsemenyController();
        var e = new EsemenyModel(LocalDateTime.now(), "Koncert", "Aula", 10);

        String v = c.visszajelzes(e);
        assertEquals("Minden rendben. Felvihető.", v);
    }

    @Test
    void testFelvitelSikeres() {
        EsemenyController c = new EsemenyController();
        var e = new EsemenyModel(LocalDateTime.now(), "Teszt", "Tanterem", 5);

        c.esemenyFeltolt(e);

        assertEquals(1, c.getTar().size());
        assertTrue(c.getTar().contains(e));
    }
}