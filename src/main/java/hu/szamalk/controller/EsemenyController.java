package hu.szamalk.controller;

import hu.szamalk.model.EsemenyModel;

import java.util.ArrayList;
import java.util.List;

public class EsemenyController {

    private final List<EsemenyModel> tar = new ArrayList<>();

    // Csak eltárolja, nincs visszatérő ID, nem írunk ki semmit
    public void esemenyFeltolt(EsemenyModel e) {
        tar.add(e);
    }

    // Csak hibát/hiányosságot vagy "Minden rendben. Felvihető." üzenetet ad
    public String visszajelzes(EsemenyModel e) {
        if (e.getNev() == null || e.getNev().isBlank()) return "Hibás: az esemény neve kötelező.";
        if (e.getHelyszin() == null || e.getHelyszin().isBlank()) return "Hibás: a helyszín kötelező.";
        if (e.getDatum() == null) return "Hibás: dátum/idő kötelező.";
        if (e.getLetszam() <= 0) return "Hibás: a létszámnak 1-nél nagyobbnak kell lennie.";
        return "Minden rendben. Felvihető.";
    }

    public List<EsemenyModel> getTar() {
        return List.copyOf(tar);
    }
}