package hu.szamalk.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class EsemenyModelTest {

    @Test
    void testLetrehozas() {
        var e = new EsemenyModel(LocalDateTime.of(2026, 3, 10, 12, 0),
                "Koncert", "Aula", 20);

        assertEquals("Koncert", e.getNev());
        assertEquals("Aula", e.getHelyszin());
        assertEquals(20, e.getLetszam());
        assertEquals("Alap esemény", e.getTipus());
    }

    @Test
    void testCloneEvent() {
        var e = new EsemenyModel(LocalDateTime.now(), "Teszt", "Aula", 10);
        var clone = e.cloneEvent();

        assertNotSame(e, clone);
        assertEquals(e.getNev(), clone.getNev());
        assertEquals(e.getHelyszin(), clone.getHelyszin());
        assertEquals(e.getLetszam(), clone.getLetszam());
    }
}