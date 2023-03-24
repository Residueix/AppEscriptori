package residueix.residueixapp;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;
import residueix.residueixapp.models.Usuari;
import residueix.residueixapp.utils.Api;

/**
 * Classe per obrir la pantalla per donar d'alta un usuari
 * @author Daniel Garcia Ruiz
 * @version 12/03/2023
 */
public class PantallaAltaUsuari extends javax.swing.JFrame {
    
    
    // Atributs
    /**
     * Uusari loginat.
    */
    private static Usuari usuari;
    /**
     * Posició x del ratolí.
     */
    private int xMouse;
    /**
     * Posició y del ratolí.
     */
    private int yMouse;  
    /**
     * Utils API.java
     */
    private Api api;
    /**
     * Llistat de tipus d'usuari.
     */
    private ArrayList<String[]> llistatTipus = new ArrayList<String[]>();
    /**
     * Llistat de tipus d'usuari.
     */
    private ArrayList<String[]> llistatPoblacions = new ArrayList<String[]>();    
    /**
     * Llistat de tipus d'usuari.
     */
    private ArrayList<String[]> llistatTipusAdherit = new ArrayList<String[]>();
    
    /**
     * Crea una nova instància de la classe PantallaPrincipal.
     * @param usuari: Usuari loginat a l'aplicació.
     */
    public PantallaAltaUsuari(Usuari usuari) {
        // Utilitats api
        api = new Api();
        // Assignació de l'usuari
        this.usuari = usuari;
        // Inicialització dels components
        initComponents();
        // Centrem pantalla
        centrarPantalla();
        // Accions en funcio de l'usuari
        gestioUsuari();
        // Càrrega inicial del formulari.
        carregaFormulari();
    }

