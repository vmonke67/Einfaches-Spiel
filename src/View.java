import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * View
 *
 * @author Monke Vladyslav
 */
public class View extends JFrame {

    private final JLabel lblRundenErgebnis;
    private final JLabel lblGesamtpunkte;

    private final JTextField txtSpielerZahl;
    private final JTextField txtComputerZahl;

    private final JButton btnNochEinmal;

    /**
     * Erstellt das Hauptfenster der Anwendung und initialisiert
     * alle grafischen Komponenten.
     */
    public View() {
        setTitle("Zahlen-Gewinnspiel (v1.0)");
        setSize(900, 530);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Hauptpanel
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(new EmptyBorder(5, 5, 15, 5));
        mainPanel.setBackground(new Color(238, 238, 238));

        JPanel statusPanel = new JPanel(new GridLayout(2, 2, 10, 0));
        statusPanel.setBackground(new Color(238, 238, 238));

        JLabel lblRundenTitel = new JLabel("Rundenergebnis:", SwingConstants.CENTER);
        JLabel lblGesamtTitel = new JLabel("Gesamtpunkte:", SwingConstants.CENTER);

        lblRundenTitel.setFont(new Font("Arial", Font.PLAIN, 28));
        lblGesamtTitel.setFont(new Font("Arial", Font.PLAIN, 28));

        lblRundenErgebnis = new JLabel(
                "Tippe eine Zahl von 1 bis 9",
                SwingConstants.CENTER
        );

        lblGesamtpunkte = new JLabel(
                "Gesamtpunkte: 30",
                SwingConstants.CENTER
        );

        lblRundenErgebnis.setFont(new Font("Arial", Font.BOLD, 30));
        lblGesamtpunkte.setFont(new Font("Arial", Font.BOLD, 30));

        // Immer weiß
        lblRundenErgebnis.setOpaque(true);
        lblRundenErgebnis.setBackground(Color.WHITE);

        lblGesamtpunkte.setOpaque(true);
        lblGesamtpunkte.setBackground(Color.WHITE);

        statusPanel.add(lblRundenTitel);
        statusPanel.add(lblGesamtTitel);
        statusPanel.add(lblRundenErgebnis);
        statusPanel.add(lblGesamtpunkte);

        mainPanel.add(statusPanel, BorderLayout.NORTH);

        JPanel gamePanel = new JPanel(new GridLayout(2, 2, 20, 10));
        gamePanel.setBackground(new Color(238, 238, 238));

        JLabel lblDeineZahl = new JLabel("Deine Zahl:", SwingConstants.CENTER);
        JLabel lblComputer = new JLabel("Computer:", SwingConstants.CENTER);

        lblDeineZahl.setFont(new Font("Arial", Font.PLAIN, 28));
        lblComputer.setFont(new Font("Arial", Font.PLAIN, 28));

        gamePanel.add(lblDeineZahl);
        gamePanel.add(lblComputer);

        // Eingabefeld
        txtSpielerZahl = new JTextField();
        txtSpielerZahl.setFont(new Font("Arial", Font.PLAIN, 38));
        txtSpielerZahl.setHorizontalAlignment(JTextField.CENTER);
        txtSpielerZahl.setBackground(Color.WHITE);

        // Computer-Feld
        txtComputerZahl = new JTextField();
        txtComputerZahl.setFont(new Font("Arial", Font.PLAIN, 38));
        txtComputerZahl.setHorizontalAlignment(JTextField.CENTER);
        txtComputerZahl.setBackground(Color.WHITE);
        txtComputerZahl.setEditable(false);

        gamePanel.add(txtSpielerZahl);
        gamePanel.add(txtComputerZahl);

        mainPanel.add(gamePanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setBackground(new Color(238, 238, 238));

        btnNochEinmal = new JButton("Noch einmal!");
        btnNochEinmal.setFont(new Font("Arial", Font.PLAIN, 26));
        btnNochEinmal.setPreferredSize(new Dimension(230, 50));
        btnNochEinmal.setEnabled(false);

        buttonPanel.add(btnNochEinmal);

        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        setContentPane(mainPanel);

        getRootPane().setDefaultButton(null);

        setVisible(true);
    }

    /**
     * Gibt das Eingabefeld für die Zahl des Spielers zurück.
     *
     * @return Das Textfeld für die Eingabe des Spielers
     */
    public JTextField getTxtSpielerZahl() {
        return txtSpielerZahl;
    }

    /**
     * Gibt das Textfeld mit der Zahl des Computers zurück.
     *
     * @return Das Textfeld für die Computerzahl
     */
    public JTextField getTxtComputerZahl() {
        return txtComputerZahl;
    }

    /**
     * Gibt das Label für das Ergebnis der aktuellen Runde zurück.
     *
     * @return Das Label mit dem Rundenergebnis
     */
    public JLabel getLblRundenErgebnis() {
        return lblRundenErgebnis;
    }

    /**
     * Gibt das Label mit der Gesamtpunktzahl zurück.
     *
     * @return Das Label mit den Gesamtpunkten
     */
    public JLabel getLblGesamtpunkte() {
        return lblGesamtpunkte;
    }

    /**
     * Gibt den Button zum Starten einer weiteren Runde zurück.
     *
     * @return Der Button "Noch einmal!"
     */
    public JButton getBtnNochEinmal() {
        return btnNochEinmal;
    }

    /**
     * Fügt einen Listener für die Eingabe der Spielerzahl hinzu.
     *
     * @param listener Der ActionListener, der bei einer Eingabe ausgelöst wird
     */
    public void addSpielerZahlListener(ActionListener listener) {
        txtSpielerZahl.addActionListener(listener);
    }

    /**
     * Fügt einen Listener für den Button "Noch einmal!" hinzu.
     *
     * @param listener Der ActionListener, der beim Klicken des Buttons ausgelöst wird
     */
    public void addNochEinmalListener(ActionListener listener) {
        btnNochEinmal.addActionListener(listener);
    }

    /**
     * Setzt die vom Computer generierte Zahl in das entsprechende Textfeld.
     *
     * @param zahl Die vom Computer gewählte Zahl
     */
    public void setComputerZahl(int zahl) {
        txtComputerZahl.setText(String.valueOf(zahl));
    }

    /**
     * Setzt das Ergebnis der aktuellen Runde.
     * Positive Werte werden mit einem Pluszeichen angezeigt.
     *
     * @param ergebnis Die in der aktuellen Runde erreichten Punkte
     */
    public void setRundenErgebnis(int ergebnis) {
        if (ergebnis > 0) {
            lblRundenErgebnis.setText("+" + ergebnis);
        } else {
            lblRundenErgebnis.setText(String.valueOf(ergebnis));
        }
    }

    /**
     * Setzt das Rundenergebnis direkt als Text.
     *
     * @param ergebnis Das anzuzeigende Rundenergebnis
     */
    public void setRundenErgebnis(String ergebnis) {
        lblRundenErgebnis.setText(ergebnis);
    }

    /**
     * Setzt die aktuelle Gesamtpunktzahl des Spielers.
     *
     * @param punkte Die aktuelle Gesamtpunktzahl
     */
    public void setGesamtpunkte(int punkte) {
        lblGesamtpunkte.setText("Gesamtpunkte: " + punkte);
    }

    /**
     * Leert alle Eingabefelder und setzt das Rundenergebnis zurück.
     */
    public void clearRunde() {
        txtSpielerZahl.setText("");
        txtComputerZahl.setText("");
        lblRundenErgebnis.setText("");
    }
}