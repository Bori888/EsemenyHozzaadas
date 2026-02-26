package hu.szamalk.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SzemelyModelTest {

    @Test
    void testGetVezNev() {
        SzemelyModel s = new SzemelyModel("Kiss", "Anna", true, 1);
        assertEquals("Kiss", s.getVezNev());
    }

    @Test
    void testGetKerNev() {
        SzemelyModel s = new SzemelyModel("Kiss", "Anna", true, 1);
        assertEquals("Anna", s.getKerNev());
    }

    @Test
    void testIsIskolaiDolgozoE() {
        SzemelyModel s = new SzemelyModel("Kiss", "Anna", true, 1);
        assertTrue(s.isIskolaiDolgozoE());

        SzemelyModel s2 = new SzemelyModel("Nagy", "Béla", false, 3);
        assertFalse(s2.isIskolaiDolgozoE());
    }

    @Test
    void testGetStatusz() {
        SzemelyModel s = new SzemelyModel("Kiss", "Anna", true, 1);
        assertEquals(1, s.getStatusz());

        SzemelyModel s2 = new SzemelyModel("Nagy", "Béla", false, 3);
        assertEquals(3, s2.getStatusz());
    }

    @Test
    void testToString() {
        SzemelyModel s = new SzemelyModel("Kiss", "Anna", true, 1);
        String t = s.toString();

        assertTrue(t.contains("Kiss"));
        assertTrue(t.contains("Anna"));
        assertTrue(t.contains("1"));   // státusz megjelenik
    }
}