import javax.swing.*;
import java.awt.*;


/**
 * Controller
 *
 * @author Monke Vladyslav
 */
public class Controller {

    private final GewinnModel gewinnModel;
    private final View view;

    /**
     * Erstellt einen neuen Controller und initialisiert
     * das GewinnModel sowie die View.
     * Anschließend werden die benötigten Listener hinzugefügt.
     */
    public Controller() {
        gewinnModel = new GewinnModel();
        view = new View();

        addListeners();
    }

    /**
     * Startet die Anwendung und erstellt einen neuen Controller.
     *
     * @param args Kommandozeilenargumente
     */
    public static void main(String[] args) {
        new Controller();
    }

    /**
     * Fügt die Listener für die Eingabe des Spielers
     * und für den Button "Noch einmal!" hinzu.
     */
    private void addListeners() {
        view.addSpielerZahlListener(e -> spielerZahlEingegeben());
        view.addNochEinmalListener(e -> nochEinmalEingabe());
    }

    /**
     * Bereitet die View für eine neue Runde vor.
     * Der Button wird deaktiviert, die Eingabe wieder aktiviert
     * und die Werte der vorherigen Runde werden gelöscht.
     */
    private void nochEinmalEingabe() {
        view.getBtnNochEinmal().setEnabled(false);
        view.getTxtSpielerZahl().setEditable(true);
        view.clearRunde();
    }

    /**
     * Liest die eingegebene Spielerzahl ein und startet eine Runde,
     * sofern die Eingabe gültig ist.
     */
    private void spielerZahlEingegeben() {
        int spielerZahl = leseSpielerZahl();

        if (spielerZahl == -1) {
            return;
        }

        spieleRunde(spielerZahl);
        aktualisiereView();
    }

    /**
     * Liest die Zahl aus dem Eingabefeld der View
     * und überprüft, ob es sich um eine gültige Zahl handelt.
     *
     * @return Die eingegebene Zahl oder -1 bei einer ungültigen Eingabe
     */
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

    /**
     * Führt eine komplette Spielrunde durch.
     * Die Spielerzahl wird an das Model übergeben, anschließend
     * wird eine Computerzahl erzeugt und das Rundenergebnis berechnet.
     *
     * @param spielerZahl Die vom Spieler eingegebene Zahl
     */
    private void spieleRunde(int spielerZahl) {
        gewinnModel.setSpielerZahl(spielerZahl);
        gewinnModel.berechneComputerZahl();
        gewinnModel.berechneRunde();
    }

    /**
     * Aktualisiert die Anzeige der View anhand des aktuellen
     * Spielstands und des Ergebnisses der letzten Runde.
     * Außerdem wird geprüft, ob das Spiel gewonnen oder verloren wurde.
     */
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
        view.getTxtSpielerZahl().setEditable(false);
        view.getBtnNochEinmal().setEnabled(true);
        view.setRundenErgebnis(gewinnModel.getRundenErgebnis());
        view.setGesamtpunkte(gewinnModel.getGesamtPunkte());
    }
}