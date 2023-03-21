package residueix.residueixapp;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
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
    }

     /**
     * Mètode critad per el constructor per inicialitzar el formulari.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();
        panelPrincipal = new javax.swing.JPanel();
        panelContingut = new javax.swing.JPanel();
        panelBar = new javax.swing.JPanel();
        labelUsuari = new javax.swing.JLabel();
        panelTitol = new javax.swing.JPanel();
        labelTitol = new javax.swing.JLabel();
        separadorAdresa = new javax.swing.JSeparator();
        labelEmail = new javax.swing.JLabel();
        labelPassword = new javax.swing.JLabel();
        labelTipus = new javax.swing.JLabel();
        labelNom = new javax.swing.JLabel();
        labelCognom1 = new javax.swing.JLabel();
        labelCognom2 = new javax.swing.JLabel();
        labelTelefon = new javax.swing.JLabel();
        labelActiu = new javax.swing.JLabel();
        separadorAdresa1 = new javax.swing.JSeparator();
        javax.swing.JLabel labelTitolDades = new javax.swing.JLabel();
        javax.swing.JLabel labelTitolDades1 = new javax.swing.JLabel();
        panelOpcions = new javax.swing.JPanel();
        buttonTornar = new javax.swing.JButton();
        buttonAlta = new javax.swing.JButton();
        buttonLogOut = new javax.swing.JButton();
        buttonModificacio = new javax.swing.JButton();
        buttonBaixa = new javax.swing.JButton();
        buttonPerfil2 = new javax.swing.JButton();
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
        panelContingut.add(separadorAdresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 700, 10));

        labelEmail.setFont(new java.awt.Font("Sansation", 0, 14)); // NOI18N
        labelEmail.setText("Email");
        panelContingut.add(labelEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 100, 30));

        labelPassword.setFont(new java.awt.Font("Sansation", 0, 14)); // NOI18N
        labelPassword.setText("Password");
        panelContingut.add(labelPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 100, 30));

        labelTipus.setFont(new java.awt.Font("Sansation", 0, 14)); // NOI18N
        labelTipus.setText("Tipus");
        panelContingut.add(labelTipus, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 100, 30));

        labelNom.setFont(new java.awt.Font("Sansation", 0, 14)); // NOI18N
        labelNom.setText("Nom");
        panelContingut.add(labelNom, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 100, 30));

        labelCognom1.setFont(new java.awt.Font("Sansation", 0, 14)); // NOI18N
        labelCognom1.setText("Cognom 1");
        panelContingut.add(labelCognom1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 100, 30));

        labelCognom2.setFont(new java.awt.Font("Sansation", 0, 14)); // NOI18N
        labelCognom2.setText("Cognom 2");
        labelCognom2.setToolTipText("");
        panelContingut.add(labelCognom2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, 100, 30));

        labelTelefon.setFont(new java.awt.Font("Sansation", 0, 14)); // NOI18N
        labelTelefon.setText("Telèfon");
        labelTelefon.setToolTipText("");
        panelContingut.add(labelTelefon, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, 100, 30));

        labelActiu.setFont(new java.awt.Font("Sansation", 0, 14)); // NOI18N
        labelActiu.setText("Actiu");
        labelActiu.setToolTipText("");
        panelContingut.add(labelActiu, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 440, 100, 30));
        panelContingut.add(separadorAdresa1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 510, 700, 10));

        labelTitolDades.setFont(new java.awt.Font("Sansation", 0, 14)); // NOI18N
        labelTitolDades.setForeground(new java.awt.Color(153, 153, 153));
        labelTitolDades.setText("Adreça (només Residuents i Adherits)");
        panelContingut.add(labelTitolDades, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 490, -1, -1));

        labelTitolDades1.setFont(new java.awt.Font("Sansation", 0, 14)); // NOI18N
        labelTitolDades1.setForeground(new java.awt.Color(153, 153, 153));
        labelTitolDades1.setText("Dades de l'usuari");
        panelContingut.add(labelTitolDades1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, -1));

        panelPrincipal.add(panelContingut, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 2, 798, 746));

        panelOpcions.setBackground(new java.awt.Color(255, 255, 255));
        panelOpcions.setOpaque(false);
        panelOpcions.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        buttonTornar.setBackground(new java.awt.Color(255, 204, 0));
        buttonTornar.setFont(new java.awt.Font("Sansation", 1, 14)); // NOI18N
        buttonTornar.setText("Tornar Llistat");
        buttonTornar.setToolTipText("Sortir");
        buttonTornar.setBorderPainted(false);
        buttonTornar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonTornar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonTornarActionPerformed(evt);
            }
        });
        panelOpcions.add(buttonTornar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 660, 150, 30));

        buttonAlta.setBackground(new java.awt.Color(51, 102, 255));
        buttonAlta.setFont(new java.awt.Font("Sansation", 1, 14)); // NOI18N
        buttonAlta.setForeground(new java.awt.Color(255, 255, 255));
        buttonAlta.setText("Alta");
        buttonAlta.setToolTipText("Alta");
        buttonAlta.setBorderPainted(false);
        buttonAlta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonAlta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAltaActionPerformed(evt);
            }
        });
        panelOpcions.add(buttonAlta, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 70, 150, 30));

        buttonLogOut.setBackground(new java.awt.Color(153, 0, 0));
        buttonLogOut.setFont(new java.awt.Font("Sansation", 1, 14)); // NOI18N
        buttonLogOut.setForeground(new java.awt.Color(255, 255, 255));
        buttonLogOut.setText("Logout");
        buttonLogOut.setToolTipText("Sortir");
        buttonLogOut.setBorderPainted(false);
        buttonLogOut.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonLogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonLogOutActionPerformed(evt);
            }
        });
        panelOpcions.add(buttonLogOut, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 700, 150, 30));

        buttonModificacio.setBackground(new java.awt.Color(51, 102, 255));
        buttonModificacio.setFont(new java.awt.Font("Sansation", 1, 14)); // NOI18N
        buttonModificacio.setForeground(new java.awt.Color(255, 255, 255));
        buttonModificacio.setText("Modificar");
        buttonModificacio.setToolTipText("Modificar");
        buttonModificacio.setBorderPainted(false);
        buttonModificacio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panelOpcions.add(buttonModificacio, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 110, 150, 30));

        buttonBaixa.setBackground(new java.awt.Color(51, 102, 255));
        buttonBaixa.setFont(new java.awt.Font("Sansation", 1, 14)); // NOI18N
        buttonBaixa.setForeground(new java.awt.Color(255, 255, 255));
        buttonBaixa.setText("Baixa");
        buttonBaixa.setToolTipText("Baixa");
        buttonBaixa.setBorderPainted(false);
        buttonBaixa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panelOpcions.add(buttonBaixa, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 150, 150, 30));

        buttonPerfil2.setBackground(new java.awt.Color(51, 102, 255));
        buttonPerfil2.setFont(new java.awt.Font("Sansation", 1, 14)); // NOI18N
        buttonPerfil2.setForeground(new java.awt.Color(255, 255, 255));
        buttonPerfil2.setText("Perfil");
        buttonPerfil2.setToolTipText("Perfil");
        buttonPerfil2.setBorderPainted(false);
        buttonPerfil2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panelOpcions.add(buttonPerfil2, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 30, 150, 30));

        panelPrincipal.add(panelOpcions, new org.netbeans.lib.awtextra.AbsoluteConstraints(798, 2, 200, 746));

        labelPrincipal.setBackground(new java.awt.Color(255, 255, 255));
        labelPrincipal.setIcon(new javax.swing.ImageIcon("C:\\Users\\isard\\Downloads\\fons_general.png")); // NOI18N
        labelPrincipal.setOpaque(true);
        panelPrincipal.add(labelPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 2, 996, 746));

        getContentPane().add(panelPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 750));

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
    private void buttonTornarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonTornarActionPerformed
         this.dispose();
         PantallaPrincipal pantallaPrincipal = new PantallaPrincipal(usuari);
         pantallaPrincipal.setVisible(true);
    }//GEN-LAST:event_buttonTornarActionPerformed

    private void buttonLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonLogOutActionPerformed
        // Fem el logout
        api.logout(usuari);
        System.exit( 0);
    }//GEN-LAST:event_buttonLogOutActionPerformed

    private void buttonAltaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAltaActionPerformed
        this.dispose();
        PantallaAltaUsuari pantallaAltaUsuari = new PantallaAltaUsuari(usuari);
        pantallaAltaUsuari.setVisible(true);
                
    }//GEN-LAST:event_buttonAltaActionPerformed

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
    * Botó per donar d'alta un usuari
    */
    private javax.swing.JButton buttonAlta;
    /**
    * Botó per donar de baixa un usuari.
    */
    private javax.swing.JButton buttonBaixa;
    /**
    * Botó per desloginar-se i sortir de l'aplicació.
    */
    private javax.swing.JButton buttonLogOut;
    /**
    * Botó per modificar un usuari.
    */
    private javax.swing.JButton buttonModificacio;
    /**
    * Botó per accedir al perfil de l'usuari.
    */
    private javax.swing.JButton buttonPerfil2;
    /**
    * Botó per tornar a la pantalla principal.
    */
    private javax.swing.JButton buttonTornar;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel labelActiu;
    private javax.swing.JLabel labelCognom1;
    private javax.swing.JLabel labelCognom2;
    private javax.swing.JLabel labelEmail;
    private javax.swing.JLabel labelNom;
    private javax.swing.JLabel labelPassword;
    /**
    * Label per contenir el logo de l'aplicació.
    */
    private javax.swing.JLabel labelPrincipal;
    private javax.swing.JLabel labelTelefon;
    private javax.swing.JLabel labelTipus;
    /**
    * Label per el títol de la pantalla.
    */
    private javax.swing.JLabel labelTitol;
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
    private javax.swing.JSeparator separadorAdresa;
    private javax.swing.JSeparator separadorAdresa1;
    // End of variables declaration//GEN-END:variables
}