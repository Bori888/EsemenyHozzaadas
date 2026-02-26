package hu.szamalk.view;

import hu.szamalk.controller.EsemenyController;
import hu.szamalk.model.EsemenyModel;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class EsemenyViewConsoleTest {

    @Test
    void testFelvitelNemTartalmazIDt() {
        EsemenyController c = new EsemenyController();
        EsemenyModel e = new EsemenyModel(LocalDateTime.now(), "Teszt", "Aula", 5);

        String v = c.visszajelzes(e);

        // NE szerepeljen ID vagy létszám-teljesség
        assertFalse(v.toLowerCase().contains("id"));
        assertFalse(v.toLowerCase().contains("teljes"));
    }
}