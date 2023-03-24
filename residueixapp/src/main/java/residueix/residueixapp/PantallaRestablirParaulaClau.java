package residueix.residueixapp;

import java.awt.Dimension;
import java.awt.Toolkit;
import org.json.JSONObject;
import residueix.residueixapp.utils.Api;
import residueix.residueixapp.utils.EnviamentCorreu;

/**
 * Classe per obrir la finestra per Restablir paraula clau.
 * @author Daniel Garcia Ruiz
 * @version 12/03/2023
 */
public class PantallaRestablirParaulaClau extends javax.swing.JFrame {

    // Atributs
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
     * Crea una nova instpancia de la classe PantallaRestablirParaulaClau.
     */
    public PantallaRestablirParaulaClau() {
        // Utilitats api
        api = new Api();
        initComponents();
        centrarPantalla();
    }

    /**
     * Mètode critad per el constructor per inicialitzar el formulari.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelPrincipal = new javax.swing.JPanel();
        buttonTancar = new javax.swing.JButton();
        labelEmail = new javax.swing.JLabel();
        textFieldEmail = new javax.swing.JTextField();
        buttonRestablir = new javax.swing.JButton();
        labelResposta = new javax.swing.JLabel();
        labelFons = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);
        setResizable(false);
        setSize(new java.awt.Dimension(400, 300));
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

        buttonTancar.setFont(new java.awt.Font("Sansation", 0, 14)); // NOI18N
        buttonTancar.setText("X");
        buttonTancar.setToolTipText("Tancar");
        buttonTancar.setBorder(null);
        buttonTancar.setBorderPainted(false);
        buttonTancar.setContentAreaFilled(false);
        buttonTancar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonTancar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonTancarActionPerformed(evt);
            }
        });
        panelPrincipal.add(buttonTancar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        labelEmail.setFont(new java.awt.Font("Sansation", 1, 14)); // NOI18N
        labelEmail.setForeground(new java.awt.Color(102, 102, 102));
        labelEmail.setText("Introdueix el teu e-mail d'usuari.");
        panelPrincipal.add(labelEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 70, -1, -1));

        textFieldEmail.setFont(new java.awt.Font("Sansation", 0, 14)); // NOI18N
        textFieldEmail.setForeground(new java.awt.Color(102, 102, 102));
        textFieldEmail.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        textFieldEmail.setToolTipText("E-mail d'usuari");
        panelPrincipal.add(textFieldEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 110, 200, 30));

        buttonRestablir.setBackground(new java.awt.Color(0, 204, 51));
        buttonRestablir.setFont(new java.awt.Font("Sansation", 1, 14)); // NOI18N
        buttonRestablir.setForeground(new java.awt.Color(255, 255, 255));
        buttonRestablir.setText("Restablir");
        buttonRestablir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRestablirActionPerformed(evt);
            }
        });
        panelPrincipal.add(buttonRestablir, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 150, 200, 30));

        labelResposta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        panelPrincipal.add(labelResposta, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 350, 30));

        labelFons.setBackground(new java.awt.Color(255, 255, 255));
        labelFons.setIcon(new javax.swing.ImageIcon("C:\\Users\\isard\\Downloads\\logo_pantalles_petites.png")); // NOI18N
        panelPrincipal.add(labelFons, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 300));

        getContentPane().add(panelPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 300));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Mètode per centrar la pantalla
     */
    private void centrarPantalla(){
        // Centrar pantalla.
        Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(((pantalla.width)-this.getWidth())/2,((pantalla.height)-this.getHeight())/2);
    }
    
    /**
     * Mètode getter per retornar l'atribut api
     * @return Api
    */
    public Api getApi(){
        return this.api;
    }
    
    /**
     * Mètode executat quan premem el botó per tancar finestra
     * @param evt Action Event: Event de prémer botó
     */
    private void buttonTancarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonTancarActionPerformed
        this.dispose();
    }//GEN-LAST:event_buttonTancarActionPerformed

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
     * Mètode per restablir paraula clau i enviar un correu al destinatari.
     * @param evt Action event: event quan clickem el botó.
     */
    private void buttonRestablirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRestablirActionPerformed
        
        // Validem l'email.
        if(api.validarEmail(textFieldEmail.getText().toString())){
               
            // Comprovem que existeix el correu
            JSONObject jsonExisteixCorreu = api.existeixCorreu(textFieldEmail.getText().toString());

            if(!jsonExisteixCorreu.isEmpty()){
                if(jsonExisteixCorreu.get("codi_error").toString().equals("0")){
                    // Correcte, intenem enviar el correu
                    EnviamentCorreu correu = new EnviamentCorreu();
                    boolean resultat = correu.enviament("Restabliment de paraula clau a Residueix", "S'ha demanat el restabliment de la paraula clau. La seva paraula clau es : "+ jsonExisteixCorreu.get("password").toString() +" . Aconsellem que la canvii el més aviat possible.", textFieldEmail.getText().toString());
                    if(resultat){
                       PantallaAdvertencia pantallaAdvertencia = new PantallaAdvertencia(api.error(11));
                        pantallaAdvertencia.setVisible(true); 
                        this.dispose();
                    }else{
                        PantallaAdvertencia pantallaAdvertencia = new PantallaAdvertencia(api.error(10));
                        pantallaAdvertencia.setVisible(true); 
                        this.dispose();
                    }
            }else{
                    // Error al json
                    PantallaAdvertencia pantallaAdvertencia = new PantallaAdvertencia("Error : " + jsonExisteixCorreu.get("codi_error").toString() + " - " + jsonExisteixCorreu.get("error").toString() );
                    pantallaAdvertencia.setVisible(true); 
                    this.dispose();
                }
        }else{
            PantallaAdvertencia pantallaAdvertencia = new PantallaAdvertencia(api.error(13));
            pantallaAdvertencia.setVisible(true); 
            this.dispose();
        }
        
        }else{
            
            }
        
    }//GEN-LAST:event_buttonRestablirActionPerformed

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
            java.util.logging.Logger.getLogger(PantallaRestablirParaulaClau.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PantallaRestablirParaulaClau.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PantallaRestablirParaulaClau.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PantallaRestablirParaulaClau.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PantallaRestablirParaulaClau().setVisible(true);
            }
        });
    }                     

    // Variables declaration - do not modify//GEN-BEGIN:variables
    /**
    * Botó restablir per demanar nova paraula clau.
    */
    private javax.swing.JButton buttonRestablir;
    /**
    * Botó per tancar la finestra.
    */
    private javax.swing.JButton buttonTancar;
    /**
    * Label email.
    */
    private javax.swing.JLabel labelEmail;
    /**
    * Label que conté la imatge de fons de la pantalla.
    */
    private javax.swing.JLabel labelFons;
    /**
    * Label que mostra la resposta a les accions.
    */
    private javax.swing.JLabel labelResposta;
    /**
    * Panel principal per contenir la pantalla.
    */
    private javax.swing.JPanel panelPrincipal;
    /**
    * Text Field per posar el email.
    */
    private javax.swing.JTextField textFieldEmail;
    // End of variables declaration//GEN-END:variables
}
