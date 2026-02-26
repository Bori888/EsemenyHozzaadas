package hu.szamalk.view;

import hu.szamalk.controller.EsemenyController;
import hu.szamalk.model.EsemenyModel;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class EsemenyViewGUI {

    private JFrame frame;
    private JTextField tfNev;
    private JTextField tfHelyszin;
    private JSpinner spDatum;
    private JSpinner spLetszam;
    private JTextArea taUzenetek;
    private JButton btnFelvitel;

    public void start(EsemenyController controller) {
        SwingUtilities.invokeLater(() -> {
            frame = new JFrame("Esemény felvitel");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(520, 400);
            frame.setLocationRelativeTo(null);
            frame.setLayout(new BorderLayout(8, 8));

            JPanel form = new JPanel(new GridBagLayout());
            GridBagConstraints c = new GridBagConstraints();
            c.insets = new Insets(6,6,6,6);
            c.anchor = GridBagConstraints.WEST;
            c.fill = GridBagConstraints.HORIZONTAL;
            c.weightx = 1.0;

            tfNev = new JTextField();
            tfHelyszin = new JTextField();

            SpinnerDateModel dateModel = new SpinnerDateModel(new Date(), null, null, java.util.Calendar.MINUTE);
            spDatum = new JSpinner(dateModel);
            JSpinner.DateEditor editor = new JSpinner.DateEditor(spDatum, "yyyy-MM-dd HH:mm");
            spDatum.setEditor(editor);

            spLetszam = new JSpinner(new SpinnerNumberModel(1, 1, 100000, 1));

            btnFelvitel = new JButton("Felvitel");

            taUzenetek = new JTextArea(5, 40);
            taUzenetek.setEditable(false);
            taUzenetek.setLineWrap(true);
            taUzenetek.setWrapStyleWord(true);

            int row = 0;
            addRow(form, c, row++, "Esemény neve:", tfNev);
            addRow(form, c, row++, "Helyszín:", tfHelyszin);
            addRow(form, c, row++, "Dátum és idő:", spDatum);
            addRow(form, c, row++, "Létszám:", spLetszam);

            frame.add(form, BorderLayout.CENTER);

            JPanel south = new JPanel(new BorderLayout(6,6));
            south.add(btnFelvitel, BorderLayout.NORTH);
            south.add(new JScrollPane(taUzenetek), BorderLayout.CENTER);
            frame.add(south, BorderLayout.SOUTH);

            btnFelvitel.addActionListener(ev -> onFelvitel(controller));

            frame.setVisible(true);
        });
    }

    private void addRow(JPanel panel, GridBagConstraints c, int row, String label, JComponent comp) {
        c.gridy = row;

        c.gridx = 0;
        c.weightx = 0;
        panel.add(new JLabel(label), c);

        c.gridx = 1;
        c.weightx = 1.0;
        panel.add(comp, c);
    }

    private void onFelvitel(EsemenyController controller) {
        String nev = tfNev.getText().trim();
        String hely = tfHelyszin.getText().trim();

        Date d = (Date) spDatum.getValue();
        LocalDateTime ldt = d.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();

        int letszam = (Integer) spLetszam.getValue();

        EsemenyModel e = new EsemenyModel(ldt, nev, hely, letszam);

        String vissza = controller.visszajelzes(e);
        taUzenetek.append("Ellenőrzés: " + vissza + "\n");

        if (!vissza.startsWith("Minden rendben")) {
            taUzenetek.append("Nem történt felvitel.\n");
            return;
        }

        controller.esemenyFeltolt(e);
        taUzenetek.append("Sikeres felvitel.\n");
    }
}