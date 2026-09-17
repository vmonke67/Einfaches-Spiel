public class Controller {
    public static void main(String[] args) {
        GewinnModel gewinnModel = new GewinnModel();
//        int spielerZahl = view.getZahl();
//        gewinnModel.setSpielerZahl(spielerZahl);
        gewinnModel.berechneComputerZahl();
        gewinnModel.berechneRunde();

        if (gewinnModel.hatGewonnen()) {
            // view set win screen
        } else if (gewinnModel.hatVerloren()) {
            // view set lose screen
        } else {
            // view update screen
        }
    }
}