     /**
     * Mètode critad per el constructor per inicialitzar el formulari.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelPrincipal = new javax.swing.JPanel();
        panelContingut = new javax.swing.JPanel();
        panelBar = new javax.swing.JPanel();
        labelUsuari = new javax.swing.JLabel();
        panelTitol = new javax.swing.JPanel();
        labelTitol = new javax.swing.JLabel();
        separadorUsuari = new javax.swing.JSeparator();
        labelPoblacio = new javax.swing.JLabel();
        labelPassword = new javax.swing.JLabel();
        labelTipus = new javax.swing.JLabel();
        labelNom = new javax.swing.JLabel();
        labelCognom1 = new javax.swing.JLabel();
        labelCognom2 = new javax.swing.JLabel();
        labelTelefon = new javax.swing.JLabel();
        labelActiu = new javax.swing.JLabel();
        separadorAdresa = new javax.swing.JSeparator();
        labelTitolDades = new javax.swing.JLabel();
        textFieldCognom2 = new javax.swing.JTextField();
        textFieldEmail = new javax.swing.JTextField();
        textFieldCP = new javax.swing.JTextField();
        textFieldCognom1 = new javax.swing.JTextField();
        passwordFieldPassword = new javax.swing.JPasswordField();
        comboBoxPoblacio = new javax.swing.JComboBox<>();
        textFieldNom = new javax.swing.JTextField();
        checkBoxActiu = new javax.swing.JCheckBox();
        labelEmail1 = new javax.swing.JLabel();
        labelNomAdherit = new javax.swing.JLabel();
        labelCP = new javax.swing.JLabel();
        textFieldNomAdherit = new javax.swing.JTextField();
        comboBoxTipusUsuari = new javax.swing.JComboBox<>();
        textFieldTelefon = new javax.swing.JTextField();
        labelTitolAdherit = new javax.swing.JLabel();
        separadorAdherit = new javax.swing.JSeparator();
        labelCarrer = new javax.swing.JLabel();
        textFieldCarrer = new javax.swing.JTextField();
        labelHoraris = new javax.swing.JLabel();
        textFieldHoraris = new javax.swing.JTextField();
        labelTipusAdherit = new javax.swing.JLabel();
        comboBoxTipusAdherit = new javax.swing.JComboBox<>();
        buttonAlta = new javax.swing.JButton();
        labelTitolAdresa = new javax.swing.JLabel();
        panelOpcions = new javax.swing.JPanel();
        buttonLogOut = new javax.swing.JButton();
        buttonTornar = new javax.swing.JButton();
        labelPrincipal = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setLocation(new java.awt.Point(0, 0));
        setMinimumSize(new java.awt.Dimension(200, 100));
        setName("framePrincipal"); // NOI18N
        setUndecorated(true);
        setResizable(false);
        setSize(new java.awt.Dimension(1000, 750));
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelPrincipal.setBackground(new java.awt.Color(255, 255, 255));
        panelPrincipal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 2));
        panelPrincipal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelContingut.setOpaque(false);
        panelContingut.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelBar.setOpaque(false);

        labelUsuari.setFont(new java.awt.Font("Sansation", 0, 12)); // NOI18N
        labelUsuari.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelUsuari.setPreferredSize(new java.awt.Dimension(600, 30));
        panelBar.add(labelUsuari);

        panelContingut.add(panelBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 50));

        panelTitol.setOpaque(false);
        panelTitol.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelTitol.setFont(new java.awt.Font("Sansation", 1, 14)); // NOI18N
        labelTitol.setText("Alta Usuari");
        labelTitol.setToolTipText("");
        panelTitol.add(labelTitol, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 600, 30));

        panelContingut.add(panelTitol, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 51, 800, 50));
        panelContingut.add(separadorUsuari, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 730, 10));

        labelPoblacio.setFont(new java.awt.Font("Sansation", 0, 14)); // NOI18N
        labelPoblacio.setText("Població");
        panelContingut.add(labelPoblacio, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 430, 100, 30));

        labelPassword.setFont(new java.awt.Font("Sansation", 0, 14)); // NOI18N
        labelPassword.setText("Password");
        panelContingut.add(labelPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 100, 30));

        labelTipus.setFont(new java.awt.Font("Sansation", 0, 14)); // NOI18N
        labelTipus.setText("Tipus");
        panelContingut.add(labelTipus, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 160, 100, 30));

        labelNom.setFont(new java.awt.Font("Sansation", 0, 14)); // NOI18N
        labelNom.setText("Nom");
        panelContingut.add(labelNom, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 100, 30));

        labelCognom1.setFont(new java.awt.Font("Sansation", 0, 14)); // NOI18N
        labelCognom1.setText("Cognom 1");
        panelContingut.add(labelCognom1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 240, 100, 30));

        labelCognom2.setFont(new java.awt.Font("Sansation", 0, 14)); // NOI18N
        labelCognom2.setText("Cognom 2");
        labelCognom2.setToolTipText("");
        panelContingut.add(labelCognom2, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 240, 100, 30));

        labelTelefon.setFont(new java.awt.Font("Sansation", 0, 14)); // NOI18N
        labelTelefon.setText("Telèfon");
        labelTelefon.setToolTipText("");
        panelContingut.add(labelTelefon, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 100, 30));

        labelActiu.setFont(new java.awt.Font("Sansation", 0, 14)); // NOI18N
        labelActiu.setText("Actiu");
        labelActiu.setToolTipText("");
        panelContingut.add(labelActiu, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 290, 50, 30));
        panelContingut.add(separadorAdresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, 730, 10));

        labelTitolDades.setFont(new java.awt.Font("Sansation", 0, 14)); // NOI18N
        labelTitolDades.setForeground(new java.awt.Color(153, 153, 153));
        labelTitolDades.setText("Dades de l'usuari");
        panelContingut.add(labelTitolDades, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, -1));

        textFieldCognom2.setFont(new java.awt.Font("Sansation", 0, 14)); // NOI18N
        textFieldCognom2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        textFieldCognom2.setToolTipText("Cognom 2 d'usuari");
        textFieldCognom2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        textFieldCognom2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textFieldCognom2KeyTyped(evt);
            }
        });
        panelContingut.add(textFieldCognom2, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 240, 150, 30));

        textFieldEmail.setFont(new java.awt.Font("Sansation", 0, 14)); // NOI18N
        textFieldEmail.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        textFieldEmail.setToolTipText("Email");
        textFieldEmail.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        textFieldEmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textFieldEmailKeyTyped(evt);
            }
        });
        panelContingut.add(textFieldEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 160, 150, 30));

        textFieldCP.setFont(new java.awt.Font("Sansation", 0, 14)); // NOI18N
        textFieldCP.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        textFieldCP.setToolTipText("Codi Postal");
        textFieldCP.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        textFieldCP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textFieldCPKeyTyped(evt);
            }
        });
        panelContingut.add(textFieldCP, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 430, 150, 30));

        textFieldCognom1.setFont(new java.awt.Font("Sansation", 0, 14)); // NOI18N
        textFieldCognom1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        textFieldCognom1.setToolTipText("Cognom 1 d'usuari");
        textFieldCognom1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        textFieldCognom1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textFieldCognom1KeyTyped(evt);
            }
        });
        panelContingut.add(textFieldCognom1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 240, 150, 30));

        passwordFieldPassword.setToolTipText("Password");
        passwordFieldPassword.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        passwordFieldPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                passwordFieldPasswordKeyTyped(evt);
            }
        });
        panelContingut.add(passwordFieldPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 200, 150, 30));

        comboBoxPoblacio.setFont(new java.awt.Font("Sansation", 0, 14)); // NOI18N
        comboBoxPoblacio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tria població" }));
        comboBoxPoblacio.setToolTipText("Població");
        comboBoxPoblacio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panelContingut.add(comboBoxPoblacio, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 430, 310, 30));

        textFieldNom.setFont(new java.awt.Font("Sansation", 0, 14)); // NOI18N
        textFieldNom.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        textFieldNom.setToolTipText("Nom d'usuari");
        textFieldNom.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        textFieldNom.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textFieldNomKeyTyped(evt);
            }
        });
        panelContingut.add(textFieldNom, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 240, 150, 30));

        checkBoxActiu.setFont(new java.awt.Font("Sansation", 0, 14)); // NOI18N
        checkBoxActiu.setToolTipText("Actiu");
        checkBoxActiu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panelContingut.add(checkBoxActiu, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 290, 20, 30));

        labelEmail1.setFont(new java.awt.Font("Sansation", 0, 14)); // NOI18N
        labelEmail1.setText("Email");
        panelContingut.add(labelEmail1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 100, 30));

        labelNomAdherit.setFont(new java.awt.Font("Sansation", 0, 14)); // NOI18N
        labelNomAdherit.setText("Nom Adherit");
        panelContingut.add(labelNomAdherit, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 550, 100, 30));

        labelCP.setFont(new java.awt.Font("Sansation", 0, 14)); // NOI18N
        labelCP.setText("CP");
        panelContingut.add(labelCP, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 430, 100, 30));

        textFieldNomAdherit.setFont(new java.awt.Font("Sansation", 0, 14)); // NOI18N
        textFieldNomAdherit.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        textFieldNomAdherit.setToolTipText("Nom adherit");
        textFieldNomAdherit.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        textFieldNomAdherit.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textFieldNomAdheritKeyTyped(evt);
            }
        });
        panelContingut.add(textFieldNomAdherit, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 550, 630, 30));

        comboBoxTipusUsuari.setFont(new java.awt.Font("Sansation", 0, 14)); // NOI18N
        comboBoxTipusUsuari.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tria tipus" }));
        comboBoxTipusUsuari.setToolTipText("Tipus d'usuari");
        comboBoxTipusUsuari.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        comboBoxTipusUsuari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxTipusUsuariActionPerformed(evt);
            }
        });
        panelContingut.add(comboBoxTipusUsuari, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 160, 150, 30));

        textFieldTelefon.setFont(new java.awt.Font("Sansation", 0, 14)); // NOI18N
        textFieldTelefon.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        textFieldTelefon.setToolTipText("Telèfon d'usuari");
        textFieldTelefon.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        textFieldTelefon.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textFieldTelefonKeyTyped(evt);
            }
        });
        panelContingut.add(textFieldTelefon, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 280, 150, 30));

        labelTitolAdherit.setFont(new java.awt.Font("Sansation", 0, 14)); // NOI18N
        labelTitolAdherit.setForeground(new java.awt.Color(153, 153, 153));
        labelTitolAdherit.setText("Dades Adherit");
        panelContingut.add(labelTitolAdherit, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 500, -1, -1));
        panelContingut.add(separadorAdherit, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 520, 730, 10));

        labelCarrer.setFont(new java.awt.Font("Sansation", 0, 14)); // NOI18N
        labelCarrer.setText("Carrer");
        panelContingut.add(labelCarrer, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, 100, 30));

        textFieldCarrer.setFont(new java.awt.Font("Sansation", 0, 14)); // NOI18N
        textFieldCarrer.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        textFieldCarrer.setToolTipText("Carrer");
        textFieldCarrer.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        textFieldCarrer.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textFieldCarrerKeyTyped(evt);
            }
        });
        panelContingut.add(textFieldCarrer, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 390, 630, 30));

        labelHoraris.setFont(new java.awt.Font("Sansation", 0, 14)); // NOI18N
        labelHoraris.setText("Horaris");
        panelContingut.add(labelHoraris, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 590, 100, 30));

        textFieldHoraris.setFont(new java.awt.Font("Sansation", 0, 14)); // NOI18N
        textFieldHoraris.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        textFieldHoraris.setToolTipText("Horaris");
        textFieldHoraris.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        textFieldHoraris.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textFieldHorarisKeyTyped(evt);
            }
        });
        panelContingut.add(textFieldHoraris, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 590, 630, 30));

        labelTipusAdherit.setFont(new java.awt.Font("Sansation", 0, 14)); // NOI18N
        labelTipusAdherit.setText("Tipus");
        panelContingut.add(labelTipusAdherit, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 630, 100, 30));

        comboBoxTipusAdherit.setFont(new java.awt.Font("Sansation", 0, 14)); // NOI18N
        comboBoxTipusAdherit.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tria tipus adherit" }));
        comboBoxTipusAdherit.setToolTipText("Tipus d'adherit");
        comboBoxTipusAdherit.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panelContingut.add(comboBoxTipusAdherit, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 630, 290, 30));

        buttonAlta.setBackground(new java.awt.Color(51, 204, 0));
        buttonAlta.setFont(new java.awt.Font("Sansation", 1, 14)); // NOI18N
        buttonAlta.setForeground(new java.awt.Color(255, 255, 255));
        buttonAlta.setText("Donar d'Alta");
        buttonAlta.setToolTipText("Donar d'alta l'usuari");
        buttonAlta.setBorderPainted(false);
        buttonAlta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonAlta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAltaActionPerformed(evt);
            }
        });
        panelContingut.add(buttonAlta, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 690, 150, 30));

        labelTitolAdresa.setFont(new java.awt.Font("Sansation", 0, 14)); // NOI18N
        labelTitolAdresa.setForeground(new java.awt.Color(153, 153, 153));
        labelTitolAdresa.setText("Dades de l'adreça (Residuents i adherits)");
        panelContingut.add(labelTitolAdresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, -1, -1));

        panelPrincipal.add(panelContingut, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 2, 798, 746));

        panelOpcions.setBackground(new java.awt.Color(255, 255, 255));
        panelOpcions.setOpaque(false);
        panelOpcions.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        buttonLogOut.setBackground(new java.awt.Color(153, 0, 0));
        buttonLogOut.setFont(new java.awt.Font("Sansation", 1, 14)); // NOI18N
        buttonLogOut.setForeground(new java.awt.Color(255, 255, 255));
        buttonLogOut.setText("Logout");
        buttonLogOut.setToolTipText("Sortir de l'aplicació");
        buttonLogOut.setBorderPainted(false);
        buttonLogOut.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonLogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonLogOutActionPerformed(evt);
            }
        });
        panelOpcions.add(buttonLogOut, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 700, 150, 30));

        buttonTornar.setBackground(new java.awt.Color(255, 204, 0));
        buttonTornar.setFont(new java.awt.Font("Sansation", 1, 14)); // NOI18N
        buttonTornar.setText("Tornar Llistat");
        buttonTornar.setToolTipText("Tornar al llistat d'usuaris");
        buttonTornar.setBorderPainted(false);
        buttonTornar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonTornar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonTornarActionPerformed(evt);
            }
        });
        panelOpcions.add(buttonTornar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 660, 150, 30));

        panelPrincipal.add(panelOpcions, new org.netbeans.lib.awtextra.AbsoluteConstraints(798, 2, 200, 746));

        labelPrincipal.setBackground(new java.awt.Color(255, 255, 255));
        labelPrincipal.setIcon(new javax.swing.ImageIcon("C:\\Users\\isard\\Downloads\\fons_general.png")); // NOI18N
        labelPrincipal.setOpaque(true);
        panelPrincipal.add(labelPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 2, 996, 746));

        getContentPane().add(panelPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 750));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    /**
     * Mètode per carregar dades necesàries del formulari
     */
    private void carregaFormulari(){
       
        String problemes = "no";
        
        // Json array amb els tipus d'usuari per al combobox
        JSONObject jsonTipusUsuaris = api.llistatTipusUsuari(usuari);
        
        if(!jsonTipusUsuaris.isEmpty()){
            if(jsonTipusUsuaris.get("codi_error").toString().equals("0")){
                JSONArray llistatTipusUsuaris = jsonTipusUsuaris.getJSONArray("llistat");
                if(!llistatTipusUsuaris.isEmpty()){
                    for(int i = 0; i < llistatTipusUsuaris.length(); i++){
                        JSONObject jsonTipus = llistatTipusUsuaris.getJSONObject(i);
                        comboBoxTipusUsuari.addItem(jsonTipus.get("nom").toString());
                        llistatTipus.add(new String[]{jsonTipus.get("id").toString(),jsonTipus.get("nom").toString()});
                    }
                }else{
                    problemes += "Hi ha problemes amb el llistat de tipus d'usuari. ";
                }
            }else{
                problemes += "Hi ha problemes amb els tipus d'usuari:  " + jsonTipusUsuaris.get("codi_error").toString() + " - " + jsonTipusUsuaris.get("error").toString() ;
            }
        }else{
            problemes += "Hi ha problemes amb els tipus d'usuari. ";
        }
        comboBoxTipusUsuari.setBackground(new Color(255,255,255,255));
        
        // Json array amb les poblacions
        JSONObject jsonPoblacions = api.llistatPoblacions(usuari);
        
        if(!jsonPoblacions.isEmpty()){
            if(jsonPoblacions.get("codi_error").toString().equals("0")){
                JSONArray jsonllistatPoblacions = jsonPoblacions.getJSONArray("llistat");
                if(!jsonllistatPoblacions.isEmpty()){
                    for(int i = 0; i < jsonllistatPoblacions.length(); i++){
                        JSONObject jsonPoblacio = jsonllistatPoblacions.getJSONObject(i);
                        comboBoxPoblacio.addItem(jsonPoblacio.get("nom").toString() + " (" + jsonPoblacio.get("nom_provincia").toString() + ")");
                        llistatPoblacions.add(new String[]{jsonPoblacio.get("id").toString(),jsonPoblacio.get("nom").toString() + " (" + jsonPoblacio.get("nom_provincia").toString() + ")"});
                    }
                }else{
                    problemes += "Hi ha problemes amb el llistat de poblacions. ";
                }
            }else{
                problemes += "Hi ha problemes amb les poblacions:  " + jsonPoblacions.get("codi_error").toString() + " - " + jsonPoblacions.get("error").toString() ;
            }
        }else{
            problemes += "Hi ha problemes amb les poblacions. ";
        }
        comboBoxPoblacio.setBackground(new Color(255,255,255,255));
        
        // Json amb els tipus d'adherits
        JSONObject jsonTipusAdherits = api.llistatTipusAdherit(usuari);
        
         if(!jsonTipusAdherits.isEmpty()){
            if(jsonTipusAdherits.get("codi_error").toString().equals("0")){
                JSONArray jsonLlistatTipusAdherit = jsonTipusAdherits.getJSONArray("llistat");
                if(!jsonLlistatTipusAdherit.isEmpty()){
                    for(int i = 0; i < jsonLlistatTipusAdherit.length(); i++){
                        JSONObject jsonTipusAdherit = jsonLlistatTipusAdherit.getJSONObject(i);
                        comboBoxTipusAdherit.addItem(jsonTipusAdherit.get("nom").toString());
                        llistatTipusAdherit.add(new String[]{jsonTipusAdherit.get("id").toString(),jsonTipusAdherit.get("nom").toString()});
                    }
                }else{
                    problemes += "Hi ha problemes amb el llistat de tipus d'adherits. ";
                }
            }else{
                problemes += "Hi ha problemes amb els tipus d'adherits:  " + jsonTipusAdherits.get("codi_error").toString() + " - " + jsonTipusAdherits.get("error").toString() ;
            }
        }else{
            problemes += "Hi ha problemes amb els tipus d'adherit. ";
        }
        comboBoxTipusAdherit.setBackground(new Color(255,255,255,255));
       
    }
    
