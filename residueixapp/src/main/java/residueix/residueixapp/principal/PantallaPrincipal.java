package residueix.residueixapp.principal;

import residueix.residueixapp.usuaris.PantallaLlistatUsuaris;
import residueix.residueixapp.puntsrecollida.PantallaLlistatPuntsRecollida;
import residueix.residueixapp.residus.PantallaLlistatResidus;
import java.awt.Dimension;
import java.awt.Toolkit;
import residueix.residueixapp.acces.PantallaLogin;
import residueix.residueixapp.esdeveniments.PantallaLlistatEsdeveniments;
import residueix.residueixapp.models.Usuari;
import residueix.residueixapp.puntsrecollida.PantallaRecollidaIdentificacio;
import residueix.residueixapp.utils.Api;

/**
 * Classe per obrir la pantalla principal de l'aplicació.
 * @author Daniel Garcia Ruiz
 * @version 12/03/2023
 */
public class PantallaPrincipal extends javax.swing.JFrame {
    
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
    public PantallaPrincipal(Usuari usuari) {
        // Iniciem els atributs.
        this.api = new Api();
        this.usuari = usuari;
        // Iniciem els components
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

        panelPrincipal = new javax.swing.JPanel();
        panelContingut = new javax.swing.JPanel();
        panelBar = new javax.swing.JPanel();
        labelUsuari = new javax.swing.JLabel();
        panelOpcions = new javax.swing.JPanel();
        buttonRecollida = new javax.swing.JButton();
        buttonEsdeveniments = new javax.swing.JButton();
        buttonPuntsRecollida = new javax.swing.JButton();
        buttonResidus = new javax.swing.JButton();
        buttonUsuaris = new javax.swing.JButton();
        buttonLogOut = new javax.swing.JButton();
        buttonPerfil = new javax.swing.JButton();
        buttonCanvi = new javax.swing.JButton();
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

        panelPrincipal.add(panelContingut, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 2, 798, 746));

