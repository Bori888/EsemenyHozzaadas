package hu.szamalk.view;

import hu.szamalk.controller.EsemenyController;
import hu.szamalk.model.EsemenyModel;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Scanner;

public class EsemenyViewConsole {

    public void konzolosFelvitel(EsemenyController controller) {
        Scanner sc = new Scanner(System.in);

        String nev;
        do {
            System.out.print("Esemény neve: ");
            nev = sc.nextLine().trim();
            if (nev.isBlank()) System.out.println("Hiba: a név kötelező.");
        } while (nev.isBlank());

        String helyszin;
        do {
            System.out.print("Helyszín: ");
            helyszin = sc.nextLine().trim();
            if (helyszin.isBlank()) System.out.println("Hiba: a helyszín kötelező.");
        } while (helyszin.isBlank());

        LocalDate date = null;
        while (date == null) {
            System.out.print("Dátum (YYYY-MM-DD): ");
            String d = sc.nextLine().trim();
            try {
                date = LocalDate.parse(d);
            } catch (Exception ex) {
                System.out.println("Hiba: formátum pl. 2026-03-15");
            }
        }

        LocalTime time = null;
        while (time == null) {
            System.out.print("Idő (HH:MM): ");
            String t = sc.nextLine().trim();
            try {
                time = LocalTime.parse(t);
            } catch (Exception ex) {
                System.out.println("Hiba: formátum pl. 14:30");
            }
        }

        Integer letszam = null;
        while (letszam == null) {
            System.out.print("Létszám (> 0): ");
            String l = sc.nextLine().trim();
            try {
                int v = Integer.parseInt(l);
                if (v <= 0) throw new IllegalArgumentException();
                letszam = v;
            } catch (Exception ex) {
                System.out.println("Hiba: adj meg 0-nál nagyobb egész számot.");
            }
        }

        EsemenyModel e = new EsemenyModel(LocalDateTime.of(date, time), nev, helyszin, letszam);

        String vissza = controller.visszajelzes(e);
        System.out.println("Ellenőrzés: " + vissza);

        if (!vissza.startsWith("Minden rendben")) {
            System.out.println("Nem történt felvitel.");
            return;
        }

        controller.esemenyFeltolt(e);
        System.out.println("Sikeres felvitel.");
    }
}