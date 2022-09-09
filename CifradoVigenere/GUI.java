import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class GUI {
    
    JFrame ventana = new JFrame();
    JPanel panel = new JPanel();
    JTextArea txPlane = new JTextArea();
    JTextArea txEncript = new JTextArea();
    JButton btnImportPlane = new JButton();
    JButton btnImportEncript = new JButton();
    JButton btnSavePlane = new JButton();
    JButton btnSaveEncript = new JButton();
    JButton btnEncript = new JButton();
    JButton btnDesencript = new JButton();
    JLabel lblTitle = new JLabel();
    JLabel lblPlane = new JLabel();
    JLabel lblEncript = new JLabel();
    Controller driver = new Controller();

    public GUI() {
        initFrame();
        initPanel();
        initTextBox();
        initButtons();
        initLabels();
        eventos();

        addComponents();
    }

    private void initFrame() {
        ventana.setTitle("Cifrado Vigenere");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(1000, 600);
        ventana.setLocationRelativeTo(null);
        ventana.setResizable(false);

        ventana.setVisible(true);
    }

    private void initPanel() {
        panel.setLayout(null);
    }

    private void initTextBox() {
        txPlane.setBounds(100, 150, 300, 300);
        txPlane.setBackground(Color.white);
        txPlane.setLineWrap(true);
        txPlane.setWrapStyleWord(true);
        txPlane.setFont(new Font("Monospace", Font.PLAIN, 16));

        txEncript.setBounds(600, 150, 300, 300);
        txEncript.setBackground(Color.white);
        txEncript.setLineWrap(true);
        txEncript.setWrapStyleWord(true);
        txEncript.setFont(new Font("Monospace", Font.PLAIN, 16));
    }

    private void initButtons() {
        btnEncript.setText("\u2192");
        btnEncript.setFont(new Font("Arial", Font.BOLD, 18));
        btnEncript.setBounds(450, 250, 100, 50);

        btnDesencript.setText("\u2190");
        btnDesencript.setFont(new Font("Arial", Font.BOLD, 24));
        btnDesencript.setBounds(450, 350, 100, 50);

        btnImportPlane.setText("Importar");
        btnImportPlane.setBounds(120, 480, 120, 30);

        btnSavePlane.setText("Guardar");
        btnSavePlane.setBounds(260, 480, 120, 30);

        btnImportEncript.setText("Importar");
        btnImportEncript.setBounds(620, 480, 120, 30);

        btnSaveEncript.setText("Guardar");
        btnSaveEncript.setBounds(760, 480, 120, 30);
    }

    private void initLabels() {
        lblTitle.setText("Cifrado Vigenere");
        lblTitle.setFont(new Font("Times New Roman", Font.BOLD, 36));
        lblTitle.setBounds(100, 10, 800, 100);
        lblTitle.setHorizontalAlignment(JLabel.CENTER);

        lblPlane.setText("Texto plano");
        lblPlane.setFont(new Font("Arial", Font.PLAIN, 18));
        lblPlane.setBounds(100, 100, 300, 50);
        lblPlane.setHorizontalAlignment(JLabel.CENTER);

        lblEncript.setText("Cifrado Vigenere");
        lblEncript.setFont(new Font("Arial", Font.PLAIN, 18));
        lblEncript.setBounds(600, 100, 300, 50);
        lblEncript.setHorizontalAlignment(JLabel.CENTER);
    }

    private void addComponents() {
        panel.add(txPlane);
        panel.add(txEncript);
        panel.add(btnEncript);
        panel.add(btnDesencript);
        panel.add(btnImportPlane);
        panel.add(btnImportEncript);
        panel.add(btnSavePlane);
        panel.add(btnSaveEncript);
        panel.add(lblTitle);
        panel.add(lblPlane);
        panel.add(lblEncript);
        
        ventana.add(panel);
    }

    // Eventos
    // importar texto plano
    public void eventos() {
        btnImportPlane.addActionListener((ActionEvent e) -> {
            txPlane.setText(driver.openFileTextPlain());
        });
        
        btnImportEncript.addActionListener((ActionEvent e) -> {
            txEncript.setText(driver.openFileCifrado());
        });
        
        btnSavePlane.addActionListener((ActionEvent e) -> {
            driver.guardarPlano(txPlane.getText());
        });
        
        btnSaveEncript.addActionListener((ActionEvent e) -> {
            driver.guardarEncriptado(txEncript.getText());
        });
        
        btnEncript.addActionListener((ActionEvent e) -> {
            txEncript.setText(driver.cifrarTexto(txPlane.getText()));
        });
        
        btnDesencript.addActionListener((ActionEvent e) -> {
            txPlane.setText(driver.decifrarTexto(txEncript.getText()));
        });
    }

    public static void main(String[] args) {
        new GUI();
    }
}
