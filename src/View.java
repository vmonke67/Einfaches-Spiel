import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class View extends JFrame {

    private final JLabel lblRundenErgebnis;
    private final JLabel lblGesamtpunkte;

    private final JTextField txtSpielerZahl;
    private final JTextField txtComputerZahl;

    private final JButton btnNochEinmal;

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

    // getters
    public JTextField getTxtSpielerZahl() {
        return txtSpielerZahl;
    }

    public JTextField getTxtComputerZahl() {
        return txtComputerZahl;
    }

    public JLabel getLblRundenErgebnis() {
        return lblRundenErgebnis;
    }

    public JLabel getLblGesamtpunkte() {
        return lblGesamtpunkte;
    }

    public JButton getBtnNochEinmal() {
        return btnNochEinmal;
    }

    // listeners
    public void addSpielerZahlListener(ActionListener listener) {
        txtSpielerZahl.addActionListener(listener);
    }

    public void addNochEinmalListener(ActionListener listener) {
        btnNochEinmal.addActionListener(listener);
    }

    // setters
    public void setComputerZahl(int zahl) {
        txtComputerZahl.setText(String.valueOf(zahl));
    }

    public void setRundenErgebnis(int ergebnis) {
        if (ergebnis > 0) {
            lblRundenErgebnis.setText("+" + ergebnis);
        } else {
            lblRundenErgebnis.setText(String.valueOf(ergebnis));
        }
    }

    public void setRundenErgebnis(String ergebnis) {
        lblRundenErgebnis.setText(ergebnis);
    }

    public void setGesamtpunkte(int punkte) {
        lblGesamtpunkte.setText("Gesamtpunkte: " + punkte);
    }

    public void clearRunde() {
        txtSpielerZahl.setText("");
        txtComputerZahl.setText("");
        lblRundenErgebnis.setText("");
    }
}