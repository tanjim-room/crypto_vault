// crypto.java
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.ColorUIResource;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class crypto {

    private static final String ENCRYPTION_DIR = "encryption_storage/";
    private static final String DECRYPTION_DIR = "decryption_storage/";

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                createAndShowGUI();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        new File(ENCRYPTION_DIR).mkdirs();
        new File(DECRYPTION_DIR).mkdirs();
    }

    public static void createAndShowGUI() throws FontFormatException, IOException {

        JFrame frame = new JFrame("CRyPt0_VaULt");
        frame.setSize(400, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        Image top_icon = Toolkit.getDefaultToolkit().getImage("CVL.jpg");
        frame.setIconImage(top_icon);

        CardLayout cl = new CardLayout();
        JPanel container = new JPanel(cl);

        Font btnFont = new Font("SansSerif", Font.PLAIN, 16);
        Font btnFont2 = Font.createFont(Font.TRUETYPE_FONT, new File("scripto/crypteo-Regular.otf")).deriveFont(18f);
        GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(btnFont2);
        Font titleFont2 = Font.createFont(Font.TRUETYPE_FONT, new File("scripto/crypteo-Regular.otf")).deriveFont(36f);
        GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(titleFont2);

        ImageIcon icon = null;
        try {
            BufferedImage originalImage = ImageIO.read(new File("Security Shield Logo.png"));
            Image scaledImage = originalImage.getScaledInstance(300, 300, Image.SCALE_SMOOTH);
            icon = new ImageIcon(scaledImage);
        } catch (IOException e) {
            e.printStackTrace();
        }

        JPanel welcome = new JPanel();
        welcome.setLayout(new BoxLayout(welcome, BoxLayout.Y_AXIS));
        welcome.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel imageLabel = new JLabel(icon);
        imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel welcomeButtons = new JPanel(new GridLayout(2, 1, 10, 10));
        JButton toRegister = new JButton("Register");
        JButton toLogin = new JButton("Login");

        toRegister.setFont(btnFont2);
        toRegister.setBackground(Color.decode("#1D3353"));
        toRegister.setForeground(Color.WHITE);

        toLogin.setFont(btnFont2);
        toLogin.setBackground(Color.decode("#1D3353"));
        toLogin.setForeground(Color.WHITE);

        welcomeButtons.add(toRegister);
        welcomeButtons.add(toLogin);
        welcomeButtons.setMaximumSize(new Dimension(200, 100));
        welcomeButtons.setAlignmentX(Component.CENTER_ALIGNMENT);

        welcome.add(imageLabel);
        welcome.add(Box.createRigidArea(new Dimension(0, 10)));
        welcome.add(welcomeButtons);
        JPanel dummy = new JPanel();
        dummy.setFocusable(true);
        frame.add(dummy);
        dummy.requestFocusInWindow();

        // Registration Panel
        JPanel register = new JPanel(new BorderLayout());
        JLabel titleRegister = new JLabel("CRyPt0_VaULt", SwingConstants.CENTER);
        titleRegister.setBorder(new EmptyBorder(50, 20, 0, 20));
        titleRegister.setFont(titleFont2);
        register.add(titleRegister, BorderLayout.NORTH);

        JPanel regForm = new JPanel(new GridLayout(5, 1, 10, 20));
        regForm.setBorder(BorderFactory.createEmptyBorder(100, 50, 100, 50));

        JTextField regEmail = new JTextField();
        JPasswordField regPwd = new JPasswordField();
        JButton regBtn = new JButton("Register");
        regBtn.setFocusable(false);


        JButton regBack = new JButton("Back");

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setFont(btnFont2);
        JLabel passwordLabel = new JLabel("New Password:");
        passwordLabel.setFont(btnFont2);

        regBtn.setBackground(Color.decode("#1D3353"));
        regBtn.setForeground(Color.WHITE);
        regBtn.setFont(btnFont2);
        regBack.setBackground(Color.decode("#1D3353"));
        regBack.setForeground(Color.WHITE);
        regBack.setFont(btnFont2);

        regForm.add(emailLabel);
        regForm.add(regEmail);
        regForm.add(passwordLabel);
        regForm.add(regPwd);
        regForm.add(regBtn);

        JPanel regControls = new JPanel(new BorderLayout());
        regControls.add(regForm, BorderLayout.CENTER);
        //regControls.add(regBtn, BorderLayout.CENTER);

        JPanel regBottom = new JPanel(new BorderLayout());
        regBottom.add(regControls, BorderLayout.CENTER);
        regBottom.add(regBack, BorderLayout.SOUTH);
        register.add(regBottom, BorderLayout.CENTER);

        
        // Login Panel
        JPanel login = new JPanel(new BorderLayout());
        JLabel titleLogin = new JLabel("CRyPt0_VaULt", SwingConstants.CENTER);
        titleLogin.setBorder(new EmptyBorder(50, 20, 0, 20));
        titleLogin.setFont(titleFont2);
        login.add(titleLogin, BorderLayout.NORTH);

        JPanel logForm = new JPanel(new GridLayout(5, 1, 10, 20));
        logForm.setBorder(BorderFactory.createEmptyBorder(100, 50, 100, 50));
        JTextField logEmail = new JTextField();
        JPasswordField logPwd = new JPasswordField();
        JButton logBtn = new JButton("Login");
        JButton logBack = new JButton("Back");

        JLabel emailLabel2 = new JLabel("Email:");
        emailLabel2.setFont(btnFont2);
        JLabel passwordLabel2 = new JLabel("Password:");
        passwordLabel2.setFont(btnFont2);

        logBtn.setBackground(Color.decode("#1D3353"));
        logBtn.setForeground(Color.WHITE);
        logBtn.setFont(btnFont2);
        logBack.setBackground(Color.decode("#1D3353"));
        logBack.setForeground(Color.WHITE);
        logBack.setFont(btnFont2);

        logForm.add(emailLabel2);
        logForm.add(logEmail);
        logForm.add(passwordLabel2);
        logForm.add(logPwd);
        logForm.add(logBtn);


        JPanel logControls = new JPanel(new BorderLayout());
        logControls.add(logForm, BorderLayout.CENTER);
        //logControls.add(logBtn, BorderLayout.SOUTH);

        JPanel logBottom = new JPanel(new BorderLayout());
        logBottom.add(logControls, BorderLayout.CENTER);
        logBottom.add(logBack, BorderLayout.SOUTH);
        login.add(logBottom, BorderLayout.CENTER);

        // Main Panel
        JPanel main = new JPanel(new BorderLayout());
        JPanel mainPanel = new JPanel(new GridLayout(6, 1, 10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
        JTextField keyField = new JTextField();
        keyField.setFont(btnFont2);

        JButton encBtn = new JButton("Encrypt File");
        JButton decBtn = new JButton("Decrypt File");
        JButton storeBtn = new JButton("View Storage");
        JButton mainBack = new JButton("Logout");

        encBtn.setFont(btnFont2);
        encBtn.setBackground(Color.decode("#1D3353"));
        encBtn.setForeground(Color.WHITE);
        decBtn.setFont(btnFont2);
        decBtn.setBackground(Color.decode("#1D3353"));
        decBtn.setForeground(Color.WHITE);
        storeBtn.setFont(btnFont2);
        storeBtn.setBackground(Color.decode("#1D3353"));
        storeBtn.setForeground(Color.WHITE);
        mainBack.setFont(btnFont2);
        mainBack.setBackground(Color.decode("#1D3353"));
        mainBack.setForeground(Color.WHITE);

        JLabel keyLabel = new JLabel("Enter 16‑char AES Key:");
        keyLabel.setFont(btnFont2);
        mainPanel.add(keyLabel);
        mainPanel.add(keyField);
        mainPanel.add(encBtn);
        mainPanel.add(decBtn);
        mainPanel.add(storeBtn);
        mainPanel.add(mainBack);
        main.add(mainPanel, BorderLayout.CENTER);

        // Add all cards
        container.add(welcome, "welcome");
        container.add(register, "register");
        container.add(login, "login");
        container.add(main, "main");
        frame.add(container);

        // Navigation
        toRegister.addActionListener(e -> cl.show(container, "register"));
        toLogin.addActionListener(e -> cl.show(container, "login"));
        regBack.addActionListener(e -> cl.show(container, "welcome"));
        logBack.addActionListener(e -> cl.show(container, "welcome"));
        mainBack.addActionListener(e -> cl.show(container, "welcome"));

        // Register
        regBtn.addActionListener(e -> {
            String email = regEmail.getText();
            String password = new String(regPwd.getPassword());
            if (email.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Email and password required.");
                return;
            }
            try {
                if (User.register(email, password)) {
                    JOptionPane.showMessageDialog(frame, "Registration successful.");
                    cl.show(container, "welcome");
                } else {
                    JOptionPane.showMessageDialog(frame, "Email already exists.");
                }
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(frame, "Error: " + ex.getMessage());
            }
        });

        // Login
        logBtn.addActionListener(e -> {
            String email = logEmail.getText();
            String password = new String(logPwd.getPassword());
            if (email.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Email and password required.");
                return;
            }
            try {
                if (User.login(email, password)) {
                    JOptionPane.showMessageDialog(frame, "Login successful!");
                    cl.show(container, "main");
                } else {
                    JOptionPane.showMessageDialog(frame, "Invalid email or password.");
                }
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(frame, "Error: " + ex.getMessage());
            }
        });

        // Encryption & Decryption
        encBtn.addActionListener(e -> {
            JFileChooser fc = new JFileChooser();
            if (fc.showOpenDialog(frame) == JFileChooser.APPROVE_OPTION) {
                String key = keyField.getText();
                if (key.length() != 16) {
                    JOptionPane.showMessageDialog(frame, "Key must be 16 characters.");
                    return;
                }
                try {
                    File in = fc.getSelectedFile();
                    File out = new File(ENCRYPTION_DIR + in.getName() + ".enc");
                    AES.encryptFile(in.getAbsolutePath(), out.getAbsolutePath(), key);
                    JOptionPane.showMessageDialog(frame, "Encrypted → " + out.getPath());
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(frame, "Error: " + ex.getMessage());
                }
            }
        });

        decBtn.addActionListener(e -> {
            JFileChooser fc = new JFileChooser();
            if (fc.showOpenDialog(frame) == JFileChooser.APPROVE_OPTION) {
                String key = keyField.getText();
                if (key.length() != 16) {
                    JOptionPane.showMessageDialog(frame, "Key must be 16 characters.");
                    return;
                }
                try {
                    File in = fc.getSelectedFile();
                    String base = in.getName().replaceFirst("\\.enc$", "");
                    File out = new File(DECRYPTION_DIR + base + ".dec");
                    AES.decryptFile(in.getAbsolutePath(), out.getAbsolutePath(), key);
                    JOptionPane.showMessageDialog(frame, "Decrypted → " + out.getPath());
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(frame, "Error: " + ex.getMessage());
                }
            }
        });

        storeBtn.addActionListener(e -> openStorageViewer(frame));

        cl.show(container, "welcome");
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private static void openStorageViewer(JFrame owner) {
        JDialog dlg = new JDialog(owner, "Storage Viewer", false);
        dlg.setSize(460, 360);
        dlg.setLayout(new BorderLayout());

        JTabbedPane tabs = new JTabbedPane();
        tabs.add("Encrypted", makeTabPanel(ENCRYPTION_DIR, dlg));
        tabs.add("Decrypted", makeTabPanel(DECRYPTION_DIR, dlg));
        dlg.add(tabs, BorderLayout.CENTER);

        JButton close = new JButton("Close");
        close.setBackground(Color.decode("#1D3353"));
        close.setForeground(Color.WHITE);
        close.addActionListener(ev -> dlg.dispose());
        dlg.add(close, BorderLayout.SOUTH);

        dlg.setLocationRelativeTo(owner);
        dlg.setVisible(true);
    }

    private static JPanel makeTabPanel(String dirPath, JDialog parent) {
        DefaultListModel<String> model = new DefaultListModel<>();
        File dir = new File(dirPath);
        if (dir.exists()) {
            for (File f : dir.listFiles()) model.addElement(f.getName());
        }
        JList<String> list = new JList<>(model);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        Runnable openSelected = () -> {
            int i = list.getSelectedIndex();
            if (i >= 0) {
                try {
                    Desktop.getDesktop().open(new File(dir, model.get(i)));
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(parent, "Cannot open file: " + ex.getMessage());
                }
            }
        };

        list.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) openSelected.run();
            }
        });

        list.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) openSelected.run();
            }
        });

        JButton openFolder = new JButton("📂 Open Folder");
        openFolder.setBackground(Color.decode("#1D3353"));
        openFolder.setForeground(Color.WHITE);
        openFolder.addActionListener(ev -> {
            try {
                Desktop.getDesktop().open(dir);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(parent, "Cannot open folder: " + ex.getMessage());
            }
        });

        JPanel p = new JPanel(new BorderLayout());
        p.add(new JScrollPane(list), BorderLayout.CENTER);
        p.add(openFolder, BorderLayout.SOUTH);
        return p;
    }
}
