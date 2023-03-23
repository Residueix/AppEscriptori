package residueix.residueixapp;

import java.awt.Dimension;
import java.awt.Toolkit;
import residueix.residueixapp.models.Usuari;
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
        buttonLlistatUsuaris = new javax.swing.JButton();
        buttonLogOut = new javax.swing.JButton();
        buttonPerfil = new javax.swing.JButton();
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

        buttonLlistatUsuaris.setBackground(new java.awt.Color(51, 102, 255));
        buttonLlistatUsuaris.setFont(new java.awt.Font("Sansation", 1, 14)); // NOI18N
        buttonLlistatUsuaris.setForeground(new java.awt.Color(255, 255, 255));
        buttonLlistatUsuaris.setText("Llistat usuaris");
        buttonLlistatUsuaris.setToolTipText("Perfil");
        buttonLlistatUsuaris.setAutoscrolls(true);
        buttonLlistatUsuaris.setBorderPainted(false);
        buttonLlistatUsuaris.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonLlistatUsuaris.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonLlistatUsuarisActionPerformed(evt);
            }
        });
        panelOpcions.add(buttonLlistatUsuaris, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 80, 150, 30));

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
                buttonLlistatUsuaris.setVisible(false);
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
    private void buttonLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonLogOutActionPerformed
        // Fem el logout
        api.logout(usuari);
        System.exit( 0); 
    }//GEN-LAST:event_buttonLogOutActionPerformed

    /**
     * Mètode utiitzar quan es prem el botó de Llistat d'usauris.
     * @param evt ActionEvent: Pulsar el botó.
     */
    private void buttonLlistatUsuarisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonLlistatUsuarisActionPerformed
        
        PantallaLlistatUsuaris pantallaLlistatUsuaris = new PantallaLlistatUsuaris(usuari);
        pantallaLlistatUsuaris.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_buttonLlistatUsuarisActionPerformed

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
    * Botó per accedir al llistat d'usuaris
    */
    private javax.swing.JButton buttonLlistatUsuaris;
    /**
    * Botó per desloginar-se i sortir de l'aplicació.
    */
    private javax.swing.JButton buttonLogOut;
    /**
    * Botó per accedir al perfil de l'usuari.
    */
    private javax.swing.JButton buttonPerfil;
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