    /**
     * Mètode per gestionar accions en funció de l'usuari
     */
    private void gestioUsuari(){
        // Posem el nom de l'usuari a la part superior
        labelUsuari.setText( usuari.getNom() + " " + usuari.getCognom1() + " " + usuari.getCognom2() );   
        // Tractament de permisos per mostrar opcions disponibles.
        switch(usuari.getTipus()){
            case 1 -> { 
            }
            case 2 -> {
            }
        }
    }
    
    /**
     * Mètode per centrar la pantalla
     */
    private void centrarPantalla(){
        // Centrar pantalla.
        Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(((pantalla.width)-this.getWidth())/2,((pantalla.height)-this.getHeight())/2);
    }
    
    /**
     * Mètode per resetejar el formulari
     */
    private void resetFormulari(){
        comboBoxTipusUsuari.setSelectedIndex(0);
        textFieldEmail.setText("");
        passwordFieldPassword.setText("");
        textFieldNom.setText("");
        textFieldCognom1.setText("");
        textFieldCognom2.setText("");
        textFieldTelefon.setText("");
        checkBoxActiu.setSelected(false);
        textFieldCarrer.setText("");
        textFieldCP.setText("");
        comboBoxPoblacio.setSelectedIndex(0);
        textFieldNomAdherit.setText("");
        textFieldHoraris.setText("");
        comboBoxTipusAdherit.setSelectedIndex(0);
    }
    
