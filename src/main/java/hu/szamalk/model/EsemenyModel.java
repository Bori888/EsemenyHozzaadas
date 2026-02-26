package hu.szamalk.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class EsemenyModel extends EsemenyBase implements CloneableEvent {

    private boolean teljesEaLetszam;   // számolt érték
    private int letszam;
    private List<String> letszamNevek;

    public EsemenyModel(LocalDateTime datum, String nev, String helyszin, int letszam) {
        super(datum, nev, helyszin);
        this.letszam = letszam;
        this.letszamNevek = new ArrayList<>();
        this.teljesEaLetszam = false;
    }

    @Override
    public String getTipus() {
        return "Alap esemény";
    }

    public boolean letszamEllenorzo() {
        return letszamNevek.size() >= letszam;
    }

    public List<String> letszamFeltolt(String ujNev) {
        if (!letszamEllenorzo()) {
            letszamNevek.add(ujNev);
            if (letszamNevek.size() == letszam) {
                teljesEaLetszam = true;
            }
        }
        return letszamNevek;
    }

    public boolean isTeljesEaLetszam() { return teljesEaLetszam; }
    public int getLetszam() { return letszam; }
    public List<String> getLetszamNevek() { return List.copyOf(letszamNevek); } // olvasható

    public void setLetszam(int letszam) { this.letszam = letszam; }

    @Override
    public EsemenyModel cloneEvent() {
        EsemenyModel copy = new EsemenyModel(this.datum, this.nev, this.helyszin, this.letszam);
        copy.letszamNevek = new ArrayList<>(this.letszamNevek);
        copy.teljesEaLetszam = this.teljesEaLetszam;
        return copy;
    }

    @Override
    public String toString() {
        return nev + " (" + helyszin + " | " + datum + ") "
                + " jelentkezők: " + letszamNevek.size() + "/" + letszam
                + " | teljes-e: " + (teljesEaLetszam ? "igen" : "nem");
    }
}
