package hu.szamalk.model;

public class SzemelyModel {

    private boolean iskolaiDolgozoE;
    private String vezNev;
    private String kerNev;
    private int statusz; // 1=szervező, 2=alkalmazott, 3=gyerek

    public SzemelyModel(String vezNev, String kerNev, boolean iskolaiDolgozoE, int statusz) {
        this.vezNev = vezNev;
        this.kerNev = kerNev;
        this.iskolaiDolgozoE = iskolaiDolgozoE;
        this.statusz = statusz;
    }

    public String getVezNev() { return vezNev; }
    public String getKerNev() { return kerNev; }
    public boolean isIskolaiDolgozoE() { return iskolaiDolgozoE; }
    public int getStatusz() { return statusz; }

    @Override
    public String toString() {
        return vezNev + " " + kerNev + " (státusz: " + statusz + ")";
    }
}