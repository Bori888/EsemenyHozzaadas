package hu.szamalk.view;

import hu.szamalk.controller.EsemenyController;
import hu.szamalk.model.EsemenyModel;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class EsemenyViewGUITest {

    @Test
    void testVisszajelzesNemTartalmazTiltottSzavakat() {
        EsemenyController c = new EsemenyController();
        var e = new EsemenyModel(LocalDateTime.now(), "GUI teszt", "Aula", 5);

        String v = c.visszajelzes(e);

        assertFalse(v.toLowerCase().contains("id"));
        assertFalse(v.toLowerCase().contains("teljes"));
    }
}