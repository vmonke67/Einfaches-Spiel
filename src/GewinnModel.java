import java.util.Random;


/**
 * Model
 *
 * @author Monke Vladyslav
 */
public class GewinnModel {
    private int gesamtPunkte;
    private int spielerZahl;
    private int computerZahl;
    private int rundenErgebnis;

    /**
     * Erstellt ein neues GewinnModel und setzt die Startwerte.
     * Die Gesamtpunktzahl wird auf 30 Punkte gesetzt.
     */
    public GewinnModel() {
        gesamtPunkte = 30;
        spielerZahl = 0;
        computerZahl = 0;
        rundenErgebnis = 0;
    }

    /**
     * Setzt die vom Spieler eingegebene Zahl.
     *
     * @param spielerZahl Die vom Spieler gewählte Zahl
     */
    public void setSpielerZahl(int spielerZahl) {
        this.spielerZahl = spielerZahl;
    }

    /**
     * Gibt die aktuelle Gesamtpunktzahl zurück.
     *
     * @return Die Gesamtpunktzahl des Spielers
     */
    public int getGesamtPunkte() {
        return gesamtPunkte;
    }

    /**
     * Gibt die vom Computer gewählte Zahl zurück.
     *
     * @return Die aktuelle Computerzahl
     */
    public int getComputerZahl() {
        return computerZahl;
    }

    /**
     * Gibt das Ergebnis der letzten Runde zurück.
     *
     * @return Die in der letzten Runde erhaltenen Punkte
     */
    public int getRundenErgebnis() {
        return rundenErgebnis;
    }

    /**
     * Generiert eine zufällige Zahl zwischen 1 und 9
     * und speichert diese als Computerzahl.
     */
    public void berechneComputerZahl() {
        Random rand = new Random();
        computerZahl = rand.nextInt(9) + 1;
    }

    /**
     * Berechnet das Ergebnis der aktuellen Runde.
     * Bei gleicher Zahl erhält der Spieler 20 Punkte.
     * Bei einer Abweichung von genau 1 erhält der Spieler 5 Punkte.
     * In allen anderen Fällen verliert der Spieler 10 Punkte.
     * Das Rundenergebnis wird anschließend zur Gesamtpunktzahl addiert.
     */
    public void berechneRunde() {
        int punktenBekommen;

        if (spielerZahl == computerZahl) {
            punktenBekommen = 20;
        } else if (spielerZahl + 1 == computerZahl || spielerZahl - 1 == computerZahl) {
            punktenBekommen = 5;
        } else {
            punktenBekommen = -10;
        }

        rundenErgebnis = punktenBekommen;
        gesamtPunkte = gesamtPunkte + rundenErgebnis;
    }

    /**
     * Prüft, ob der Spieler das Spiel gewonnen hat.
     *
     * @return true, wenn die Gesamtpunktzahl mindestens 100 beträgt,
     *         sonst false
     */
    public boolean hatGewonnen() {
        return gesamtPunkte >= 100;
    }

    /**
     * Prüft, ob der Spieler das Spiel verloren hat.
     *
     * @return true, wenn die Gesamtpunktzahl 0 oder weniger beträgt,
     *         sonst false
     */
    public boolean hatVerloren() {
        return gesamtPunkte <= 0;
    }
}
