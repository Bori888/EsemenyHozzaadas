package hu.szamalk.model;

import java.time.LocalDateTime;

public abstract class EsemenyBase {
    protected LocalDateTime datum;
    protected String nev;
    protected String helyszin;

    public EsemenyBase(LocalDateTime datum, String nev, String helyszin) {
        this.datum = datum;
        this.nev = nev;
        this.helyszin = helyszin;
    }

    public abstract String getTipus();

    public LocalDateTime getDatum() { return datum; }
    public String getNev() { return nev; }
    public String getHelyszin() { return helyszin; }

    public void setDatum(LocalDateTime datum) { this.datum = datum; }
    public void setNev(String nev) { this.nev = nev; }
    public void setHelyszin(String helyszin) { this.helyszin = helyszin; }
}