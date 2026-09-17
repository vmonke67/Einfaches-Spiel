import javax.swing.*;
import java.awt.*;

public class Controller {

    private final GewinnModel gewinnModel;
    private final View view;

    public Controller() {
        gewinnModel = new GewinnModel();
        view = new View();

        addListeners();
    }

    public static void main(String[] args) {
        new Controller();
    }

    private void addListeners() {
        view.addSpielerZahlListener(e -> spielerZahlEingegeben());
        view.addNochEinmalListener(e -> view.clearRunde());
    }

    private void spielerZahlEingegeben() {
        int spielerZahl = leseSpielerZahl();

        if (spielerZahl == -1) {
            return;
        }

        spieleRunde(spielerZahl);
        aktualisiereView();
    }

    private int leseSpielerZahl() {
        String eingabe = view.getTxtSpielerZahl().getText().trim();

        try {
            int zahl = Integer.parseInt(eingabe);

            if (zahl < 0 || zahl > 9) {
                System.out.println("Bitte eine Zahl zwischen 0 und 9 eingeben.");
                return -1;
            }

            return zahl;

        } catch (NumberFormatException ex) {
            System.out.println("Falsche Eingabe. Bitte eine Zahl eingeben.");
            return -1;
        }
    }

    private void spieleRunde(int spielerZahl) {
        gewinnModel.setSpielerZahl(spielerZahl);
        gewinnModel.berechneComputerZahl();
        gewinnModel.berechneRunde();
    }

    private void aktualisiereView() {
        view.setComputerZahl(gewinnModel.getComputerZahl());

        if (gewinnModel.getRundenErgebnis() > 0) {
            view.getLblGesamtpunkte().setForeground(Color.GREEN);
            view.getLblRundenErgebnis().setForeground(Color.GREEN);
        } else {
            view.getLblGesamtpunkte().setForeground(Color.RED);
            view.getLblRundenErgebnis().setForeground(Color.RED);
        }

        if (gewinnModel.hatGewonnen()) {
            view.setRundenErgebnis("Gewonnen");
            view.setGesamtpunkte(gewinnModel.getGesamtPunkte());
            return;
        }

        if (gewinnModel.hatVerloren()) {
            view.setRundenErgebnis("Verloren");
            view.setGesamtpunkte(gewinnModel.getGesamtPunkte());
            return;
        }

        view.setRundenErgebnis(gewinnModel.getRundenErgebnis());
        view.setGesamtpunkte(gewinnModel.getGesamtPunkte());
    }
}