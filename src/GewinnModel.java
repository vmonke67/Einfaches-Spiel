import java.util.Random;

public class GewinnModel {
    private int gesamtPunkte;
    private int spielerZahl;
    private int computerZahl;
    private int rundenErgebnis;

    public GewinnModel() {
        gesamtPunkte = 30;
        spielerZahl = 0;
        computerZahl = 0;
        rundenErgebnis = 0;
    }

    public void setSpielerZahl(int spielerZahl) {
        this.spielerZahl = spielerZahl;
    }

    public int getGesamtPunkte() {
        return gesamtPunkte;
    }

    public int getComputerZahl() {
        return computerZahl;
    }

    public int getRundenErgebnis() {
        return rundenErgebnis;
    }

    public void ComputerZahl() {
        Random rand = new Random();
        computerZahl = rand.nextInt(9) + 1;
    }

    public void berechneRunde() {
        int punktenBekommen;
        if (spielerZahl == computerZahl) {
            punktenBekommen = 20;
        } else  if (spielerZahl + 1 == computerZahl || spielerZahl -1 == computerZahl) {
            punktenBekommen = 5;
        } else {
            punktenBekommen = -10;
        }
        rundenErgebnis = punktenBekommen;
        gesamtPunkte = rundenErgebnis;
    }

    public boolean hatGewonnen() {
        return gesamtPunkte >= 100;
    }

    public boolean hatVerloren() {
        return gesamtPunkte <= 0;
    }
}