    /**
     * Mètode per capturar la x i y del mouse quan el deixem pulsat sobre el frame principal.
     * @param evt MouseEvent: event de deixar pulsat el botó del ratolí.
     */
    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_formMousePressed

    /**
     * Mètode executat quan movem el mouse amb el formulari pulsat. 
     * @param evt MouseEvent: event quan arroseguem amb el ratolí.
     */
    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        setLocation(x-xMouse, y-yMouse);
    }//GEN-LAST:event_formMouseDragged

    /**
     * Mètode utilitzat quan es prem el botó de logout per tancar la sessió.
     * @param evt ActionEvent: Pulsar el botó.
     */
    private void buttonAltaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAltaActionPerformed
         
        boolean enviament = true;
        String missatge = "Falta omplir: - ";
        
        // Comprovem les dades del formulari
         String tipus = comboBoxTipusUsuari.getSelectedItem().toString();
         String email = textFieldEmail.getText();
         String password = passwordFieldPassword.getText();
         String nom = textFieldNom.getText();
         String cognom1 = textFieldCognom1.getText();
         String cognom2 = textFieldCognom2.getText();
         String telefon = textFieldTelefon.getText();
         boolean boolActiu = checkBoxActiu.isSelected();
         String actiu = "1";
         if(boolActiu){ actiu = "1"; }else{ actiu = "0"; }
         String carrer = "";
         String cp = "";
         String poblacio = "";
         String nomAdherit = "";
         String horaris = "";
         String tipusAdherit = "";
         
         // Fem comprovació
         if(tipus.equals("Tria tipus")){
             missatge += " tipus usuari -"; enviament = false;
         }
         if(email.equals("")){
             missatge += " email -"; enviament = false;
         }else{
            if(!api.validarEmail(email)){
               missatge += " format email incorrecte -"; enviament = false; 
            }
         }
         if(password.equals("")){
             missatge += " password -"; enviament = false;
         }else{
             if(password.length() < 8){
                 missatge += " password mínim 8 caràcters -"; enviament = false;
             }
         }
         if(nom.equals("")){ missatge += " nom -"; enviament = false; }
         if(cognom1.equals("")){ missatge += " cognom1 -"; enviament = false; }
         if(telefon.equals("")){
             missatge += " telèfon -"; enviament = false;
         }else{
             if(telefon.length() < 9){
                 missatge += " telèfon ha de tenir 9 dígits -"; enviament = false;
             }
         }
         
         String tipus_id = "0";
         for (String[] e : llistatTipus) {
             if (e[1].equals(tipus)) {
                 tipus_id = e[0];
                break;
             }
        }
         
        String poblacio_id = "0";
        String tipusAdherit_id = "0";
         
        // Comprovem el tipus d'usuari per saber quins camps més hem d'agafar
        switch(tipus){
             case "Administrador","Treballador" -> {
                 // No s'han de comprovar més camps.
             }
             case "Residuent" -> {
                 carrer = textFieldCarrer.getText();
                 cp = textFieldCP.getText();
                 poblacio = comboBoxPoblacio.getSelectedItem().toString();
                 if(carrer.equals("")){ missatge += " carrer -"; enviament = false; }
                 if(cp.equals("")){
                     missatge += " codi postal -"; enviament = false;
                 }else{
                     if(cp.length() < 5){
                        missatge += " codi postal falten números -"; enviament = false; 
                     }
                 }
                if(poblacio.equals("Tria població")){
                    missatge += " població -"; enviament = false;
                }
                for (String[] e : llistatPoblacions) {
                    if (e[1].equals(poblacio)) {
                        poblacio_id = e[0];
                    break;
                    }
                }
             }
             case "Adherit" -> {
                 carrer = textFieldCarrer.getText();
                 cp = textFieldCP.getText();
                 poblacio = comboBoxPoblacio.getSelectedItem().toString();
                 nomAdherit = textFieldNomAdherit.getText();
                 horaris = textFieldHoraris.getText();
                 tipusAdherit = comboBoxTipusAdherit.getSelectedItem().toString();
                 if(carrer.equals("")){ missatge += " carrer -"; enviament = false; }
                 if(cp.equals("")){
                     missatge += " codi postal -"; enviament = false;
                 }else{
                     if(cp.length() < 5){
                        missatge += " codi postal falten números -"; enviament = false; 
                     }
                 }
                 if(poblacio.equals("Tria població")){
                    missatge += " població -"; enviament = false;
                }
                 if(nomAdherit.equals("")){ missatge += " nom adherit -"; enviament = false; }
                 if(horaris.equals("")){ missatge += " horaris -"; enviament = false; }
                 if(tipusAdherit.equals("Tria tipus adherit")){
                    missatge += " tipus adherit -"; enviament = false;
                }
                 for (String[] e : llistatPoblacions) {
                    if (e[1].equals(poblacio)) {
                        poblacio_id = e[0];
                    break;
                    }
                }
                 for (String[] e : llistatTipusAdherit) {
                    if (e[1].equals(tipusAdherit)) {
                        tipusAdherit_id = e[0];
                    break;
                    }
                }
             }
         }
         
        if(enviament){
            // Cridem l'api per donar d'alta usari 
            switch(tipus){
                case "Administrador" -> {  
                    JSONObject jsonRetorn = api.crearUsuariAdministrador(usuari,email,password,tipus_id,nom,cognom1,cognom2,telefon,actiu);
                    if(!jsonRetorn.isEmpty()){
                        if(jsonRetorn.get("codi_error").toString().equals("0")){
                            PantallaAdvertencia pantallaAdvertencia = new PantallaAdvertencia(jsonRetorn.get("descripcio").toString());
                            pantallaAdvertencia.setVisible(true);
                            this.resetFormulari();
                        }else{
                            PantallaAdvertencia pantallaAdvertencia = new PantallaAdvertencia(jsonRetorn.get("codi_error").toString() + " - " +jsonRetorn.get("error").toString());
                            pantallaAdvertencia.setVisible(true); 
                        }
                    }else{
                        PantallaAdvertencia pantallaAdvertencia = new PantallaAdvertencia(api.error(4));
                        pantallaAdvertencia.setVisible(true);   
                    }
                }
                case "Treballador" -> {
                    JSONObject jsonRetorn = api.crearUsuariTreballador(usuari,email,password,tipus_id,nom,cognom1,cognom2,telefon,actiu);
                    if(!jsonRetorn.isEmpty()){
                        if(jsonRetorn.get("codi_error").toString().equals("0")){
                            PantallaAdvertencia pantallaAdvertencia = new PantallaAdvertencia(jsonRetorn.get("descripcio").toString());
                            pantallaAdvertencia.setVisible(true);
                            this.resetFormulari();
                        }else{
                            PantallaAdvertencia pantallaAdvertencia = new PantallaAdvertencia(jsonRetorn.get("codi_error").toString() + " - " +jsonRetorn.get("error").toString());
                            pantallaAdvertencia.setVisible(true); 
                        }
                    }else{
                        PantallaAdvertencia pantallaAdvertencia = new PantallaAdvertencia(api.error(4));
                        pantallaAdvertencia.setVisible(true);   
                    }
                }
                case "Residuent" -> {
                    JSONObject jsonRetorn = api.crearUsuariResiduent(usuari,email,password,tipus_id,nom,cognom1,cognom2,telefon,actiu,carrer,cp,poblacio_id);
                    if(!jsonRetorn.isEmpty()){
                        if(jsonRetorn.get("codi_error").toString().equals("0")){
                            PantallaAdvertencia pantallaAdvertencia = new PantallaAdvertencia(jsonRetorn.get("descripcio").toString());
                            pantallaAdvertencia.setVisible(true);
                            this.resetFormulari();
                        }else{
                            PantallaAdvertencia pantallaAdvertencia = new PantallaAdvertencia(jsonRetorn.get("codi_error").toString() + " - " +jsonRetorn.get("error").toString());
                            pantallaAdvertencia.setVisible(true); 
                        }
                    }else{
                        PantallaAdvertencia pantallaAdvertencia = new PantallaAdvertencia(api.error(4));
                        pantallaAdvertencia.setVisible(true);   
                    }
                }
                case "Adherit" -> {
                    JSONObject jsonRetorn = api.crearUsuariAdherit(usuari,email,password,tipus_id,nom,cognom1,cognom2,telefon,actiu,carrer,cp,poblacio_id,nomAdherit,horaris,tipusAdherit_id);
                    if(!jsonRetorn.isEmpty()){
                        if(jsonRetorn.get("codi_error").toString().equals("0")){
                            PantallaAdvertencia pantallaAdvertencia = new PantallaAdvertencia(jsonRetorn.get("descripcio").toString());
                            pantallaAdvertencia.setVisible(true);
                            this.resetFormulari();
                        }else{
                            PantallaAdvertencia pantallaAdvertencia = new PantallaAdvertencia(jsonRetorn.get("codi_error").toString() + " - " +jsonRetorn.get("error").toString());
                            pantallaAdvertencia.setVisible(true); 
                        }
                    }else{
                        PantallaAdvertencia pantallaAdvertencia = new PantallaAdvertencia(api.error(4));
                        pantallaAdvertencia.setVisible(true);   
                    }
                }
            }
        }else{
             PantallaAdvertencia pantallaAdvertencia = new PantallaAdvertencia(missatge);
             pantallaAdvertencia.setVisible(true);
         }
         
    }//GEN-LAST:event_buttonAltaActionPerformed
    
    /**
     * Mètode utilitzat quan es prem el botó de logout per tancar la sessió.
     * @param evt (ActionEvent) : event al pulsar el botó.
     */
    private void buttonLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonLogOutActionPerformed
        // Fem el logout
        api.logout(usuari);
        System.exit( 0);
    }//GEN-LAST:event_buttonLogOutActionPerformed

    /**
     * Mètode utilitzat quan es prem el botó de Tornar per tornar al llistat d'usuaris
     * @param evt (ActionEvent) : event al pulsar el botó.
     */
    private void buttonTornarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonTornarActionPerformed
        PantallaLlistatUsuaris pantallaLlistatUsuaris = new PantallaLlistatUsuaris(usuari);
        pantallaLlistatUsuaris.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_buttonTornarActionPerformed
    
    /**
     * Mètode utilitzat quan es canvia d'item al combobox de tipus d'usuari
     * @param evt 
     */
    private void comboBoxTipusUsuariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxTipusUsuariActionPerformed
        switch(comboBoxTipusUsuari.getSelectedItem().toString()){
            case "Administrador" -> {
                labelTitolAdresa.setVisible(false);
                separadorAdresa.setVisible(false);
                labelCarrer.setVisible(false);
                textFieldCarrer.setVisible(false);
                labelCP.setVisible(false);
                textFieldCP.setVisible(false);
                labelPoblacio.setVisible(false);
                comboBoxPoblacio.setVisible(false);
                labelTitolAdherit.setVisible(false);
                separadorAdherit.setVisible(false);
                labelNomAdherit.setVisible(false);
                textFieldNomAdherit.setVisible(false);
                labelHoraris.setVisible(false);
                textFieldHoraris.setVisible(false);
                labelTipusAdherit.setVisible(false);
                comboBoxTipusAdherit.setVisible(false);
            }
            case "Treballador" -> {
                labelTitolAdresa.setVisible(false);
                separadorAdresa.setVisible(false);
                labelCarrer.setVisible(false);
                textFieldCarrer.setVisible(false);
                labelCP.setVisible(false);
                textFieldCP.setVisible(false);
                labelPoblacio.setVisible(false);
                comboBoxPoblacio.setVisible(false);
                labelTitolAdherit.setVisible(false);
                separadorAdherit.setVisible(false);
                labelNomAdherit.setVisible(false);
                textFieldNomAdherit.setVisible(false);
                labelHoraris.setVisible(false);
                textFieldHoraris.setVisible(false);
                labelTipusAdherit.setVisible(false);
                comboBoxTipusAdherit.setVisible(false);
            }
            case "Residuent" -> {
                labelTitolAdresa.setVisible(true);
                separadorAdresa.setVisible(true);
                labelCarrer.setVisible(true);
                textFieldCarrer.setVisible(true);
                labelCP.setVisible(true);
                textFieldCP.setVisible(true);
                labelPoblacio.setVisible(true);
                comboBoxPoblacio.setVisible(true);
                labelTitolAdherit.setVisible(false);
                separadorAdherit.setVisible(false);
                labelNomAdherit.setVisible(false);
                textFieldNomAdherit.setVisible(false);
                labelHoraris.setVisible(false);
                textFieldHoraris.setVisible(false);
                labelTipusAdherit.setVisible(false);
                comboBoxTipusAdherit.setVisible(false);               
            }
            case "Adherit" -> {
                labelTitolAdresa.setVisible(true);
                separadorAdresa.setVisible(true);
                labelCarrer.setVisible(true);
                textFieldCarrer.setVisible(true);
                labelCP.setVisible(true);
                textFieldCP.setVisible(true);
                labelPoblacio.setVisible(true);
                comboBoxPoblacio.setVisible(true);
                labelTitolAdherit.setVisible(true);
                separadorAdherit.setVisible(true);
                labelNomAdherit.setVisible(true);
                textFieldNomAdherit.setVisible(true);
                labelHoraris.setVisible(true);
                textFieldHoraris.setVisible(true);
                labelTipusAdherit.setVisible(true);
                comboBoxTipusAdherit.setVisible(true);
            }
        }
        
    }//GEN-LAST:event_comboBoxTipusUsuariActionPerformed
    
    /**
     * Mètode utilitzat per limitar els caràcters al textfield de telèfon
     * @param evt (KeyEvent) : event de teclat.
     */
    private void textFieldCPKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textFieldCPKeyTyped
        if(textFieldCP.getText().length() >= 5){
            evt.consume();
        }else{
            int key = evt.getKeyChar();
            boolean num = key >=48 && key <= 57;
            if(!num){ evt.consume(); }
        }
    }//GEN-LAST:event_textFieldCPKeyTyped
    
    /**
     * Mètode utilitzar per limitar els caràcters al textField de nom
     * @param evt (keyEvent) : event de teclat.
     */
    private void textFieldNomKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textFieldNomKeyTyped
        if(textFieldNom.getText().length() >= 100){
            evt.consume();
        }
    }//GEN-LAST:event_textFieldNomKeyTyped

    /**
     * Mètode utilitzar per limitar els caràcters al textField de cognom 1
     * @param evt (keyEvent) : event de teclat.
     */
    private void textFieldCognom1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textFieldCognom1KeyTyped
        if(textFieldCognom1.getText().length() >= 100){
            evt.consume();
        }
    }//GEN-LAST:event_textFieldCognom1KeyTyped

    /**
     * Mètode utilitzar per limitar els caràcters al textField de cognom 2
     * @param evt (keyEvent) : event de teclat.
     */
    private void textFieldCognom2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textFieldCognom2KeyTyped
        if(textFieldCognom2.getText().length() >= 100){
            evt.consume();
        }
    }//GEN-LAST:event_textFieldCognom2KeyTyped
    
    /**
     * Mètode utilitzar per limitar els caràcters al textField de email
     * @param evt (keyEvent) : event de teclat.
     */
    private void textFieldEmailKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textFieldEmailKeyTyped
        if(textFieldEmail.getText().length() >= 255){
            evt.consume();
        }
    }//GEN-LAST:event_textFieldEmailKeyTyped

    /**
     * Mètode utilitzar per limitar els caràcters al passwordField de password
     * @param evt (keyEvent) : event de teclat.
     */
    private void passwordFieldPasswordKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passwordFieldPasswordKeyTyped
        if(passwordFieldPassword.getText().length() >= 255){
            evt.consume();
        }
    }//GEN-LAST:event_passwordFieldPasswordKeyTyped

    /**
     * Mètode utilitzar per limitar els caràcters al textField telèfon
     * @param evt (keyEvent) : event de teclat.
     */
    private void textFieldTelefonKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textFieldTelefonKeyTyped
        if(textFieldTelefon.getText().length() >= 9){
            evt.consume();
        }else{
            int key = evt.getKeyChar();
            boolean num = key >=48 && key <= 57;
            if(!num){ evt.consume(); }
        }
    }//GEN-LAST:event_textFieldTelefonKeyTyped

    /**
     * Mètode utilitzar per limitar els caràcters al textField carrer
     * @param evt (keyEvent) : event de teclat.
     */
    private void textFieldCarrerKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textFieldCarrerKeyTyped
        if(textFieldCarrer.getText().length() >= 255){
            evt.consume();
        }
    }//GEN-LAST:event_textFieldCarrerKeyTyped

    /**
     * Mètode utilitzar per limitar els caràcters al textField nom adherit
     * @param evt (keyEvent) : event de teclat.
     */
    private void textFieldNomAdheritKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textFieldNomAdheritKeyTyped
        if(textFieldNomAdherit.getText().length() >= 255){
            evt.consume();
        }
    }//GEN-LAST:event_textFieldNomAdheritKeyTyped
    
    /**
     * Mètode utilitzar per limitar els caràcters al textField nom adherit
     * @param evt (keyEvent) : event de teclat.
     */
    private void textFieldHorarisKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textFieldHorarisKeyTyped
        if(textFieldHoraris.getText().length() >= 255){
            evt.consume();
        }
    }//GEN-LAST:event_textFieldHorarisKeyTyped

    /**
     * Mètode principal de la classe.
     * @param args arguments de la linia de comandament
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PantallaAltaUsuari.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PantallaAltaUsuari.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PantallaAltaUsuari.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PantallaAltaUsuari.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PantallaAltaUsuari(usuari).setVisible(true);
            }
        });
        
        
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    /**
    * Botó per donar d'alta l'usuari
    */
    private javax.swing.JButton buttonAlta;
    /**
    * Botó per desloginar-se i sortir de l'aplicació.
    */
    private javax.swing.JButton buttonLogOut;
    /**
    * Botó per tornar a la pantalla principal.
    */
    private javax.swing.JButton buttonTornar;
    /**
    * Checkbox actiu
    */
    private javax.swing.JCheckBox checkBoxActiu;
    /**
    * Combo box població
    */
    private javax.swing.JComboBox<String> comboBoxPoblacio;
    /**
    * Combo box tipus adherit
    */
    private javax.swing.JComboBox<String> comboBoxTipusAdherit;
    /**
    * Combo box tipus usuari
    */
    private javax.swing.JComboBox<String> comboBoxTipusUsuari;
    /**
    * Label actiu
    */
    private javax.swing.JLabel labelActiu;
    /**
    * Label CP
    */
    private javax.swing.JLabel labelCP;
    /**
    * Label carrer
    */
    private javax.swing.JLabel labelCarrer;
    /**
    * Label cognom 1
    */
    private javax.swing.JLabel labelCognom1;
    /**
    * Label cognom 2
    */
    private javax.swing.JLabel labelCognom2;
    /**
    * labelTitolAdresa email
    */
    private javax.swing.JLabel labelEmail1;
    /**
    * Label horaris
    */
    private javax.swing.JLabel labelHoraris;
    /**
    * Label nom usuari
    */
    private javax.swing.JLabel labelNom;
    /**
    * Label nom adherit
    */
    private javax.swing.JLabel labelNomAdherit;
    /**
    * Label password
    */
    private javax.swing.JLabel labelPassword;
    /**
    * Label població
    */
    private javax.swing.JLabel labelPoblacio;
    /**
    * Label per contenir el logo de l'aplicació.
    */
    private javax.swing.JLabel labelPrincipal;
    /**
    * Label telèfon
    */
    private javax.swing.JLabel labelTelefon;
    /**
    * Label tipus usuari
    */
    private javax.swing.JLabel labelTipus;
    /**
    * Label tipus adherit
    */
    private javax.swing.JLabel labelTipusAdherit;
    /**
    * Label per el títol de la pantalla.
    */
    private javax.swing.JLabel labelTitol;
    /**
    * Label per el títol de dades adherit
    */
    private javax.swing.JLabel labelTitolAdherit;
    /**
    * Label per el titol d'adreces
    */
    private javax.swing.JLabel labelTitolAdresa;
    /**
    * Label per el títol de dades usuari
    */
    private javax.swing.JLabel labelTitolDades;
    /**
    * Label per tenir les dades de l'usuari loginat
    */
    private javax.swing.JLabel labelUsuari;
    /**
    * Panel per contenir la informació de l'usuari loginat
    */
    private javax.swing.JPanel panelBar;
    /**
    * Panel per tenir el contingut de la pantalla.
    */
    private javax.swing.JPanel panelContingut;
    /**
    * Panel per tenir les opcions.
    */
    private javax.swing.JPanel panelOpcions;
    /**
    * Panel principal per contenir la distribució de la pantalla.
    */
    private javax.swing.JPanel panelPrincipal;
    /**
    * Panel per contenir el títol de la pantalla
    */
    private javax.swing.JPanel panelTitol;
    /**
    * Password field password
    */
    private javax.swing.JPasswordField passwordFieldPassword;
    /**
    * Separador dades adherit
    */
    private javax.swing.JSeparator separadorAdherit;
    /**
    * Separador adreça
    */
    private javax.swing.JSeparator separadorAdresa;
    /**
    * Separador dades usuari
    */
    private javax.swing.JSeparator separadorUsuari;
    /**
    * Text field cp
    */
    private javax.swing.JTextField textFieldCP;
    /**
    * Text field carrer
    */
    private javax.swing.JTextField textFieldCarrer;
    /**
    * Text field cognom 1
    */
    private javax.swing.JTextField textFieldCognom1;
    /**
    * Text field cognom 2
    */
    private javax.swing.JTextField textFieldCognom2;
    /**
    * Text Field email
    */
    private javax.swing.JTextField textFieldEmail;
    /**
    * Text field adherit
    */
    private javax.swing.JTextField textFieldHoraris;
    /**
    * Text field nom usuari
    */
    private javax.swing.JTextField textFieldNom;
    /**
    * Text field nom adherit
    */
    private javax.swing.JTextField textFieldNomAdherit;
    /**
    * Text field telèfon
    */
    private javax.swing.JTextField textFieldTelefon;
    // End of variables declaration//GEN-END:variables
}