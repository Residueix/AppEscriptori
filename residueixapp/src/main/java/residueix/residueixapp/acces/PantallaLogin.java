package residueix.residueixapp.acces;

import java.awt.Dimension;
import java.awt.Toolkit;
import org.json.JSONObject;
import residueix.residueixapp.principal.PantallaAdvertencia;
import residueix.residueixapp.principal.PantallaPrincipal;
import residueix.residueixapp.models.Usuari;
import residueix.residueixapp.utils.Api;
import residueix.residueixapp.utils.Utils;
import residueix.residueixapp.utils.xifratParaulaClau;


/**
 * Classe que representa la pantalla de Login de l'aplicació.
 * @author Daniel Garcia Ruiz
 * @version 02/05/2023
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
     * Crea una nova instància de la classe PantallaLogin
     */
    public PantallaLogin() {
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
        setSize(new java.awt.Dimension(1004, 754));
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
        panelFormulari.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelUsuari.setFont(new java.awt.Font("Sansation", 1, 14)); // NOI18N
        labelUsuari.setForeground(new java.awt.Color(102, 102, 102));
        labelUsuari.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelUsuari.setText("Usuari");
        labelUsuari.setPreferredSize(new java.awt.Dimension(100, 30));
        panelFormulari.add(labelUsuari, new org.netbeans.lib.awtextra.AbsoluteConstraints(177, 307, 150, -1));
        labelUsuari.getAccessibleContext().setAccessibleName("");

        labelParaulaClau.setFont(new java.awt.Font("Sansation", 1, 14)); // NOI18N
        labelParaulaClau.setForeground(new java.awt.Color(102, 102, 102));
        labelParaulaClau.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelParaulaClau.setText("Paraula clau");
        labelParaulaClau.setPreferredSize(new java.awt.Dimension(83, 30));
        panelFormulari.add(labelParaulaClau, new org.netbeans.lib.awtextra.AbsoluteConstraints(177, 397, 150, -1));
        labelParaulaClau.getAccessibleContext().setAccessibleName("");

        textFieldUsuari.setFont(new java.awt.Font("Sansation", 0, 14)); // NOI18N
        textFieldUsuari.setForeground(new java.awt.Color(102, 102, 102));
        textFieldUsuari.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        textFieldUsuari.setToolTipText("usuari");
        panelFormulari.add(textFieldUsuari, new org.netbeans.lib.awtextra.AbsoluteConstraints(177, 349, 150, 30));
        textFieldUsuari.getAccessibleContext().setAccessibleName("");

        passwordFieldParaulaClau.setFont(new java.awt.Font("Sansation", 0, 14)); // NOI18N
        passwordFieldParaulaClau.setForeground(new java.awt.Color(102, 102, 102));
        passwordFieldParaulaClau.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        passwordFieldParaulaClau.setToolTipText("Paraula clau");
        passwordFieldParaulaClau.setPreferredSize(new java.awt.Dimension(150, 30));
        panelFormulari.add(passwordFieldParaulaClau, new org.netbeans.lib.awtextra.AbsoluteConstraints(177, 433, -1, -1));
        passwordFieldParaulaClau.getAccessibleContext().setAccessibleName("");

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
        panelFormulari.add(buttonLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(177, 491, -1, -1));
        buttonLogin.getAccessibleContext().setAccessibleName("");

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
        panelFormulari.add(buttonTancar, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, -1, -1));
        buttonTancar.getAccessibleContext().setAccessibleName("");
        buttonTancar.getAccessibleContext().setAccessibleDescription("");

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
        panelFormulari.add(labelRestablirParaulaClau, new org.netbeans.lib.awtextra.AbsoluteConstraints(177, 533, 152, -1));
        labelRestablirParaulaClau.getAccessibleContext().setAccessibleName("");
        labelRestablirParaulaClau.getAccessibleContext().setAccessibleDescription("");

        panelPrincipal.add(panelFormulari, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 2, 500, 746));
        panelFormulari.getAccessibleContext().setAccessibleName("");
        panelFormulari.getAccessibleContext().setAccessibleDescription("");

        panelLogo.setBackground(new java.awt.Color(255, 255, 255));
        panelLogo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelLogo.setBackground(new java.awt.Color(255, 51, 0));
        labelLogo.setIcon(new javax.swing.ImageIcon("C:\\Users\\isard\\Downloads\\logo_imatge_marca.png")); // NOI18N
        labelLogo.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        panelLogo.add(labelLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 0, 500, 750));

        panelPrincipal.add(panelLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(502, 2, 500, 746));
        panelLogo.getAccessibleContext().setAccessibleName("");
        panelLogo.getAccessibleContext().setAccessibleDescription("");

        getContentPane().add(panelPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1004, 754));

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
        if(Utils.validarEmail(textFieldUsuari.getText().toString())){
            
            // 
            String usuariemail = textFieldUsuari.getText();
            String password = passwordFieldParaulaClau.getText();
            String passwordXifrat = null;
            try {
                passwordXifrat = xifratParaulaClau.encrypt(password);
            } catch (Exception ex) {
                PantallaAdvertencia pantallaAdvertencia = new PantallaAdvertencia(Utils.error(18));
                pantallaAdvertencia.setVisible(true);
            }
            
            // Criidem a l'api per loginar-se.
            JSONObject json = Api.login(usuariemail, passwordXifrat);
        
            // Controlem el que ens ha arribat
            if(json.isEmpty()) {
                PantallaAdvertencia pantallaAdvertencia = new PantallaAdvertencia(Utils.error((1)));
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
                            PantallaAdvertencia pantallaAdvertencia = new PantallaAdvertencia(Utils.error((2)));
                            pantallaAdvertencia.setVisible(true); 
                        }
                    }
                }else{
                    PantallaAdvertencia pantallaAdvertencia = new PantallaAdvertencia(json.get("codi_error").toString() + " - " + json.get("error").toString());
                    pantallaAdvertencia.setVisible(true); 
                
                }
            }
        }else{
            PantallaAdvertencia pantallaAdvertencia = new PantallaAdvertencia(Utils.error(13));
            pantallaAdvertencia.setVisible(true);
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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PantallaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        
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