        panelOpcions.setBackground(new java.awt.Color(255, 255, 255));
        panelOpcions.setOpaque(false);
        panelOpcions.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        buttonRecollida.setBackground(new java.awt.Color(51, 102, 255));
        buttonRecollida.setFont(new java.awt.Font("Sansation", 1, 14)); // NOI18N
        buttonRecollida.setForeground(new java.awt.Color(255, 255, 255));
        buttonRecollida.setText("Recollida");
        buttonRecollida.setToolTipText("Llistat punts de recollida");
        buttonRecollida.setAutoscrolls(true);
        buttonRecollida.setBorderPainted(false);
        buttonRecollida.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonRecollida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRecollidaActionPerformed(evt);
            }
        });
        panelOpcions.add(buttonRecollida, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 430, 150, 30));
        switch(usuari.getTipus()){
            case 2 ->{
                panelOpcions.add(buttonRecollida, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 130, 150, 30));
            }
            case 1 ->{
                buttonRecollida.setVisible(false);
            }
        }

        buttonEsdeveniments.setBackground(new java.awt.Color(51, 102, 255));
        buttonEsdeveniments.setFont(new java.awt.Font("Sansation", 1, 14)); // NOI18N
        buttonEsdeveniments.setForeground(new java.awt.Color(255, 255, 255));
        buttonEsdeveniments.setText("Esdeveniments");
        buttonEsdeveniments.setToolTipText("Llistat Esdeveniments");
        buttonEsdeveniments.setAutoscrolls(true);
        buttonEsdeveniments.setBorderPainted(false);
        buttonEsdeveniments.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonEsdeveniments.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEsdevenimentsActionPerformed(evt);
            }
        });
        panelOpcions.add(buttonEsdeveniments, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 230, 150, 30));
        if(usuari.getTipus() == 2){
            buttonEsdeveniments.setVisible(false);
        }

        buttonPuntsRecollida.setBackground(new java.awt.Color(51, 102, 255));
        buttonPuntsRecollida.setFont(new java.awt.Font("Sansation", 1, 14)); // NOI18N
        buttonPuntsRecollida.setForeground(new java.awt.Color(255, 255, 255));
        buttonPuntsRecollida.setText("Punts de recollida");
        buttonPuntsRecollida.setToolTipText("Llistat punts de recollida");
        buttonPuntsRecollida.setAutoscrolls(true);
        buttonPuntsRecollida.setBorderPainted(false);
        buttonPuntsRecollida.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonPuntsRecollida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPuntsRecollidaActionPerformed(evt);
            }
        });
        panelOpcions.add(buttonPuntsRecollida, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 180, 150, 30));
        if(usuari.getTipus() == 2){
            buttonPuntsRecollida.setVisible(false);
        }

        buttonResidus.setBackground(new java.awt.Color(51, 102, 255));
        buttonResidus.setFont(new java.awt.Font("Sansation", 1, 14)); // NOI18N
        buttonResidus.setForeground(new java.awt.Color(255, 255, 255));
        buttonResidus.setText("Residus");
        buttonResidus.setToolTipText("Llistat residus");
        buttonResidus.setAutoscrolls(true);
        buttonResidus.setBorderPainted(false);
        buttonResidus.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonResidus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonResidusActionPerformed(evt);
            }
        });
        if(usuari.getTipus() == 2){
            panelOpcions.add(buttonResidus, new org.netbeans.lib.awtextra.AbsoluteConstraints(25,80,150,30));
        }else{
            panelOpcions.add(buttonResidus, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 130, 150, 30));
        }

        buttonUsuaris.setBackground(new java.awt.Color(51, 102, 255));
        buttonUsuaris.setFont(new java.awt.Font("Sansation", 1, 14)); // NOI18N
        buttonUsuaris.setForeground(new java.awt.Color(255, 255, 255));
        buttonUsuaris.setText("Usuaris");
        buttonUsuaris.setToolTipText("Llistat usuaris");
        buttonUsuaris.setAutoscrolls(true);
        buttonUsuaris.setBorderPainted(false);
        buttonUsuaris.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonUsuaris.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonUsuarisActionPerformed(evt);
            }
        });
        panelOpcions.add(buttonUsuaris, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 80, 150, 30));
        if(usuari.getTipus() == 2){
            buttonUsuaris.setVisible(false);
        }

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

        buttonPerfil.setBackground(new java.awt.Color(51, 102, 255));
        buttonPerfil.setFont(new java.awt.Font("Sansation", 1, 14)); // NOI18N
        buttonPerfil.setForeground(new java.awt.Color(255, 255, 255));
        buttonPerfil.setText("Perfil");
        buttonPerfil.setToolTipText("Perfil");
        buttonPerfil.setBorderPainted(false);
        buttonPerfil.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPerfilActionPerformed(evt);
            }
        });
        panelOpcions.add(buttonPerfil, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 30, 150, 30));

        buttonCanvi.setBackground(new java.awt.Color(255, 204, 0));
        buttonCanvi.setFont(new java.awt.Font("Sansation", 1, 14)); // NOI18N
        buttonCanvi.setText("Canvi d'usuari");
        buttonCanvi.setToolTipText("Tornar al llistat d'usuaris");
        buttonCanvi.setBorderPainted(false);
        buttonCanvi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonCanvi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCanviActionPerformed(evt);
            }
        });
        panelOpcions.add(buttonCanvi, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 660, 150, 30));

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
    private void buttonLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonLogOutActionPerformed
        // Fem el logout
        api.logout(usuari);
        System.exit( 0); 
    }//GEN-LAST:event_buttonLogOutActionPerformed

    /**
     * Mètode utiitzar quan es prem el botó de Llistat d'usauris.
     * @param evt ActionEvent: Pulsar el botó.
     */
    private void buttonUsuarisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonUsuarisActionPerformed
        
        PantallaLlistatUsuaris pantallaLlistatUsuaris = new PantallaLlistatUsuaris(usuari);
        pantallaLlistatUsuaris.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_buttonUsuarisActionPerformed

    /**
     * Mètode utilitzat quan es prem el botó de perfil
     * @param evt (ActionEvent) : Pulsar el botó.
     */
    private void buttonPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonPerfilActionPerformed
        PantallaPerfil pantallaPerfil = new PantallaPerfil(usuari,usuari.getId());
        pantallaPerfil.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_buttonPerfilActionPerformed

    /**
     * Mètode utilitzat quan es prem el botó de perfil
     * @param evt (ActionEvent) : Pulsar el botó.
     */
    private void buttonResidusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonResidusActionPerformed
        PantallaLlistatResidus pantallaLlistatResidus = new PantallaLlistatResidus(usuari);
        pantallaLlistatResidus.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_buttonResidusActionPerformed

    /**
     * Mètode utilitzat quan es prem el botó de punts de recollida
     * @param evt (ActionEvent) : Pulsar el botó.
     */
    private void buttonPuntsRecollidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonPuntsRecollidaActionPerformed
        PantallaLlistatPuntsRecollida pantallaLlistatPuntsRecollida = new PantallaLlistatPuntsRecollida(usuari);
        pantallaLlistatPuntsRecollida.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_buttonPuntsRecollidaActionPerformed

    /**
     * Mètode utilitzat quan es prem el botó de recollida
     * @param evt (ActionEvent) : Pulsar el botó.
     */
    private void buttonRecollidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRecollidaActionPerformed
        PantallaRecollidaIdentificacio pantallaRecollidaIdentificacio = new PantallaRecollidaIdentificacio(usuari);
        pantallaRecollidaIdentificacio.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_buttonRecollidaActionPerformed

    /**
     * Mètode utilitzat quan es prem el botó de canviar d'usuari.
     * @param evt (ActionEvent) : Pulsar el botó.
     */
    private void buttonCanviActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCanviActionPerformed
        // Fem el logout de l'usuari i obrim la pantalla de login
        api.logout(usuari);
        PantallaLogin pantallaLogin = new PantallaLogin();
        pantallaLogin.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_buttonCanviActionPerformed

    /**
     * Mètode utilitzat quan es prem el botó de esdeveniments
     * @param evt (ActionEvent) : Pulsar el botó.
     */
    private void buttonEsdevenimentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEsdevenimentsActionPerformed
        PantallaLlistatEsdeveniments pantallaLlistatEsdeveniments = new PantallaLlistatEsdeveniments(usuari);
        pantallaLlistatEsdeveniments.setVisible(true);
        this.dispose();    
    }//GEN-LAST:event_buttonEsdevenimentsActionPerformed

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
            java.util.logging.Logger.getLogger(PantallaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PantallaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PantallaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PantallaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PantallaPrincipal(usuari).setVisible(true);
            }
        });
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    /**
    * Botó per tornar a la pantalla principal.
    */
    private javax.swing.JButton buttonCanvi;
    /**
    * Botó per accedir al llistat d'esdeveniments
    */
    private javax.swing.JButton buttonEsdeveniments;
    /**
    * Botó per desloginar-se i sortir de l'aplicació.
    */
    private javax.swing.JButton buttonLogOut;
    /**
    * Botó per accedir al perfil de l'usuari.
    */
    private javax.swing.JButton buttonPerfil;
    /**
    * Botó per accedir al llistat de punts de recollida
    */
    private javax.swing.JButton buttonPuntsRecollida;
    /**
    * Botó per accedir a la recollida
    */
    private javax.swing.JButton buttonRecollida;
    /**
    * Botó per accedir al llistat de residus
    */
    private javax.swing.JButton buttonResidus;
    /**
    * Botó per accedir al llistat d'usuaris
    */
    private javax.swing.JButton buttonUsuaris;
    /**
    * Label per contenir el logo de l'aplicació.
    */
    private javax.swing.JLabel labelPrincipal;
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
    // End of variables declaration//GEN-END:variables
}
