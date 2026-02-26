package hu.szamalk;

import hu.szamalk.controller.EsemenyController;
import hu.szamalk.view.EsemenyViewConsole;
import hu.szamalk.view.EsemenyViewGUI;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        EsemenyController controller = new EsemenyController();
        Scanner sc = new Scanner(System.in);

        int mode = askMode(sc);

        if (mode == 1) {
            System.out.println("Konzolos felvitel indul...");
            new EsemenyViewConsole().konzolosFelvitel(controller);
            System.out.println("Kész.");
        } else {
            System.out.println("GUI indul...");
            new EsemenyViewGUI().start(controller);
        }
    }

    /**
     * Addig kérdezi a módot, amíg 1 (konzol) vagy 2 (GUI) nem érkezik.
     * Elfogadott beviteli formák:
     * - "1", "konzol", "console", "c"
     * - "2", "gui", "g", "graphical"
     */
    private static int askMode(Scanner sc) {
        while (true) {
            System.out.println("Válassz módot: 1 = Konzol, 2 = GUI");
            System.out.print("Bevitel: ");
            String in;
            try {
                in = sc.nextLine();
            } catch (Exception e) {
                // Ha nincs input (EOF), inkább KONZOL módra állunk biztonsággal
                System.out.println("\nNincs bevitel érzékelve. Alapértelmezés: Konzol mód.");
                return 1;
            }

            if (in == null) {
                System.out.println("Érvénytelen választás. Kérlek, add meg: 1 (Konzol) vagy 2 (GUI).");
                continue;
            }

            String norm = in.trim().toLowerCase(Locale.ROOT);

            // Konzol mód elfogadott értékei
            if (norm.equals("1") || norm.equals("konzol") || norm.equals("console") || norm.equals("c")) {
                return 1;
            }

            // GUI mód elfogadott értékei
            if (norm.equals("2") || norm.equals("gui") || norm.equals("g") || norm.equals("graphical")) {
                return 2;
            }

            System.out.println("Érvénytelen választás. Kérlek, add meg: 1 (Konzol) vagy 2 (GUI).");
        }
    }
}