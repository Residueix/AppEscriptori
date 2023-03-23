package residueix.residueixapp;

import java.awt.Dimension;
import java.awt.Toolkit;
import org.json.JSONObject;
import residueix.residueixapp.models.Usuari;
import residueix.residueixapp.utils.Api;


/**
 * Classe que representa la pantalla de Login de l'aplicació.
 * @author Daniel Garcia Ruiz
 * @version 13/03/2023
*/
public class PantallaLogin extends javax.swing.JFrame {
    
    // Atributs
    /**
     * Posició x del ratolí.
     */
    private int xMouse;
    /**
     * Posició y del ratolí
     */
    private int yMouse;
    /**
     * Utils API.java
     */
    private final Api api;

    /**
     * Crea una nova instància de la classe PantallaLogin
     */
    public PantallaLogin() {
        // Iniciem els atributs.
        this.api = new Api();
        // Iniciem els components
        initComponents();
        // Centrem pantalla
        centrarPantalla();
    }

    /**
     * Mètode critad per el constructor per inicialitzar el formulari.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelPrincipal = new javax.swing.JPanel();
        panelFormulari = new javax.swing.JPanel();
        labelUsuari = new javax.swing.JLabel();
        labelParaulaClau = new javax.swing.JLabel();
        textFieldUsuari = new javax.swing.JTextField();
        passwordFieldParaulaClau = new javax.swing.JPasswordField();
        buttonLogin = new javax.swing.JButton();
        buttonTancar = new javax.swing.JButton();
        labelRestablirParaulaClau = new javax.swing.JLabel();
        panelLogo = new javax.swing.JPanel();
        labelLogo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setBounds(new java.awt.Rectangle(0, 0, 1000, 750));
        setUndecorated(true);
        setResizable(false);
        setSize(new java.awt.Dimension(1010, 760));
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

        panelPrincipal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 2));
        panelPrincipal.setMinimumSize(new java.awt.Dimension(1004, 174));
        panelPrincipal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelFormulari.setBackground(new java.awt.Color(255, 255, 255));
        panelFormulari.setPreferredSize(new java.awt.Dimension(500, 750));

        labelUsuari.setFont(new java.awt.Font("Sansation", 1, 14)); // NOI18N
        labelUsuari.setForeground(new java.awt.Color(102, 102, 102));
        labelUsuari.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelUsuari.setText("Usuari");
        labelUsuari.setPreferredSize(new java.awt.Dimension(100, 30));

        labelParaulaClau.setFont(new java.awt.Font("Sansation", 1, 14)); // NOI18N
        labelParaulaClau.setForeground(new java.awt.Color(102, 102, 102));
        labelParaulaClau.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelParaulaClau.setText("Paraula clau");
        labelParaulaClau.setPreferredSize(new java.awt.Dimension(83, 30));

        textFieldUsuari.setFont(new java.awt.Font("Sansation", 0, 14)); // NOI18N
        textFieldUsuari.setForeground(new java.awt.Color(102, 102, 102));
        textFieldUsuari.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        textFieldUsuari.setToolTipText("usuari");

        passwordFieldParaulaClau.setFont(new java.awt.Font("Sansation", 0, 14)); // NOI18N
        passwordFieldParaulaClau.setForeground(new java.awt.Color(102, 102, 102));
        passwordFieldParaulaClau.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        passwordFieldParaulaClau.setToolTipText("Paraula clau");
        passwordFieldParaulaClau.setPreferredSize(new java.awt.Dimension(150, 30));

        buttonLogin.setBackground(new java.awt.Color(0, 204, 51));
        buttonLogin.setFont(new java.awt.Font("Sansation", 1, 14)); // NOI18N
        buttonLogin.setForeground(new java.awt.Color(255, 255, 255));
        buttonLogin.setText("Entrar");
        buttonLogin.setToolTipText("Entrar");
        buttonLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonLogin.setPreferredSize(new java.awt.Dimension(150, 30));
        buttonLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonLoginActionPerformed(evt);
            }
        });

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

        labelRestablirParaulaClau.setBackground(new java.awt.Color(255, 255, 255));
        labelRestablirParaulaClau.setFont(new java.awt.Font("Sansation", 0, 12)); // NOI18N
        labelRestablirParaulaClau.setForeground(new java.awt.Color(153, 153, 153));
        labelRestablirParaulaClau.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelRestablirParaulaClau.setText("Restablir paraula clau");
        labelRestablirParaulaClau.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelRestablirParaulaClau.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelRestablirParaulaClauMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelFormulariLayout = new javax.swing.GroupLayout(panelFormulari);
        panelFormulari.setLayout(panelFormulariLayout);
        panelFormulariLayout.setHorizontalGroup(
            panelFormulariLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFormulariLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(buttonTancar)
                .addContainerGap(477, Short.MAX_VALUE))
            .addGroup(panelFormulariLayout.createSequentialGroup()
                .addGap(0, 177, Short.MAX_VALUE)
                .addGroup(panelFormulariLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelFormulariLayout.createSequentialGroup()
                        .addGroup(panelFormulariLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelRestablirParaulaClau, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                            .addComponent(buttonLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(passwordFieldParaulaClau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textFieldUsuari, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(171, 171, 171))
                    .addGroup(panelFormulariLayout.createSequentialGroup()
                        .addGroup(panelFormulariLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelUsuari, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelParaulaClau, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        panelFormulariLayout.setVerticalGroup(
            panelFormulariLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFormulariLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(buttonTancar)
                .addGap(284, 284, 284)
                .addComponent(labelUsuari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(textFieldUsuari, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(labelParaulaClau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passwordFieldParaulaClau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(buttonLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelRestablirParaulaClau, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(199, Short.MAX_VALUE))
        );

        labelUsuari.getAccessibleContext().setAccessibleName("");
        labelParaulaClau.getAccessibleContext().setAccessibleName("");
        textFieldUsuari.getAccessibleContext().setAccessibleName("");
        passwordFieldParaulaClau.getAccessibleContext().setAccessibleName("");
        buttonLogin.getAccessibleContext().setAccessibleName("");
        buttonTancar.getAccessibleContext().setAccessibleName("");
        buttonTancar.getAccessibleContext().setAccessibleDescription("");
        labelRestablirParaulaClau.getAccessibleContext().setAccessibleName("");
        labelRestablirParaulaClau.getAccessibleContext().setAccessibleDescription("");

        panelPrincipal.add(panelFormulari, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 2, 500, 746));
        panelFormulari.getAccessibleContext().setAccessibleName("");
        panelFormulari.getAccessibleContext().setAccessibleDescription("");

        panelLogo.setBackground(new java.awt.Color(255, 255, 255));

        labelLogo.setBackground(new java.awt.Color(255, 51, 0));
        labelLogo.setIcon(new javax.swing.ImageIcon("C:\\Users\\isard\\Downloads\\logo_imatge_marca.png")); // NOI18N
        labelLogo.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout panelLogoLayout = new javax.swing.GroupLayout(panelLogo);
        panelLogo.setLayout(panelLogoLayout);
        panelLogoLayout.setHorizontalGroup(
            panelLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLogoLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(labelLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panelLogoLayout.setVerticalGroup(
            panelLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLogoLayout.createSequentialGroup()
                .addComponent(labelLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 750, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        panelPrincipal.add(panelLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(502, 2, 496, 746));
        panelLogo.getAccessibleContext().setAccessibleName("");
        panelLogo.getAccessibleContext().setAccessibleDescription("");

        getContentPane().add(panelPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 750));

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
     * Mètode per capturar la x i y del mouse quan el deixem pulsat sobre el frame principal.
     * @param evt MouseEvent: event de deixar pulsat el botó del ratolí.
     */
    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();// TODO add your handling code here:
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
     * Mètode executat quan premem el label de restablir paraula clau i obrirm una nova finestra.
     * @param evt MouseEvent: Event de clickar amb el ratolí
    */
    private void labelRestablirParaulaClauMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelRestablirParaulaClauMouseClicked
        // Cridar a restablir pass
        PantallaRestablirParaulaClau pantallaRestablir = new PantallaRestablirParaulaClau();
        pantallaRestablir.setVisible(true);
    }//GEN-LAST:event_labelRestablirParaulaClauMouseClicked

    /**
     * Mètode executat quan premem el botó per tancar finestra
     * @param evt Action Event: Event de prémer botó.
     */
    private void buttonTancarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonTancarActionPerformed
        System.exit( 0);
    }//GEN-LAST:event_buttonTancarActionPerformed

    /**
     * Mètode executat quan premem el botó de loginar-se.
     * @param evt ActionEvent: event de premer botó 
     */
    private void buttonLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonLoginActionPerformed
        
        // Validem l'email.
        if(api.validarEmail(textFieldUsuari.getText().toString())){
            
            // Criidem a l'api per loginar-se.
            JSONObject json = api.login(textFieldUsuari.getText(), passwordFieldParaulaClau.getText());
        
            // Controlem el que ens ha arribat
            if(json.isEmpty()) {
                PantallaAdvertencia pantallaAdvertencia = new PantallaAdvertencia(api.error((1)));
                pantallaAdvertencia.setVisible(true); 
            }else{
                if(json.get("codi_error").toString().equals("0")){
                // Creem un nou usuari amb les dades
                Usuari usuari = new Usuari(Integer.parseInt(json.get("id").toString()),Integer.parseInt(json.get("tipus").toString()),json.get("tipus_nom").toString(),json.get("email").toString(),json.get("password").toString(),json.get("nom").toString(),json.get("cognom1").toString(),json.get("cognom2").toString(),json.get("telefon").toString(),json.get("token").toString());
                // Comprovem quin tipus d'usuari és
                    switch(usuari.getTipus()){
                        case 1,2 -> {
                            PantallaPrincipal pantallaPrincipal = new PantallaPrincipal(usuari);
                            pantallaPrincipal.setVisible(true);
                            this.dispose();
                        }
                        default -> {
                            PantallaAdvertencia pantallaAdvertencia = new PantallaAdvertencia(api.error((2)));
                            pantallaAdvertencia.setVisible(true); 
                        }
                    }
                }else{
                    PantallaAdvertencia pantallaAdvertencia = new PantallaAdvertencia(json.get("codi_error").toString() + " - " + json.get("error").toString());
                    pantallaAdvertencia.setVisible(true); 
                
                }
            }
        }else{
            PantallaAdvertencia pantallaAdvertencia = new PantallaAdvertencia(api.error(13));
            pantallaAdvertencia.setVisible(true); 
            this.dispose();
        }
    }//GEN-LAST:event_buttonLoginActionPerformed

    /**
     * Mètode principal de la classe.
     * @param args arguments de la linia de comandament
     */
    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PantallaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PantallaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PantallaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PantallaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Creació i mostra del formulari */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PantallaLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    /**
    * Botó per loginar-se.
    */
    private javax.swing.JButton buttonLogin;
    /**
    * Botó per tancar la finestra.
    */
    private javax.swing.JButton buttonTancar;
    /**
    * Label per contenir el logo.
    */
    private javax.swing.JLabel labelLogo;
    /**
    * Label paraula clau
    */
    private javax.swing.JLabel labelParaulaClau;
    /**
    * Label per restablir la paraula clau.
    */
    private javax.swing.JLabel labelRestablirParaulaClau;
    /**
    * Label usuari.
    */
    private javax.swing.JLabel labelUsuari;
    /**
    * Panel per contenir el formulari de login.
    */
    private javax.swing.JPanel panelFormulari;
    /**
    * Panel per contenir el logo.
    */
    private javax.swing.JPanel panelLogo;
    /**
    * Panel principal per la distribució del formulari.
    */
    private javax.swing.JPanel panelPrincipal;
    /**
    * Password Field per possar la paraula clau de l'usuari.
    */
    private javax.swing.JPasswordField passwordFieldParaulaClau;
    /**
    * Text Field per posar l'email de l'usari.
    */
    private javax.swing.JTextField textFieldUsuari;
    // End of variables declaration//GEN-END:variables
}
