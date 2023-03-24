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
 * @version 24/03/2023
 */
public class PantallaBaixaUsuari extends javax.swing.JFrame {
    
    
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
     * Id usuari a eliminar.
     */
    private static int idUsuari;  
    /**
     * Utils API.java
     */
    private Api api;
    
    /**
     * Crea una nova instància de la classe PantallaPrincipal.
     * @param usuari (Usuari) : Usuari loginat a l'aplicació.
     * @param idUsuariSeleccionat (int) : id de l'usuari a eliminar.
     */
    public PantallaBaixaUsuari(Usuari usuari, int idUsuariSeleccionat) {
        // Utilitats api
        api = new Api();
        // Assignació de l'usuari
        this.usuari = usuari;
        this.idUsuari = idUsuariSeleccionat;
        // Inicialització dels components
        initComponents();
        // Centrem pantalla
        centrarPantalla();
        // Accions en funcio de l'usuari
        gestioUsuari();
        // Càrrega inicial del formulari.
        carregarFormulari(idUsuariSeleccionat);
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
        labelTitolDades = new javax.swing.JLabel();
        buttonBaixa = new javax.swing.JButton();
        labelEmail = new javax.swing.JLabel();
        labelMissatge = new javax.swing.JLabel();
        labelNomComplet = new javax.swing.JLabel();
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
        labelTitol.setText("Baixa usuari");
        labelTitol.setToolTipText("");
        panelTitol.add(labelTitol, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 600, 30));

        panelContingut.add(panelTitol, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 51, 800, 50));
        panelContingut.add(separadorUsuari, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 730, 10));

        labelTitolDades.setFont(new java.awt.Font("Sansation", 0, 14)); // NOI18N
        labelTitolDades.setForeground(new java.awt.Color(153, 153, 153));
        labelTitolDades.setText("Dades de l'usuari");
        panelContingut.add(labelTitolDades, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, -1));

        buttonBaixa.setBackground(new java.awt.Color(153, 0, 0));
        buttonBaixa.setFont(new java.awt.Font("Sansation", 1, 14)); // NOI18N
        buttonBaixa.setForeground(new java.awt.Color(255, 255, 255));
        buttonBaixa.setText("Donar de baixa");
        buttonBaixa.setToolTipText("Donar de baixa l'usuari");
        buttonBaixa.setBorderPainted(false);
        buttonBaixa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonBaixa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBaixaActionPerformed(evt);
            }
        });
        panelContingut.add(buttonBaixa, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 690, 150, 30));

        labelEmail.setFont(new java.awt.Font("Sansation", 0, 14)); // NOI18N
        labelEmail.setToolTipText("Email de l'usuari.");
        panelContingut.add(labelEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 400, 30));

        labelMissatge.setFont(new java.awt.Font("Sansation", 0, 14)); // NOI18N
        labelMissatge.setToolTipText("Email de l'usuari.");
        panelContingut.add(labelMissatge, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 730, 30));

        labelNomComplet.setFont(new java.awt.Font("Sansation", 0, 14)); // NOI18N
        labelNomComplet.setToolTipText("Email de l'usuari.");
        panelContingut.add(labelNomComplet, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 400, 30));

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
     * Mètode per carregar el formulari amb les dades
     */
    private void carregarFormulari(int idUsuariSeleccionat){
        // Amb l'usuari seleccionat recuperem les seves dades.
        JSONObject jsonUsuari = api.consultaUsuari(usuari,idUsuariSeleccionat);
        if(!jsonUsuari.isEmpty()){
            if(jsonUsuari.get("codi_error").toString().equals("0")){
               labelEmail.setText(jsonUsuari.get("email").toString());
               labelNomComplet.setText(jsonUsuari.get("nom").toString() + " " + jsonUsuari.get("cognom1").toString() + " " + jsonUsuari.get("cognom2").toString());
               if( jsonUsuari.get("actiu").toString().equals("0") ){
                   labelMissatge.setText("Aquest usuari ja està eliminat. Quan un usuari s'elimina es posa l'estat a inactiu i no s'elimina completament.");
                   buttonBaixa.setVisible(false);               }
            }else{
                PantallaAdvertencia pantallaAdvertencia = new PantallaAdvertencia(jsonUsuari.get("codi_error").toString() + " - " +jsonUsuari.get("error").toString());
                pantallaAdvertencia.setVisible(true); 
            }
        }else{
            PantallaAdvertencia pantallaAdvertencia = new PantallaAdvertencia(api.error(5));
            pantallaAdvertencia.setVisible(true); 
        }
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

//GEN-FIRST:event_buttonAltaActionPerformed
 
//GEN-LAST:event_buttonAltaActionPerformed
    /**
     * Mètode utilitzat quan es prem el botó de baixa d'usuari.
     * @param evt (ActionEvent) : event al pulsar el botó.
     */
    private void buttonBaixaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBaixaActionPerformed
        // Eliminem l'usuari.
        JSONObject jsonUsuari = api.eliminarUsuari(usuari,idUsuari);
        if(!jsonUsuari.isEmpty()){
            if(jsonUsuari.get("codi_error").toString().equals("0")){
                PantallaAdvertencia pantallaAdvertencia = new PantallaAdvertencia("Usuari eliminat.");
                pantallaAdvertencia.setVisible(true); 
            }else{
                PantallaAdvertencia pantallaAdvertencia = new PantallaAdvertencia(jsonUsuari.get("codi_error").toString() + " - " +jsonUsuari.get("error").toString());
                pantallaAdvertencia.setVisible(true); 
            }
        }else{
            PantallaAdvertencia pantallaAdvertencia = new PantallaAdvertencia(api.error(6));
            pantallaAdvertencia.setVisible(true); 
        }
    }//GEN-LAST:event_buttonBaixaActionPerformed
    
   
   
   
   
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
            java.util.logging.Logger.getLogger(PantallaBaixaUsuari.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PantallaBaixaUsuari.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PantallaBaixaUsuari.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PantallaBaixaUsuari.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
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
                new PantallaBaixaUsuari(usuari,idUsuari).setVisible(true);
            }
        });
        
        
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    /**
    * Botó per donar d'alta l'usuari
    */
    private javax.swing.JButton buttonBaixa;
    /**
    * Botó per desloginar-se i sortir de l'aplicació.
    */
    private javax.swing.JButton buttonLogOut;
    /**
    * Botó per tornar a la pantalla principal.
    */
    private javax.swing.JButton buttonTornar;
    /**
    * Label per contenir el email de l'usuari a eliminar
    */
    private javax.swing.JLabel labelEmail;
    /**
    * Label per contenir resposta.
    */
    private javax.swing.JLabel labelMissatge;
    /**
    * Label per contenir el nom complet de l'usuari a eliminar
    */
    private javax.swing.JLabel labelNomComplet;
    /**
    * Label per contenir el logo de l'aplicació.
    */
    private javax.swing.JLabel labelPrincipal;
    /**
    * Label per el títol de la pantalla.
    */
    private javax.swing.JLabel labelTitol;
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
    * Separador dades usuari
    */
    private javax.swing.JSeparator separadorUsuari;
    // End of variables declaration//GEN-END:variables
}